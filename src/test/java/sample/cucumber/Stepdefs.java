package sample.cucumber;

import com.browserstack.local.Local;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class Stepdefs {
    private String results;
    private Local l;

    public WebDriver driver;
    public DesiredCapabilities caps;
    public String browserStackUserName = "mukeshtiwari";
    public String browserStackAutomateKey = "yRFpDrGLBnnuQKzUxqbz",
            url = "https://" + browserStackUserName + ":" + browserStackAutomateKey + "@hub.browserstack.com/wd/hub";

    @Before
    public void setup() throws Exception{

        caps= new DesiredCapabilities();
        caps.setCapability("build","Cucumber-Tests");
        caps.setCapability("browserName",System.getProperty("browser"));
        caps.setCapability("browserVersion",System.getProperty("browser_version"));
        caps.setCapability("os",System.getProperty("os"));
        caps.setCapability("os_version",System.getProperty("os_version"));
        caps.setCapability("device",System.getProperty("device"));
        caps.setCapability("real_mobile",System.getProperty("real_mobile"));

        if((System.getProperty("local")!=null)&&(System.getProperty("local").equalsIgnoreCase("true"))){
            l=new Local();
            Map<String,String> args = new HashMap();
            args.put("key",browserStackAutomateKey);
            l.start(args);
            caps.setCapability("browserstack.local","true");
        }

        driver= new RemoteWebDriver(new URL(url),caps);
    }

    @Given("I am in Google homepage")
    public void onTheGoogleHomePage(){

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
    }

    @When("I enter the keyword \\\"([^\\\"]*)\\\"$")
    public void enterKeyWord(String keyword){

        WebElement searchBox =driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys(keyword);
        searchBox.submit();

        results = driver.getTitle().trim();

    }

    @Then("I should get results in searchpage as \\\"([^\\\"]*)\\\"$")
    public void myAnswer(String expected){
        assertTrue(results.contains(expected.trim()));
    }

    @After
    public void tearDown() throws Exception{
        driver.quit();
        if (l!=null){l.stop();
            System.out.print("tearing down local instance");
        }
    }
}