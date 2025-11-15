package project.social_network.surveys.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.social_network.accounting.entity.User;
import project.social_network.surveys.dto.AreaCreateRequest;
import project.social_network.surveys.entities.Area;
import project.social_network.surveys.services.AreaService;

import java.util.List;

@RestController
@RequestMapping("/api/areas")
public class AreaController {
    private final AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }


    @PostMapping
    public ResponseEntity<Area> createArea(@RequestBody AreaCreateRequest areaCreateRequest) {
        Area createdArea = areaService.createArea(areaCreateRequest.ownerId(),areaCreateRequest.title(),areaCreateRequest.description());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdArea);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Area> deleteArea(@PathVariable Long id) {
        Area deleted = areaService.deleteArea(id);
        return ResponseEntity.ok(deleted);
    }

    @PostMapping("/{areaId}/users/{userId}")
    public ResponseEntity<List<User>> addUserToArea(@PathVariable Long areaId, @PathVariable Long userId) {
        List<User> area = areaService.addUserToArea(areaId, userId);
        return ResponseEntity.ok(area);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Area> getAreaById(@PathVariable Long id) {
        Area area = areaService.getAreaById(id);
        return ResponseEntity.ok(area);
    }

    @DeleteMapping("/{areaId}/users/{userId}")
    public ResponseEntity<Area> removeUserFromArea(@PathVariable Long areaId, @PathVariable Long userId) {
        Area area = areaService.removeUserFromArea(areaId, userId);
        return ResponseEntity.ok(area);
    }
}

