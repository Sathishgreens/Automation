package org.testng;

public class Test extends BaseClass {
	
	public static void main(String[] args) {
		
		FlipKartPOM flipkart = PageManager.getFlipkart();
		FlipKartPOM flipkart2 = PageManager.getFlipkart();
		
		
		//AmazonPOM amazon = PageManager.getAmazon();
		
		PageManager manager = new PageManager();
		AmazonPOM amazon = manager.getAmazon();
		AmazonPOM amazon2 = manager.getAmazon();
		
		System.out.println(System.identityHashCode(amazon));
		System.out.println(System.identityHashCode(amazon2));
		
	}

}
