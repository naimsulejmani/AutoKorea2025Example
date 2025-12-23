package dev.naimsulejmani.autokorea2025example.controllers.api;

import dev.naimsulejmani.autokorea2025example.dtos.BrandDto;
import dev.naimsulejmani.autokorea2025example.exceptions.NotFoundException;
import dev.naimsulejmani.autokorea2025example.services.BrandService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@RequiredArgsConstructor
public class BrandApiController {

    private final BrandService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BrandDto> getAllBrands() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandDto> getBrandById(@Valid @PathVariable @Positive long id) {
        try {
            return ResponseEntity.ok(this.service.findOne(id));
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createBrand(@Valid @RequestBody BrandDto brandDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.add(brandDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBrand(@Valid @PathVariable @Positive long id,
                                         @Valid @RequestBody BrandDto brandDto) {
        return ResponseEntity.ok(this.service.modify(id, brandDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBrand(@Valid @PathVariable @Positive long id) {
      try {
          this.service.remove(id);
      } catch (NotFoundException e){
          throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
      }
    }

}













