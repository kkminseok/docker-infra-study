package org.example.business.domain.aggregate.demo.service;

import lombok.RequiredArgsConstructor;
import org.example.business.domain.aggregate.demo.model.User;
import org.example.business.domain.aggregate.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public String getUserName(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user != null ? user.get().getName() : null;
    }
}
