package ru.sib.exam.solution.pages.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.sib.exam.solution.pages.filter.FilterForm;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

@Name("Main page")
public class MainPage {

    private FilterForm filterForm;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(
                new HtmlElementLocatorFactory(driver)), this);
    }

    public FilterForm getFilterForm() {
        return filterForm;
    }
}
