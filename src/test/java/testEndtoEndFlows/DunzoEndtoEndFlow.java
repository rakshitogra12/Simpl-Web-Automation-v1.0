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
import pageObjectFiles.DunzoFlowElements;

public class DunzoEndtoEndFlow extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	ReadConfig readconfig = new ReadConfig();

	public Map<Integer, ArrayList<String>> DunzoSuccessTestCode() throws Exception {

		driver.get(readconfig.getdunzoURL());

		driver.manage().window().maximize();

		int pl_position = 0;

		int eventPositiononbtn = 0;

		String eventPositiononbtntext = null;

		int flag = 0;

		ArrayList<String> dataList = new ArrayList<String>();

		Map<Integer, ArrayList<String>> dataValues = new HashMap<Integer, ArrayList<String>>();

		driver.findElement(By.xpath(DunzoFlowElements.SignIn)).click();

		driver.findElement(By.xpath(DunzoFlowElements.MobNo)).sendKeys(readconfig.getsuccessMobNo());

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(DunzoFlowElements.Continuebtn)));

		driver.findElement(By.cssSelector(DunzoFlowElements.Continuebtn)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DunzoFlowElements.SendOTPbtn)));

		driver.findElement(By.xpath(DunzoFlowElements.SendOTPbtn)).click();

		Thread.sleep(15000);

		driver.findElement(By.xpath(DunzoFlowElements.Grocerylink)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DunzoFlowElements.Locationlink)));

		driver.findElement(By.xpath(DunzoFlowElements.Locationlink)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DunzoFlowElements.Addbtn)));

		driver.findElement(By.xpath(DunzoFlowElements.Addbtn)).click();

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id(DunzoFlowElements.framelocator)));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DunzoFlowElements.closelink)));

		driver.findElement(By.xpath(DunzoFlowElements.closelink)).click();

		driver.switchTo().defaultContent();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DunzoFlowElements.checkoutbtn)));

		driver.findElement(By.xpath(DunzoFlowElements.checkoutbtn)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DunzoFlowElements.addressbtn)));

		driver.findElement(By.xpath(DunzoFlowElements.addressbtn)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DunzoFlowElements.selectTimebtn)));

		driver.findElement(By.xpath(DunzoFlowElements.selectTimebtn)).click();

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(DunzoFlowElements.elementsList)));

		List<WebElement> payMethodList = driver.findElements(By.xpath(DunzoFlowElements.elementsList));

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

					eventPositiononbtntext = "N";
				}

				String actualtext = driver.findElement(By.xpath(DunzoFlowElements.payLaterElement)).getText();

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