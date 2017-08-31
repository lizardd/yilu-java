package org.yilu.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

/**
 * Created by lmk39 on 2017/8/30.
 */
public class Test {
    public static void main(String [] args){
        System.setProperty("phantomjs.binary.path", "C:/phantomjs.exe");

        //定义驱动对象为 FirefoxDriver 对象
        WebDriver driver = new PhantomJSDriver();


        //驱动的网址
        driver.get("http://www.baidu.com/");

        System.out.println(driver.getTitle());
        System.out.println(driver.getPageSource());


        //关闭驱动
        driver.close();
    }
}
