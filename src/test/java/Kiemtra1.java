package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Kiemtra1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//a[@id='btn-login']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        driver.findElement(By.xpath("//span[normalize-space()=\"Category\"]")).click();

        // Chọn button addnew
        driver.findElement(By.xpath("//span[normalize-space()='Add New category']")).click();
        Thread.sleep(2000);

        //Name
        driver.findElement(By.id("name")).sendKeys("Test");
        Thread.sleep(2000);


        //Parent
        driver.findElement(By.xpath("//div[contains(text(),'No Parent')]")).click();
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("Test");
        Actions action = new Actions(driver);

        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);

        //Ordering Number
        driver.findElement(By.xpath("//input[@id='order_level']")).sendKeys("1");

        //Type
        driver.findElement(By.xpath("//button[@title='Physical']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Physical']")).click();
        Thread.sleep(2000);

        //Banner
        driver.findElement(By.xpath("//div[5]//div[1]//div[1]//div[1]//div[1]")).click();
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("gio-qua-2");
        driver.findElement(By.xpath("//div[@title='Imagedrink.jpg']//img[@class='img-fit']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        Thread.sleep(2000);

        //Add Icon
        driver.findElement(By.xpath("//div[6]//div[1]//div[1]//div[1]//div[1]")).click();
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("gio-qua-2");
        driver.findElement(By.xpath("//div[@data-value=\"521\"]")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        Thread.sleep(2000);
        //Meta Type
        driver.findElement(By.xpath("//input[@placeholder='Meta Title']")).sendKeys("Test");
        Thread.sleep(2000);

        //Meta description
        driver.findElement(By.xpath("//textarea[@name='meta_description']")).sendKeys("Test");
        Thread.sleep(2000);

        //Filtering Attributes
        driver.findElement(By.xpath("//div[contains(text(),'Nothing selected')]")).click();
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("Size");
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);

        // Save
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).submit();
        Thread.sleep(2000);

        //Search and Verify
        WebElement src_category = driver.findElement(By.id("search"));
        src_category.sendKeys("Test");
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);

        //Quit
        driver.quit();
    }
}


