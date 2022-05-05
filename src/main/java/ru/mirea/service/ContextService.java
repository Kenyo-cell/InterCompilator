package ru.mirea.service;

import org.springframework.stereotype.Service;
import ru.mirea.entity.ContextEntity;
import ru.mirea.repository.ContextRepository;

import java.util.List;

@Service
public class ContextService {
    private final ContextRepository contextRepository;

    public ContextService(ContextRepository contextRepository) {
        this.contextRepository = contextRepository;
    }

    public ContextEntity saveContext(ContextEntity context, long userId) {
        return null;
    }

    public ContextEntity updateContext(ContextEntity context, long contextId, long userId) {
        return null;
    }

    public long deleteContext(long userId, long contextId) {
        return 0;
    }

    public List<ContextEntity> getContextsByUserId(long userId) {
        return List.of();
    }
}
