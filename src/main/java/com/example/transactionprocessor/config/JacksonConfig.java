package com.example.transactionprocessor.config;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JacksonConfig {

    public static final String CYBERSOURCE_OBJECT_MAPPER = "cyberSourceObjectMapper";

    public static final String SERVER_OBJECT_MAPPER = "serverObjectMapper";

    /**
     * Used for the mediation api.
     */
    @Primary
    @Bean(SERVER_OBJECT_MAPPER)
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper mapper = builder.createXmlMapper(false).build();

        mapper.registerModules(new Jdk8Module(), new JavaTimeModule());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.setSerializationInclusion(Include.NON_NULL);

        // Null lists should be deserialized as empty to avoid null pointers
        mapper.configOverride(List.class).setSetterInfo(
            JsonSetter.Value.forContentNulls(Nulls.AS_EMPTY)
        );

        return mapper;
    }

    /**
     * Used with the webclient to make calls to vitality. Uses a custom deserializer which deserializes null strings
     * ("null") as actual nulls.
     */
    @Bean(CYBERSOURCE_OBJECT_MAPPER)
    public ObjectMapper clientObjectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModules(new Jdk8Module(), new JavaTimeModule(), new JsonNullableModule());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL);
        mapper.setSerializationInclusion(Include.NON_NULL);
        mapper.enable(Feature.WRITE_BIGDECIMAL_AS_PLAIN);

        return mapper;
    }

}
