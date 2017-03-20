package com.guilherme.miguel.conf.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;

import java.time.LocalDateTime;
import java.util.Date;

import static java.time.LocalDateTime.ofInstant;
import static java.time.ZoneId.systemDefault;

/**
 * @author Miguel Guilherme
 */

public class DateConverters {

    @WritingConverter
//    @ReadingConverter
    public enum LocalDateTimeToLong implements Converter<LocalDateTime, Long> {
        INSTANCE;

        @Override
        public Long convert(LocalDateTime localDateTime) {
            return localDateTime == null ? null : Date.from(localDateTime.atZone(systemDefault()).toInstant()).getTime();
        }

    }

    @ReadingConverter
//    @WritingConverter
    public enum NumberToLocalDateTime implements Converter<Number, LocalDateTime> {
        INSTANCE;

        @Override
        public LocalDateTime convert(Number source) {
            if (source == null) {
                return null;
            }

            Date date = new Date();
            date.setTime(source.longValue());
            return ofInstant(date.toInstant(), systemDefault());
        }

    }

}
