package com.youe.cd.apptest;

//import io.appium.java_client.MobileBy;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AppOperation {
    @Test
    public void CalculatorTest()  throws MalformedURLException,InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("automationName", "Appium2");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("appPackage", "com.work.app.househealth");
        capabilities.setCapability("appActivity", ".module.login.LoginActivity");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        //driver.installApp("D:\\zhaijian.apk");

        if(driver.isAppInstalled("com.work.app.househealth")) {
            System.out.println("App is Installed");
        } else {
            System.out.println("App is not Installed");
        }

        //driver.closeApp();
        //driver.launchApp();

        //driver.removeApp("com.work.app.househealth"); //能卸载成功，但会报错

        driver.quit();
    }
}
