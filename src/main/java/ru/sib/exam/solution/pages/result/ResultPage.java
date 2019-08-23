package ru.sib.exam.solution.pages.result;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.sib.exam.solution.pages.filter.FilterFormResult;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

@Name("Result page")
public class ResultPage {

    private FilterFormResult filterFormResult;

    public ResultPage(WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(
                new HtmlElementLocatorFactory(driver)), this);
    }

    public FilterFormResult getFilterFormResult() {
        return filterFormResult;
    }
}
