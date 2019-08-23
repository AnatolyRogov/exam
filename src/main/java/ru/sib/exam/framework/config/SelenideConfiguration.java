package ru.sib.exam.framework.config;

import com.codeborne.selenide.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SelenideConfiguration {

    @Value("${browser.name}")
    protected String browserName;

    @Value("${browser.version}")
    protected String browserVersion;

    public void setConfig(){
        Configuration.timeout = 15000;
        Configuration.fastSetValue = true;
        Configuration.browser = browserName;
        Configuration.browserVersion = browserVersion;
        Configuration.startMaximized = true;
    }
}
