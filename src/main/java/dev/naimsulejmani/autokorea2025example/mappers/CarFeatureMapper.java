package dev.naimsulejmani.autokorea2025example.mappers;

import dev.naimsulejmani.autokorea2025example.dtos.CarFeatureDto;
import dev.naimsulejmani.autokorea2025example.entities.CarFeatureEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarFeatureMapper extends BaseMapper<CarFeatureDto, CarFeatureEntity> {
}
