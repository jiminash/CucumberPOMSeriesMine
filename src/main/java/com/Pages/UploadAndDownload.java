package com.Pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.factory.DriverFactory;

public class UploadAndDownload extends BasePage{

	@FindBy(css = "#downloadButton")
	private WebElement downloadBtn;

	public UploadAndDownload(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickDownloadBtn() {
		utils.clickElement(downloadBtn);
	}

	
	public void randomnumber(){
		
	}
	
	public boolean isFileDownloaded(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		System.out.println(downloadPath);
		System.out.println(fileName);
		File[] dirContents = dir.listFiles();

		for (int i = 0; i < dirContents.length; i++) {
			System.out.println(dirContents[i]+"cscsdvdvd"+dirContents[i].getName());
			if (dirContents[i].getName().contains(fileName)) {
				// File has been found, it can now be deleted:
				String s =   dirContents[i].getAbsolutePath();
				if(new File(s).exists()) {
					return new File(s).delete();
					
				}

			}
		}
		return false;
	}

}
