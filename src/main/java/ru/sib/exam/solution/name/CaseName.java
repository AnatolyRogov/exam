package ru.sib.exam.solution.name;

/**
 * Перечисление для названия тест-кейсов и их корректного отображения в Allure отчете. Преимущественно для DataProvider
 */
public enum CaseName {

        _001("Проверка функциональности \"Найти\""),
    ;

    final private String name;

    CaseName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}
