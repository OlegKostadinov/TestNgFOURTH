package PackTestfourth;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestFourth {

    WebDriver driver;







    @BeforeMethod

    public  void precond(){

        ChromeOptions options;
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.setHeadless(true);
        driver = new ChromeDriver(options);
        driver.get("https://www.python.org/");
        driver.manage().window().maximize();


    }

    @Test(priority = 4)

    public  void test1 ()  {



        String cururl = driver.getCurrentUrl();
        System.out.println(cururl);


    }

    @Test(priority = 0)

    public void test2 (){

        String curtitle = driver.getTitle();
        System.out.println(curtitle);
    }

    @Test(priority = 1)

    public  void test3 (){

        WebElement field1 = driver.findElement(By.xpath("//*[@id = 'id-search-field']"));
        field1.sendKeys("111113333333333");
        WebElement button1 = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        button1.click();





    }
    @Test(priority = 3)

    public void test4 () {


        String parurl = driver.getCurrentUrl();
        WebElement event2 = driver.findElement(By.xpath("//*[@id = 'events']"));
        Actions action = new Actions(driver).moveToElement(event2);
        action.sendKeys(Keys.ENTER).build().perform();






        for(String childWindow: driver.getWindowHandles())
        {


            driver.switchTo().window(childWindow); }
        String childurl = driver.getCurrentUrl();
        System.out.println(childurl);
        if (parurl.equals(childurl)){
            System.out.println("The TEST FAILED!!!!");
        }
        else {
            System.out.println("THe test PASSED!!!");
        }





        }
        @AfterMethod

        public  void  postcond () {

        driver.close();
        }
}
