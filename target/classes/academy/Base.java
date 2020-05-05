package academy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Base {

	public WebDriver driver;
	public String baseURL;
	public String email;
	public String password;
	Properties prop;
	
	 public static Logger log = LogManager.getLogger(Base.class.getName());
	
//static final String DEFAULT_XML_CONFIGURATION_FILE = "log4j2.xml";
	public WebDriver initializeDriver() throws IOException {
		
		
		
		FileInputStream fis = new FileInputStream("./src/main/resources/data.properties");
		prop = new Properties();
		prop.load(fis);
		//``Logger.

		String browserName = prop.getProperty("browser");
		baseURL = prop.getProperty("url");
		email = prop.getProperty("email");
		password = prop.getProperty("password");
		
		//String browserName = System.getProperty("browser");
		//baseURL = System.getProperty("url");
		//email = prop.getProperty("email");
		//password = prop.getProperty("password");

		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/Drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			log.info("Chrome is invoked");
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./src/main/resources/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			log.info("Firefox is invoked");
		}

		else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "./src/main/resources/Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			log.info("IE is invoked");
		}

		driver.manage().timeouts().implicitlyWait(10000L, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		log.info("Window is maximized");

		return driver;
	}

	public void getScreenshot(String name) throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(".//Screenshots//"+name+"_screenshot.png"));
		
		log.info(name+"screenshot.png has been taken");
	}
}
