package me.main;



import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lmk39 on 2017/5/26.
 */
public class TestJsonParse {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "bb");
        map.put("2", "cc");
        map.put("3", "dd");

        Dog dog=new Dog();
        dog.setName("傻逼");
        dog.setOptions(map);
        JSONObject jsonObject = JSONObject.fromObject(dog);
        System.out.println(jsonObject);
    }
}

