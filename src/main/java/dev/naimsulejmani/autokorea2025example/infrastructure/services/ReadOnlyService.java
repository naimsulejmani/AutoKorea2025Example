package dev.naimsulejmani.autokorea2025example.infrastructure.services;

public interface ReadOnlyService<D, Did> extends FindOneService<D, Did>, FindAll<D> {
}
