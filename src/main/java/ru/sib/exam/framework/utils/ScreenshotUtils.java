package ru.sib.exam.framework.utils;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ScreenshotUtils {

    private static Logger log = LoggerFactory.getLogger(ScreenshotUtils.class);

    public static void takeBrowserScreenshot(String screenName) {
        if (WebDriverRunner.hasWebDriverStarted()) {
            byte[] img = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
            if (img == null || img.length == 0) {
                log.info("Не удалоь сделать скриншот");
            } else {
                attachScreen(screenName, img);
            }
        }
    }

    @Attachment(value = "{screenName}", type = "image/png")
    public static byte[] attachScreen(String screenName, byte[] img) {
        return img;
    }

    @Attachment(value = "Последний url теста")
    public static String attachUrl(String text) {
        return text;
    }
}
