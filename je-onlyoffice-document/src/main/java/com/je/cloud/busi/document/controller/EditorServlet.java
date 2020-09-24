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


import com.je.cloud.busi.document.config.DocumentConfig;
import com.je.cloud.busi.document.config.DocumentUtils;
import com.je.cloud.busi.document.entities.FileModel;
import com.je.cloud.busi.document.helpers.CookieManager;
import com.je.cloud.busi.document.helpers.FileUtility;
import com.je.cloud.busi.document.helpers.ServiceConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;


@Controller()
public class EditorServlet extends HttpServlet {

    @Autowired
    DocumentUtils documentUtils;

    @Autowired
    private DocumentConfig documentConfig;

    @Autowired
    private FileUtility fileUtility;

    @Autowired
    private ServiceConverter serviceConverter;

    @RequestMapping("/EditorServlet")
    public ModelAndView editorServlet(HttpServletRequest request, HttpServletResponse response, ModelAndView view) throws IOException {

        view.addObject("docserviceApiUrl", documentConfig.getApiUrl());
        Cookie cookie = new Cookie("SameSite", "None");
        cookie.setSecure(true);
        response.addCookie(cookie);
        view.setViewName("editor");

        String fileName = request.getParameter("fileName");
        String fileExt = request.getParameter("fileExt");
        String sample = request.getParameter("sample");

        Boolean sampleData = (sample == null || sample.isEmpty()) ? false : sample.toLowerCase().equals("true");

        CookieManager cm = new CookieManager(request);

        if (fileExt != null) {
            try {
                view.addObject("Model", FileModel.Serialize(null));
                fileName = documentUtils.CreateDemo(fileExt, sampleData, cm.getCookie("uid"), cm.getCookie("uname"));
                response.sendRedirect("EditorServlet?fileName=" + URLEncoder.encode(fileName, "UTF-8"));
                return view;
            } catch (Exception ex) {
                response.getWriter().write("Error: " + ex.getMessage());
            }
        }

        FileModel file = new FileModel();
        file.documentType = fileUtility.GetFileType(fileName).toString().toLowerCase();
        file.document = new FileModel.Document();
        file.document.title = fileName;
        file.document.url = documentUtils.GetFileUri(request, fileName);

        file.editorConfig = new FileModel.EditorConfig();
        file.editorConfig.callbackUrl = documentUtils.GetCallback(request, fileName);
        String lang = cm.getCookie("ulang");
        if (lang != null) file.editorConfig.lang = lang;

        String uid = cm.getCookie("uid");
        if (uid != null) file.editorConfig.user.id = uid;
        String uname = cm.getCookie("uname");
        if (uname != null) file.editorConfig.user.name = uname;

        file.editorConfig.customization.goback.url = documentUtils.GetServerUrl(request) + "/IndexServlet";
        Boolean canEdit = documentUtils.GetEditedExts().contains(fileUtility.GetFileExtension(file.document.title));
        file.changeType(file.mode, file.type, canEdit);


//        if (DocumentManager.TokenEnabled()) {
//            file.BuildToken();
//        }

        view.addObject("file", file);
        view.addObject("Model", FileModel.Serialize(file));
        return view;
    }

}
