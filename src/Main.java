import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver", "//Users//fida10//selenium//drivers//chrome//chromedriver");

		DesiredCapabilities ch = DesiredCapabilities.chrome(); //this creates an object that allows us to input desired capabilities into chrome (and all active chrome drivers.
		// commenting this out because the next line does the same thing ch.acceptInsecureCerts(); //this sets a desired capability; the ability to accept insecure chrome certifications
		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true); //this is another (perhaps easier) way of setting capabilities)
		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); //this also allows acceptance of SSL certification issues
		ChromeOptions c = new ChromeOptions(); //creates a new chrome options object to set options for the Chrome driver
		c.merge(ch); //merges the assigned capabilities to this chrome options object, thus giving it the capabilities. In this case, it has the capability to accept insecure certifications. This is a chrome profile with customized options.

		WebDriver dr = new ChromeDriver(c); //and this applies the above profile to our instance of chromedriver
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dr.get("");
	}
}
