package com.academy.techcenture.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.time.Instant;

public class PaymentDonePage extends BasePage{

    public PaymentDonePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//h2/b[text()='Order Placed!']")
    private WebElement orderPlacedHeader;
    @FindBy(xpath="//p[text()='Congratulations! Your order has been confirmed!']")
    private WebElement orderPlacedText;
    @FindBy(xpath="//a[text()='Download Invoice']")
    private WebElement downloadInvoiceBtn;


    public void verifyUserIsOnPaymentDonePage(){
        Assert.assertTrue("Order placed header is not displayed", orderPlacedHeader.isDisplayed());
        Assert.assertTrue("Order placed text is not displayed", orderPlacedText.isDisplayed());
    }
    public void clickOnDownloadInvoiceBtn(){
        Assert.assertTrue("Download invoice is not enabled", downloadInvoiceBtn.isEnabled());
        downloadInvoiceBtn.click();
    }
    public void verifyInvoiceDownloaded(){
        String folderName = System.getProperty("users/ayse") + File.separator + "downloads";
        // Array to Store List of Files in Directory
        File[] listOfFiles;
        // Store File Name
        String fileName;
        //  Consider file is not downloaded
        boolean fileDownloaded = false;
        long startTime = Instant.now().toEpochMilli();
        long waitTime = startTime;
        while (Instant.now().toEpochMilli() < waitTime) {
            // get all the files of the folder
            listOfFiles = new File(folderName).listFiles();

            // iterate through each file
            for (File file : listOfFiles) {
                // get the name of the current file
                fileName = file.getName().toLowerCase();

                // condition 1 - Last Modified Time > Start Time
                // condition 2 - till the time file is completely downloaded extension will be crdownload
                // Condition 3 - Current File name contains expected Text
                // Condition 4 - Current File name contains expected extension
                if (file.lastModified() > startTime && !fileName.contains("crdownload") &&   fileName.contains("invoice".toLowerCase()) && fileName.contains("txt".toLowerCase()))
                {
                    fileDownloaded = true;
                    break;
                }
            }
            if (fileDownloaded)
                break;
        }
        System.out.println("Invoice downloaded successfully.");
    }
}
