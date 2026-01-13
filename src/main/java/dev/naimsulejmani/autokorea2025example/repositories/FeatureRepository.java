package dev.naimsulejmani.autokorea2025example.repositories;

import dev.naimsulejmani.autokorea2025example.entities.FeatureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepository extends JpaRepository<FeatureEntity, Long> {
}
