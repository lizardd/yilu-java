package me.main;

import java.util.Map;

/**
 * Created by lmk39 on 2017/5/26.
 */
public class Dog {
    public String name;
    public Map<String,String> options;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getOptions() {
        return options;
    }

    public void setOptions(Map<String, String> options) {
        this.options = options;
    }
}
