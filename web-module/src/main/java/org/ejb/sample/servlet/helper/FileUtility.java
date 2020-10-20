package org.ejb.sample.servlet.helper;

import java.io.FileWriter;
import java.io.IOException;
import com.amazoneaws.auth.AWSStaticCredentialsProvider;

public class FileUtility {

    void generateReportFile(String content) throws IOException {
        FileWriter fileWriter = new FileWriter("~/DailyReports/Report.csv");
        fileWriter.write(content);
        fileWriter.close();
    }

    public URL uploadS3ObjectAndGetUrl(String bucketName, String uploadContentPath, String ketName) {
        AmazoneS3 s3client = getS3Client();
        s3client.putObject(new PutObjectRequest(bucketName, keyName, new File(uploadContentPath)));
        return s3client.getUrl(bucketName, keyName);
    }
}
