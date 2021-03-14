package com.example.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class FileUploadRestController {

    int i = 0;
    ObjectMapper objectMapper = new ObjectMapper();

//    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PostMapping("/upload")
//	public ResponseEntity<Object> uploadFile(@RequestParam(required=true, value="file") MultipartFile file, @RequestParam(required=true, value="jsondata")UserData userData) throws IOException  {
//    public ResponseEntity<Object> uploadFile(@RequestParam(required = true, value = "file") MultipartFile[] files, @RequestParam(required = true, value = "jsondata") Object jsondata) throws IOException {
    public ResponseEntity<Object> uploadFile(@RequestParam(value = "data") List<dto> d) throws IOException {
//        for (MultipartFile file : files) {
//            Path path = Paths.get("C:/Temp/" + file.getOriginalFilename());
//            Files.write(path, file.getBytes());
//        }
//
//
////		UserData userData = objectMapper.readValue(jsondata, UserData.class);
////        System.out.println(userData.getFirstname());
////        System.out.println(userData.getLastname());
//        System.out.println(jsondata);
        System.out.println(d);
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