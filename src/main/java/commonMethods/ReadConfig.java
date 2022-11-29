package commonMethods;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() // constructor
	{
		File src = new File("/Users/rakshitogra/eclipse-workspace/Simpl-Web-Automation-v1.0/Config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);

		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	// To read the values, we will create the method for every Variable

	public String getbigBasketURL() {
		String bigBasketURL = pro.getProperty("bigBasketURL");
		return bigBasketURL;
	}

	public String getlogglyURL() {
		String logglyURL = pro.getProperty("logglyURL");
		return logglyURL;
	}

	public String getsuccessMobNo() {
		String successMobNo = pro.getProperty("successMobNo");
		return successMobNo;
	}

	public String getdunzoURL() {

		String dunzoURL = pro.getProperty("dunzoURL");
		return dunzoURL;
	}

	public String getblockedMobNo() {

		String blockedMobNo = pro.getProperty("blockedMobNo");
		return blockedMobNo;
	}

	public String getpendingbillNo() {

		String pendingbillNo = pro.getProperty("pendingbillNo");
		return pendingbillNo;
	}

	public String getMMTURL() {

		String mmtURL = pro.getProperty("mmtURL");
		return mmtURL;
	}

	public String getTata1MGURL() {

		String tata1MGURL = pro.getProperty("tata1MGURL");
		return tata1MGURL;
	}

	public String getNetMedsURL() {

		String NetMedsURL = pro.getProperty("netmedsURL");
		return NetMedsURL;
	}

	public String getAbhiBusURL() {

		String AbhiBusURL = pro.getProperty("abhibusURL");
		return AbhiBusURL;
	}

	public String getfreshtoHomeURL() {

		String FreshtoHomeURL = pro.getProperty("freshtoHomeURL");
		return FreshtoHomeURL;
	}

	public String getEatsureURL() {

		String EatsureURL = pro.getProperty("eatsureURL");
		return EatsureURL;
	}

	public String getTenderCutsURL() {

		String TenderCutsURL = pro.getProperty("tendercutsURL");
		return TenderCutsURL;
	}

	public String getFreshMenuURL() {

		String FreshMenuURL = pro.getProperty("freshmenuURL");
		return FreshMenuURL;
	}

	public String getGoibiboURL() {

		String goibiboURL = pro.getProperty("goibiboURL");
		return goibiboURL;

	}

	public String getJioURL() {

		String jioURL = pro.getProperty("jioURL");
		return jioURL;

	}

	public String getNykaaURL() {

		String nykaaURL = pro.getProperty("nykaaURL");
		return nykaaURL;

	}

	public String getjioMartNo() {

		String jioMartNo = pro.getProperty("jioMartNo");
		return jioMartNo;

	}

	public String getjioMartURL() {

		String jioMartURL = pro.getProperty("jioMartURL");
		return jioMartURL;

	}

}