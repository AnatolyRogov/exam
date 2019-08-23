package ru.sib.exam.tests;

import io.qameta.allure.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.sib.exam.ExamApplicationTests;
import ru.sib.exam.framework.annotations.TestName;
import ru.sib.exam.framework.utils.CollectionUtils;
import ru.sib.exam.solution.pages.result.ResultPage;
import ru.sib.exam.solution.steps.FilterFormResultSteps;
import ru.sib.exam.solution.steps.FilterFormSteps;

import java.math.BigDecimal;
import java.util.ArrayList;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static ru.sib.exam.solution.name.CaseName._001;

@Feature("Найти")
public class firstTest extends ExamApplicationTests {

    @Autowired
    CollectionUtils collectionUtils;
    @Autowired
    protected FilterFormSteps filterFormSteps;
    @Autowired
    protected FilterFormResultSteps filterFormResultSteps;

    @DataProvider
    public Object[][] getTestData() {
        Object[][] testData = excelUtils.getTableArray("src/main/resources/testData.xlsx", "testData");
        return testData;
    }

    @Test(dataProvider = "getTestData")
    @TestName(_001)
    public void testing(String operation, String kind, String category, String rooms, String amount, String geo) {
        ArrayList<String> roomsList = collectionUtils.getListOfString(rooms);
        filterFormSteps.selectOperation(mainPage.getFilterForm(), operation);
        filterFormSteps.selectKind(mainPage.getFilterForm(), kind);
        filterFormSteps.selectCategory(mainPage.getFilterForm(), category);
        filterFormSteps.selectRooms(mainPage.getFilterForm(), roomsList);
        filterFormSteps.setAmount(mainPage.getFilterForm(), new BigDecimal(amount));
        filterFormSteps.setGeo(mainPage.getFilterForm(), geo);
        filterFormSteps.clickFind(mainPage.getFilterForm());
        ResultPage resultPage = new ResultPage(getWebDriver());
        resultPage.getFilterFormResult().getDealTypeButton();
        filterFormResultSteps.checkOperation(resultPage, operation);
        filterFormResultSteps.checkKind(resultPage, kind);
        filterFormResultSteps.checkCategory(resultPage, category);
        filterFormResultSteps.checkAmount(resultPage, amount);
        filterFormResultSteps.checkLocation(resultPage, geo);
    }

}
