package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import test.testGittiGidiyor;

public class HomePageObjects {
    private static Logger log = Logger.getLogger(testGittiGidiyor.class);
    WebDriver driver =null;

    By frame_button =By.cssSelector("#main-header > div:nth-child(3) > div > div > div.sc-1yvp483-0.jUYNgf > div.sc-1nx8ums-0.oAQul > div > div:nth-child(1) > div");
    By button_open_login_page =By.cssSelector("a[data-cy='header-login-button']");

    By textbox_search=By.cssSelector("input[data-cy='header-search-input']");
    By button_search=By.cssSelector("button[data-cy='search-find-button']");

    By button_open_basket=By.xpath("//a[contains(text(),'Sepete Git')]");


    public HomePageObjects(WebDriver driver) {
        this.driver=driver;
    }

    public void clickOpenLoginPage() throws InterruptedException {
        log.debug("ClickOpenLoginPage metodu başladı");
        driver.findElement(frame_button).click();
        Thread.sleep(1000);
        driver.findElement(button_open_login_page).click();
    }

    public void setTextbox_search(String product) throws InterruptedException {
        log.debug("setTextbox_search metodu basladi");
        Thread.sleep(1000);
        driver.findElement(textbox_search).sendKeys(product);
    }

    public void clickButton_search() throws InterruptedException {
        log.debug("clickButton_search metodu basladi");
        driver.findElement(button_search).click();
        Thread.sleep(2000);
    }

    public void clickButton_page_changing(int page_number){
        log.debug("clickButton_page_changing metodu basladi");
        driver.findElement(By.xpath("//a[text()='"+page_number+"']")).click();
    }

    public void clickButton_product_adding(int rnd) throws InterruptedException{
        log.debug("clickButton_product_adding metodu basladi");
        Thread.sleep(2000);
        WebElement product_frame=driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[2]/div[3]/div[2]/ul/li["+rnd+"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product_frame);

        Actions actions = new Actions(driver);
        actions.moveToElement(product_frame).build().perform();

        WebElement button_sepete_ekle =driver.findElement(By.xpath("//body/div[5]/div[2]/div[1]/div[2]/div[3]/div[2]/ul[1]/li["+rnd+"]/a[1]/div[1]/div[1]/div[1]/div[3]/button[1]"));
        button_sepete_ekle.click();
        Thread.sleep(1000);
    }

    public String getPagePrices(int rnd){
        log.debug("getPagePrices metodu basladi");
        String page_price =driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[2]/div[1]/div[2]/div[3]/div[2]/ul[1]/li["+rnd+"]/a[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/p[1]")).getText();
    return page_price;
    }

    public String getBasketPrices() throws InterruptedException {
        log.debug("getBasketPrices metodu basladi");

        WebElement sepet=driver.findElement(By.xpath("//body/div[@id='topContainer']/div[@id='GGHeaderWrapper']/div[@id='header_wrapper']/div[4]/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/div[2]/p[3]/span[1]"));
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.moveToElement(sepet).build().perform();
        Thread.sleep(2000);
        String basket_price=driver.findElement(By.xpath("//body/div[@id='topContainer']/div[@id='GGHeaderWrapper']/div[@id='header_wrapper']/div[4]/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/div[2]/p[3]/span[1]")).getText();
        return basket_price;
    }

    public void clickToBasket() throws InterruptedException {
        log.debug("clickToBasket metodu basladi");
        Thread.sleep(1000);
        driver.findElement(button_open_basket).click();
        Thread.sleep(1000);
    }

}
