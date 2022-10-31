package testEndtoEndFlows;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import commonMethods.BaseClass;
import commonMethods.ReadConfig;

public class makeMyTripendtoendflow extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	ReadConfig readconfig = new ReadConfig();

	public Map<Integer, ArrayList<String>> makemytripSuccessfulScenarioCode() throws Exception {

		driver.get(readconfig.getMMTURL());

		driver.manage().window().maximize();

//		int pl_position = 0;

//		int eventPositiononbtn = 0;

//		String eventPositiononbtntext = null;

//		ArrayList<String> dataList = new ArrayList<String>();

		Map<Integer, ArrayList<String>> dataValues = new HashMap<Integer, ArrayList<String>>();

		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='notification-frame-~55852cba']")));

		Actions builder = new Actions(driver);

		Action mouseOverHome = builder.moveToElement(driver.findElement(By.cssSelector("a[class='close']"))).click()
				.build();

		mouseOverHome.perform();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'hotels')]")));

		driver.findElement(By.xpath("//a[contains(@href,'hotels')]")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='hsw_search_button']")));

		driver.findElement(By.xpath("//button[@id='hsw_search_button']")).click();

		Thread.sleep(5000);

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//input[@aria-label=\"Search location or property\"]")));

		driver.findElement(By.xpath("//input[@aria-label=\"Search location or property\"]"))
				.sendKeys("This Is It - Beach Hostel | Rooms & Dorms");

		Thread.sleep(5000);

		Action mouseOverHome1 = builder
				.moveToElement(
						driver.findElement(By.cssSelector("div[id='react-autowhatever-1']>ul>li:nth-child(1)>a>p")))
				.click().build();

		mouseOverHome1.perform();

		Thread.sleep(15000);

		driver.navigate().refresh();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='Listing_hotel_0'])[1]/a")));

		Action mouseOverHome2 = builder
				.moveToElement(driver.findElement(By.xpath("(//div[@id='Listing_hotel_0'])[1]/a"))).click().build();

		mouseOverHome2.perform();

		String primaryWindowHandle = driver.getWindowHandle();

		Set<String> allWindowHandles = driver.getWindowHandles();

		Iterator<String> iterator = allWindowHandles.iterator();

		while (iterator.hasNext()) {

			String ChildWindow = iterator.next();

			if (!primaryWindowHandle.equalsIgnoreCase(ChildWindow)) {

				driver.switchTo().window(ChildWindow);

			}

		}

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='prmRoomDtlCard__link']")));

		driver.findElement(By.cssSelector("a[class='prmRoomDtlCard__link']")).click();

		Thread.sleep(5000);

		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Select No. Of Beds')]")));

		driver.findElement(By.xpath("//div[contains(text(),'Select No. Of Beds')]")).click();

		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//div[starts-with(@class,'slctBedDropdown')])[1]/div/ul/li[1]")));

		driver.findElement(By.xpath("(//div[starts-with(@class,'slctBedDropdown')])[1]/div/ul/li[1]")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='rmPayable__dtl--addBtn'])[1]")));

		driver.findElement(By.xpath("(//a[@class='rmPayable__dtl--addBtn'])[1]")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("detpg_confirm_booking_btn")));

		driver.findElement(By.id("detpg_confirm_booking_btn")).click();

		System.out.println("Before Code block");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='fName']")));

		driver.findElement(By.xpath("//input[@id='fName']")).sendKeys("Rakshit");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='lName']")));

		driver.findElement(By.xpath("//input[@id='lName']")).sendKeys("Ogra");

		System.out.println("After Code block");

//
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='email']")));
//
//		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("rakshit.ogra@getsimpl.com");
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class,'btnContinuePayment')]")));
//
//		driver.findElement(By.xpath("//a[contains(@class,'btnContinuePayment')]")).click();

//
//		wait.until(ExpectedConditions
//				.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='payment__options__tab']/ul/li")));
//
//		List<WebElement> payMethodList = driver.findElements(By.xpath("//div[@class='payment__options__tab']/ul/li"));
//
//		for (int i = 0; i < payMethodList.size(); i++) {
//
//			String payMethodName = payMethodList.get(i).getText();
//
//			pl_position = (i + 1);
//
//			if (payMethodName.contains("Pay Later")) {
//
//				System.out.println("Simpl Option is present on the No. " + pl_position + " position");
//
//				String xpathactual = payMethodList.get(i).toString();
//
//				String[] xpathact1 = xpathactual.split("xpath:");
//
//				System.out.println(xpathact1);

//				String xpathact2 = xpathact1[1].replaceAll("button]", "button");
//
//				String abc = "(" + xpathact2 + ")[" + pl_position + "]";
//
//				String abc1 = abc.replace(" ", "");
//				

//				WebElement element1 = driver.findElement(By.xpath(abc1));
//
//				element1.click();
//
//				if (eventPositiononbtn == 0) {
//
//					eventPositiononbtntext = "NO";
//				}
//
//				String actualtext = driver.findElement(By.xpath("//p[@class='sc-1gu8y64-0 BbwkM sc-1cpgc0r-2 bwWQSe']"))
//						.getText();
//
//				Assert.assertEquals(actualtext, "Simpl", "Simpl Option is not present on the Payment Page");
//
//				String text1 = actualtext + " Option is present on the Payment Page";
//
//				dataList.add(text1);
//
//				dataList.add(eventPositiononbtntext);
//
//				dataValues.put(pl_position, dataList);

//			}
//
//			else {
//
//				System.out.println("Simpl option is not present on the No." + pl_position + " position");
//
//				flag++;
//
//			}
//
//			if (!payMethodName.contains("Pay Later") && flag == payMethodList.size()) {
//
//				System.out.println("Pay Later Option is not present for this particular user");
//
//			}
//
//		}

		return dataValues;

	}

}
