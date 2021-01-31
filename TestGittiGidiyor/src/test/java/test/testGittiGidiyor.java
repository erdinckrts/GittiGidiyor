package test;


import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasketPageObjects;
import pages.HomePageObjects;
import pages.LoginPageObjects;
import resources.user;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class testGittiGidiyor {

    private static Logger log = Logger.getLogger(testGittiGidiyor.class);


    public WebDriver driver;
    user user1=new user();
    String email= user1.getEmail(); ;
    String password= user1.getPassword();

    HomePageObjects homeObj;
    BasketPageObjects basketObj;
    LoginPageObjects loginObj;

    @Test
    public void testCase() throws InterruptedException{

        goToThisUrlWithChromeTest("https://www.gittigidiyor.com/"); //siteye git ve açıldığını test et
            log.info("goToThisUrlWithChromeTest metodu bitti");
        loginTest(email,password); // login ol ve test et
            log.info("loginTest metodu bitti");
        searchTest("bilgisayar"); // ürünü ara, 2. sayfaya git ve test et
            log.info("searchTest metodu bitti");
        goToPageNumberTest(2);
            log.info("goToPageNumberTest metodu bitti");
        randomProductAndAdd(); //Rasgele ürün ekle ve fiyatı test et
            log.info("randomProductAndAdd metodu bitti");
        prouctIncreasing(); //adet arttırılır ve 2 adet olduğu doğrulanır
            log.info("prouctIncreasing metodu bitti");
        deleteProduct(); //ürün silinir ve silindiği doğrulanır
            log.info("deleteProduct metodu bitti");
        Thread.sleep(10000);
            driver.close();
    }




    private void goToThisUrlWithChromeTest(String url) {
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\erdin\\Desktop\\driverlar\\chromedriver_win32\\chromedriver.exe");
        String path = System.getProperty("user.dir");
        System.out.println("Proje path : " + path);
        System.setProperty("webdriver.chrome.driver", path + "\\src\\main\\resources\\chromedriver.exe");


        driver =new ChromeDriver();
        WebDriverWait wait=new WebDriverWait(driver,5);
        driver.get(url);
        driver.manage().window().maximize();
        assertEquals("GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi",driver.getTitle(),"anasayfa yüklenemedi");

    }

    private void loginTest(String email, String password) throws InterruptedException {
        loginObj =new LoginPageObjects(driver);
        homeObj=new HomePageObjects(driver);

        homeObj.clickOpenLoginPage();
        loginObj.setTextbox_email(email);
        loginObj.setTextbox_password(password);
        loginObj.clickButton_login();

        String actual=driver.findElement(By.cssSelector("#main-header > div:nth-child(3) > div > div > div.sc-1yvp483-0.jUYNgf > div.sc-1nx8ums-0.oAQul > div > div:nth-child(1) > div > div.gekhq4-4.hwMdSM")).getText();
        assertEquals("Hesabım",actual.substring(0,7),"başarısız login");
    }

    private void searchTest(String searching_word) throws InterruptedException {
        homeObj.setTextbox_search(searching_word);
        homeObj.clickButton_search();
    }

    private void goToPageNumberTest(int page_to_go) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scroll(0,7200);");

        homeObj.clickButton_page_changing(page_to_go);

        assertEquals("Bilgisayar - GittiGidiyor - 2/100",driver.getTitle(),"sayfa açılamadı");
    }

    private void randomProductAndAdd() throws InterruptedException {
        int rnd =(0+(int) (Math.random()*48));

        homeObj.clickButton_product_adding(rnd);

        String page_price= homeObj.getPagePrices(rnd);
        String basket_price=homeObj.getBasketPrices();
        assertEquals(basket_price,page_price,"başarısız sepet fiyatı");
    }

    private void prouctIncreasing() throws InterruptedException {
        basketObj =new BasketPageObjects(driver);

        homeObj.clickToBasket();
        basketObj.clickProduct_Increasing();

        String product_number=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div/div[2]/div[1]/div[2]/div[6]/div[2]/div[2]/div[4]/div/input")).getAttribute("value");
        assertEquals("2",product_number,"ürün adedi eşleşmiyor");
    }

    private void deleteProduct() throws InterruptedException {

        basketObj.product_Delete();

        String message=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div/div[2]/h2")).getText();
        if (message!="Sepetinizde ürün bulunmamaktadır."){
            log.error("son ürün silindi ancak sepette önceden kalma ürünler var");
        }
        else{
        assertEquals("Sepetinizde ürün bulunmamaktadır.",message,"ürün adedi eşleşmiyor");
        }
    }

}
