package testEndtoEndFlows;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import commonMethods.BaseClass;
import commonMethods.ReadConfig;

public class JioMartEndtoEndFlow extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	ReadConfig readconfig = new ReadConfig();

	public Map<Integer, ArrayList<String>> JioMartSuccessfulScenarioCode() throws Exception {

		driver.get(readconfig.getjioMartURL());

		driver.manage().window().maximize();

		int pl_position = 0;

		int eventPositiononbtn = 0;

		String eventPositiononbtntext = null;

		int flag = 0;

		ArrayList<String> dataList = new ArrayList<String>();

		Map<Integer, ArrayList<String>> dataValues = new HashMap<Integer, ArrayList<String>>();

		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("loginfirst_mobileno")));

		driver.findElement(By.id("loginfirst_mobileno")).sendKeys(readconfig.getjioMartNo());

		driver.findElement(By.xpath("//button[contains(@class,'btn-signpass')]")).click();

		Thread.sleep(15000);

		driver.findElement(By.xpath("//button[@class='btn-login']")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@class,'input-text')]")));

		driver.findElement(By.xpath("//input[contains(@class,'input-text')]")).sendKeys("Colgate");

		driver.findElement(By.xpath("//input[contains(@class,'input-text')]")).sendKeys(Keys.ENTER);

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-sku='590983728']")));

		driver.findElement(By.cssSelector("button[data-sku='590983728']")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='cart_text']")));

		driver.findElement(By.cssSelector("a[class='cart_text']")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'btn-checkout')]")));

		driver.findElement(By.xpath("//button[contains(@class,'btn-checkout')]")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[class='deliver']")));

		driver.findElement(By.cssSelector("button[class='deliver']")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'btn-checkout')]")));

		driver.findElement(By.xpath("//button[contains(@class,'btn-checkout')]")).click();

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='css-1jheut0']/div/div")));

		List<WebElement> payMethodList = driver.findElements(By.xpath("//div[@class='css-1jheut0']/div/div"));

		for (int i = 0; i < payMethodList.size(); i++) {

			String payMethodName = payMethodList.get(i).getText();

			pl_position = (i + 1);

			if (payMethodName.contains("PAY LATER")) {

				System.out.println("Simpl Option is present on the No. " + pl_position + " position");

				String xpathactual = payMethodList.get(i).toString();

				String[] xpathact1 = xpathactual.split("xpath:");

				String xpathact2 = xpathact1[1].replaceAll("/div/div]", "/div/div");

				String abc = "(" + xpathact2 + ")[" + pl_position + "]";

				String abc1 = abc.replace(" ", "");

				WebElement element1 = driver.findElement(By.xpath(abc1));

				element1.click();

				if (eventPositiononbtn == 0) {

					eventPositiononbtntext = "N";
				}

				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//p[contains(text(),'Simpl')])[2]")));
				
				String actualtext = driver.findElement(By.xpath("(//p[contains(text(),'Simpl')])[2]")).getText();

				Assert.assertEquals(actualtext, "Simpl", "Simpl Option is not present on the Payment Page");

				String text1 = actualtext + " Option is present on the Payment Page";

				String text2 = text1.strip().toLowerCase();

				dataList.add(text2);

				dataList.add(eventPositiononbtntext);

				dataValues.put(pl_position, dataList);

			} else {

				System.out.println("Simpl option is not present on the No." + pl_position + " position");

				flag++;

			}

			if (!payMethodName.contains("Pay Later") && flag == payMethodList.size()) {

				System.out.println("Pay Later Option is not present for this particular user");

			}

		}
		return dataValues;

	}

}
