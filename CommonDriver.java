package commonLibs.implementation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonDriver {

    private WebDriver driver;
    private int pageLoadTimeout;
    private int elementDetectionTimeout;

    // Constructor
    public CommonDriver(String browserType) throws Exception {

        pageLoadTimeout = 10;
        elementDetectionTimeout = 10;

        if (browserType.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else {
            throw new Exception("Invalid Browser Type: " + browserType);
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    // Navigate method
    public void navigateToURL(String url) {

        driver.manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(elementDetectionTimeout));

        driver.get(url);
    }

    // Getter for driver
    public WebDriver getDriver() {
        return driver;
    }

    // Quit browser
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    public void setPageLoadTimeout(int pageLoadTimeout) {
    	this.pageLoadTimeout=pageLoadTimeout;
    }
    public void setElementDetectionTimeout(int elementDetectionTimeout) {
    	this.elementDetectionTimeout=elementDetectionTimeout;
    }
    public String getTitleOfthePage() {
    	return driver.getTitle();
    }
}
