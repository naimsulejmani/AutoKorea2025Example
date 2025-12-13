package dev.naimsulejmani.autokorea2025example.services;

public interface WriteOnlyService<D, Did> extends AddService<D>, ModifyService<D, Did>, RemoveService<Did> {
}
