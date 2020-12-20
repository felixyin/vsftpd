package com.qtrj.vsftpd.controller;

import com.qtrj.vsftpd.service.IFileDemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("/file")
public class FileDemoController {

    @Resource
    private IFileDemoService fileDemoService;

    @PostMapping
    public String upload(MultipartFile file) {
        System.out.println("\n\n\n上传文件：" + file);
        String s = fileDemoService.updatePhoto(file);
        System.out.println(s);
        return s;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello spring test";
    }

}