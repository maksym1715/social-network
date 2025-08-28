package project.social_network.surveys.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
}
