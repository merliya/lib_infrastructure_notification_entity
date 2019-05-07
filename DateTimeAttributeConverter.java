package com.jbhunt.infrastructure.notification.entity.converter;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class DateTimeAttributeConverter implements AttributeConverter<LocalDateTime, String> {
    @Override
    public String convertToDatabaseColumn(LocalDateTime localDateTime) {
        if (Optional.ofNullable(localDateTime).isPresent()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSS XXX");
            OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, OffsetDateTime.now().getOffset());
            return offsetDateTime.format(formatter);
        }
        return null;
    }

    @Override
    public LocalDateTime convertToEntityAttribute(String dateTimeString) {
        if (Optional.ofNullable(dateTimeString).isPresent()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSS XXX");
            return LocalDateTime.parse(dateTimeString, formatter);
        }
        return null;
    }
}
