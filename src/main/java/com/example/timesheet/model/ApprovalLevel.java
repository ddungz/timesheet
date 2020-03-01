package com.example.timesheet.model;

public enum ApprovalLevel {
    /**
     * 人事担当
     */
    ASSISTANT_APPROVAL("01", "人事担当"),
    /**
     * 総括担当
     */
    GENERAL_APPROVAL("02", "総括担当"),
    /**
     * 管理職承認
     */
    MANAGER_APPROVAL("03", "管理職承認");

    private final String value;

    private final String name;

    public String value() {
        return this.value;
    }


    ApprovalLevel(String value, String name) {
        this.value = value;
        this.name = name;
    }
}
