package au.edu.sydney.web.service;

import java.io.InputStream;


public interface FileService {

    /**
     * upload file to aliyun oss
     */

    String upload(InputStream inputStream, String module, String fileName);

    /**
     * remove file from aliyun oss
     */

    void removeFile(String url);
}
