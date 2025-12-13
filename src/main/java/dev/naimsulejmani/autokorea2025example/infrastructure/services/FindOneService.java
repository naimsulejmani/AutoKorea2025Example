package dev.naimsulejmani.autokorea2025example.services;

public interface FindOneService<D, Did> {
    D findOne(Did id);
}
