package project.social_network.surveys.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import project.social_network.accounting.entity.User;
import project.social_network.accounting.repository.UserRepository;
import project.social_network.surveys.entities.Area;
import project.social_network.surveys.repositories.AreaRepository;

@Service
public class AreaService {
    private final AreaRepository areaRepository;
    private final UserRepository userRepository;

    public AreaService(AreaRepository areaRepository, UserRepository userRepository) {
        this.areaRepository = areaRepository;
        this.userRepository = userRepository;
    }

    public Area createArea(Long ownerId, String name, String description) {
        User owner = userRepository.findById(ownerId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));


        Area area = new Area();
        area.setOwner(owner);
        area.setName(name);
        area.setDescription(description);
        return areaRepository.save(area);
    }
}
