package com.qa.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GetByfromWebEle {
	
//	return ByType of WebElement
			public By toByVal(WebElement we) {
			    // By format = "[foundFrom] -> locator: term"
			    // see RemoteWebElement toString() implementation
			    String[] data = we.toString().split(" -> ")[1].split(": ");
			    		// replace("]", "").split(": ");
			    String locator = data[0];
			    System.out.println(locator);
			    String term = data[1];
			    String s = term.substring(0, term.length()-1);
			    System.out.println(s);

			    switch (locator) {
			    case "xpath":
			        return By.xpath(s);
			    case "css selector":
			        return By.cssSelector(s);
			    case "id":
			        return By.id(s);
			    case "tag name":
			        return By.tagName(term);
			    case "name":
			        return By.name(term);
			    case "link text":
			        return By.linkText(term);
			    case "class name":
			        return By.className(term);
			    }
			    return (By) we;
			}

}
