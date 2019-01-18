package com.youe.cd.apptest;

//import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AppTest {
    @Test
    public void CalculatorTest()  throws MalformedURLException,InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", ".Calculator");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        //Thread.sleep(3000);

        //driver.findElement(By.id("com.android.calculator2:id/digit_1")).click();
        //driver.findElement(By.name("1")).click(); //By.name()已移除，不可用
        driver.findElement(By.xpath("//android.view.ViewGroup/android.widget.Button[7]")).click();
        //driver.findElement(By.id("com.android.calculator2:id/digit_5")).click();
        //driver.findElement(By.xpath("//android.widget.Button[@text='5']")).click();
        driver.findElement(By.xpath("//android.widget.Button[contains(@text,'5')]")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_9")).click();
        driver.findElement(By.id("com.android.calculator2:id/del")).click();
        //driver.findElement(By.id("com.android.calculator2:id/op_add")).click();
        //driver.findElement(By.xpath("//android.widget.Button[@content-desc='plus']")).click();
        //driver.findElementByAccessibilityId("plus").click(); //通过属性content-desc定位元素
        //driver.findElementByAndroidUIAutomator("new UiSelector().text(\"+\")").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().description(\"plus\")").click(); //description()方法用的是content-desc属性
        driver.findElement(By.id("com.android.calculator2:id/digit_6")).click();
        driver.findElement(By.id("com.android.calculator2:id/eq")).click();
        Thread.sleep(2000);

        String result = driver.findElement(By.id("com.android.calculator2:id/formula")).getText();
        System.out.println("Getting result is: " + result);

        driver.quit();
    }
}
