package dev.naimsulejmani.autokorea2025example.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarFeatureDto {
    private Long id;
    private CarDto car;
    private FeatureDto feature;
    private LocalDate createdAt;
}
