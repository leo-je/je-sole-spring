/*
 *
 * (c) Copyright Ascensio System SIA 2020
 *
 * The MIT License (MIT)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package com.je.cloud.busi.document.controller;

import com.je.cloud.busi.document.config.DocumentUtils;
import com.je.cloud.busi.document.entities.FileType;
import com.je.cloud.busi.document.helpers.CookieManager;
import com.je.cloud.busi.document.helpers.FileUtility;
import com.je.cloud.busi.document.helpers.ServiceConverter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@Controller
public class IndexServlet {


    @Autowired
    DocumentUtils documentUtils;

    @Autowired
    FileUtility fileUtility;

    @Autowired
    private ServiceConverter serviceConverter;

    @RequestMapping({"/IndexServlet", "/"})
    public Object indexServlet(HttpServletRequest request, HttpServletResponse response, ModelAndView view) throws IOException {
        view.setViewName("index");
        view.addObject("ConverExtList", String.join(",", documentUtils.GetConvertExts()));
        view.addObject("EditedExtList", String.join(",", documentUtils.GetEditedExts()));
        String action = request.getParameter("type");
        if (action == null) {
            File[] files = documentUtils.GetStoredFiles(null);
            view.addObject("files", files);
            return view;
        }

        PrintWriter writer = response.getWriter();

        switch (action.toLowerCase()) {
            case "upload":
                Upload(request, response, writer);
                break;
            case "convert":
                Convert(request, response, writer);
                break;
            case "track":
                Track(request, writer);
                break;
            case "remove":
                Remove(request, writer);
                break;
        }
        return null;
    }


    private void Upload(HttpServletRequest request, HttpServletResponse response, PrintWriter writer) {
        response.setContentType("text/plain");

        try {
            Part httpPostedFile = request.getPart("file");

            String fileName = "";
            for (String content : httpPostedFile.getHeader("content-disposition").split(";")) {
                if (content.trim().startsWith("filename")) {
                    fileName = content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
                }
            }

            long curSize = httpPostedFile.getSize();
            if (documentUtils.GetMaxFileSize() < curSize || curSize <= 0) {
                writer.write("{ \"error\": \"File size is incorrect\"}");
                return;
            }

            String curExt = fileUtility.GetFileExtension(fileName);
            if (!documentUtils.GetFileExts().contains(curExt)) {
                writer.write("{ \"error\": \"File type is not supported\"}");
                return;
            }

            InputStream fileStream = httpPostedFile.getInputStream();

            fileName = documentUtils.GetCorrectName(fileName);
            String fileStoragePath = documentUtils.StoragePath(fileName, null);

            File file = new File(fileStoragePath);

            try (FileOutputStream out = new FileOutputStream(file)) {
                int read;
                final byte[] bytes = new byte[1024];
                while ((read = fileStream.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }

                out.flush();
            }

            CookieManager cm = new CookieManager(request);
            documentUtils.CreateMeta(fileName, cm.getCookie("uid"), cm.getCookie("uname"));

            writer.write("{ \"filename\": \"" + fileName + "\"}");

        } catch (Exception e) {
            writer.write("{ \"error\": \"" + e.getMessage() + "\"}");
        }
    }

    private void Convert(HttpServletRequest request, HttpServletResponse response, PrintWriter writer) {
        response.setContentType("text/plain");

        try {
            String fileName = request.getParameter("filename");
            String fileUri = documentUtils.GetFileUri(request, fileName);
            String fileExt = fileUtility.GetFileExtension(fileName);
            FileType fileType = fileUtility.GetFileType(fileName);
            String internalFileExt = documentUtils.GetInternalExtension(fileType);

            if (documentUtils.GetConvertExts().contains(fileExt)) {
                String key = serviceConverter.GenerateRevisionId(fileUri);

                String newFileUri = serviceConverter.GetConvertedUri(fileUri, fileExt, internalFileExt, key, true);

                if (newFileUri.isEmpty()) {
                    writer.write("{ \"step\" : \"0\", \"filename\" : \"" + fileName + "\"}");
                    return;
                }

                String correctName = documentUtils.GetCorrectName(fileUtility.GetFileNameWithoutExtension(fileName) + internalFileExt);

                URL url = new URL(newFileUri);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream stream = connection.getInputStream();

                if (stream == null) {
                    throw new Exception("Stream is null");
                }

                File convertedFile = new File(documentUtils.StoragePath(correctName, null));
                try (FileOutputStream out = new FileOutputStream(convertedFile)) {
                    int read;
                    final byte[] bytes = new byte[1024];
                    while ((read = stream.read(bytes)) != -1) {
                        out.write(bytes, 0, read);
                    }

                    out.flush();
                }

                connection.disconnect();

                //remove source file ?
                //File sourceFile = new File(DocumentManager.StoragePath(fileName, null));
                //sourceFile.delete();

                fileName = correctName;

                CookieManager cm = new CookieManager(request);
                documentUtils.CreateMeta(fileName, cm.getCookie("uid"), cm.getCookie("uname"));
            }

            writer.write("{ \"filename\" : \"" + fileName + "\"}");

        } catch (Exception ex) {
            writer.write("{ \"error\": \"" + ex.getMessage() + "\"}");
        }
    }

    private void Track(HttpServletRequest request, PrintWriter writer) {
        String userAddress = request.getParameter("userAddress");
        String fileName = request.getParameter("fileName");

        String storagePath = documentUtils.StoragePath(fileName, userAddress);
        String body = "";

        try {
            Scanner scanner = new Scanner(request.getInputStream());
            scanner.useDelimiter("\\A");
            body = scanner.hasNext() ? scanner.next() : "";
            scanner.close();
        } catch (Exception ex) {
            writer.write("get request.getInputStream error:" + ex.getMessage());
            return;
        }

        if (body.isEmpty()) {
            writer.write("empty request.getInputStream");
            return;
        }

        JSONParser parser = new JSONParser();
        JSONObject jsonObj;

        try {
            Object obj = parser.parse(body);
            jsonObj = (JSONObject) obj;
        } catch (Exception ex) {
            writer.write("JSONParser.parse error:" + ex.getMessage());
            return;
        }

        int status;
        String downloadUri;
        String changesUri;
        String key;

        status = Math.toIntExact((long) jsonObj.get("status"));
        downloadUri = (String) jsonObj.get("url");
        changesUri = (String) jsonObj.get("changesurl");
        key = (String) jsonObj.get("key");


        int saved = 0;
        if (status == 2 || status == 3)//MustSave, Corrupted
        {
            try {
                String histDir = documentUtils.HistoryDir(storagePath);
                String versionDir = documentUtils.VersionDir(histDir, documentUtils.GetFileVersion(histDir) + 1);
                File ver = new File(versionDir);
                File toSave = new File(storagePath);

                if (!ver.exists()) ver.mkdirs();

                toSave.renameTo(new File(versionDir + File.separator + "prev" + fileUtility.GetFileExtension(fileName)));

                downloadToFile(downloadUri, toSave);
                downloadToFile(changesUri, new File(versionDir + File.separator + "diff.zip"));

                String history = (String) jsonObj.get("changeshistory");
                if (history == null && jsonObj.containsKey("history")) {
                    history = ((JSONObject) jsonObj.get("history")).toJSONString();
                }
                if (history != null && !history.isEmpty()) {
                    FileWriter fw = new FileWriter(new File(versionDir + File.separator + "changes.json"));
                    fw.write(history);
                    fw.close();
                }

                FileWriter fw = new FileWriter(new File(versionDir + File.separator + "key.txt"));
                fw.write(key);
                fw.close();
            } catch (Exception ex) {
                saved = 1;
            }
        }

        writer.write("{\"error\":" + saved + "}");
    }

    private void Remove(HttpServletRequest request, PrintWriter writer) {
        try {
            String fileName = request.getParameter("filename");
            String path = documentUtils.StoragePath(fileName, null);

            File f = new File(path);
            delete(f);

            File hist = new File(documentUtils.HistoryDir(path));
            delete(hist);

            writer.write("{ \"success\": true }");
        } catch (Exception e) {
            writer.write("{ \"error\": \"" + e.getMessage() + "\"}");
        }
    }

    private void delete(File f) throws Exception {
        if (f.isDirectory()) {
            for (File c : f.listFiles())
                delete(c);
        }
        if (!f.delete())
            throw new Exception("Failed to delete file: " + f);
    }

    private void downloadToFile(String url, File file) throws Exception {
        if (url == null || url.isEmpty()) throw new Exception("argument url");
        if (file == null) throw new Exception("argument path");

        URL uri = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
        InputStream stream = connection.getInputStream();

        if (stream == null) {
            throw new Exception("Stream is null");
        }

        try (FileOutputStream out = new FileOutputStream(file)) {
            int read;
            final byte[] bytes = new byte[1024];
            while ((read = stream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            out.flush();
        }

        connection.disconnect();
    }
}
