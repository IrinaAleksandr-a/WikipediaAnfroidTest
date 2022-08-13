package tests;

import io.appium.java_client.android.AndroidDriver;
import lib.CoreTestCase;
import lib.SearchPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.net.URL;

public class SearchTest extends CoreTestCase {
    private SearchPage searchPage;

    @Before
    public void initPage() {
        searchPage = new SearchPage(this.driver);
    }

    @Test
    public void searchTest() {
        searchPage.initSearch();
        searchPage.findByText("Java");
        searchPage.selectByText("Island of Indonesia");
    }

    @Test
    public void searchNotResultFoundTest() {
        searchPage.initSearch();
        searchPage.findByText("wfewfewfwegweg");
        Assert.assertTrue(searchPage.isNotResultFound());
    }
}
