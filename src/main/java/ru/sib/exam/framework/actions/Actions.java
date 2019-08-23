package ru.sib.exam.framework.actions;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.testng.Assert;
import ru.sib.exam.solution.pages.main.MainPage;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static ru.sib.exam.framework.utils.ScreenshotUtils.takeBrowserScreenshot;

@Component
public class Actions {

    private static Logger log = LoggerFactory.getLogger(Actions.class);

    @Value("${base.url}")
    private String url;


    @Step("Открыть главную страницу")
    public <T> MainPage openStartPage() {
        open(url);
        MainPage mainPage = new MainPage(getWebDriver());
        takeBrowserScreenshot(MainPage.class.getAnnotation(Name.class).value());
        return mainPage;
    }

    public Actions click(TypifiedElement typifiedElement) {
        typifiedElement.isDisplayed();
        this.click(typifiedElement, typifiedElement.getText());
        return this;
    }

    public Actions click(WebElement webElement) {
        webElement.isDisplayed();
        this.click(webElement, webElement.getText());
        return this;
    }

    @Step("Нажатие на элемент \"{elementName}\"")
    public Actions click(TypifiedElement typifiedElement, String elementName) {
        typifiedElement.click();
        return this;
    }

    @Step("Нажатие на элемент \"{elementName}\"")
    public Actions click(WebElement typifiedElement, String elementName) {
        typifiedElement.click();
        return this;
    }

    @Step("Нажатие по элементу, содержащему \"{value}\", из элементов \"{name}\"")
    public Actions chooseAndClick(List<WebElement> listWebElement, String value, String name) {
        for (WebElement we : listWebElement) {
            if (we.isDisplayed() && we.getText().toLowerCase().contains(value.toLowerCase())) {
                we.click();
                break;
            }
        }
        return this;
    }

    @Step("Ввести в поле \"{name}\" значение: \"{value}\"")
    public Actions setValue(TypifiedElement se, String value, String name) {
        se.click();
        cleanField(se);
        se.sendKeys(value);
        return this;
    }

    public Actions cleanField(TypifiedElement se) {
        int length = se.getText().length() + 1;
        for (int i = 0; i < length; i++) {
            se.sendKeys(Keys.BACK_SPACE);
            wait_int(50);
        }
        return this;
    }

    public Actions wait_int(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public void pressEnter() {
        org.openqa.selenium.interactions.Actions actions =
                new org.openqa.selenium.interactions.Actions(WebDriverRunner.getWebDriver());
        actions.sendKeys(Keys.ENTER);

    }

    @Step("Проверка на содержание текста \"{value}\"")
    public Actions check(String element, String value) {
        Assert.assertTrue(element.contains(value));
        return this;
    }

}
