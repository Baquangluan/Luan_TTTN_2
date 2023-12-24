package com.example.example3.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.example3.entity.User;
import com.example.example3.service.UserService;
import com.example.example3.repository.UserRepository;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User CreateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.orElse(null);
    }

    @Override
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPhone(user.getPhone());
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setAddress(user.getAddress());
            existingUser.setImage(user.getImage());
            existingUser.setRoles(user.getRoles());
            existingUser.setCreated_at(user.getCreated_at());
            existingUser.setUpdated_at(user.getUpdated_at());
            existingUser.setCreated_by(user.getCreated_by());
            existingUser.setUpdated_by(user.getUpdated_by());
            existingUser.setStatus(user.getStatus());
            

            return userRepository.save(existingUser);
        } else {
            return null;
        }
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
