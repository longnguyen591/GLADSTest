package ngf.glads.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ngf.glads.qa.util.GLADSConstants;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static boolean highlightElement;
	public OptionsManager optionsManager;

	public Properties init_properties() {
		prop = new Properties();

		String path = null;
		String env = null;

		try {
			env = "test";//System.getProperty("env");

			if (env.equalsIgnoreCase("test")) {
				path = ".\\src\\main\\java\\ngf\\glads\\qa\\config\\test.properties";

				System.out.println("Launching Test environment");

			} else if (env.equalsIgnoreCase("dev")) {
				path = ".\\src\\main\\java\\ngf\\glads\\qa\\config\\dev.properties";

				System.out.println("Launching Dev environment");

			} else if (env.equalsIgnoreCase("int")) {
				path = ".\\src\\main\\java\\ngf\\glads\\qa\\config\\int.properties";

				System.out.println("Launching Int environment");

			}

		} catch (Exception e) {
			path = ".\\src\\main\\java\\ngf\\glads\\qa\\config\\test.properties";
			System.out.println("Launching default environment-Test");

		}

		try {

			FileInputStream fileInput = new FileInputStream(path);
			prop.load(fileInput);

		} catch (FileNotFoundException e) {
			System.out.println("Issue with config properties.Please correct your config.");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

	public String getValue(String key) {
		String envProperty = System.getenv(key);
		if (envProperty != null && !envProperty.equals("null")) {
			return envProperty;
		}

		String systemProperty = System.getProperty(key);
		if (systemProperty != null && !systemProperty.equals("null")) {
			return systemProperty;
		}

		return prop.getProperty(key);
	}

	// This method is used to initialize the driver on the basis of given browser
	// name

	public WebDriver init_driver(Properties prop) {

		String browser = getValue("browser");
		String url = getValue("Url");

		highlightElement = Boolean.parseBoolean(getValue("highlight"));

		optionsManager = new OptionsManager(prop);

		if (browser.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();

			if (Boolean.parseBoolean(getValue("remote"))) {
				init_remoteDriver(browser);

			} else {
				setDriver(new ChromeDriver(optionsManager.getChromeOptions()));

			}

		} else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			setDriver(new EdgeDriver(optionsManager.getEdgeOptions()));

		} else {
			System.out.println("invalid browser");
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(GLADSConstants.page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(GLADSConstants.implicit_wait, TimeUnit.SECONDS);
		driver.get(url);

		return getDriver();
	}

	public void init_remoteDriver(String browser) {
		
		String dockerIp = getValue("dockerIp");
		System.out.println("dockerIp: " + dockerIp);
		if (browser.equalsIgnoreCase("chrome")) {
			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setCapability(ChromeOptions.CAPABILITY, optionsManager.getChromeOptions());

			try {
				setDriver(new RemoteWebDriver(new URL("http://" + dockerIp + ":4444/wd/hub"), capability));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

		}
	}


	private WebDriver getDriver() {
		return driver;
	}

	public static WebDriver setDriver(WebDriver driver) {
		return TestBase.driver = driver;
	}

	public void close() {
		driver.close();

	}

	public void quit() {
		driver.quit();
	}

}
