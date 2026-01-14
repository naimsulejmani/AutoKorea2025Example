package dev.naimsulejmani.autokorea2025example.entities;

import dev.naimsulejmani.autokorea2025example.enums.FuelType;
import dev.naimsulejmani.autokorea2025example.enums.TransmissionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;


@Entity(name = "cars")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "cars", schema = "public")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "vin_no", nullable = false, length = 17, unique = true)
    private String vin;

    //give me some columns for auto car model
    @Column(nullable = false)
    private int producedYear;

    @Column(nullable = false, length = 100)
    private String model;

//    @Column(nullable = false, length = 100)
//    private String brand;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private BrandEntity brand;

    @Column(nullable = false, length = 100)
    private String color;

    @Column(nullable = false)
    private int doors;

    @Column(nullable = false)
    private int seats;

    @Column(nullable = false, precision = 15)
    private double price;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private TransmissionType transmissionType;

    @Column(nullable = false)
    private boolean available;

    @Column(nullable = false)
    private boolean archived;

    @Column(nullable = false, precision = 15)
        private float mileage=0;

    private int horsePower;

    private int cubicCapacity;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;


    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false, updatable = false, length = 50)
    private String createdBy;


    @Column(insertable = false)
    private LocalDateTime updatedAt;

    @Column(length = 50, insertable = false)
    private String updatedBy;

    //
    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

    @PostRemove
    public void postRemove() {
        System.out.println("CarEntity postRemove");
    }

    @PostPersist
    public void postPersist() {
        System.out.println("CarEntity postPersist");
    }

    //@PostRemove
    //@PreRemove

    //@PostPersist
    //@PostRemove

    @OneToMany(mappedBy = "car")
    private Set<CarFeatureEntity> carFeatures;
}








