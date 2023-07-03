package qaTest.productSearch;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PomPage extends BrowserSetup {

	// WebElements and the locators
	@FindBy(xpath = "//html")
	private WebElement element;

	@FindBy(id = "twotabsearchtextbox")
	private WebElement search;

	@FindBy(id = "nav-search-submit-button")
	private WebElement searchbtn;

	@FindBys({ @FindBy(xpath = "//ul[@data-csa-c-content-id='1480888031']/span/li/span/a") })
	private List<WebElement> ListDisplayType;

	@FindBys({ @FindBy(xpath = "//ul[@data-csa-c-content-id='1480889031']/span/li/span/a") })
	private List<WebElement> ListMaterial;

	@FindBys({ @FindBy(xpath = "//ul[@data-csa-c-content-id='3837712031']/span/li/span/a") })
	private List<WebElement> ListOfBrands;

	@FindBys({ @FindBy(xpath = "//ul[@data-csa-c-content-id='2665398031']/span/li/span/a") })
	private List<WebElement> ListOfDiscounts;

	@FindBys({ @FindBy(xpath = "//div[@data-component-type='s-search-result']") })
	private List<WebElement> ListOfProducts;
	// div[@data-component-type='s-search-result']

	// to initialize the elements
	public PomPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// to search the specific product
	public void searchProduct(String product) {
		search.sendKeys(product);
		searchbtn.click();
	}

	// to select the display type
	public void selectDisplay(String display) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,1200)");

		Iterator<WebElement> itr = ListDisplayType.iterator();
		while (itr.hasNext()) {
			WebElement element = itr.next();
			if (element.getText().equalsIgnoreCase(display)) {
				System.out.println("** DISPLAY TYPE: " + element.getText() + " is selected");
				element.click();
				break;

			}
		}
	}

	// to select the material of the product
	public void selectMaterial(String material) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,1500)");

		Iterator<WebElement> itr = ListMaterial.iterator();
		while (itr.hasNext()) {
			WebElement element = itr.next();
			if (element.getText().equalsIgnoreCase(material)) {
				System.out.println("** MATERIAL TYPE: " + element.getText() + " is selected");
				element.click();
				break;
			}
		}

	}

	// to select the specific brand
	public void selectBrand(String brand) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,500)");

		Iterator<WebElement> itr = ListOfBrands.iterator();
		while (itr.hasNext()) {
			WebElement element = itr.next();
			if (element.getText().equalsIgnoreCase(brand)) {
				System.out.println("** BRAND: " + element.getText() + " is selected");
				element.click();
				break;
			}
		}
	}

	// to select the discount
	public void selectDiscount(int discount) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,900)");

		if (discount >= 10 && discount < 25) {
			System.out.println("** DISCOUNT: " + ListOfDiscounts.get(0).getText() + " is selected");
			ListOfDiscounts.get(0).click();
		} else if (discount >= 25 && discount < 35) {
			System.out.println("** DISCOUNT: " + ListOfDiscounts.get(1).getText() + " is selected");
			ListOfDiscounts.get(1).click();
		} else if (discount >= 35 && discount < 50) {
			System.out.println("** DISCOUNT: " + ListOfDiscounts.get(2).getText() + " is selected");
			ListOfDiscounts.get(2).click();
		} else if (discount >= 50 && discount < 60) {
			System.out.println("** DISCOUNT: " + ListOfDiscounts.get(3).getText() + " is selected");
			ListOfDiscounts.get(3).click();
		} else if (discount >= 60 && discount < 70) {
			System.out.println("** DISCOUNT: " + ListOfDiscounts.get(4).getText() + " is selected");
			ListOfDiscounts.get(4).click();
		} else if (discount >= 70) {
			System.out.println("** DISCOUNT: " + ListOfDiscounts.get(5).getText() + " is selected");
			ListOfDiscounts.get(5).click();
		} else {
			System.out.println("** DISCOUNT: not applicable for discount");
		}

	}

	// to select the product by number
	public void selectProduct(int number) {
//		Utility.WaitForAll(ListOfProducts);

		System.out.println("** TOTAL PRODUCTS ON THE PAGE :" + ListOfProducts.size());

		WebElement element = ListOfProducts.get(number-1);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		js.executeScript("arguments[0].style.border='2px solid red'", element);

		System.out.println("** DESIRED PRODUCT DETAILS: " + element.getText());
		element.findElement(By.tagName("a")).click();
	}
}

