package ru.mirea.service.container;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public record ContainerDefinitionObject(String language, String host, int port, boolean free) {
    @JsonCreator
    ContainerDefinitionObject(
            @JsonProperty("language") String language,
            @JsonProperty("host") String host,
            @JsonProperty("port") int port) {

        this(language, host, port, true);
    }
}
