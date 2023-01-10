package pageObjectFiles;

public interface BigbasketFlowElements {

	public static String Login = "Login/Sign Up";

	public static String OTP = "otpEmail";

	public static String Continuebtn = "//*[@id='login']/login/div/form/div[2]/button[3]";

	public static String VerifyOTPbtn = "#login > login > div > div:nth-child(2) > form > button";

	public static String AddItembtn = "//button[contains(text(),'Add')][1]";

	public static String Mybasketbtn = "//a[@href='/basket/?nc=nb']";

	public static String gotItBtn = "//button[contains(text(),'Got it')]";

	public static String Checkoutbtn = "//button[contains(text(),'Checkout')]";

	public static String ContinuetoPaymentsbtn = "//button[contains(text(),'Continue to Payments')]";

	public static String juspayFrame = "//iframe[@id='juspay_iframe']";

	public static String payMethodselements = "//div[@id='108']/div/div/div/div/div/div/div/div/div/div[3]/div/div/article";

	public static String payLaterElements = "//article[normalize-space()='Simpl']";

}
