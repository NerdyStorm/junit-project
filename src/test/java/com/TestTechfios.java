package com;

import com.techfios.pages.TestPage;
import com.techfios.utils.BrowserFactory;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TestTechfios {
    
    private static WebDriver driver;
    
    private static TestPage testPage;

    @BeforeClass
    public static void beforeClass(){
        
        driver = BrowserFactory.initDriver();
        testPage = new TestPage(driver);

    }

    @Before
    public void before(){

    }

    @Test 
    public void allBoxCheckTest() {

        testPage.checkAllBox();
        testPage.verifyAllBoxChecked();

    }

    @Test
    public void removeSingleItem(){

        testPage.removeSingleItem();
        testPage.verifySingleItemRemoved();

    }

    @Test
    public void removeAllItems(){

        testPage.removeAllItems();
        testPage.verifyAllItemsRemoved();

    }


}
