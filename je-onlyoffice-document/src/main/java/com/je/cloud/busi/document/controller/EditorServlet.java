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



import com.je.cloud.busi.document.entities.FileModel;
import com.je.cloud.busi.document.helpers.ConfigManager;
import com.je.cloud.busi.document.helpers.CookieManager;
import com.je.cloud.busi.document.helpers.DocumentManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;


@Controller()
public class EditorServlet extends HttpServlet {

    @RequestMapping("/EditorServlet")
    public ModelAndView editorServlet(HttpServletRequest request, HttpServletResponse response, ModelAndView view) throws ServletException, IOException {
        view.addObject("docserviceApiUrl", ConfigManager.GetProperty("files.docservice.url.api"));
        Cookie cookie=new Cookie("SameSite","None");
        cookie.setSecure(true);
        response.addCookie(cookie);
        view.setViewName("editor");
        DocumentManager.Init(request, response);

        String fileName = request.getParameter("fileName");
        String fileExt = request.getParameter("fileExt");
        String sample = request.getParameter("sample");

        Boolean sampleData = (sample == null || sample.isEmpty()) ? false : sample.toLowerCase().equals("true");

        CookieManager cm = new CookieManager(request);

        if (fileExt != null) {
            try {
                view.addObject("Model", FileModel.Serialize(null));
                fileName = DocumentManager.CreateDemo(fileExt, sampleData, cm.getCookie("uid"), cm.getCookie("uname"));
                response.sendRedirect("EditorServlet?fileName=" + URLEncoder.encode(fileName, "UTF-8"));
                return view;
            } catch (Exception ex) {
                response.getWriter().write("Error: " + ex.getMessage());
            }
        }

        FileModel file = new FileModel(fileName, cm.getCookie("ulang"), cm.getCookie("uid"), cm.getCookie("uname"));
        file.changeType(request.getParameter("mode"), request.getParameter("type"));

        if (DocumentManager.TokenEnabled()) {
            file.BuildToken();
        }
        view.addObject("file",file);
        view.addObject("Model",FileModel.Serialize(file));
        return view;
    }

}
