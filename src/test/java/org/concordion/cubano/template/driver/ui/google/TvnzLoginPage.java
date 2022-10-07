package org.concordion.cubano.template.driver.ui.google;

import org.concordion.cubano.driver.BrowserBasedTest;
import org.concordion.cubano.template.driver.ui.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class TvnzLoginPage extends PageObject<TvnzLoginPage> {
    public TvnzLoginPage(BrowserBasedTest test) {
        super(test);
    }

    @FindBy(name = "q")
    WebElement query;

    @FindBy(name = "elementNotFound")
    WebElement elementNotFound;

    @FindBy(css = "div.rc")
    List<SearchResult> searchResults;

    @FindBy(className = "Form-logo-link")
    WebElement logo;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(xpath = "//*[@type=\"Submit\"]")
    WebElement submitButton;

    @Override
    public ExpectedCondition<?> pageIsLoaded(Object... params) {
        return ExpectedConditions.visibilityOf(logo);
    }

    public static TvnzLoginPage open(BrowserBasedTest test) {
        test.getBrowser().getDriver().navigate().to("https://login.tech.tvnz.co.nz/");
        return new TvnzLoginPage(test);
    }

    public TvnzPersonalPage login(BrowserBasedTest test, String userName,String password){
        email.sendKeys(userName);
        passwordField.sendKeys(password);
        submitButton.click();
        return new TvnzPersonalPage(test);
    }

    public TvnzLoginPage searchForElementNotFound() {

        elementNotFound.sendKeys("you won't find me");
        return this;
    }

    public TvnzLoginPage searchFor(String term) {

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
        return logo.isDisplayed();
    }
}
