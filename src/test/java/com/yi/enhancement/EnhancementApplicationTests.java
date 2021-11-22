package com.yi.enhancement;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.yi.enhancement.util.AddressUtils;
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

    @Test
    void test2(){
        String s = "{\"pay_date\":\"2021-10-19 14:37:37\",\"biz_scene\":\"ENTRUST_TRANSFER\",\"action_type\":\"FINISH\",\"pay_fund_order_id\":\"20211019110070001506820011639428\",\"origin_interface\":\"alipay.fund.trans.uni.transfer\",\"out_biz_no\":\"82088daf8ddb4a179bfc3b4b0de0bb11\",\"trans_amount\":\"0.01\",\"product_code\":\"SINGLE_TRANSFER_NO_PWD\",\"order_id\":\"20211019110070000006820063412098\",\"status\":\"SUCCESS\"}";
        JSONObject jsonObject = JSONUtil.parseObj(s);
        Object out_biz_no = jsonObject.get("out_biz_no");
        System.out.println(out_biz_no.toString());
    }

    @Test
    void test3(){
        String thisMonthStart = DateUtil.beginOfMonth(DateUtil.date()).toString("yyyy-MM-dd HH:mm:ss");
        System.out.println(thisMonthStart);
    }
}
