package com.example.timesheet.service.impl.converter;

import com.example.timesheet.model.ApprovalStatus;
import org.springframework.http.HttpStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ApprovalStatusConverter implements AttributeConverter<ApprovalStatus, String> {

    @Override
    public String convertToDatabaseColumn(ApprovalStatus attribute) {
        return attribute.value();
    }

    @Override
    public ApprovalStatus convertToEntityAttribute(String dbData) {
        switch (dbData) {
            case "01":
                return ApprovalStatus.NOT_YET;
            case "02":
                return ApprovalStatus.WAITING;
            case "03":
                return ApprovalStatus.DONE;
            default:
                throw new IllegalArgumentException("ApprovalStatus " + dbData + " not supported");
        }
    }
}
