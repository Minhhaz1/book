package bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookstore.dto.UserDto;
import bookstore.entity.Book;
import bookstore.entity.User;
import bookstore.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean createUser(UserDto user) {
        if (checkEmail(user.getEmail())) {
            return false;
        } else {
            userRepository.save(new User(user));
            return true;
        }
    }

    public boolean checkEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public User login(UserDto userDto) {
        return userRepository.getUserByEmailAndPassword(userDto.getEmail(), userDto.getPassword());
    }

    public User getUser(Integer id) {
        return userRepository.getUserById(id);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }


}
