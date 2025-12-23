package dev.naimsulejmani.autokorea2025example.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrandDto {
    @PositiveOrZero(message = "Id must be positive or zero")
    private Long id;

    @NotBlank(message = "Name should be provided")
    @Size(min = 1, max = 100, message = "Name should be between 1 and 100 characters")
    private String name;

    @NotBlank(message = "Brand code should be provided")
    @Size(min = 1, max = 20, message = "Brand code should be between 1 and 20 characters")
    private String brandCode;

    @Size(max = 1000, message = "Logo should be between 1 and 1000 characters")
    private String logo;
}
