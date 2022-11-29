package testEndtoEndFlows;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import commonMethods.BaseClass;
import commonMethods.ReadConfig;

public class GoIbiboEndtoEndFlow extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	ReadConfig readconfig = new ReadConfig();

	public Map<Integer, ArrayList<String>> GoIbiboSuccessTestCode() throws Exception {

		driver.get(readconfig.getGoibiboURL());

		driver.manage().window().maximize();

		int pl_position = 0;

		int eventPositiononbtn = 0;

		String eventPositiononbtntext = null;

		ArrayList<String> dataList = new ArrayList<String>();

		Map<Integer, ArrayList<String>> dataValues = new HashMap<Integer, ArrayList<String>>();

		driver.findElement(By.xpath("(//a[@href='/cars/'])[1]")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("downshift-1-input")));

		driver.findElement(By.id("downshift-1-input")).sendKeys("Dhanori, Pune, Maharashtra, India");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='downshift-1-menu']/div/li)[1]")));

		driver.findElement(By.xpath("(//div[@id='downshift-1-menu']/div/li)[1]")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("downshift-2-input")));

		driver.findElement(By.id("downshift-2-input")).sendKeys(
				"Pune Airport (PNQ), New Airport Road, Pune International Airport Area, Lohegaon, Pune, Maharashtra, India");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='downshift-2-menu']/div/li)[1]")));

		driver.findElement(By.xpath("(//div[@id='downshift-2-menu']/div/li)[1]")).click();

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[contains(@class,'CalendarBlock')]/div[1]/span")));

		driver.findElement(By.xpath("//div[contains(@class,'CalendarBlock')]/div[1]/span")).click();

		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@class,'DateWrapDiv')]/li[16]/span")));

		driver.findElement(By.xpath("//ul[contains(@class,'DateWrapDiv')]/li[16]/span")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'SEARCH CABS')]")));

		driver.findElement(By.xpath("//button[contains(text(),'SEARCH CABS')]")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'SELECT')])[1]")));

		driver.findElement(By.xpath("(//button[contains(text(),'SELECT')])[1]")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@class='textInput'])[2]")));

		driver.findElement(By.xpath("(//input[@class='textInput'])[2]")).sendKeys("Rakshit Ogra");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@class='textInput'])[3]")));

		driver.findElement(By.xpath("(//input[@class='textInput'])[3]")).sendKeys("9324977971");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@class='textInput'])[4]")));

		driver.findElement(By.xpath("(//input[@class='textInput'])[4]")).sendKeys("rakshit.ogra@getsimpl.com");

		wait.until(ExpectedConditions.elementToBeClickable(By.id("paymentButton")));

		driver.findElement(By.id("paymentButton")).click();

		wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'paymentOptions')]/ul/li")));

		List<WebElement> payMethodList = driver
				.findElements(By.xpath("//div[contains(@class,'paymentOptions')]/ul/li"));

		for (int i = 0; i < payMethodList.size(); i++) {

			String payMethodName = payMethodList.get(i).getText();

			pl_position = (i + 1);

			if (payMethodName.contains("Pay Later")) {

				System.out.println("Pay Later Option is present on the No. " + (i + 1) + " position");

				String xpathactual = payMethodList.get(i).toString();

				String[] xpathact1 = xpathactual.split("xpath:");

				String xpathact2 = xpathact1[1].replaceAll("/ul/li]", "/ul/li");

				String abc = "(" + xpathact2 + ")[" + pl_position + "]";

				String abc1 = abc.replace(" ", "");

				WebElement element4 = driver.findElement(By.xpath(abc1));

				wait.until(ExpectedConditions.elementToBeClickable(element4));

				element4.click();

				wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//button[contains(text(),'Find partners')]")));

				driver.findElement(By.xpath("//button[contains(text(),'Find partners')]")).click();

				eventPositiononbtn = 1;

				if (eventPositiononbtn == 0) {

					eventPositiononbtntext = "NO";
				}

				else {
					eventPositiononbtntext = "YES";
				}

				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'Simpl')]")));

				String actualtext = driver.findElement(By.xpath("//p[contains(text(),'Simpl')]")).getText();

				Assert.assertEquals(actualtext, "Simpl", "Simpl Option is not present on the Payment Page");

				String text1 = actualtext + " Option is present on the Payment Page";

				String text2 = text1.strip().toLowerCase();

				dataList.add(text2);

				dataList.add(eventPositiononbtntext);

				dataValues.put(pl_position, dataList);

			}

			else {

				System.out.println("Pay Later Option is not present on the No." + pl_position + " position");

			}

		}
		return dataValues;

	}

}
