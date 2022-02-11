package com.yi.enhancement;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.yi.enhancement.service.IArticleService;
import com.yi.enhancement.service.impl.ArticleServiceImpl;
import com.yi.enhancement.util.AddressUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
class EnhancementApplicationTests {

    @Resource
    ArticleServiceImpl articleService;

    @Test
    void test() throws URISyntaxException, IOException {
        String str = "(ab)11";
        String regex = "^\\(ab\\).*";
        Pattern r = Pattern.compile(regex);
        Matcher m = r.matcher(str);
        System.out.println(m.matches());
    }

    @Test
    void test1() {
        String city = AddressUtils.getCity("119.146.182.130");
        System.out.println(city);
    }

    public <T> List<T> getList() {
        return new ArrayList<>();
    }

    @Test
    void test2() {
        String s = "{\"pay_date\":\"2021-10-19 14:37:37\",\"biz_scene\":\"ENTRUST_TRANSFER\",\"action_type\":\"FINISH\",\"pay_fund_order_id\":\"20211019110070001506820011639428\",\"origin_interface\":\"alipay.fund.trans.uni.transfer\",\"out_biz_no\":\"82088daf8ddb4a179bfc3b4b0de0bb11\",\"trans_amount\":\"0.01\",\"product_code\":\"SINGLE_TRANSFER_NO_PWD\",\"order_id\":\"20211019110070000006820063412098\",\"status\":\"SUCCESS\"}";
        JSONObject jsonObject = JSONUtil.parseObj(s);
        Object out_biz_no = jsonObject.get("out_biz_no");
        System.out.println(out_biz_no.toString());
    }
}
