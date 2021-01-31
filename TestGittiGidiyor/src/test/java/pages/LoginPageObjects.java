package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.testGittiGidiyor;

public class LoginPageObjects {
        private static Logger log = Logger.getLogger(testGittiGidiyor.class);
        WebDriver driver =null;

        By textbox_email =By.cssSelector("#L-UserNameField");
        By textbox_password =By.cssSelector("#L-PasswordField");
        By button_login =By.cssSelector("#gg-login-enter");

        public LoginPageObjects(WebDriver driver) {
            this.driver=driver;
        }

        public void setTextbox_email(String email) {
            log.debug("setTextbox_email metodu basladi");
            driver.findElement(textbox_email).sendKeys(email);
        }
        public void setTextbox_password(String password) {
            log.debug("setTextbox_password metodu basladi");
            driver.findElement(textbox_password).sendKeys(password);
        }
        public void clickButton_login() throws InterruptedException {
            log.debug("clickButton_login metodu basladi");
            Thread.sleep(1000);
            driver.findElement(button_login).click();
        }

}
