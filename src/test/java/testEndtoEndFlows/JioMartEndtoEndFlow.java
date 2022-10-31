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

public class JioMartEndtoEndFlow extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	ReadConfig readconfig = new ReadConfig();

	public Map<Integer, ArrayList<String>> jioMartSuccessfulScenarioCode() throws Exception {

		driver.get(readconfig.getdunzoURL());

		driver.manage().window().maximize();

		int pl_position = 0;

		int eventPositiononbtn = 0;

		String eventPositiononbtntext = null;

		int flag = 0;

		ArrayList<String> dataList = new ArrayList<String>();

		Map<Integer, ArrayList<String>> dataValues = new HashMap<Integer, ArrayList<String>>();
		
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		
		driver.findElement(By.id("#loginfirst_mobileno")).sendKeys(readconfig.getsuccessMobNo());
		
		driver.findElement(By.xpath("//button[@class='btn-signpass arrowbtn']")).click();
		
		Thread.sleep(150000);
		
		driver.findElement(By.xpath("//button[@class='btn-login']")).click();
		
		driver.findElement(By.xpath("//button[@class='toCart addtocartbtn' and @data-sku='590032551']")).click();
		
		driver.findElement(By.className("cart_text")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		wait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@orientation='vertical']/button")));

		List<WebElement> payMethodList = driver.findElements(By.xpath("//div[@orientation='vertical']/button"));

		for (int i = 0; i < payMethodList.size(); i++) {

			String payMethodName = payMethodList.get(i).getText();

			pl_position = (i + 1);

			if (payMethodName.contains("Recently Used")) {

				System.out.println("Simpl Option is present on the No. " + pl_position + " position");

				String xpathactual = payMethodList.get(i).toString();

				String[] xpathact1 = xpathactual.split("xpath:");

				String xpathact2 = xpathact1[1].replaceAll("button]", "button");

				String abc = "(" + xpathact2 + ")[" + pl_position + "]";

				String abc1 = abc.replace(" ", "");

				WebElement element1 = driver.findElement(By.xpath(abc1));

				element1.click();

				if (eventPositiononbtn == 0) {

					eventPositiononbtntext = "NO";
				}

				String actualtext = driver.findElement(By.xpath("//p[@class='sc-1gu8y64-0 BbwkM sc-1cpgc0r-2 bwWQSe']"))
						.getText();

				Assert.assertEquals(actualtext, "Simpl", "Simpl Option is not present on the Payment Page");

				String text1 = actualtext + " Option is present on the Payment Page";

				dataList.add(text1);

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
