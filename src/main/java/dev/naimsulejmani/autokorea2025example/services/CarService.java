package dev.naimsulejmani.autokorea2025example.services;

import dev.naimsulejmani.autokorea2025example.dtos.CarDto;
import dev.naimsulejmani.autokorea2025example.infrastructure.services.CrudService;

public interface CarService extends CrudService<CarDto, Long> {
    CarDto findCarByVin(String vin);
}
