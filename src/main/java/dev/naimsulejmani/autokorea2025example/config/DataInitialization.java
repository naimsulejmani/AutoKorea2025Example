package dev.naimsulejmani.autokorea2025example.config;

import dev.naimsulejmani.autokorea2025example.entities.BrandEntity;
import dev.naimsulejmani.autokorea2025example.repositories.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


//Seeder
@Component
@RequiredArgsConstructor
public class DataInitialization implements CommandLineRunner {

    private final BrandRepository repository;

    @Override
    public void run(String... args) throws Exception {

        if (repository.count() == 0) {
            BrandEntity brandEntity = new BrandEntity();
            brandEntity.setName("Toyota");
            brandEntity.setBrandCode("TOY");
            brandEntity.setLogo("https://example.com/toyota-logo.png");
            repository.save(brandEntity);

            // mercedes and bmw
            BrandEntity mercedes = BrandEntity.builder()
                    .name("Mercedes")
                    .brandCode("MER")
                    .logo("https://example.com/mercedes-logo.png")
                    .build();
            repository.save(mercedes);

            BrandEntity bmw = BrandEntity.builder()
                    .name("BMW")
                    .brandCode("BMW")
                    .logo("https://example.com/bmw-logo.png")
                    .build();
            repository.save(bmw);

        }
    }
}
