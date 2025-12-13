package dev.naimsulejmani.autokorea2025example.services;

public interface ModifyService<D, Did> {
    D modify(Did id, D model);
}
