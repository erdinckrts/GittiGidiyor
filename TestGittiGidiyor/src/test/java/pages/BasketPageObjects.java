package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.testGittiGidiyor;

public class BasketPageObjects {
    private static Logger log = Logger.getLogger(testGittiGidiyor.class);
    WebDriver driver =null;

    By button_plus=By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div/div[2]/div[1]/div[2]/div[6]/div[2]/div[2]/div[4]/div/span[2]");

    By button_delete=By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div/div[2]/div[1]/div[2]/div[6]/div[2]/div[2]/div[3]/div/div[2]/div/a[1]");
    By message_box=By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div/div[2]/h2");


    public BasketPageObjects(WebDriver driver) {
        this.driver=driver;
    }

    public void clickProduct_Increasing() throws InterruptedException {
        log.debug("clickProduct_Increasing metodu başladi");
        driver.findElement(button_plus).click();
        Thread.sleep(1000);

    }


    public void product_Delete() throws InterruptedException {
        log.debug("product_Delete metodu başladi");
        Thread.sleep(2000);
        driver.findElement(button_delete).click();
        Thread.sleep(1000);

    }

}
