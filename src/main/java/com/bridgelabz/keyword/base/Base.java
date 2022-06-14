package com.bridgelabz.keyword.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {

    public WebDriver driver;
    public Properties prop;

    public WebDriver init_driver(String browserName){
        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prakash Udikeri\\IdeaProjects\\" +
                    "CFP - Automation Testing\\WebDrivers\\chromedriver.exe");
            if(prop.getProperty("headless").equals("yes")){
                //headless mode:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                driver = new ChromeDriver(options);
            }else{
                driver = new ChromeDriver();
            }
        }
        return driver;
    }

    public Properties init_properties(){
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("C:\\Users\\Prakash Udikeri\\IdeaProjects\\" +
                    "CFP - Automation Testing\\KeyWord_Driven_Full\\src\\main\\java\\com\\bridgelabz\\keyword\\" +
                    "config\\config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
