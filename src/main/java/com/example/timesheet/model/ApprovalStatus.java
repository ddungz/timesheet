package com.example.timesheet.model;

public enum ApprovalStatus {
    /**
     * 未実施
     */
    NOT_YET("01", "未実施"),
    /**
     * 待機
     */
    WAITING("02", "待機"),
    /**
     * 済
     */
    DONE("03", "済");

    private final String value;

    private final String name;

    public String value() {
        return this.value;
    }


    ApprovalStatus(String value, String name) {
        this.value = value;
        this.name = name;
    }
}
