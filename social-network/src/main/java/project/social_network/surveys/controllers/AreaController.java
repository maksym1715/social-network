package project.social_network.surveys.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.social_network.surveys.entities.Area;
import project.social_network.surveys.services.AreaService;

@RestController
@RequestMapping("/api/areas")
public class AreaController {
    private final AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }


    @PostMapping
    public ResponseEntity<Area> createArea(@RequestParam Long ownerId,
                                           @RequestParam String name,
                                           @RequestParam(required = false) String description) {
        Area createdArea = areaService.createArea(ownerId, name, description);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdArea);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Area> deleteArea(@PathVariable Long id) {
        Area deleted = areaService.deleteArea(id);
        return ResponseEntity.ok(deleted);
    }

    @PostMapping("/{areaId}/users/{userId}")
    public ResponseEntity<Area> addUserToArea(@PathVariable Long areaId, @PathVariable Long userId) {
        Area area = areaService.addUserToArea(areaId, userId);
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

