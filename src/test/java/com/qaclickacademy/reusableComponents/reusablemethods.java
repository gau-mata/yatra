package com.qaclickacademy.reusableComponents;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.WebDriver;

public class reusablemethods {
	public static void timelaps(WebDriver driver) {
		int time=3;
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	public static boolean getElement(By selector, WebDriver driver) {
		try {
			driver.findElement(selector);
			return true;
		}catch(Exception e) {
			System.out.println(String.format("Element do not exist",selector));
		}
		return false;
		
	}
	
	public static boolean sendkeys(By selector , String value , WebDriver driver) {
		try {
			driver.findElement(selector).sendKeys(value);
			return true;
			
		}catch(Exception e) {
			System.out.println(String.format("Element do not exist", selector));
		}
		
		return false;
		
	}
	public static boolean click(By selector, WebDriver driver) {
		try {
			driver.findElement(selector).click();
			return true;
		}catch(Exception e ) {
			System.out.println(String.format("Element do not exist",selector));
		}
		return false;
		
	}
	public static boolean deletekeys(By selector,WebDriver driver) {
		driver.findElement(selector).sendKeys(Keys.DELETE);
		return true;
	}
	public static String gettitle(WebDriver driver) {
		String title=driver.getTitle();
		return title;
	}


}
