package com.example.timesheet.model;

public enum CorrectionType {
    /**
     * 追納返納
     */
    CORRECTION_PAYMENT("01", "追納返納"),
    /**
     * 年休返還
     */
    CORRECTION_HOLIDAY("02", "年休返還"),
    /**
     * その他
     */
    CORRECTION_OTHER("03", "その他");

    private final String value;

    private final String name;


    CorrectionType(String value, String name) {
        this.value = value;
        this.name = name;
    }
}
