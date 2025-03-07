package TestScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page2 {
	WebDriver driver;
	public Page2(WebDriver driver) {//browser reference
		this.driver=driver;
	}
	//WebElement locator+ respective method
	//WebElement ele=driver.findelement(By.id("sss"));
	By username=By.id("email");
	By password=By.name("pass");
	By log=By.xpath("//button[@name='login']");
	By forget= By.xpath("//a[normalize-space()='Forgotten password?'][1]");

	public void getLogin(String user , String pass) {	//login methods
		WebElement email=driver.findElement(username);
		email.sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(log).click();
	}
	
	public void getRecoverPassword() {
		driver.findElement(forget).click();
	}
}
