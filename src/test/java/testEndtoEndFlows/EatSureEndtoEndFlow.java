	package testEndtoEndFlows;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import commonMethods.BaseClass;
import commonMethods.ReadConfig;

public class EatSureEndtoEndFlow extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	ReadConfig readconfig = new ReadConfig();

	public Map<Integer, ArrayList<String>> eatSureSuccessTestCode() throws Exception {

		driver.get(readconfig.getEatsureURL());

		driver.manage().window().maximize();

		int pl_position = 0;

		int eventPositiononbtn = 0;

		String eventPositiononbtntext = null;

		ArrayList<String> dataList = new ArrayList<String>();

		Map<Integer, ArrayList<String>> dataValues = new HashMap<Integer, ArrayList<String>>();

		driver.findElement(By.cssSelector("input[data-testid=\"autocomplete-input\"]")).sendKeys("Pune");

		wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("ul[data-testid=\"autocomplete-dropdown\"]>li:nth-child(1)")));

		wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("ul[data-testid=\"autocomplete-dropdown\"]>li:nth-child(1)")));

		driver.findElement(By.cssSelector("ul[data-testid=\"autocomplete-dropdown\"]>li:nth-child(1)")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("p[data-qa=\"searchOption\"]")));

		driver.findElement(By.cssSelector("p[data-qa=\"searchOption\"]")).click();

		wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("input[class=\"style__Input-sc-1nogo41-4 cbRUfa\"]")));

		driver.findElement(By.cssSelector("input[class=\"style__Input-sc-1nogo41-4 cbRUfa\"]")).sendKeys("Biryani");

		wait.until(ExpectedConditions.elementToBeClickable(
				By.cssSelector("div[class=\"style__ListContainer-sc-1nogo41-9 cPORqb\"]>a:nth-child(1)")));

		driver.findElement(By.cssSelector("div[class=\"style__ListContainer-sc-1nogo41-9 cPORqb\"]>a:nth-child(1)"))
				.click();

		wait.until(
				ExpectedConditions.elementToBeClickable(By.cssSelector("button[class=\"Button-sc-3qnwiq-0 etFFiT\"]")));

		driver.findElement(By.cssSelector("button[class=\"Button-sc-3qnwiq-0 etFFiT\"]")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-qa=\"addItemButton\"]")));

		driver.findElement(By.cssSelector("button[data-qa=\"addItemButton\"]")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("p[data-qa='cartOption']")));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				driver.findElement(By.cssSelector("p[data-qa='cartOption']")));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone_number")));

		driver.findElement(By.id("phone_number")).sendKeys("9324977971");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("send_otp")));

		driver.findElement(By.id("send_otp")).click();

		Thread.sleep(15000);

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[role=\"submit\"]")));

		driver.findElement(By.cssSelector("button[role=\"submit\"]")).click();

		wait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='sc-furvIG lkLLxz']>div")));

		List<WebElement> payMethodList = driver.findElements(By.cssSelector("div[class='sc-furvIG lkLLxz']>div"));

		Thread.sleep(5000);

		for (int i = 0; i < payMethodList.size(); i++) {

			String payMethodName = payMethodList.get(i).getText();

			pl_position = (i + 1);

			if (payMethodName.contains("Pay later")) {

				System.out.println("Pay Later Option is present on the No. " + pl_position + " position");

				String xpathactual = payMethodList.get(i).toString();

				String[] xpathact1 = xpathactual.split("css selector:");

				String xpathact2 = xpathact1[1].replaceAll(">div]", ">div");

				String abc = xpathact2 + ":nth-child" + "(" + pl_position + ")";

				WebElement element4 = driver.findElement(By.cssSelector(abc));

				wait.until(ExpectedConditions.elementToBeClickable(element4));

				element4.click();

				if (eventPositiononbtn == 0) {

					eventPositiononbtntext = "N";
				}

				Thread.sleep(10000);

				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.cssSelector("div[class='flex-x9ump0-0 iAgTKA']>div:nth-child(1)")));

				String actualtext = driver
						.findElement(By.cssSelector("div[class='flex-x9ump0-0 iAgTKA']>div:nth-child(1)")).getText();

				Assert.assertEquals(actualtext, "SIMPL", "Simpl Option is not present on the Payment Page");

				String text1 = actualtext + " Option is present on the Payment Page";

				String text2 = text1.toLowerCase();

				dataList.add(text2);

				dataList.add(eventPositiononbtntext);

				dataValues.put(pl_position, dataList);

				// print command that Simpl is present on the Big Basket- Web Application
				// Checkout Page for email shooting

			}

			else {

				System.out.println("Pay Later Option is not present on the No." + pl_position + " position");

				// print command that Simpl is not present on the Big Basket- Web Application
				// Checkout Page for email shooting

			}

		}

		return dataValues;
	}

//	public void eatSureBlockedTestCode() throws InterruptedException {
//
//		driver.get(readconfig.getbigBasketURL());
//
//		driver.manage().window().maximize();
//
//		int pl_position = 0;
//
//		int flag = 0;
//
//		driver.findElement(By.linkText(bigbasketFlowElements.Login)).click();
//
//		driver.findElement(By.id(bigbasketFlowElements.OTP)).sendKeys(readconfig.getblockedMobNo());
//
//		driver.findElement(By.xpath(bigbasketFlowElements.Continuebtn)).click();
//
//		Thread.sleep(15000);
//
//		driver.findElement(By.cssSelector(bigbasketFlowElements.VerifyOTPbtn)).click();
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bigbasketFlowElements.AddItembtn)));
//
//		driver.findElement(By.xpath(bigbasketFlowElements.AddItembtn)).click(); // Add a item here
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bigbasketFlowElements.Mybasketbtn)));
//
//		driver.findElement(By.xpath(bigbasketFlowElements.Mybasketbtn)).click();
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bigbasketFlowElements.Checkoutbtn)));
//
//		driver.findElement(By.xpath(bigbasketFlowElements.Checkoutbtn)).click();
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(bigbasketFlowElements.Checkoutbtn2)));
//
//		driver.findElement(By.cssSelector(bigbasketFlowElements.Checkoutbtn2)).click();
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(bigbasketFlowElements.deliverHere)));
//
//		WebElement element1 = driver.findElement(By.cssSelector(bigbasketFlowElements.deliverHere));
//
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bigbasketFlowElements.handleCartbtn)));
//
//		WebElement element2 = driver.findElement(By.xpath(bigbasketFlowElements.handleCartbtn));
//
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element2);
//
//		Thread.sleep(13000);
//
//		System.out.println("Page Load has been successfully completed");
//
//		WebElement element3 = driver.findElement(By.xpath(bigbasketFlowElements.confirmSlotbtn));
//
//		Actions builder = new Actions(driver);
//
//		Action mouseOverHome = builder.moveToElement(element3).click().build();
//
//		Thread.sleep(5000);
//
//		mouseOverHome.perform();
//
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(bigbasketFlowElements.juspayFrame)));
//
//		wait.until(
//				ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(bigbasketFlowElements.payMethodselements)));
//
//		List<WebElement> payMethodList = driver.findElements(By.xpath(bigbasketFlowElements.payMethodselements));
//
//		Thread.sleep(10000);
//
//		for (int i = 0; i < payMethodList.size(); i++) {
//
//			String payMethodName = payMethodList.get(i).getText();
//
//			pl_position = (i + 1);
//
//			if (payMethodName.contains("Pay Later")) {
//
//				System.out.println("Pay Later Option is present on the No. " + (i + 1) + " position");
//
//				String xpathactual = payMethodList.get(i).toString();
//
//				String[] xpathact1 = xpathactual.split("xpath:");
//
//				String xpathact2 = xpathact1[1].replaceAll("article]", "article");
//
//				String abc = "(" + xpathact2 + ")[" + pl_position + "]";
//
//				String abc1 = abc.replace(" ", "");
//
//				WebElement element4 = driver.findElement(By.xpath(abc1));
//
//				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element4);
//
//				Thread.sleep(13000);
//
//				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(abc1)))).click();
//
//				wait.until(
//						ExpectedConditions.presenceOfElementLocated(By.xpath(bigbasketFlowElements.payLaterElements)));
//
//				String actualtext = driver.findElement(By.xpath(bigbasketFlowElements.payLaterElements)).getText();
//
//				Assert.assertEquals(actualtext, "Simpl", "Simpl Option is not present on the Payment Page");
//
//			}
//
//			if (!payMethodName.contains("Pay Later")) {
//
//				System.out.println("Pay Later Option is not present on the No." + pl_position + " position");
//
//				flag++;
//
//				// print command that Simpl is not present on the Big Basket- Web Application
//				// Checkout Page for email shooting
//
//			}
//			if (!payMethodName.contains("Pay Later") && flag == payMethodList.size()) {
//
//				System.out.println("Pay Later Option is not present for this particular user");
//
//			}
//
//		}
//
//	}
//
//	public void eatSureInsufficentCreditTestCode() throws InterruptedException {
//
//		driver.get(readconfig.getbigBasketURL());
//
//		driver.manage().window().maximize();
//
//		int pl_position = 0;
//
//		int flag = 0;
//
//		driver.findElement(By.linkText(bigbasketFlowElements.Login)).click();
//
//		driver.findElement(By.id(bigbasketFlowElements.OTP)).sendKeys("8904085564");
//
//		driver.findElement(By.xpath(bigbasketFlowElements.Continuebtn)).click();
//
//		Thread.sleep(20000);
//
//		driver.findElement(By.cssSelector(bigbasketFlowElements.VerifyOTPbtn)).click();
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bigbasketFlowElements.AddItembtn)));
//
//		driver.findElement(By.xpath(bigbasketFlowElements.AddItembtn)).click(); // Add a item here
//
//		Thread.sleep(10000);
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bigbasketFlowElements.Mybasketbtn)));
//
//		driver.findElement(By.xpath(bigbasketFlowElements.Mybasketbtn)).click();
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bigbasketFlowElements.Checkoutbtn)));
//
//		driver.findElement(By.xpath(bigbasketFlowElements.Checkoutbtn)).click();
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(bigbasketFlowElements.Checkoutbtn2)));
//
//		driver.findElement(By.cssSelector(bigbasketFlowElements.Checkoutbtn2)).click();
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(bigbasketFlowElements.deliverHere)));
//
//		WebElement element1 = driver.findElement(By.cssSelector(bigbasketFlowElements.deliverHere));
//
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bigbasketFlowElements.handleCartbtn)));
//
//		WebElement element2 = driver.findElement(By.xpath(bigbasketFlowElements.handleCartbtn));
//
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element2);
//
//		Thread.sleep(13000);
//
//		System.out.println("Page Load has been successfully completed");
//
//		WebElement element3 = driver.findElement(By.xpath(bigbasketFlowElements.confirmSlotbtn));
//
//		Actions builder = new Actions(driver);
//
//		Action mouseOverHome = builder.moveToElement(element3).click().build();
//
//		Thread.sleep(5000);
//
//		mouseOverHome.perform();
//
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(bigbasketFlowElements.juspayFrame)));
//
//		wait.until(
//				ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(bigbasketFlowElements.payMethodselements)));
//
//		List<WebElement> payMethodList = driver.findElements(By.xpath(bigbasketFlowElements.payMethodselements));
//
//		Thread.sleep(10000);
//
//		for (int i = 0; i < payMethodList.size(); i++) {
//
//			String payMethodName = payMethodList.get(i).getText();
//
//			pl_position = (i + 1);
//
//			if (payMethodName.contains("Pay Later")) {
//
//				System.out.println("Pay Later Option is present on the No. " + (i + 1) + " position");
//
//				String xpathactual = payMethodList.get(i).toString();
//
//				String[] xpathact1 = xpathactual.split("xpath:");
//
//				String xpathact2 = xpathact1[1].replaceAll("article]", "article");
//
//				String abc = "(" + xpathact2 + ")[" + pl_position + "]";
//
//				String abc1 = abc.replace(" ", "");
//
//				WebElement element4 = driver.findElement(By.xpath(abc1));
//
//				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element4);
//
//				Thread.sleep(13000);
//
//				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(abc1)))).click();
//
//				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bigbasketFlowElements.payLaterElements)));
//
//				driver.findElement(By.xpath(bigbasketFlowElements.payLaterElements)).click();
//
//				wait.until(ExpectedConditions
//						.elementToBeClickable(By.xpath("//div[@class='linearLayout ' and @id='578']/div/article")));
//
//				driver.findElement(By.xpath("//div[@class='linearLayout ' and @id='578']/div/article")).click();
//
//				Thread.sleep(10000);
//
//				wait.until(
//						ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='transaction-flow-banner']/p")));
//
//				String text = driver.findElement(By.xpath("//div[@class='transaction-flow-banner']/p")).getText();
//
//				System.out.println(text);
//
////				Assert.assertEquals(actualtext, "Simpl", "Simpl Option is not present on the Payment Page");
//
//			}
//
//			if (!payMethodName.contains("Pay Later")) {
//
//				System.out.println("Pay Later Option is not present on the No." + pl_position + " position");
//
//				flag++;
//
//				// print command that Simpl is not present on the Big Basket- Web Application
//				// Checkout Page for email shooting
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
//
//	}
//
//	public void eatSureUnableToProcessTestCode() throws InterruptedException {
//
//		driver.get(readconfig.getbigBasketURL());
//
//		driver.manage().window().maximize();
//
//		int pl_position = 0;
//
//		int flag = 0;
//
//		driver.findElement(By.linkText(bigbasketFlowElements.Login)).click();
//
//		driver.findElement(By.id(bigbasketFlowElements.OTP)).sendKeys(readconfig.getsuccessMobNo());
//
//		driver.findElement(By.xpath(bigbasketFlowElements.Continuebtn)).click();
//
//		Thread.sleep(15000);
//
//		driver.findElement(By.cssSelector(bigbasketFlowElements.VerifyOTPbtn)).click();
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bigbasketFlowElements.AddItembtn)));
//
//		driver.findElement(By.xpath(bigbasketFlowElements.AddItembtn)).click(); // Add a item here
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bigbasketFlowElements.Mybasketbtn)));
//
//		driver.findElement(By.xpath(bigbasketFlowElements.Mybasketbtn)).click();
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bigbasketFlowElements.Checkoutbtn)));
//
//		driver.findElement(By.xpath(bigbasketFlowElements.Checkoutbtn)).click();
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(bigbasketFlowElements.Checkoutbtn2)));
//
//		driver.findElement(By.cssSelector(bigbasketFlowElements.Checkoutbtn2)).click();
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(bigbasketFlowElements.deliverHere)));
//
//		WebElement element1 = driver.findElement(By.cssSelector(bigbasketFlowElements.deliverHere));
//
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bigbasketFlowElements.handleCartbtn)));
//
//		WebElement element2 = driver.findElement(By.xpath(bigbasketFlowElements.handleCartbtn));
//
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element2);
//
//		Thread.sleep(13000);
//
//		System.out.println("Page Load has been successfully completed");
//
//		WebElement element3 = driver.findElement(By.xpath(bigbasketFlowElements.confirmSlotbtn));
//
//		Actions builder = new Actions(driver);
//
//		Action mouseOverHome = builder.moveToElement(element3).click().build();
//
//		Thread.sleep(5000);
//
//		mouseOverHome.perform();
//
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(bigbasketFlowElements.juspayFrame)));
//
//		wait.until(
//				ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(bigbasketFlowElements.payMethodselements)));
//
//		List<WebElement> payMethodList = driver.findElements(By.xpath(bigbasketFlowElements.payMethodselements));
//
//		Thread.sleep(10000);
//
//		for (int i = 0; i < payMethodList.size(); i++) {
//
//			String payMethodName = payMethodList.get(i).getText();
//
//			pl_position = (i + 1);
//
//			if (payMethodName.contains("Pay Later")) {
//
//				System.out.println("Pay Later Option is present on the No. " + (i + 1) + " position");
//
//				String xpathactual = payMethodList.get(i).toString();
//
//				String[] xpathact1 = xpathactual.split("xpath:");
//
//				String xpathact2 = xpathact1[1].replaceAll("article]", "article");
//
//				String abc = "(" + xpathact2 + ")[" + pl_position + "]";
//
//				String abc1 = abc.replace(" ", "");
//
//				WebElement element4 = driver.findElement(By.xpath(abc1));
//
//				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element4);
//
//				Thread.sleep(13000);
//
//				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(abc1)))).click();
//
//				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bigbasketFlowElements.payLaterElements)));
//
//				driver.findElement(By.xpath(bigbasketFlowElements.payLaterElements)).click();
//
//				wait.until(ExpectedConditions
//						.elementToBeClickable(By.xpath("//div[@class='linearLayout ' and @id='578']/div/article")));
//
//				driver.findElement(By.xpath("//div[@class='linearLayout ' and @id='578']/div/article")).click();
//
//				Thread.sleep(20000);
//
//				wait.until(ExpectedConditions
//						.presenceOfElementLocated(By.xpath("//div[@class='transaction-flow-banner']/p")));
//
//				String text = driver.findElement(By.xpath("//div[@class='transaction-flow-banner']/p")).getText();
//
//				System.out.println(text);
//
////					Assert.assertEquals(actualtext, "Simpl", "Simpl Option is not present on the Payment Page");
//
//			}
//
//			if (!payMethodName.contains("Pay Later")) {
//
//				System.out.println("Pay Later Option is not present on the No." + pl_position + " position");
//
//				flag++;
//
//				// print command that Simpl is not present on the Big Basket- Web Application
//				// Checkout Page for email shooting
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
//
//	}
//
//	public void eatSurependingBillTestCode() throws InterruptedException {
//
//		driver.get(readconfig.getbigBasketURL());
//
//		driver.manage().window().maximize();
//
//		int pl_position = 0;
//
//		int flag = 0;
//
//		driver.findElement(By.linkText(bigbasketFlowElements.Login)).click();
//
//		driver.findElement(By.id(bigbasketFlowElements.OTP)).sendKeys(readconfig.getpendingbillNo());
//
//		driver.findElement(By.xpath(bigbasketFlowElements.Continuebtn)).click();
//
//		Thread.sleep(15000);
//
//		driver.findElement(By.cssSelector(bigbasketFlowElements.VerifyOTPbtn)).click();
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bigbasketFlowElements.AddItembtn)));
//
//		driver.findElement(By.xpath(bigbasketFlowElements.AddItembtn)).click(); // Add a item here
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bigbasketFlowElements.Mybasketbtn)));
//
//		driver.findElement(By.xpath(bigbasketFlowElements.Mybasketbtn)).click();
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bigbasketFlowElements.Checkoutbtn)));
//
//		driver.findElement(By.xpath(bigbasketFlowElements.Checkoutbtn)).click();
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(bigbasketFlowElements.Checkoutbtn2)));
//
//		driver.findElement(By.cssSelector(bigbasketFlowElements.Checkoutbtn2)).click();
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(bigbasketFlowElements.deliverHere)));
//
//		WebElement element1 = driver.findElement(By.cssSelector(bigbasketFlowElements.deliverHere));
//
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bigbasketFlowElements.handleCartbtn)));
//
//		WebElement element2 = driver.findElement(By.xpath(bigbasketFlowElements.handleCartbtn));
//
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element2);
//
//		Thread.sleep(13000);
//
//		System.out.println("Page Load has been successfully completed");
//
//		WebElement element3 = driver.findElement(By.xpath(bigbasketFlowElements.confirmSlotbtn));
//
//		Actions builder = new Actions(driver);
//
//		Action mouseOverHome = builder.moveToElement(element3).click().build();
//
//		Thread.sleep(5000);
//
//		mouseOverHome.perform();
//
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(bigbasketFlowElements.juspayFrame)));
//
//		wait.until(
//				ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(bigbasketFlowElements.payMethodselements)));
//
//		List<WebElement> payMethodList = driver.findElements(By.xpath(bigbasketFlowElements.payMethodselements));
//
//		Thread.sleep(10000);
//
//		for (int i = 0; i < payMethodList.size(); i++) {
//
//			String payMethodName = payMethodList.get(i).getText();
//
//			pl_position = (i + 1);
//
//			if (payMethodName.contains("Pay Later")) {
//
//				System.out.println("Pay Later Option is present on the No. " + (i + 1) + " position");
//
//				String xpathactual = payMethodList.get(i).toString();
//
//				String[] xpathact1 = xpathactual.split("xpath:");
//
//				String xpathact2 = xpathact1[1].replaceAll("article]", "article");
//
//				String abc = "(" + xpathact2 + ")[" + pl_position + "]";
//
//				String abc1 = abc.replace(" ", "");
//
//				WebElement element4 = driver.findElement(By.xpath(abc1));
//
//				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element4);
//
//				Thread.sleep(13000);
//
//				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(abc1)))).click();
//
//				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bigbasketFlowElements.payLaterElements)));
//
//				driver.findElement(By.xpath(bigbasketFlowElements.payLaterElements)).click();
//
//				wait.until(ExpectedConditions
//						.elementToBeClickable(By.xpath("//div[@class='linearLayout ' and @id='578']/div/article")));
//
//				driver.findElement(By.xpath("//div[@class='linearLayout ' and @id='578']/div/article")).click();
//
//				Thread.sleep(20000);
//
//				wait.until(ExpectedConditions
//						.presenceOfElementLocated(By.xpath("//div[@class='transaction-flow-banner']/p")));
//
//				String text = driver.findElement(By.xpath("//div[@class='transaction-flow-banner']/p")).getText();
//
//				System.out.println(text);
//
////					Assert.assertEquals(actualtext, "Simpl", "Simpl Option is not present on the Payment Page");
//
//			}
//
//			if (!payMethodName.contains("Pay Later")) {
//
//				System.out.println("Pay Later Option is not present on the No." + pl_position + " position");
//
//				flag++;
//
//				// print command that Simpl is not present on the Big Basket- Web Application
//				// Checkout Page for email shooting
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
//
//	}
//
//	public void eatSureOtherScenarioCode() throws InterruptedException {
//
//		driver.get(readconfig.getbigBasketURL());
//
//		driver.manage().window().maximize();
//
//		int pl_position = 0;
//
//		int flag = 0;
//
//		driver.findElement(By.linkText(bigbasketFlowElements.Login)).click();
//
//		driver.findElement(By.id(bigbasketFlowElements.OTP)).sendKeys(readconfig.getpendingbillNo());
//
//		driver.findElement(By.xpath(bigbasketFlowElements.Continuebtn)).click();
//
//		Thread.sleep(15000);
//
//		driver.findElement(By.cssSelector(bigbasketFlowElements.VerifyOTPbtn)).click();
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bigbasketFlowElements.AddItembtn)));
//
//		driver.findElement(By.xpath(bigbasketFlowElements.AddItembtn)).click(); // Add a item here
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bigbasketFlowElements.Mybasketbtn)));
//
//		driver.findElement(By.xpath(bigbasketFlowElements.Mybasketbtn)).click();
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bigbasketFlowElements.Checkoutbtn)));
//
//		driver.findElement(By.xpath(bigbasketFlowElements.Checkoutbtn)).click();
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(bigbasketFlowElements.Checkoutbtn2)));
//
//		driver.findElement(By.cssSelector(bigbasketFlowElements.Checkoutbtn2)).click();
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(bigbasketFlowElements.deliverHere)));
//
//		WebElement element1 = driver.findElement(By.cssSelector(bigbasketFlowElements.deliverHere));
//
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bigbasketFlowElements.handleCartbtn)));
//
//		WebElement element2 = driver.findElement(By.xpath(bigbasketFlowElements.handleCartbtn));
//
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element2);
//
//		Thread.sleep(13000);
//
//		System.out.println("Page Load has been successfully completed");
//
//		WebElement element3 = driver.findElement(By.xpath(bigbasketFlowElements.confirmSlotbtn));
//
//		Actions builder = new Actions(driver);
//
//		Action mouseOverHome = builder.moveToElement(element3).click().build();
//
//		Thread.sleep(5000);
//
//		mouseOverHome.perform();
//
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(bigbasketFlowElements.juspayFrame)));
//
//		wait.until(
//				ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(bigbasketFlowElements.payMethodselements)));
//
//		List<WebElement> payMethodList = driver.findElements(By.xpath(bigbasketFlowElements.payMethodselements));
//
//		Thread.sleep(10000);
//
//		for (int i = 0; i < payMethodList.size(); i++) {
//
//			String payMethodName = payMethodList.get(i).getText();
//
//			pl_position = (i + 1);
//
//			if (payMethodName.contains("Pay Later")) {
//
//				System.out.println("Pay Later Option is present on the No. " + (i + 1) + " position");
//
//				String xpathactual = payMethodList.get(i).toString();
//
//				String[] xpathact1 = xpathactual.split("xpath:");
//
//				String xpathact2 = xpathact1[1].replaceAll("article]", "article");
//
//				String abc = "(" + xpathact2 + ")[" + pl_position + "]";
//
//				String abc1 = abc.replace(" ", "");
//
//				WebElement element4 = driver.findElement(By.xpath(abc1));
//
//				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element4);
//
//				Thread.sleep(13000);
//
//				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(abc1)))).click();
//
//				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bigbasketFlowElements.payLaterElements)));
//
//				driver.findElement(By.xpath(bigbasketFlowElements.payLaterElements)).click();
//
//				wait.until(ExpectedConditions
//						.elementToBeClickable(By.xpath("//div[@class='linearLayout ' and @id='578']/div/article")));
//
//				driver.findElement(By.xpath("//div[@class='linearLayout ' and @id='578']/div/article")).click();
//
//				Thread.sleep(20000);
//
//				wait.until(ExpectedConditions
//						.presenceOfElementLocated(By.xpath("//div[@class='transaction-flow-banner']/p")));
//
//				String text = driver.findElement(By.xpath("//div[@class='transaction-flow-banner']/p")).getText();
//
//				System.out.println(text);
//
////					Assert.assertEquals(actualtext, "Simpl", "Simpl Option is not present on the Payment Page");
//
//			}
//
//			if (!payMethodName.contains("Pay Later")) {
//
//				System.out.println("Pay Later Option is not present on the No." + pl_position + " position");
//
//				flag++;
//
//				// print command that Simpl is not present on the Big Basket- Web Application
//				// Checkout Page for email shooting
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
//
//	}

}
