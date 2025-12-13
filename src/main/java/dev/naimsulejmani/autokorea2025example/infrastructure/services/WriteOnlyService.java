package dev.naimsulejmani.autokorea2025example.infrastructure.services;

public interface WriteOnlyService<D, Did> extends AddService<D>, ModifyService<D, Did>, RemoveService<Did> {
}
