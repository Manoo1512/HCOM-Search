package com.hotels.in.tests;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.hotels.in.testbase.TestBase;
import com.hotels.in.testpages.HomePage;
import com.hotels.in.testpages.ListingPage;
import com.hotels.in.utils.FileUtils;

public class hotelSearch extends TestBase{

	@SuppressWarnings("deprecation")
	@Test
	public void openHomePage(){
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.openHomePage();
		try{
			homePage.searchHotel("Core area of Bangalore, India", new Date(118,4,8), new Date(118,4,9));
		}catch (Exception e){
			e.printStackTrace();
		}

	}

	@Test(dependsOnMethods="openHomePage")
	public void findMaximumPriceHotelsWithWiFi(){

		ListingPage listingPage = PageFactory.initElements(driver, ListingPage.class);
		try {
			listingPage.applyPopularFilter("Free wifi");
			listingPage.sortByPrice("Price" , "Price (high to low)");
			List<String> nameAndPriceList= listingPage.getHotelNameAndPriceList();
			FileUtils.writeListToCsvFile(System.getProperty("user.dir")+"\\output\\file_"
					+ new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar
							.getInstance().getTime()), nameAndPriceList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

