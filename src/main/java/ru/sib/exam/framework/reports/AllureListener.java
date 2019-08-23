package ru.sib.exam.framework.reports;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.*;
import ru.sib.exam.framework.annotations.TestName;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.hasWebDriverStarted;
import static ru.sib.exam.framework.utils.ScreenshotUtils.attachUrl;
import static ru.sib.exam.framework.utils.ScreenshotUtils.takeBrowserScreenshot;

public class AllureListener implements ITestListener, IInvokedMethodListener {

    private static final Logger log = LoggerFactory.getLogger(AllureListener.class);


    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            try {
                if (hasWebDriverStarted())
                    takeBrowserScreenshot("Скриншот последнего шага");
                    attachUrl(getWebDriver().getCurrentUrl());
            } finally {
                if (hasWebDriverStarted()) {
                    getWebDriver().close();
                    getWebDriver().quit();
                }
            }
        }
    }


    @Override
    public void onTestStart(ITestResult result) {
        changeTitle(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

    public void changeTitle(ITestResult iTestResult) {
        if (iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(TestName.class) != null) {
            TestName testName = iTestResult
                    .getMethod()
                    .getConstructorOrMethod()
                    .getMethod()
                    .getAnnotation(TestName.class);
            if (testName != null && testName.value().toString() != null) {
                iTestResult.getMethod().setDescription(testName.value().toString());
            }
        }
    }
}
