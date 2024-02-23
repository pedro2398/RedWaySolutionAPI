package com.RedWaySolutionAPI.service;

import com.RedWaySolutionAPI.domain.User;
import com.RedWaySolutionAPI.dto.UserDTO;
import com.RedWaySolutionAPI.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Assertions;

import java.util.Optional;

import static org.mockito.Mockito.*;

class UserServiceTest {

    private UserRepository repository;

    @Autowired
    UserService service;

    @BeforeEach
    void setup() {
        //MockitoAnnotations.initMocks(this);
        repository = Mockito.mock(UserRepository.class);
        this.service = new UserService(repository);
    }

    @Test
    @DisplayName("must return user by id successfully")
    void getUserCase1() {
        User user1 = new  User(1L, "Pedro", "Cardoso", "pedro@gmail.com");

        when(repository.findById(1L)).thenReturn(Optional.of(user1));

        User createdUser = service.getUserById(1L);

        Assertions.assertEquals(createdUser, user1);
    }
    @Test
    @DisplayName("You must register a user successfully")
    void postUserCase1() {
        UserDTO user1 = new UserDTO("Bianca", "Vichino", "bianca@gmail.com");

        UserDTO postedUser = service.postUser(user1);

        verify(this.repository, times(1)).save(any());
        Assertions.assertEquals(postedUser, user1);
    }
}