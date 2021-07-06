package com.je.cloud.busi.document.config;

import com.je.cloud.busi.document.entities.FileType;
import com.je.cloud.busi.document.helpers.FileUtility;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class DocumentUtils {

    @Autowired
    private DocumentConfig documentConfig;

    public List<String> GetConvertExts() {
        String exts = documentConfig.getConvertDocs();//ConfigManager.GetProperty("files.docservice.convert-docs");
        return Arrays.asList(exts.split("\\|"));
    }

    public List<String> GetEditedExts() {
        String exts = documentConfig.getEditedDocs();//("files.docservice.edited-docs");
        return Arrays.asList(exts.split("\\|"));
    }

    public long GetMaxFileSize() {
        long size;

        try {
            size = documentConfig.getFilesizeMax();//Long.parseLong(ConfigManager.GetProperty("filesize-max"));
        } catch (Exception ex) {
            size = 0;
        }

        return size > 0 ? size : 5 * 1024 * 1024;
    }

    public List<String> GetFileExts() {
        List<String> res = new ArrayList<>();
        res.addAll(GetViewedExts());
        res.addAll(GetEditedExts());
        res.addAll(GetConvertExts());
        return res;
    }

    public List<String> GetViewedExts() {
        String exts = documentConfig.getViewedDocs();//ConfigManager.GetProperty("files.docservice.viewed-docs");
        return Arrays.asList(exts.split("\\|"));
    }

    @Autowired
    FileUtility fileUtility;

    public String GetCorrectName(String fileName) {
        String baseName = fileUtility.GetFileNameWithoutExtension(fileName);
        String ext = fileUtility.GetFileExtension(fileName);
        String name = baseName + ext;

        File file = new File(StoragePath(name, null));

        for (int i = 1; file.exists(); i++) {
            name = baseName + " (" + i + ")" + ext;
            file = new File(StoragePath(name, null));
        }

        return name;
    }

    public String StoragePath(String fileName, String userAddress) {
        String directory = FilesRootPath(userAddress);
        return directory + fileName;
    }

    public String FilesRootPath(String userAddress) {
        //String hostAddress = CurUserHostAddress(userAddress);
        //String serverPath = request.getSession().getServletContext().getRealPath("");
        String storagePath = documentConfig.getStorageFolder();//ConfigManager.GetProperty("storage-folder");
        String directory;//serverPath + "/" + storagePath + File.separator + hostAddress + File.separator;
        directory = storagePath;
        File file = new File(directory);

        if (!file.exists()) {
            file.mkdirs();
        }

        return directory;
    }


    public void CreateMeta(String fileName, String uid, String uname) throws Exception {
        String histDir = HistoryDir(StoragePath(fileName, null));

        File dir = new File(histDir);
        dir.mkdir();

        JSONObject json = new JSONObject();
        json.put("created", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        json.put("id", (uid == null || uid.isEmpty()) ? "uid-1" : uid);
        json.put("name", (uname == null || uname.isEmpty()) ? "John Smith" : uname);

        File meta = new File(histDir + File.separator + "createdInfo.json");
        try (FileWriter writer = new FileWriter(meta)) {
            json.writeJSONString(writer);
        }
    }

    public String HistoryDir(String storagePath) {
        return storagePath + "-hist";
    }

    public String GetFileUri(HttpServletRequest request, String fileName) {
        try {
            String serverPath = GetServerUrl(request);
            String storagePath = documentConfig.getStorageFolder();//ConfigManager.GetProperty("storage-folder");
            String hostAddress = CurUserHostAddress(null);

//            String filePath = serverPath + "/" + storagePath + "/" + hostAddress + "/" + URLEncoder.encode(fileName, java.nio.charset.StandardCharsets.UTF_8.toString()).replace("+", "%20");
            String filePath = serverPath + "/getfile/" + URLEncoder.encode(fileName, java.nio.charset.StandardCharsets.UTF_8.toString()).replace("+", "%20");

            return filePath;
        } catch (Exception e) {
            return "";
        }
    }

    public String GetCallback(HttpServletRequest request, String fileName) {
        String serverPath = GetServerUrl(request);
        String hostAddress = CurUserHostAddress(null);
        try {
            String query = "?type=track&fileName=" + URLEncoder.encode(fileName, java.nio.charset.StandardCharsets.UTF_8.toString()) + "&userAddress=" + URLEncoder.encode(hostAddress, java.nio.charset.StandardCharsets.UTF_8.toString());

            return serverPath + "/IndexServlet" + query;
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public File[] GetStoredFiles(String userAddress) {
        String directory = FilesRootPath(userAddress);

        File file = new File(directory);
        return file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        });
    }

    public String CreateDemo(String fileExt, Boolean sample, String uid, String uname) throws Exception {
        String demoName = (sample ? "sample." : "new.") + fileExt;
        String fileName = GetCorrectName(demoName);

        InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(demoName);

        File file = new File(StoragePath(fileName, null));

        try (FileOutputStream out = new FileOutputStream(file)) {
            int read;
            final byte[] bytes = new byte[1024];
            while ((read = stream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
        }

        CreateMeta(fileName, uid, uname);

        return fileName;
    }

    public String CurUserHostAddress(String userAddress) {
        if (userAddress == null) {
            try {
                userAddress = InetAddress.getLocalHost().getHostAddress();
            } catch (Exception ex) {
                userAddress = "";
            }
        }
        return userAddress.replaceAll("[^0-9a-zA-Z.=]", "_");
    }

    public String GetServerUrl(HttpServletRequest request) {
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }

    public String GetInternalExtension(FileType fileType) {
        if (fileType.equals(FileType.Text))
            return ".docx";

        if (fileType.equals(FileType.Spreadsheet))
            return ".xlsx";

        if (fileType.equals(FileType.Presentation))
            return ".pptx";

        return ".docx";
    }

    public String VersionDir(String histPath, Integer version) {
        return histPath + File.separator + Integer.toString(version);
    }

    public Integer GetFileVersion(String historyPath) {
        File dir = new File(historyPath);

        if (!dir.exists()) return 0;

        File[] dirs = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });

        return dirs.length;
    }
}
