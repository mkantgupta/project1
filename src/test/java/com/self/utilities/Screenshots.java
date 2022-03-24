package com.self.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
	
	public static void takeScreenshot(WebDriver driver, String fileNames) throws IOException {
		fileNames = fileNames + ".png";
		String directory = "E:\\Training\\23 sept selenium\\EcomSelfLearningProject";
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + fileNames));
		
		System.out.println("Hello World MGGewqefdf");
		System.out.println("Hi shreya and soumili");
	}
}
