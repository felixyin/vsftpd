package com.qtrj.vsftpd;

import javax.annotation.Resource;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest
public class FileDemoControllerTest {
    // @LocalServerPort
    // private int port;

    @Autowired(required = true)
    private TestRestTemplate restTemplate;

    @Test
    public void testHello() {
        // String requestResult = this.restTemplate.getForObject("http://127.0.0.1:" +
        // port + "/file/hello", String.class);
        String requestResult = this.restTemplate.getForObject("http://127.0.0.1:8080/file/hello", String.class);
        Assertions.assertThat(requestResult).contains("Hello, spring");
    }
}
