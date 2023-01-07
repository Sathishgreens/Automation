package org.testng;

public class PageManager {
	
	PageManager p;
	private static FlipKartPOM flipkart;
	private AmazonPOM amazon;
	
//	private PageManager() {
//		
//		//p=new PageManager();
//		
//
//	}
	
	public static FlipKartPOM getFlipkart() {
		if (flipkart==null) {
			flipkart = new FlipKartPOM();
		}
				return flipkart;
	}
	
	public  AmazonPOM getAmazon() {
		if(amazon==null) {
			amazon=new AmazonPOM();
		}
		
		return amazon;
	}

}
