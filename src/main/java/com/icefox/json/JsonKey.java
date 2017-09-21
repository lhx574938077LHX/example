package com.icefox.json;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.icefox.bean.Student;

public class JsonKey {

    public static void main(String[] args) {
        Student stu1 = new Student();
        stu1.setName("张三");
        stu1.setAge((short) 23);
        stu1.setSex((short) 1);
        stu1.setUserId(1);

        JSONObject resultJson = new JSONObject();
        // 把userId作为key放json中
        resultJson.put(stu1.getUserId().toString(), stu1);
//        System.out.println(resultJson);
        
        //Gson Test
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(resultJson.toString());
        System.out.println(element.toString());
    }

}
