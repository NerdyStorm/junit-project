package com.techfios.pages;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestPage {

    WebDriver driver;
    int initial;

    public TestPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.NAME, using = "allbox")
    WebElement allBox;
    @FindBy(how = How.TAG_NAME, using = "ul")
    WebElement listElements;
    @FindBy(how = How.CSS, using = "input[name='submit'][value='Remove']")
    WebElement removeButton;

    public void checkAllBox() {

        allBox.click();
        System.out.println("All toggled on.");

    }

    public void verifyAllBoxChecked() {

        Assert.assertTrue("Allbox not checked.", allBox.isSelected());

        verifyListChecked();

    }

    public void verifyListChecked() {

        List<WebElement> options = listElements.findElements(By.tagName("li"));

        for (WebElement o : options) {
            assertTrue("Checkbox not selected!", o.findElement(By.tagName("input")).isSelected());
        }

    }

    public void removeSingleItem() {

        List<WebElement> options = listElements.findElements(By.tagName("li"));

        if (options.size() > 0) {

            initial = options.size();
            System.out.println(initial);
            
            options.get(0).findElement(By.tagName("input")).click();
            System.out.println("Removed first item.");
            removeButton.click();

        }
        
        else {
            System.out.println("No items remaining.");
        }

    }

    public void verifySingleItemRemoved(){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(listElements));

        List<WebElement> options = listElements.findElements(By.tagName("li"));

        Assert.assertTrue("Due to interference, cannot tell if item was removed.", options.size() == initial-1);
        System.out.println("First item removed.");

    }

    public void removeAllItems() {

        checkAllBox();
        removeButton.click();

    }

    public void verifyAllItemsRemoved(){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(listElements));

        List<WebElement> options = listElements.findElements(By.tagName("li"));

        Assert.assertTrue("All items were not removed or some other item was added unexpectedly", options.size() == 0);
        System.out.println("All items removed.");

    }

}
