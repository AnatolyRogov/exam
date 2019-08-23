package ru.sib.exam.solution.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sib.exam.framework.actions.Actions;
import ru.sib.exam.solution.pages.filter.FilterForm;

import java.math.BigDecimal;
import java.util.List;

@Component
public class FilterFormSteps {

    @Autowired
    private Actions actions;

    @Step("Выбрать тип операции \"{type}\"")
    public void selectOperation(FilterForm filterForm, String type) {
        actions.click(filterForm.getFilterButtonOperation());
        actions.chooseAndClick(filterForm.getListOfOperations(), type, "контента");
    }

    @Step("Выбрать вид недвижимости \"{type}\"")
    public void selectKind(FilterForm filterForm, String type) {
        actions.click(filterForm.getFilterButtonPropertyKind());
        actions.chooseAndClick(filterForm.getListOfContent(), type, "категории недвижимости");
    }

    @Step("Выбрать вид недвижимости \"{type}\"")
    public void selectCategory(FilterForm filterForm, String type) {
        if(type != null) {
            actions.click(filterForm.getFilterButtonPropertyCategory());
            actions.chooseAndClick(filterForm.getListOfContent(), type, "категории недвижимости");
        }
    }

    @Step("Выбрать кол-во комнат \"{type}\"")
    public void selectRooms(FilterForm filterForm, List<String> number) {
        if(number != null) {
            actions.click(filterForm.getFilterButtonRoom());
            deselectRooms(filterForm);
            for (String n : number) {
                actions.chooseAndClick(filterForm.getListOfCheckBoxRoomAll(), n, "категории недвижимости");
            }
        }
    }

    @Step("Убрать выбранные элементы кол-во комнат")
    public void deselectRooms(FilterForm filterForm) {
        for(WebElement element:filterForm.getListOfCheckBoxRoomChoosen()) {
            actions.click(element);
        }
    }

    @Step("Задать стоимость недвижемости")
    public void setAmount(FilterForm filterForm, BigDecimal amount) {
        actions.setValue(filterForm.getFilterInputPrice(), amount.toString(), "До");
    }

    @Step("Задать регион поиска")
    public void setGeo(FilterForm filterForm, String gea) {
        actions.setValue(filterForm.getFilterInputGeo(), gea, "Город, адресс ...");
        actions.wait_int(1000);
        actions.click(filterForm.getFilterButtonFirstResultGeo());
    }

    public void clickFind(FilterForm filterForm) {
        actions.click(filterForm.getFilterButtonFind(), "Найти");
    }


}
