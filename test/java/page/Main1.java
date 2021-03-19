package page;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import page.Base;

public class Main1 extends Base  {

	public Main1(WebDriver driver) {
		super(driver);
	}
	
	/*Prerequisite:Do search
	 /*Given:get in to web sit
	 * When:Click on register button
	 * Then:open register page
	*/
	public void goregister() throws InterruptedException {
	click(By.id("menu-item-15608"));	
	}
    
	public void choosesupllier() {
		click(By.xpath("//*[@id='other']/div[1]/div"));		
		click(By.xpath("//*[@id='other']/div[1]/div/div/ul/li[1]")); 
		click(By.xpath("//*[@id='other']/div[2]/div"));
		click(By.xpath("//*[@id='other']/div[2]/div/div/ul/li[2]"));
	}
	
	public void register() {
		
		click(By.xpath("//*[@id='plan-8']/div[1]/div[1]/div[1]"));
		click(By.xpath("//*[@id='business-type-step-one']/div/div/div/div/div[1]"));
		click(By.cssSelector("#business-type-step-two  div.dropdown.shadow.custom-select.line-of-business > span"));
		click(By.cssSelector( "div.dropdown.shadow.custom-select.line-of-business.open > div > ul > li:nth-child(13)"));
		click(By.cssSelector("#business-type-step-two > div > div > div > div > a > span"));
	}



	
}