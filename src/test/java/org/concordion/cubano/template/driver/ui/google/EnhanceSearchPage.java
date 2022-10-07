package org.concordion.cubano.template.driver.ui.google;

import org.concordion.cubano.driver.BrowserBasedTest;
import org.concordion.cubano.template.AppConfig;
import org.concordion.cubano.template.driver.ui.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class EnhanceSearchPage extends PageObject<EnhanceSearchPage> {
    public EnhanceSearchPage(BrowserBasedTest test) {
        super(test);
    }

    @FindBy(name = "q")
    WebElement query;

    @FindBy(name = "elementNotFound")
    WebElement elementNotFound;

    @FindBy(css = "div.rc")
    List<SearchResult> searchResults;

    @FindBy(className = "headerText")
    WebElement header;

    @Override
    public ExpectedCondition<?> pageIsLoaded(Object... params) {
        return ExpectedConditions.visibilityOf(header);
    }

    public static EnhanceSearchPage open(BrowserBasedTest test) {
        test.getBrowser().getDriver().navigate().to("https://www.enhanceconsulting.co.nz/");

        return new EnhanceSearchPage(test);
    }

    public EnhanceSearchPage searchForElementNotFound() {

        elementNotFound.sendKeys("you won't find me");
        return this;
    }

    public EnhanceSearchPage searchFor(String term) {

        query.sendKeys(term);
        capturePage(query);

        query.submit();

        waitUntil(ExpectedConditions.presenceOfElementLocated(By.id("result-stats")), 3);

        return this;
    }

    public String getSearchResult(String link) {
        for (SearchResult searchResult : searchResults) {
            String url = searchResult.url.getText();

            if (url.contains(link)) {
                return url;
            }
        }

        return null;
    }
    public boolean isExist(){
        return header.isDisplayed();
    }
}
