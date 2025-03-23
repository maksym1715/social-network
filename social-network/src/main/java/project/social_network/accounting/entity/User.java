package project.social_network.accounting.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // Основные данные для авторизации
    @Column(nullable = false, unique = true)
    private String username;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false)
    private String password; // Рекомендуется хранить хэш пароля
    
    // Персональные данные
    private String firstName;
    private String lastName;
    
    private LocalDate dateOfBirth;
    
    private String gender;
    
    private String phoneNumber;
    
    // Дополнительные сведения
    @Column(length = 500)
    private String bio;
    
    private String profilePictureUrl;
    
    private LocalDateTime createdAt;
    
    // Автоматическая установка даты создания
    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}
