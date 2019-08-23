package ru.sib.exam.solution.pages.filter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.util.List;

@Name("Filter form")
@FindBy(xpath = "//div[contains(@class, '-c-filters-form--')]")
public class FilterForm extends HtmlElement {

    @FindBy(xpath = "//div[contains(@class, '-c-filters-field-operations-')]")
    private Button filterButtonOperation;

    @FindBy(xpath = "//div[contains(@class, '-c-filters-field-property')][1]")
    private Button filterButtonPropertyKind;

    @FindBy(xpath = "//div[contains(@class, '-c-filters-field-property')][2]")
    private Button filterButtonPropertyCategory;

    @FindBy(xpath = "//div[contains(@class, '-c-filters-field-room')]")
    private Button filterButtonRoom;

    @FindBy(xpath = "//button[contains(text(), \"Найти\")]")
    private Button filterButtonFind;

    @FindBy(xpath = "//input[contains(@class, '-c-filters-field-price-text')]")
    private TextInput filterInputPrice;

    @FindBy(xpath = "//input[contains(@id, 'geo-suggest-input')]")
    private TextInput filterInputGeo;

    @FindBy(xpath = "//div[contains(@class, \"geosuggest_widget-group-container\")]//div[contains(@class, \"geosuggest_widget-item\")][1]")
    private TextInput filterInputGeoFirst;

    @FindBy(xpath = "//div[contains(@class, '-c-filters-operations-radio')]")
    private List<WebElement> listOfOperations;

    @FindBy(xpath = "//div[contains(@class, '-c-filters-property-content')]//li//span")
    private List<WebElement> listOfContent;

    @FindBy(xpath = "//label[contains(@class, \"components-label\")]")
    private List<WebElement> listOfCheckBoxRoomAll;

    @FindBy(xpath = "//span[contains(@class, \"components-checked\")]//label")
    private List<WebElement> listOfCheckBoxRoomChoosen;

    @FindBy(xpath = "//div[contains(text(), \"Адреса\")]/..//span[1]/strong")
    private Button filterButtonFirstResultGeo;

    public Button getFilterButtonOperation() {
        return filterButtonOperation;
    }

    public Button getFilterButtonPropertyKind() {
        return filterButtonPropertyKind;
    }

    public Button getFilterButtonPropertyCategory() {
        return filterButtonPropertyCategory;
    }

    public Button getFilterButtonRoom() {
        return filterButtonRoom;
    }

    public Button getFilterButtonFind() {
        return filterButtonFind;
    }

    public TextInput getFilterInputPrice() {
        return filterInputPrice;
    }

    public TextInput getFilterInputGeo() {
        return filterInputGeo;
    }

    public TextInput getFilterInputGeoFirst() {
        return filterInputGeoFirst;
    }

    public List<WebElement> getListOfOperations() {
        return listOfOperations;
    }

    public List<WebElement> getListOfContent() {
        return listOfContent;
    }

    public List<WebElement> getListOfCheckBoxRoomAll() {
        return listOfCheckBoxRoomAll;
    }

    public List<WebElement> getListOfCheckBoxRoomChoosen() {
        return listOfCheckBoxRoomChoosen;
    }

    public Button getFilterButtonFirstResultGeo() {
        return filterButtonFirstResultGeo;
    }
}
