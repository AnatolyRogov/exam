package ru.sib.exam.framework.annotations;

import ru.sib.exam.solution.name.CaseName;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TestName {

    CaseName value();
}
