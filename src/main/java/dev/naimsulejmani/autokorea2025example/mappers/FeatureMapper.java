package dev.naimsulejmani.autokorea2025example.mappers;

import dev.naimsulejmani.autokorea2025example.dtos.FeatureDto;
import dev.naimsulejmani.autokorea2025example.entities.FeatureEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FeatureMapper extends BaseMapper<FeatureDto, FeatureEntity> {
}
