package ru.mirea.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import ru.mirea.service.container.ContainerDefinitionObject;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ContainerDispatcherService {
    private final String FILENAME = "containers.json";
    private final Map<String, List<ContainerDefinitionObject>> containers = new HashMap<>();

    public ContainerDispatcherService() throws Exception {
        ClassPathResource resource = new ClassPathResource("config/" + FILENAME);
        if (!resource.exists()) throw new Exception("Containers was not defined at classpath:/config/" + FILENAME);
        File containersConfig = resource.getFile();

        List<ContainerDefinitionObject> containersDefinitions = new ObjectMapper()
                .readValue(
                        containersConfig,
                        new TypeReference<List<ContainerDefinitionObject>>() {}
                );

        configureContainersDict(containersDefinitions);
    }

    private void configureContainersDict(List<ContainerDefinitionObject> definitions) {
        Set<String> languages = definitions.stream()
                .map(ContainerDefinitionObject::language)
                .collect(Collectors.toSet());

        for (String language : languages) {
            containers.put(
                    language,
                    definitions.stream()
                            .filter(def -> def.language().equals(language))
                            .collect(Collectors.toList())
            );
        }
    }

    public ContainerDefinitionObject getFreeContainer(String language) {
        return containers.get(language).stream().filter(ContainerDefinitionObject::free).findAny()
                .orElseThrow(() -> new RuntimeException(""));
    }
}
