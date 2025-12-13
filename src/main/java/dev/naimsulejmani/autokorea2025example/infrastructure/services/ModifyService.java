package dev.naimsulejmani.autokorea2025example.infrastructure.services;

public interface ModifyService<D, Did> {
    D modify(Did id, D model);
}
