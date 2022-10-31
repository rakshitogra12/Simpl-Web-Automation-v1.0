package testEndtoEndFlows;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonMethods.BaseClass;
import commonMethods.ReadConfig;

public class AbhiBusEndtoEndflow extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	ReadConfig readconfig = new ReadConfig();

	public Map<Integer, ArrayList<String>> AbhiBusSuccessTestCode() throws Exception {

		driver.get(readconfig.getAbhiBusURL());

		// add code for x button

		driver.manage().window().maximize();

		int pl_position = 0;

//			int eventPositiononbtn = 0;

//			String eventPositiononbtntext = null;

//			ArrayList<String> dataList = new ArrayList<String>();

		Map<Integer, ArrayList<String>> dataValues = new HashMap<Integer, ArrayList<String>>();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[id='navbarDropdown']")));

		driver.findElement(By.cssSelector("a[id='navbarDropdown']")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id = 'mobileNo']")));

		driver.findElement(By.xpath("//input[@id = 'mobileNo']")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id='getotp']")));

		driver.findElement(By.cssSelector("input[id='getotp']")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='source']")));

		driver.findElement(By.xpath("//input[@id='source']")).sendKeys("Mumbai");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='destination']")));

		driver.findElement(By.xpath("//input[@id='destination']")).sendKeys("Mumbai");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[id='datepicker1']")));

		driver.findElement(By.cssSelector("input[id='datepicker1']")).click();

		driver.findElement(By.cssSelector(
				"table[class='ui-datepicker-calendar']>tbody>tr>td>a[class='ui-state-default ui-state-active']"))
				.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Search')]")));

		driver.findElement(By.xpath("//a[contains(text(),'Search')]")).click();

		wait.until(ExpectedConditions.elementToBeClickable(
				By.cssSelector("div#result_1274902020>div:nth-child(3)>div:nth-child(2)>div:nth-child(2)>a")));

		driver.findElement(By.cssSelector("div#result_1274902020>div:nth-child(3)>div:nth-child(2)>div:nth-child(2)>a"))
				.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='O5-1']>a")));

		driver.findElement(By.cssSelector("li[id='O5-1']>a")).click();

		Select boardingpt = new Select(driver.findElement(By.id("boardingpoint_id")));

		boardingpt.selectByIndex(2);

		Select droppingpt = new Select(driver.findElement(By.id("droppingpoint_id")));

		droppingpt.selectByIndex(2);

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id='btnEnable1']")));

		driver.findElement(By.cssSelector("input[id='btnEnable1']")).click();
		
	
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='tabs']/ul/li")));

		List<WebElement> payMethodList = driver.findElements(By.xpath("//div[@id='tabs']/ul/li"));

//		Thread.sleep(5000);
//
//		for (int i = 0; i < payMethodList.size(); i++) {
//
//			String payMethodName = payMethodList.get(i).getText();
//
//			pl_position = (i + 1);
//
//			if (payMethodName.contains("PAY LATER")) {
//
//				System.out.println("Pay Later Option is present on the No. " + (i + 1) + " position");
//
//				String xpathactual = payMethodList.get(i).toString();
//
//				String[] xpathact1 = xpathactual.split("xpath:");
//
//				System.out.println(xpathact1[1]);
//
////					String xpathact2 = xpathact1[1].replaceAll("article]", "article");
//				//
////					String abc = "(" + xpathact2 + ")[" + pl_position + "]";
//				//
////					String abc1 = abc.replace(" ", "");
////					
////					System.out.println(abc1);
////					
////					WebElement element4 = driver.findElement(By.xpath(abc1));
//				//
////					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element4);
//				//
////					Thread.sleep(13000);
//				//
////					wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(abc1)))).click();
//				//
////					if (eventPositiononbtn == 0) {
//				//
////						eventPositiononbtntext = "NO";
////					}
//				//
////					wait.until(
////							ExpectedConditions.presenceOfElementLocated(By.xpath(bigbasketFlowElements.payLaterElements)));
//				//
////					String actualtext = driver.findElement(By.xpath(bigbasketFlowElements.payLaterElements)).getText();
////					Assert.assertEquals(actualtext, "Simpl", "Simpl Option is not present on the Payment Page");
//				//
////					String text1 = actualtext + " Option is present on the Payment Page";
//				//
////					dataList.add(text1);
//				//
////					dataList.add(eventPositiononbtntext);
//				//
////					dataValues.put(pl_position, dataList);
//
//				// print command that Simpl is present on the Big Basket- Web Application
//				// Checkout Page for email shooting
//
//			}
//
//			else {
//
//				System.out.println("Pay Later Option is not present on the No." + pl_position + " position");
//
//				// print command that Simpl is not present on the Big Basket- Web Application
//				// Checkout Page for email shooting
//
//			}

//		}
		return dataValues;

	}

}
