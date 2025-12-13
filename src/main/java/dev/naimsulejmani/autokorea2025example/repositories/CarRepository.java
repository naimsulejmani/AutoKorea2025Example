package dev.naimsulejmani.autokorea2025example.repositories;

import dev.naimsulejmani.autokorea2025example.entities.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {
    //metodat tjera perkatese
    Optional<CarEntity> findByVin(String vin);
}
