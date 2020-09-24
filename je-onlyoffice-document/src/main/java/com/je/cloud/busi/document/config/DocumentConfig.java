package com.je.cloud.busi.document.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "je.document")
@Component
public class DocumentConfig {

    private long filesizeMax;//5242880
    private String storageFolder;//Users/shengte/git/temp/

    private String viewedDocs;//.pdf|.djvu|.xps
    private String editedDocs;//.docx|.xlsx|.csv|.pptx|.txt
    private String convertDocs;//.docm|.dotx|.dotm|.dot|.doc|.odt|.fodt|.ott|.xlsm|.xltx|.xltm|.xlt|.xls|.ods|.fods|.ots|.pptm|.ppt|.ppsx|.ppsm|.pps|.potx|.potm|.pot|.odp|.fodp|.otp|.rtf|.mht|.html|.htm|.epub
    private String timeout;//120000

    private String converterUrl;//http://10.19.2.5:8081/ConvertService.ashx
    private String tempstorageUrl;//http://10.19.2.5:8081/ResourceService.ashx
    private String apiUrl;//http://10.19.2.5:8081/web-apps/apps/api/documents/api.js
    private String preloaderUrl;//http://10.19.2.5:8081/web-apps/apps/api/documents/cache-scripts.html
    private String secret;//


    //-----------------set and get----------------

    public long getFilesizeMax() {
        return filesizeMax;
    }

    public void setFilesizeMax(long filesizeMax) {
        this.filesizeMax = filesizeMax;
    }

    public String getStorageFolder() {
        return storageFolder;
    }

    public void setStorageFolder(String storageFolder) {
        this.storageFolder = storageFolder;
    }

    public String getViewedDocs() {
        return viewedDocs;
    }

    public void setViewedDocs(String viewedDocs) {
        this.viewedDocs = viewedDocs;
    }

    public String getEditedDocs() {
        return editedDocs;
    }

    public void setEditedDocs(String editedocs) {
        this.editedDocs = editedocs;
    }

    public String getConvertDocs() {
        return convertDocs;
    }

    public void setConvertDocs(String convertDocs) {
        this.convertDocs = convertDocs;
    }

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public String getConverterUrl() {
        return converterUrl;
    }

    public void setConverterUrl(String converterUrl) {
        this.converterUrl = converterUrl;
    }

    public String getTempstorageUrl() {
        return tempstorageUrl;
    }

    public void setTempstorageUrl(String tempstorageUrl) {
        this.tempstorageUrl = tempstorageUrl;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getPreloaderUrl() {
        return preloaderUrl;
    }

    public void setPreloaderUrl(String preloaderUrl) {
        this.preloaderUrl = preloaderUrl;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
