package Utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class ActionHelper {
    private WebDriver driver;
    private WebDriverWait wait;


    public ActionHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    public void settextelementthenEnter(By locator, String text) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
        Thread.sleep(3000);
        element.sendKeys(Keys.ARROW_DOWN);
        element.sendKeys(Keys.ENTER);

    }

    public void selecttextelementthenEnter(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.click();
        Thread.sleep(1000);
        element.sendKeys(Keys.ARROW_DOWN);
        element.sendKeys(Keys.ENTER);

    }

    public void UploadFile(By locator, String filepath) throws AWTException, InterruptedException {

        WebElement file = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Thread.sleep(5000);

        // Create robot class
        Robot robot = new Robot();

        //Ctnl +c

        StringSelection selection = new StringSelection(filepath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, null);

        // Relase for Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000);

        //Ctnl + V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.delay(2000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void click(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            button.click();
        } catch (TimeoutException e) {
            System.out.println("Element was already clicked or is no longer available.");
        }

    }


    public String getText(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element.getText();
    }

    public void selectOptionFromdropdownlist(By locator , String text) throws IllegalAccessException {

        WebElement dropdownlist = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        Select dropdown = new Select(dropdownlist);

        List<WebElement> options = dropdown.getOptions();
        System.out.println("Available options in dropdown:");

        for (int i = 0; i < options.size(); i++) {
            System.out.println(i + "" + options.get(i).getText());

        }
        dropdown.selectByContainsVisibleText(text);
    }

    public void Stream ( By locator , String text ){

        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        WebElement newelement =  elements.stream()
                .filter(x->x
                .findElement(By.cssSelector(".MuiButtonBase-root.MuiMenuItem-root.MuiMenuItem-gutters.MuiMenuItem-root.MuiMenuItem-gutters.css-r2hyib"))
                .getText().contains(text)).findFirst().orElse(null);
                 newelement.click();

    }

    public void acceptAlert() {

        // Wait for the alert to appear
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        // move to alert
        driver.switchTo().alert();

        // Accept the alert
        alert.accept();

    }

    public void OpenVirtualscanner () throws AWTException {

        // create robot class
        Robot robot = new Robot();

        // ctnl
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_B);

        robot.delay(2000);

        // relase ctnl and B
        robot.keyRelease(KeyEvent.VK_B);
        robot.keyRelease(KeyEvent.VK_CONTROL);

    }

    public  void sendkeys (By locator , String text ){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
    }
}



