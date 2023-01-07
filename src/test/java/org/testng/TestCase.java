package org.testng;

import java.util.Set;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase extends BaseClass{
	
	PageManager locators;

	@BeforeClass
	private void login() {
		browser("chrome");
		locators=new PageManager();
		launchUrl("https://www.flipkart.com/");
		locators.getFlipkart().getPopup().click();
	}
	
	@Test(priority=1)
	private void search() throws InterruptedException {
		
		locators.getFlipkart().getSearch().sendKeys("google pixel 7 pro snow 128gb",Keys.ENTER);
		
		String parentWindow = windowHandle();
		Thread.sleep(3000);
		locators.getFlipkart().getSelectFirst().click();
		Set<String> allWindows = windowHandles();
		for (String windowHandle : allWindows) {
			
			if(!windowHandle.equals(parentWindow)) {
				switchToWindow(windowHandle);
				
			}			
		}
	}
	
	@Test(priority=2)
	private void productDetails() throws InterruptedException {
		String price = locators.getFlipkart().getPrice().getText();
		String productPrice = price.substring(1).replaceAll(",", "");
		System.out.println("Price : "+productPrice);
		Thread.sleep(3000);
		locators.getFlipkart().getAddToCart().click();
		
		try {
			locators.getFlipkart().getIncQuantity().click();
		WebElement priceAfterInc = locators.getFlipkart().getPriceAfterInc();
		String text = text(priceAfterInc);
		System.out.println(text);
		}
		catch (NoSuchElementException e) {
			System.out.println("Out Of Stock");
		}
		
		
	}
	
}


