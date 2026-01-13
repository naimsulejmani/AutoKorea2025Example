package dev.naimsulejmani.autokorea2025example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "car_features")
public class CarFeatureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private CarEntity car;

    @ManyToOne
    @JoinColumn(name = "feature_id", nullable = false)
    private FeatureEntity feature;

    private LocalDateTime createdAt = LocalDateTime.now();

}































