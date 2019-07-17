package com.younggam.morethanchat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileUploadService {
    //버킷 주소 동적 할당
    @Value("${cloud.aws.s3.bucket.url}")
    private String defaultUrl;

    private final S3Service s3Service;

    public String upload(MultipartFile uploadFile) throws IOException{
        String origName = uploadFile.getOriginalFilename();
        String url;
        try{
            String ext = origName.substring(origName.lastIndexOf('.')); //확장자
            String saveFileName = getUuid() + ext; //파일이름 암호화
            File file = new File(System.getProperty("user.dir")+saveFileName);
            uploadFile.transferTo(file); //파일 변환
            s3Service.uploadOnS3(saveFileName, file); //S3 파일 업로드
            url = defaultUrl + saveFileName; //주소할당
            file.delete(); //파일 삭제
        }catch (StringIndexOutOfBoundsException e){
            url = null; //파일이 없을 경우 예외 처리
        }
        return url;
    }

    public static String getUuid(){
        return UUID.randomUUID().toString().replace("-", "");
    }

}
