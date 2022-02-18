package com.techfios.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
    WebDriver driver;

    static int i = 0;

    public Screenshot(WebDriver driver){
        this.driver = driver;
    }

    public void capture(){


        File tempSC = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(tempSC, (new File("Screenshots/screenshot"+ i + ".png")));
            i++;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }


    
}
