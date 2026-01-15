package dev.naimsulejmani.autokorea2025example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "features")
public class FeatureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String name;

//    @Column(nullable = false, columnDefinition = "NOW()")
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "feature")
    private Set<CarFeatureEntity> carFeatures;
}








