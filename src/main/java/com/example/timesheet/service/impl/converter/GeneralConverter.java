package com.example.timesheet.service.impl.converter;

import javax.persistence.AttributeConverter;

public class GeneralConverter<T, String> implements AttributeConverter<T, String> {

    @Override
    public String convertToDatabaseColumn(T attribute) {
        return null;
    }

    @Override
    public T convertToEntityAttribute(String dbData) {
        return null;
    }
}
