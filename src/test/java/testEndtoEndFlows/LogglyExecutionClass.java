/*
 * package testEndtoEndFlows;
 * 
 * import java.time.Duration; import org.openqa.selenium.By; import
 * org.openqa.selenium.JavascriptExecutor; import
 * org.openqa.selenium.interactions.Action; import
 * org.openqa.selenium.interactions.Actions; import
 * org.openqa.selenium.support.ui.ExpectedConditions; import
 * org.openqa.selenium.support.ui.WebDriverWait; import commonMethods.BaseClass;
 * import commonMethods.ReadConfig;
 * 
 * public class LogglyExecutionClass extends BaseClass {
 * 
 * ReadConfig readconfig = new ReadConfig();
 * 
 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
 * 
 * public void logglyexecutionmethod() throws InterruptedException {
 * 
 * driver.get(readconfig.getlogglyURL());
 * 
 * driver.manage().window().maximize();
 * 
 * driver.findElement(By.xpath("//button[@id='SamlLink_samlButton__oYXpU']")).
 * click();
 * 
 * driver.findElement(By.xpath("//input[@name='email']")).sendKeys(
 * "rakshit.ogra@getsimpl.com");
 * 
 * driver.findElement(By.xpath("//button[@type='submit']")).click();
 * 
 * Actions builder = new Actions(driver);
 * 
 * Action mouseOverHome = builder.moveToElement(driver.findElement(By.xpath(
 * "//input[@id='identifierId']"))) .click().build();
 * 
 * Thread.sleep(5000);
 * 
 * mouseOverHome.perform();
 * 
 * driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys(
 * "rakshit.ogra@getsimpl.com");
 * 
 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
 * "(//button[@jsname='LgbsSe'])[2]")));
 * 
 * Action mouseOverHome1 = builder.moveToElement(driver.findElement(By.xpath(
 * "(//button[@jsname='LgbsSe'])[2]"))) .click().build();
 * 
 * Thread.sleep(5000);
 * 
 * mouseOverHome1.perform();
 * 
 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
 * "//input[@type='password']")));
 * 
 * Action mouseOverHome2 =
 * builder.moveToElement(driver.findElement(By.xpath("//input[@type='password']"
 * ))).click() .build();
 * 
 * Thread.sleep(5000);
 * 
 * mouseOverHome2.perform();
 * 
 * driver.findElement(By.xpath("//input[@type='password']")).sendKeys(
 * "Midgard@0011");
 * 
 * System.out.println("Till password execution done");
 * 
 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
 * "(//button[@jsname='LgbsSe'])[2]")));
 * 
 * Action mouseOverHome3 = builder.moveToElement(driver.findElement(By.xpath(
 * "(//button[@jsname='LgbsSe'])[2]"))) .click().build();
 * 
 * Thread.sleep(5000);
 * 
 * mouseOverHome3.perform();
 * 
 * System.out.println("Till the continue button on Password page execution done"
 * );
 * 
 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
 * "//div[@data-qa='sidebar']/ul/li[6]/div/button")));
 * 
 * Action mouseOverHome4 = builder .moveToElement(driver.findElement(By.xpath(
 * "//div[@data-qa='sidebar']/ul/li[6]/div/button"))).click() .build();
 * 
 * Thread.sleep(5000);
 * 
 * mouseOverHome4.perform();
 * 
 * System.out.println("Till the Log explorer click on Loggly execution done");
 * 
 * driver.findElement(By.xpath("//label[contains(text(),'New')]")).click();
 * 
 * Thread.sleep(10000);
 * 
 * ((JavascriptExecutor)
 * driver).executeScript("arguments[0].scrollIntoView(true);",
 * driver.findElement(By.xpath(
 * "//div[contains(@class,'loggly-content container-fluid')]/div[7]/div/div/div/div/div[2]/div/input"
 * )));
 * 
 * // Action mouseOverHome5 = builder.moveToElement(driver.findElement(By.xpath(
 * //
 * "//div[contains(@class,'loggly-content container-fluid')]/div[7]/div/div/div/div/div[2]/div/input"
 * ))) // .click().build(); // // Thread.sleep(10000); // //
 * mouseOverHome5.perform();
 * 
 * Thread.sleep(10000);
 * 
 * driver.findElement(By.xpath(
 * "//div[contains(@class,'loggly-content container-fluid')]/div[7]/div/div/div/div/div[2]/div/input"
 * )) .sendKeys(readconfig.getMobNo());
 * 
 * System.out.println("Till the Number entered code executed on Loggly page");
 * 
 * // wait.until(ExpectedConditions.elementToBeClickable(By.xpath( //
 * "//div[@class='search-content-wrapper timepicker-anchor']/div/div/div/div[2]/div/ul/li[3]/button"
 * ))); // // ((JavascriptExecutor)
 * driver).executeScript("arguments[0].click();", driver.findElement(By.xpath(
 * //
 * "//div[@class='search-content-wrapper timepicker-anchor']/div/div/div/div[2]/div/ul/li[3]/button"
 * ))); // // System.out.println("Time Slot click should happen successfully");
 * 
 * System.out.println("End of successfull execution"); // // //
 * driver.findElement(By.xpath("(//button[contains(text(),'Search')])[1]")).
 * click(); // // driver.findElement(By.xpath(
 * "(//div[@class='flex-container'])[1]/div/div/div[contains(@class,'field-json')]"
 * )) // .click(); // // driver.findElement(By.xpath( //
 * "//div[@class='field-tree']/ul/lg-field-explorer-node[4]/li/div/span[contains(text(),'event_type')]"
 * )) // .click(); // // List<WebElement> eventsList =
 * driver.findElements(By.xpath("//div[@class='field-values-column']/ul/li"));
 * // // for (int i = 0; i < eventsList.size(); i++) { // // String
 * eventsListname = eventsList.get(i).getText(); // // if
 * (eventsListname.contains("")) { // get the names of the events we need to
 * pick up here // // System.out.
 * println("Event is Present in Loggly for the associated phone number"); // //
 * } // // }
 * 
 * // driver.quit(); }
 * 
 * }
 */