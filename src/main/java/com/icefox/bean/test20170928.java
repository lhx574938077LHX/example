package com.icefox.bean;

import java.util.HashMap;
import java.util.Map;

public class test20170928 {

    static Map<String, String> priceMap = new HashMap<String, String>();
    static Map<String, String[]> countMap = new HashMap<String, String[]>();
    static Map<String, String[]> autoMap = new HashMap<String, String[]>();

    static Map<String, CarGroup> garGroupMap = new HashMap<String, CarGroup>();

    public static void main(String[] args) {

        test20170928.init();

        for (String keyP : priceMap.keySet()) {
            for (String keyC : countMap.keySet()) {
                for (String keyO : autoMap.keySet()) {
                    String key = keyP + keyC + keyO;
                    CarGroup value = new CarGroup();
                    value.setPrice(priceMap.get(keyP));
                    value.setCount(countMap.get(keyC));
                    value.setAuto(autoMap.get(keyO));
                    garGroupMap.put(key, value);
                }
            }
        }
        for (String key : garGroupMap.keySet()) {
            System.out.println(key);
            CarGroup value = garGroupMap.get(key);
            for (String auto : value.getAuto()) {
                for (String count : value.getCount()) {
                    System.out.print(value.getPrice() + count + auto + "  ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void init() {

        priceMap.put("5-10万", "5_10");
        priceMap.put("10-15万", "10_15");
        priceMap.put("15-20万", "15_20");
        priceMap.put("20-30万", "20_30");
        priceMap.put("30-50万", "30_50");
        priceMap.put("50-70万", "50_70");
        priceMap.put("70-100万", "70_100");
        priceMap.put("100万以上", "70_9999999");

        countMap.put("日系", new String[] { "japan" });
        countMap.put("德系", new String[] { "germany" });
        countMap.put("美系", new String[] { "america" });
        countMap.put("自主", new String[] { "china" });
        countMap.put("韩国", new String[] { "korea" });
        countMap.put("欧系",
                new String[] { "germany", "france", "england", "sweden", "czech", "holland", "italy", "spain" });

        autoMap.put("轿车", new String[] { "1", "2" });
        autoMap.put("SUV", new String[] { "SUV" });
        autoMap.put("MPV", new String[] { "MPV" });
    }

}
