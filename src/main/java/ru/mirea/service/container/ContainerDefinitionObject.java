package ru.mirea.service.container;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public record ContainerDefinitionObject(String language, int port, boolean free) {
    @JsonCreator
    ContainerDefinitionObject(
            @JsonProperty("language") String language,
            @JsonProperty("port") int port) {

        this(language, port, true);
    }
}
