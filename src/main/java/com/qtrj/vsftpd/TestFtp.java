package com.qtrj.vsftpd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import com.dxy.library.util.ftp.FtpUtils;

import org.apache.commons.net.ftp.FTPClient;

public class TestFtp {

    private static final String FILE_PATH = "/home/fy/workspaces/vsftpd/src/test/java/com/qtrj/vsftpd/VsftpdApplicationTests.java";

    public static void main(String[] args) throws IOException {
        // test1();
        FtpUtils.connect("127.0.0.1", 21, "admin", "123456");
        FtpUtils.upload(FILE_PATH, "", "a.java");
        FtpUtils.disconnect();

    }

    private static void test1() throws SocketException, IOException, FileNotFoundException {
        FTPClient ftp = new FTPClient();
        ftp.connect("127.0.0.1", 21);
        ftp.login("amdin", "123456");

        boolean ok = ftp.isConnected();
        System.out.println("是否可以连接ftp server：" + ok);

        // ftp.changeWorkingDirectory("/home/vsftpd");
        // InputStream is =
        // TestFtp.class.getResourceAsStream("src/test/java/com/qtrj/vsftpd/VsftpdApplicationTests.java");
        // InputStream is = new FileInputStream(FILE_PATH);
        // ftp.storeFile("/home/vsftpd/admin/VsftpdApplicationTests.java", is);

        ftp.logout();
    }

}
