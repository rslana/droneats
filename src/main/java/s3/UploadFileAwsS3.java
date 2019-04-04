package s3;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import config.Config;
import java.io.File;

/**
 *
 * @author rslana
 */

public class UploadFileAwsS3 {
    private final String bucketName;
    private final String filePath;
    private final String fileName;

    public UploadFileAwsS3(String bucketName, String filePath, String fileName) {
        this.bucketName = bucketName;
        this.filePath = filePath;
        this.fileName = fileName;
    }
    
    public void doUpload() {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(Config.ACCESS_KEY, Config.SECRET_KEY);
        AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds)).withRegion(Regions.US_EAST_2)
                .build();

        try {
            s3.putObject(this.bucketName, this.fileName, new File(this.filePath));
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(0);
        }
    }
}