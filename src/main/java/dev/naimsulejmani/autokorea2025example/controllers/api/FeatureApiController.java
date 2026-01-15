package dev.naimsulejmani.autokorea2025example.controllers.api;

import dev.naimsulejmani.autokorea2025example.dtos.FeatureDto;
import dev.naimsulejmani.autokorea2025example.services.FeatureService;
import jakarta.servlet.ServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/features")
@RequiredArgsConstructor
public class FeatureApiController {
    private final FeatureService service;

    @GetMapping
    public List<FeatureDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public FeatureDto findOne(@PathVariable Long id) {
        return service.findOne(id);
    }

    @PostMapping
    public FeatureDto add(@RequestBody FeatureDto featureDto) {
        featureDto.setCreatedAt(LocalDateTime.now());
        return service.add(featureDto);
    }

    @PutMapping("/{id}")
    public FeatureDto update(@PathVariable Long id, @RequestBody FeatureDto featureDto) {
        return service.modify(id, featureDto);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id, ServletRequest servletRequest) {
        service.remove(id);
    }

}
