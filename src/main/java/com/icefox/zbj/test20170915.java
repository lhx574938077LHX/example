package com.icefox.zbj;

import java.net.URL;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

// 根据经纬度获取地址和身份证前六位
public class test20170915 {

    public static void main(String[] args) {
        // lat 39.97646
        // log 116.3039
        String add = getAdd("116.3039", "30.97646");
        JSONObject jsonObject = JSONObject.parseObject(add);
        JSONArray jsonArray = JSONArray.parseArray(jsonObject.getString("addrList"));
        if (jsonArray.size() == 0) {
            return;
        }
        JSONObject j_2 = (JSONObject) jsonArray.get(0);
        String allAdd = j_2.getString("admName");
        String admCode = j_2.getString("admCode");
        String arr[] = allAdd.split(",");
        System.out.println("省：" + arr[0] + "\n市：" + arr[1] + "\n区：" + arr[2]);
        System.out.println("地区码：" + admCode);
    }

    public static String getAdd(String log, String lat) {
        // lat 小 log 大
        // 参数解释: 纬度,经度 type 001 (100代表道路，010代表POI，001代表门址，111可以同时显示前三项)
        String urlString = "http://gc.ditu.aliyun.com/regeocoding?l=" + lat + "," + log + "&type=010";
        String res = "";
        try {
            URL url = new URL(urlString);
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            java.io.BufferedReader in = new java.io.BufferedReader(
                    new java.io.InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                res += line + "\n";
            }
            in.close();
        } catch (Exception e) {
            System.out.println("error in wapaction,and e is " + e.getMessage());
        }
        System.out.println(res);
        return res;
    }

}
