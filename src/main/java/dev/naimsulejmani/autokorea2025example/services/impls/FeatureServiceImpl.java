package dev.naimsulejmani.autokorea2025example.services.impls;

import dev.naimsulejmani.autokorea2025example.dtos.FeatureDto;
import dev.naimsulejmani.autokorea2025example.mappers.FeatureMapper;
import dev.naimsulejmani.autokorea2025example.repositories.FeatureRepository;
import dev.naimsulejmani.autokorea2025example.services.FeatureService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeatureServiceImpl implements FeatureService {
    private final FeatureRepository repository;
    private final FeatureMapper mapper;

    @Override
    public FeatureDto add(FeatureDto model) {

        if (model.getId() != null && model.getId() != 0 && repository.existsById(model.getId())) {
            throw new IllegalArgumentException("Feature with id " + model.getId() + " already exists");
        }
        var entity = mapper.toEntity(model);
        repository.save(entity);
        return mapper.toDto(entity);

    }

    @Override
    public List<FeatureDto> findAll() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public FeatureDto findOne(Long id) {

        return repository.findById(id).map(mapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Feature with id " + id + " not found"));
    }

    @Override
    public FeatureDto modify(Long id, FeatureDto model) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Feature with id " + id + " not found");
        }
        var entity = mapper.toEntity(model);
        entity.setId(id);
        repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public void remove(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Feature with id " + id + " not found");
        }
        repository.deleteById(id);
    }
}
