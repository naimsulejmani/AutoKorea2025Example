package dev.naimsulejmani.autokorea2025example.services;

public interface ReadOnlyService<D, Did> extends FindOneService<D, Did>, FindAll<D> {
}
