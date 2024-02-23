package com.RedWaySolutionAPI.domain;

import com.RedWaySolutionAPI.dto.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_USER")
@Entity(name = "TB_USER")
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;

    public User(UserDTO user) {
        this.firstName = user.firstName();
        this.lastName = user.lastName();
        this.email = user.email();
    }
}
