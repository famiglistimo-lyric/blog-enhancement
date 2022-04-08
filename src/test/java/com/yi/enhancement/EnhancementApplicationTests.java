package com.yi.enhancement;

import cn.hutool.core.collection.CollectionUtil;
import com.yi.enhancement.service.impl.ArticleServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
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
    void test2() {
        CompletableFuture<?>[] completableFutures = handleAsync();
        for (CompletableFuture<?> completableFuture : completableFutures) {
            System.out.println(completableFuture);
        }

        // 等待所有任务完成
        CompletableFuture<Void> future = CompletableFuture.allOf(completableFutures);
        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("慢慢来，谁不是翻山越岭去爱");
    }

    private CompletableFuture<?>[] handleAsync() {
        List<CompletableFuture<?>> completableFutureList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            String sign = "hello,world ";
            if (i == 0) {
                sign = sign + i;
            }
            if (i == 1) {
                sign = sign + i;
            }
            if (i == 2) {
                sign = sign + i;
            }
            if (i == 3) {
                sign = sign + i;
            }
            if (i == 4) {
                sign = sign + i;
            }
            String finalSign = sign;
            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
                for (int j = 0; j < 100000; j++) {
                    System.out.println(Thread.currentThread().getId() + " " + finalSign + " " + j);
                }
                return 1;
            }).whenComplete((res, exception) -> {

            });
            completableFutureList.add(future);
        }
        return completableFutureList.toArray(new CompletableFuture<?>[0]);
    }

    @Test
    void test3() {
        List<String> list = new ArrayList<>();
        list.add("啊速度加啊四零的");
        list.add("2啊速度加啊四零的");
        List<List<String>> lists = lyricSplit1(list, 5);
        System.out.println(lists);
    }

    public static <T> List<List<T>> lyricSplit1(List<T> list, int size) {
        int listSize = list.size();
        Map<Integer, List<T>> map = new HashMap<>();
        List<List<T>> returnList = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            if (i < size) {
                List<T> threadList = new ArrayList<>();
                map.put(i, threadList);
                returnList.add(threadList);
            }
            int stone = i % size;
            List<T> ts = map.get(stone);
            ts.add(list.get(i));
        }
        // list销毁
        list.clear();
        return returnList;
    }

    public static <T> List<List<T>> lyricSplit(List<T> list, int size) {

        int listSize = list.size();
        if (listSize < size) {
            // 如果传来的list的size小于要分成的份数,则返回原List
            List<List<T>> defaultList = new ArrayList<>();
            defaultList.add(list);
            return defaultList;
        }
        // 分成等分,比如10个元素分成size(5)份,就是2,2,2,2,2;100个元素分成size(5)份,就是20,20,20,20,20
        int i = listSize % size;
        int eachListSize = (listSize - i) / (size - 1);
        List<List<T>> split = CollectionUtil.split(list, eachListSize);
        List<T> ts = list.subList(listSize - i - 1, listSize - 1);
        split.add(ts);
        return split;
    }

//    @Resource
//    TestImpl test;
//
//    /**
//     * 测试查询账户余额
//     *
//     * @throws IOException
//     */
//    @Test
//    public void test222() throws IOException {
//        QueryProviderAccountDTO queryProviderAccountDTO = new QueryProviderAccountDTO();
//        queryProviderAccountDTO.setProviderNo("162588001");
//        String content = JSONObject.toJSONString(queryProviderAccountDTO);
//        byte[] bytes = DatatypeConverter.parseBase64Binary("UB+sGtCcyUDXjwd3pP/kmA==");
//        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, bytes);
//        String encryptHex = aes.encryptHex(content);
//        FormBody formBody = new FormBody.Builder()
//                .add("appKey", "162588001")
//                .add("data", encryptHex)
//                .build();
//        Request request = new Request.Builder()
//                .url("http://localhost:8085/rest/v1.0/xiaohePay/queryProviderAccount")
//                .post(formBody)
//                .build();
//        OkHttpClient okHttpClient = new OkHttpClient();
//        Response response = okHttpClient.newCall(request).execute();
//        ResponseBody body = response.body();
//        String respBody = new String(response.body().bytes(), "UTF-8");
//        System.out.println("respBody = " + respBody);
//        System.out.println("asdasdsds");
//    }
//
//    @Test
//    public void test332() throws IOException {
//        QueryMerchantFeeConfigDTO queryMerchantFeeConfigDTO = new QueryMerchantFeeConfigDTO();
//        queryMerchantFeeConfigDTO.setSn("FD201000011300100723");
//        queryMerchantFeeConfigDTO.setUserId("SR_2006061515s021");
//        String content = JSONObject.toJSONString(queryMerchantFeeConfigDTO);
//        byte[] bytes = DatatypeConverter.parseBase64Binary("UB+sGtCcyUDXjwd3pP/kmA==");
//        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, bytes);
//        String encryptHex = aes.encryptHex(content);
//        FormBody formBody = new FormBody.Builder()
//                .add("appKey", "162588001")
//                .add("data", encryptHex)
//                .build();
//        Request request = new Request.Builder()
//                .url("http://localhost:8085/rest/v1.0/xiaohePay/queryMerchantFeeConfig")
//                .post(formBody)
//                .build();
//        OkHttpClient okHttpClient = new OkHttpClient();
//        Response response = okHttpClient.newCall(request).execute();
//        ResponseBody body = response.body();
//        String respBody = new String(response.body().bytes(), "UTF-8");
//        // 解密
//        String decryptStr = aes.decryptStr(respBody, CharsetUtil.CHARSET_UTF_8);
//        System.out.println("decryptStr = " + decryptStr);
//        System.out.println("asdasdsds");
//    }
//
//    @Test
//    public void test3311() throws IOException {
//        QueryWithdrawOrderDTO queryWithdrawOrderDTO = new QueryWithdrawOrderDTO();
//        queryWithdrawOrderDTO.setOrderNum("621f397e77e618e3d5b5df0a");
//        String content = JSONObject.toJSONString(queryWithdrawOrderDTO);
//        byte[] bytes = DatatypeConverter.parseBase64Binary("UB+sGtCcyUDXjwd3pP/kmA==");
//        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, bytes);
//        String encryptHex = aes.encryptHex(content);
//        FormBody formBody = new FormBody.Builder()
//                .add("appKey", "162588001")
//                .add("data", encryptHex)
//                .build();
//        Request request = new Request.Builder()
//                .url("http://localhost:8085/rest/v1.0/xiaohePay/queryWithdrawOrder")
//                .post(formBody)
//                .build();
//        OkHttpClient okHttpClient = new OkHttpClient();
//        Response response = okHttpClient.newCall(request).execute();
//        ResponseBody body = response.body();
//        String respBody = new String(response.body().bytes(), "UTF-8");
//        // 解密
//        String decryptStr = aes.decryptStr(respBody, CharsetUtil.CHARSET_UTF_8);
//        System.out.println("decryptStr = " + decryptStr);
//        System.out.println("asdasdsds");
//    }
//
//    @Test
//    public void teste42342() throws IOException {
//        AddOrUpdateSimFeeChargeDTO dto = new AddOrUpdateSimFeeChargeDTO()
//                .setSn("FD201000011300100723")
//                .setChargeDate("2022-03-17 17:23:27")
//                .setAmount("1")
//                .setUserId("SR_2006061515s021");
//        String content = JSONObject.toJSONString(dto);
//        byte[] bytes = DatatypeConverter.parseBase64Binary("UB+sGtCcyUDXjwd3pP/kmA==");
//        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, bytes);
//        String encryptHex = aes.encryptHex(content);
//        FormBody formBody = new FormBody.Builder()
//                .add("appKey", "162588001")
//                .add("data", encryptHex)
//                .build();
//        Request request = new Request.Builder()
//                .url("http://localhost:8085/rest/v1.0/xiaohePay/chargeSim")
//                .post(formBody)
//                .build();
//        OkHttpClient okHttpClient = new OkHttpClient();
//        Response response = okHttpClient.newCall(request).execute();
//        ResponseBody body = response.body();
//        String respBody = new String(response.body().bytes(), "UTF-8");
//        // 解密
//        String decryptStr = aes.decryptStr(respBody, CharsetUtil.CHARSET_UTF_8);
//        System.out.println("decryptStr = " + decryptStr);
//        System.out.println("asdasdsds");
//    }
//
//    @Test
//    public void teste41242() throws IOException {
//        D d = new D();
//        d.setAmount("2.03");
//        P p = new P();
//        BeanUtils.copyProperties(d,p);
//        System.out.println("p = " + p);
//    }
//
//    @Data
//    class P {
//        BigDecimal amount;
//    }
//
//    @Data
//    class D {
//        String amount;
//    }
}
