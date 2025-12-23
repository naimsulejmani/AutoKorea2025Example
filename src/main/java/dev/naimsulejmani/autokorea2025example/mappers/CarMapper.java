package dev.naimsulejmani.autokorea2025example.mappers;

import dev.naimsulejmani.autokorea2025example.dtos.CarDto;
import dev.naimsulejmani.autokorea2025example.entities.CarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarMapper extends BaseMapper<CarDto, CarEntity> {

    @Mapping(target = "createdBy", source = "username")
    @Mapping(target = "updatedBy", source = "username")
    @Mapping(target = "brand.id", source = "brandId")
    @Override
    CarEntity toEntity(CarDto dto);

    @Override
    @Mapping(target = "brandId", source = "brand.id")
    CarDto toDto(CarEntity entity);
}
