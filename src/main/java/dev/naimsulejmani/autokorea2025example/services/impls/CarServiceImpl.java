package dev.naimsulejmani.autokorea2025example.services.impls;

import dev.naimsulejmani.autokorea2025example.dtos.CarDto;
import dev.naimsulejmani.autokorea2025example.exceptions.CarConflictException;
import dev.naimsulejmani.autokorea2025example.exceptions.CarNotFoundException;
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
        var optionalEntity = repository.findByVin(vin);

        if (optionalEntity.isEmpty()) {
            throw new CarNotFoundException("Cannot find Car with vin number: " + vin);
        }

        return mapper.toDto(optionalEntity.get());
    }

    @Override
    public CarDto add(CarDto model) {
        if (model.getId() != null && model.getId() != 0) {
            if (repository.existsById(model.getId())) {
                throw new CarConflictException("Car with id: " + model.getId() + " already exists");
            }
        }
        var entity = mapper.toEntity(model);
        repository.save(entity); //nese ID eshte auto-gjeneruese e gjeneron id edhe entitit ja jep
        return mapper.toDto(entity);
    }

    @Override
    public List<CarDto> findAll() {

        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public CarDto findOne(Long id) {
        var entity = repository.findById(id).orElseThrow(() -> new CarNotFoundException("Car with id: " + id));
        return mapper.toDto(entity);

//        var optionalEntity = repository.findById(id);
//        if (optionalEntity.isEmpty()) {
//            throw new CarNotFoundException("Car with id: " + id + " not found");
//        }
//
//        return mapper.toDto(optionalEntity.get());
    }

    @Override
    public CarDto modify(Long id, CarDto model) {
        if (!repository.existsById(id)) {
            throw new CarNotFoundException("Car with id: " + id + " not found");
        }

        var entity = mapper.toEntity(model);
        entity.setId(id);
        repository.save(entity);

        return mapper.toDto(entity);
    }

    @Override
    public void remove(Long id) {
        if (!repository.existsById(id)) {
            throw new CarNotFoundException("Car with id: " + id + " not found");
        }
        repository.deleteById(id);
    }
}
