package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class FileUploadRestController {

    ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> uploadFile(dto d)  throws IOException {
        
        for (MultipartFile file : d.getFile()) {
            Path path = Paths.get("C:/Temp/" + file.getOriginalFilename());
            Files.write(path, file.getBytes());
        }

        UserData userData = objectMapper.readValue(d.getJsondata(), UserData.class);
        System.out.println(userData.getFirstname());
        System.out.println(userData.getLastname());

        return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);

    }
}

class dto{
    MultipartFile[] file;
    String jsondata;

    public dto() {
    }

    public MultipartFile[] getFile() {
        return file;
    }

    public void setFile(MultipartFile[] file) {
        this.file = file;
    }

    public String getJsondata() {
        return jsondata;
    }

    public void setJsondata(String jsondata) {
        this.jsondata = jsondata;
    }
}
