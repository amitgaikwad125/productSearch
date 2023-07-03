package qaTest.productSearch;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestPage extends BrowserSetup {

	@BeforeTest
	public void openPage() {
		BrowserSetup.setup();
		BrowserSetup.getPage("https://www.amazon.in/");
	}

	@Test
	public void productSearchTest() throws InterruptedException{

		// STEP 1:search for the product
		PomPage pm = new PomPage(driver);

		// STEP 2: filter the product
		pm.searchProduct("Wrist Watches");
		pm.selectDisplay("analogue");		
		pm.selectMaterial("leather");
		pm.selectBrand("titan");
		pm.selectDiscount(25);
		Thread.sleep(1000);
		
		// STEP 3: get the desired product
		pm.selectProduct(5);
	}

	@AfterTest
	public void teardown() {
//		closeBrowser();
	}
}

