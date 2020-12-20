package com.qtrj.vsftpd.service;

import org.springframework.web.multipart.MultipartFile;

public interface IFileDemoService {
    String updatePhoto(MultipartFile file);
}
