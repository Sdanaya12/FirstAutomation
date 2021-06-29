import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.html.HTMLSelectElement;
import sun.nio.cs.ext.EUC_JP_Open;
import java.sql.Driver;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import static org.junit.Assert.*;

public class Automation {
    @Test
    public void Abrirpagina() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.com/-/es/");
        driver.manage().window().maximize();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("televisor");
        driver.findElement(By.id("nav-search-submit-button")).click();
        /*
        //Implicit Wait
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS);
         */

        /*
        //Explict Wait
        WebDriverWait ewait = new WebDriverWait(driver, 10);
        ewait.until(ExpectedConditions.titleContains("nevera"));
         */

        //Fluent wait
        Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
                .withTimeout(10,TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        WebElement Option = fwait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.linkText("TCL"));
            }
        }
        );

        driver.findElement(By.linkText("TCL")).click();
        driver.findElement(By.xpath("//span[@class='a-dropdown-label']")).click();
        driver.findElement(By.xpath("//li[@class='a-dropdown-item']"));
        driver.findElement(By.id("quantity_2")).click();
        driver.findElement(By.id("buy-now-button")).click();
        driver.findElement(By.id("ap_email")).sendKeys("3206552516");
        driver.findElement(By.id("continue")).click();
        driver.quit();
    }
}