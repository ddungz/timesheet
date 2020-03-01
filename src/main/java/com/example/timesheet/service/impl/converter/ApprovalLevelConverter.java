package com.example.timesheet.service.impl.converter;

import com.example.timesheet.model.ApprovalLevel;
import com.example.timesheet.model.ApprovalStatus;

import javax.persistence.AttributeConverter;

public class ApprovalLevelConverter implements AttributeConverter<ApprovalLevel, String> {
    @Override
    public String convertToDatabaseColumn(ApprovalLevel attribute) {
        return attribute.value();
    }

    @Override
    public ApprovalLevel convertToEntityAttribute(String dbData) {
        switch (dbData) {
            case "01":
                return ApprovalLevel.ASSISTANT_APPROVAL;
            case "02":
                return ApprovalLevel.GENERAL_APPROVAL;
            case "03":
                return ApprovalLevel.MANAGER_APPROVAL;
            default:
                throw new IllegalArgumentException("ApprovalStatus " + dbData + " not supported");
        }
    }
}
