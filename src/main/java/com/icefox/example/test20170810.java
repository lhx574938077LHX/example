package com.icefox.example;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.icefox.bean.GetDrawOffExpertResultRequest;



public class test20170810 {
    
    public static void main(String[] args) throws Exception {
        // 配置接口参数
        GetDrawOffExpertResultRequest data = new GetDrawOffExpertResultRequest();
        data.setWorkGroupId("你是好人");
        Gson gson = new Gson();
        String str = gson.toJson(data);

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://172.16.7.232:8081/jeecg/expertactionController.do?getDrawOffExpertResult");
        httpPost.setEntity(new StringEntity(str,"utf-8"));
        
        CloseableHttpResponse response = httpclient.execute(httpPost);
        int retCode = response.getStatusLine().getStatusCode();
        System.out.println(retCode);
        if(retCode!=200)
            System.out.println("反馈请求状态码："+retCode);
        
        HttpEntity rspEntity = response.getEntity();
        String result = "";
        if (rspEntity != null) {
            result = EntityUtils.toString(rspEntity, "utf-8");
        }
        //输出返回信息
        AjaxJson j = gson.fromJson(result, AjaxJson.class);
        System.out.println("返回信息"+result);
    }
    
}
