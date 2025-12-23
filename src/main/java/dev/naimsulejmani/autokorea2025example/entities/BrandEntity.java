package dev.naimsulejmani.autokorea2025example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "brands")
public class BrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "brand_code", nullable = false, unique = true, length = 20)
    private String brandCode;

    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String name;

    @Column(name = "logo", length = 1000)
    private String logo;

    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
    private Set<CarEntity> cars;
}
