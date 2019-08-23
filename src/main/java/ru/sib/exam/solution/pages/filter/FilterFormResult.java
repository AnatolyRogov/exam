package ru.sib.exam.solution.pages.filter;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@Name("Filter form result page")
@FindBy(xpath = "//div[contains(@class, \"--main-filters-container\")]")
public class FilterFormResult extends HtmlElement {

    @FindBy(xpath = "//button[contains(@data-mark, \"dealType\")]")
    private Button dealTypeButton;

    @FindBy(xpath = "//button[contains(@data-mark, \"offerType\")]")
    private Button offerTypeButton;

    @FindBy(xpath = "//button[contains(@data-mark, \"rooms\")]")
    private Button roomsButton;

    @FindBy(xpath = "//button[contains(text(), \"Все\")]")
    private Button kindAllButton;

    @FindBy(xpath = "//button[contains(text(), \"Новостройка\")]")
    private Button kindNewButton;

    @FindBy(xpath = "//button[contains(text(), \"Вторичка\")]")
    private Button kindOldButton;

    @FindBy(xpath = "//div[contains(@data-mark, \"priceField\")]//input[contains(@name, \"min\")]")
    private TextInput priceMinInput;

    @FindBy(xpath = "//div[contains(@data-mark, \"priceField\")]//input[contains(@name, \"max\")]")
    private TextInput priceMaxInput;

    @FindBy(xpath = "//button[contains(@data-mark, \"location\")]")
    private Button locationInput;

    public Button getDealTypeButton() {
        return dealTypeButton;
    }

    public Button getOfferTypeButton() {
        return offerTypeButton;
    }

    public Button getRoomsButton() {
        return roomsButton;
    }

    public Button getKindAllButton() {
        return kindAllButton;
    }

    public Button getKindNewButton() {
        return kindNewButton;
    }

    public Button getKindOldButton() {
        return kindOldButton;
    }

    public TextInput getPriceMinInput() {
        return priceMinInput;
    }

    public TextInput getPriceMaxInput() {
        return priceMaxInput;
    }

    public Button getLocationInput() {
        return locationInput;
    }
}
