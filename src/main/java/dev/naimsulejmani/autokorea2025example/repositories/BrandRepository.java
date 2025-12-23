package dev.naimsulejmani.autokorea2025example.repositories;

import dev.naimsulejmani.autokorea2025example.entities.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Long> {
    Optional<BrandEntity> findByName(String name);

    Optional<BrandEntity> findByBrandCode(String brandCode);
}
