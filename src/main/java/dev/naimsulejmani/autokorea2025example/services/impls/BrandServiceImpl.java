package dev.naimsulejmani.autokorea2025example.services.impls;

import dev.naimsulejmani.autokorea2025example.dtos.BrandDto;
import dev.naimsulejmani.autokorea2025example.exceptions.ConflictException;
import dev.naimsulejmani.autokorea2025example.exceptions.NotFoundException;
import dev.naimsulejmani.autokorea2025example.mappers.BrandMapper;
import dev.naimsulejmani.autokorea2025example.repositories.BrandRepository;
import dev.naimsulejmani.autokorea2025example.services.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepository repository;
    private final BrandMapper mapper;

    @Override
    public BrandDto add(BrandDto model) {
        if (model.getId() != null && repository.existsById(model.getId())) {
            throw new ConflictException("Brand with id " + model.getId() + " already exists");
        }
        var entity = mapper.toEntity(model);
        repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public List<BrandDto> findAll() {
        var brands = repository.findAll();
        return mapper.toDtoList(brands);
    }

    @Override
    public BrandDto findOne(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Brand not found with id: " + id));
        return mapper.toDto(entity);
    }

    @Override
    public BrandDto modify(Long id, BrandDto model) {
        if (model.getId() != null && model.getId().intValue() != id) {
            throw new IllegalArgumentException("Id doesn't match");
        }
        if (!repository.existsById(id)) {
            throw new NotFoundException("Brand not found with id: " + id);
        }
        var entity = mapper.toEntity(model);
        repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public void remove(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Brand not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
