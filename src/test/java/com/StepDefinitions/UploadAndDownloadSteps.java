package com.StepDefinitions;

import com.Pages.UploadAndDownload;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.*;

public class UploadAndDownloadSteps {
	UploadAndDownload u = new UploadAndDownload(DriverFactory.getDriver());
	@Given("user navigates to Upload and Download Element")
	public void user_navigates_to_upload_and_download_element() {
		DriverFactory.getDriver().get("https://demoqa.com/upload-download");
		u.clickDownloadBtn();
	}

	@Given("user click the download button")
	public void user_click_the_download_button() {
	}

	@Then("file will be downloaded in download directory")
	public void file_will_be_downloaded_in_download_directory() {
		System.out.println(u.isFileDownloaded("C:\\Users\\asjagade\\Documents\\Downloads", "sampleFile"));
		
	}

}
