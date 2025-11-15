package project.social_network.surveys.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import project.social_network.accounting.entity.User;
import project.social_network.accounting.repository.UserRepository;
import project.social_network.surveys.entities.Area;
import project.social_network.surveys.repositories.AreaRepository;

import java.util.List;

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

    public Area deleteArea(Long id) {
        Area area = areaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Area not found"));
        areaRepository.delete(area);
        return area;
    }

    public List<User> addUserToArea(Long areaId, Long userId) {
        Area area = areaRepository.findById(areaId)
                .orElseThrow(() -> new EntityNotFoundException("Area not found"));
        area.getMembers().add(userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found")));
        Area areaAfterSaved = areaRepository.save(area);
        return areaRepository.save(areaAfterSaved).getMembers();
    }

    public Area getAreaById(Long id) {
        return areaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Area not found"));
    }

    public Area removeUserFromArea(Long areaId, Long userId) {
        Area area = areaRepository.findById(areaId).orElseThrow(() -> new EntityNotFoundException("Area not found"));
        area.getMembers().remove(userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found")));
        return areaRepository.save(area);
    }

}

