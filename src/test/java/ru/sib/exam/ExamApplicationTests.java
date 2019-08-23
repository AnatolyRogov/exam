package ru.sib.exam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import ru.sib.exam.framework.actions.Actions;
import ru.sib.exam.framework.config.SelenideConfiguration;
import ru.sib.exam.framework.reports.AllureListener;
import ru.sib.exam.framework.utils.ExcelUtils;
import ru.sib.exam.solution.pages.main.MainPage;

import java.lang.reflect.Method;

@SpringBootTest
@Listeners(AllureListener.class)
public class ExamApplicationTests extends AbstractTestNGSpringContextTests {

    @Autowired
    protected SelenideConfiguration configuration;
    @Autowired
    protected Actions actions;
    @Autowired
    protected ExcelUtils excelUtils;

    protected MainPage mainPage;
    private Logger log = LoggerFactory.getLogger(ExamApplicationTests.class);

    @BeforeMethod(alwaysRun = true, description = "Установка тестовой конфигурации")
    public void beforeMethod(Method method) {
        configuration.setConfig();
        mainPage = actions.openStartPage();
        log.info("Starting test method: " + method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest(Method method) {
        log.info("Finished test method: " + method.getName());
    }


}
