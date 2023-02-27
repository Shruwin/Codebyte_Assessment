package task;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Testcase 
{
	@Test
	public void test() throws EncryptedDocumentException, IOException
	{
		System.setProperty("webdriver.chrome.driver", "./softwares/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		driver.get("https://staging3-akes.nexquare.io/");
		Reporter.log("Browser opened and application Launched");
		ArrayList<String> data = datadriven.add_data(driver);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("username")))).sendKeys(data.get(0));
		driver.findElement(By.name("password")).sendKeys(data.get(1));
		driver.findElement(By.id("log-btn")).click();
		Reporter.log("Successfully Loged-in");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hr"))).click();
		driver.findElement(By.id("link_addStaff")).click();
		driver.findElement(By.id("staffFullName")).sendKeys(data.get(2));
		driver.findElement(By.xpath("//input[@name='staffDateOfBirth']")).click();	
		driver.findElement(By.xpath("//a[.='14']")).click();
		driver.findElement(By.id("joinDate")).click();
		driver.findElement(By.xpath("//a[.='23']")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(data.get(3));
		driver.findElement(By.id("salaryStartDate")).click();
		driver.findElement(By.xpath("//a[.='1']")).click();
		driver.findElement(By.id("submitButton")).click();
		Reporter.log("Personal Data Filled");
		driver.findElement(By.id("wallet_config")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchInput"))).sendKeys("200011325");
		Reporter.log("Successfully got Student Details");
		driver.findElement(By.xpath("//input[@id='searchInput']/../../../../../div[1]/button[1]")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-expansion-panel-header-1"))).click();
		driver.findElement(By.xpath("//thead[@role='rowgroup']/..//tbody//tr[1]//mat-checkbox")).click();	
		driver.findElement(By.xpath("//span[.='Payment Mode']")).click();
		driver.findElement(By.xpath("//span[.=' Cash ']")).click();
		driver.findElement(By.xpath("//span[.='Pay']")).click();
		Reporter.log("Fee Collection successfully done and Receipt is generated");
		
	}
}
