package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {
	
	private final String DRIVER_LINUX = "./src/test/resources/chromedriver/chromedriver";
	private final String DRIVER_WINDOWS = "./src/test/resources/chromedriver/chromedriver.exe";
	
	private WebDriver driver;
	
	public Base() {
	}
	
	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver", DRIVER_LINUX);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		return driver;
	}
	
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	public List<WebElement> findElements(By locator){
		return driver.findElements(locator);
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public void visit(String url) {
		driver.get(url);
	}
	
	public Point getPosition(By locator) {
		return driver.findElement(locator).getLocation();
	}
	
	public Long getScrollPosition() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Long value = (Long) executor.executeScript("return window.pageYOffset;");
		return value;
	}
	
	public void setSize(int width, int height) {
		Dimension dimension = new Dimension(width, height);
		Point position = new Point(0, 0);
		driver.manage().window().setSize(dimension);
		driver.manage().window().setPosition(position);
	}
	
	public void cerrar() {
		driver.close();
	}
	
}
