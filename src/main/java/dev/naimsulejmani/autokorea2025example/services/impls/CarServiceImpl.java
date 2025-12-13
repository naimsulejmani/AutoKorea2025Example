package dev.naimsulejmani.autokorea2025example.services.impls;

import dev.naimsulejmani.autokorea2025example.dtos.CarDto;
import dev.naimsulejmani.autokorea2025example.mappers.CarMapper;
import dev.naimsulejmani.autokorea2025example.repositories.CarRepository;
import dev.naimsulejmani.autokorea2025example.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository repository;
    private final CarMapper mapper;


    @Override
    public CarDto findCarByVin(String vin) {
        return null;
    }

    @Override
    public CarDto add(CarDto model) {
        return null;
    }

    @Override
    public List<CarDto> findAll() {
        return List.of();
    }

    @Override
    public CarDto findOne(Long id) {
        return null;
    }

    @Override
    public CarDto modify(Long id, CarDto model) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
