package dev.naimsulejmani.autokorea2025example.infrastructure.services;

public interface FindOneService<D, Did> {
    D findOne(Did id);
}
