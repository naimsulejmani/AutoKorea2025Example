package dev.naimsulejmani.autokorea2025example.mappers;

import dev.naimsulejmani.autokorea2025example.dtos.BrandDto;
import dev.naimsulejmani.autokorea2025example.entities.BrandEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper extends BaseMapper<BrandDto, BrandEntity> {
}
