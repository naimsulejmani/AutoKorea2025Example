package dev.naimsulejmani.autokorea2025example.dtos;

import dev.naimsulejmani.autokorea2025example.enums.FuelType;
import dev.naimsulejmani.autokorea2025example.enums.TransmissionType;
import dev.naimsulejmani.autokorea2025example.infrastructure.validations.WithinYears;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {

    @PositiveOrZero
    private Long id;

    @NotBlank(message = "VIN number is required")
    @Size(min = 17, max = 17, message = "VIN number must be 17 characters long")
    private String vin;

    @WithinYears(maxYears = 15)
    private int producedYear;

    @Size(min = 2, max = 100, message = "Model must be between 2 and 100 characters long")
    private String model;

    @Positive(message = "Brand ID must be positive")
    private Long brandId;

    private BrandDto brand;

    @Size(min = 2, max = 100, message = "Color must be between 2 and 100 characters long")
    private String color;

    @Positive
    private int doors;

    @Positive
    private int seats;

    @PositiveOrZero
    private double price;

    @NotNull
    private TransmissionType transmissionType;

    //    @AssertFalse
//    @AssertTrue
    private boolean available;


    private boolean archived;

    @PositiveOrZero
    private float mileage;

    @Positive
    private int horsePower;

    @Positive
    private int cubicCapacity;


    @NotNull
    private FuelType fuelType;

    private String username;
}
