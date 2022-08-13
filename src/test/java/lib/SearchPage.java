package lib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SearchPage extends MainPage {

    //final static String INIT_SEARCH = "id:org.wikipedia:id/search_container";
    final static String INIT_SEARCH = "id:org.wikipedia:id/fragment_feed_header";
    final static String SEARCH_INPUT = "id:org.wikipedia:id/search_src_text";
    final static String RESULT_ELEMENT_BY_TEXT_TPL = "xpath://*[./*[contains(@text,'{TEXT}')]]";
    final static String RESULT_NOT_FOUND = "id:org.wikipedia:id/search_empty_text";


    public SearchPage(RemoteWebDriver driver) {
        super(driver);
    }

    public void initSearch() {
        WebElement searchInit = this.waitForElementPresent(
                INIT_SEARCH,
                "Cannot find Search Wikipedia init search input"
        );
        searchInit.click();
    }

    public void findByText(String text) {
        WebElement searchInput = this.waitForElementPresent(
                SEARCH_INPUT,
                "Cannot find search input"
        );

        searchInput.sendKeys(text);
    }

    public void selectByText(String text) {
        WebElement expectedResult = this.waitForElementPresent(
                getResultElementByText(text),
                "Cannot find result: '" + text + "'"
        );

        expectedResult.click();
    }

    private static String getResultElementByText(String text) {
        return RESULT_ELEMENT_BY_TEXT_TPL.replace("{TEXT}", text);
    }

    public Boolean isNotResultFound() {
        try {
            WebElement expectedResult = this.waitForElementPresent(
                    RESULT_NOT_FOUND,
                    "Cannot find result search 'Not results found'"
            );
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
