package com.yi.enhancement;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.yi.enhancement.util.AddressUtils;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

@SpringBootTest
class EnhancementApplicationTests {

    @Test
    void test() throws URISyntaxException, IOException {
        URL url = new URL("http://47.111.144.23:8099/profile/upload/2021/06/26/30273af05e7eabe21ee8c24e34b6ebc7.png");
        String fileUrl = url.getFile();
        String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
        InputStream inputStream = url.openStream();
        MultipartFile multipartFile = new MockMultipartFile(fileName, inputStream);
    }

    @Test
    void test1(){
        String city = AddressUtils.getCity("119.146.182.130");
        System.out.println(city);
    }
}
