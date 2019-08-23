package ru.sib.exam.solution.steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sib.exam.framework.actions.Actions;
import ru.sib.exam.solution.pages.result.ResultPage;

@Component
public class FilterFormResultSteps {

    @Autowired
    private Actions actions;

    @Step("Проверить выбранную операцию \"{type}\"")
    public void checkOperation(ResultPage resultPage, String type) {
        actions.check(resultPage.getFilterFormResult().getDealTypeButton().getText(), type);
    }

    @Step("Проверить выбранный вид \"{type}\"")
    public void checkKind(ResultPage resultPage, String type) {
        actions.check(resultPage.getFilterFormResult().getOfferTypeButton().getText(), type);
    }

    @Step("Проверить выбранный тип \"{type}\"")
    public void checkCategory(ResultPage resultPage, String type) {
        if (type != null)
            switch (type) {
                case "Все":
                    Assert.assertTrue(resultPage.getFilterFormResult().getKindAllButton().getAttribute("class")
                            .contains("active"));
                    break;
                case "Вторичка":
                    Assert.assertTrue(resultPage.getFilterFormResult().getKindOldButton().getAttribute("class")
                            .contains("active"));
                    break;
                case "Новостройка":
                    Assert.assertTrue(resultPage.getFilterFormResult().getKindNewButton().getAttribute("class")
                            .contains("active"));
                    break;
            }
    }

    @Step("Проверить введенную сумму \"{type}\"")
    public void checkAmount(ResultPage resultPage, String type) {
        actions.check(resultPage.getFilterFormResult()
                .getPriceMaxInput().getText().replaceAll(" ", ""), type);
    }

    @Step("Проверить выбранную локацию \"{type}\"")
    public void checkLocation(ResultPage resultPage, String type) {
        actions.check(resultPage.getFilterFormResult().getLocationInput().getText(), type);
    }


}
