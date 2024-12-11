package com.prathGul.journalApp.service;

import com.prathGul.journalApp.entity.User;
import com.prathGul.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Disabled
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @ParameterizedTest
    @ValueSource(strings = {
            "ram",
            "sham",
            "pratham"
    })
    public void testFindByUserName(String name) {
        assertNotNull(userRepository.findByUserName(name));
    }

    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class)
    public void testSaveNewUser(User user) {
        assertTrue(userService.saveNewUser(user));
    }

    @ParameterizedTest
    @CsvSource({
            "1,1,2",  //a,b,expected
            "2,5,7",
            "3,3,9"   //fails
    })
    public void test(int a, int b, int expected) {
        assertEquals(expected, a + b);
    }
}
