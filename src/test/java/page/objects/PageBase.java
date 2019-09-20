package page.objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class PageBase {

    Logger logger = LogManager.getRootLogger();
    WebDriver driver;
    WebDriverWait webDriverWait;

}
