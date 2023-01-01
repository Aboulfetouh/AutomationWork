package OrangehrmLive_Pageclass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dashboardPage {

	public List<WebElement> dashboardGridElements() {
		List<WebElement> dashboardGridIsPresent = new WebDriverWait(baseclass.getDriver(), 20)
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
						By.xpath("(//div[@class='oxd-grid-item oxd-grid-item--gutters orangehrm-dashboard-widget'])")));
		return dashboardGridIsPresent;
	}

	public int dashboardElementsSize() {
		int size = dashboardGridElements().size();
		return size;
	}
}