package pageObjectFiles;

public interface DunzoFlowElements {

	public static String SignIn = "//p[contains(text(),'Sign in')]";

	public static String MobNo = "//input[@placeholder='Mobile number']";

	public static String Continuebtn = "div[class='sc-AxjAm Zvfxk']>div>div>label:nth-child(1)";

	public static String SendOTPbtn = "//button[contains(text(),'Send OTP')]";

	public static String Grocerylink = "//a[@href='/pune/grocery-stores']";

	public static String Locationlink = "(//div[contains(@class,'cHQKYu')]/div/div/a)[1]";

	public static String Addbtn = "(//button[contains(text(),'ADD')])[3]";

	public static String framelocator = "wiz-iframe";

	public static String closelink = "//a[@class='wzrkClose']";

	public static String checkoutbtn = "//button[contains(text(),'Checkout')]";

	public static String addressbtn = "//p[contains(text(),'Rent office')]";
	
	public static String selectTimebtn = "//button[contains(text(),'Select this time')]";

	public static String elementsList = "//div[@orientation='vertical']/button";

	public static String payLaterElement = "//p[contains(text(),'Simpl')]";

}
