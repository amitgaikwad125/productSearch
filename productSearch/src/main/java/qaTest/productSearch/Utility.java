package qaTest.productSearch;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility extends BrowserSetup {
	
	public static void WaitForAll(List<WebElement> elements) {
		WebDriverWait w=new WebDriverWait(driver, 30);
		w.until(ExpectedConditions.visibilityOfAllElements(elements));
		
	}
	
}