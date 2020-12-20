package com.qtrj.vsftpd.service.impl;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

import com.qtrj.vsftpd.FtpUtil;
import com.qtrj.vsftpd.service.IFileDemoService;

@Slf4j
@Service
public class IFileDemoServiceImpl implements IFileDemoService {

    private static final Logger LOG = LoggerFactory.getLogger(IFileDemoService.class);

    @Resource
    private FtpUtil ftpUtil;

    @Override
    public String updatePhoto(MultipartFile file) {

        // 给起一个新的文件名称，防止名称重复
        String newname = new String();

        if (file != null) {
            // 文件名称 = 时间戳 + 文件自己的名字；
            newname = System.currentTimeMillis() + file.getOriginalFilename();

            try {
                // 图片上传，调用ftp工具类 image 上传的文件夹名称，newname 图片名称，inputStream
                boolean hopson = ftpUtil.uploadFileToFtp("images", newname, file.getInputStream());
                if (hopson) { // 上传成功
                    // 文件信息入库
                    /*
                     * File file = new File(); file.setName(newname); file.setSize(size);
                     * file.setUrl(url); file.setMassifId(massifId); file.setPhoto(path + newname);
                     * ..... 等等业务处理 this.insert(dkPhoto);
                     */
                }
                LOG.info("文件上传完成==============:" + hopson);
            } catch (Exception e) {
                LOG.info("文件上传失败==============，error:" + e.getMessage());
                e.printStackTrace();
                return "error";
            }
        } else {
            LOG.info("文件上传失败==============，请求表单为选择文件");
        }
        return "sucess";
    }
}