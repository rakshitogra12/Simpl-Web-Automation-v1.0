package testEndtoEndFlows;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import commonMethods.BaseClass;
import commonMethods.ReadConfig;

public class FreshtoHomeEndtoEndFlow extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	ReadConfig readconfig = new ReadConfig();

	public Map<Integer, ArrayList<String>> freshtoHomeSuccessTestCode() throws Exception {

		driver.get(readconfig.getfreshtoHomeURL());

		driver.manage().window().maximize();

//		int pl_position = 0;
//
//		int eventPositiononbtn = 0;
//
//		String eventPositiononbtntext = null;
//
//		ArrayList<String> dataList = new ArrayList<String>();

		Map<Integer, ArrayList<String>> dataValues = new HashMap<Integer, ArrayList<String>>();

		driver.findElement(By.id("autoComplete")).sendKeys("411015");

		driver.findElement(By.id("autoComplete")).sendKeys(Keys.ENTER);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title=\"Login\"]")));

		driver.findElement(By.cssSelector("a[title=\"Login\"]")).click();

		driver.findElement(By.cssSelector("#youama-phone")).sendKeys(readconfig.getsuccessMobNo());
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("sendOtpBtn")));

		driver.findElement(By.id("sendOtpBtn")).click();

		Thread.sleep(15000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("otpLoginBtn")));

		driver.findElement(By.id("otpLoginBtn")).click();

		System.out.println("Before code block");

//		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("form[id='search_mini_form']>div>input")));
//
//		driver.findElement(By.cssSelector("form[id='search_mini_form']>div>input")).sendKeys("Butter Chicken - 450g Pack");
//
//		System.out.println("After code block");

//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[title='Search']")));
//
//		driver.findElement(By.cssSelector("button[title='Search']")).click();
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title=\"Butter Chicken - 450g Pack\"]")));
//
//		driver.findElement(By.cssSelector("a[title=\"Butter Chicken - 450g Pack\"]")).click();
//
//		driver.findElement(By.cssSelector("button[class='button btn-cart']")).click();
//
//		driver.findElement(By.cssSelector("div[class=\"menu-cart-icon\"]")).click();
//
//		driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
//
//		driver.findElement(By.cssSelector("button[class=\"button btn-checkout\"]:nth-child(1)")).click();
//
//		driver.findElement(By.cssSelector("button[class=\"button btn-checkout\"]")).click();
//
//		driver.findElement(By.id("pay-online")).click();
//
//		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
//
//		wait.until(ExpectedConditions
//				.presenceOfAllElementsLocatedBy(By.xpath("div[class='border-list svelte-2ktngz']>button")));
//
//		List<WebElement> payMethodList = driver.findElements(By.xpath("div[class='border-list svelte-2ktngz']>button"));
//
//		Thread.sleep(10000);
//
//		for (int i = 0; i < payMethodList.size(); i++) {
//
//			String payMethodName = payMethodList.get(i).getText();
//
//			System.out.println(payMethodName);

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
//				WebElement element4 = driver.findElement(By.xpath(abc1));
//
//				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element4);
//
//				Thread.sleep(13000);
//
//				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(abc1)))).click();
//
//				if (eventPositiononbtn == 0) {
//
//					eventPositiononbtntext = "NO";
//				}
//
//				wait.until(
//						ExpectedConditions.presenceOfElementLocated(By.xpath(bigbasketFlowElements.payLaterElements)));
//
//				String actualtext = driver.findElement(By.xpath(bigbasketFlowElements.payLaterElements)).getText();
//				Assert.assertEquals(actualtext, "Simpl", "Simpl Option is not present on the Payment Page");
//
//				String text1 = actualtext + " Option is present on the Payment Page";
//
//				dataList.add(text1);
//
//				dataList.add(eventPositiononbtntext);
//
//				dataValues.put(pl_position, dataList);

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
