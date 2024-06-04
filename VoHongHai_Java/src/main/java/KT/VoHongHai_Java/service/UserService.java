package KT.VoHongHai_Java.service;

import KT.VoHongHai_Java.entities.User;
import KT.VoHongHai_Java.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public User createUser(User user) {
        // Validate user data before saving
        // Example: check if username or email already exists
        return userRepository.save(user);
    }

    public User updateUser(Long userId, User userDetails) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setUsername(userDetails.getUsername());
            // Set other user details similarly
            return userRepository.save(user);
        } else {
            // Handle case when user is not found
            throw new IllegalArgumentException("User with ID " + userId + " not found");
        }
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
