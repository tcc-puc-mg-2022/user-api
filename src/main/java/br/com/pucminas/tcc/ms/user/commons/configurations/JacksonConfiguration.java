package br.com.pucminas.tcc.ms.user.commons.configurations;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.format.DateTimeFormatter;

@Configuration
public class JacksonConfiguration {

    @Bean
    @Primary
    public Jackson2ObjectMapperBuilderCustomizer configureDateTimeSerializers() {
        return builder -> builder
                .simpleDateFormat("yyyy-MM-dd")
                .serializers(
                        new LocalDateSerializer(DateTimeFormatter.ISO_DATE),
                        new LocalDateTimeSerializer(DateTimeFormatter.ISO_DATE_TIME)
                );
    }

}
