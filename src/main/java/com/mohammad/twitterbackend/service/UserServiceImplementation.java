package com.mohammad.twitterbackend.service;

import com.mohammad.twitterbackend.config.JwtProvider;
import com.mohammad.twitterbackend.exception.UserException;
import com.mohammad.twitterbackend.model.User;
import com.mohammad.twitterbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public User findUserById(Long userId) throws UserException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserException("No user with the entered id {%s} was found".formatted(userId)));

        return user;
    }

    @Override
    public User findUserProfileByJwt(String jwt) throws UserException {
        String email = jwtProvider.getEmailFromToken(jwt);
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UserException("No user with the email, \"%s\", found".formatted(email));
        }
        return null;
    }

    @Override
    public User updateUser(Long userId, User reqUser) throws UserException {
        User user = findUserById(userId);

        if (reqUser.getFullName() != null) {
            user.setFullName(reqUser.getFullName());
        }

        if (reqUser.getImage() != null) {
            user.setImage(reqUser.getImage());
        }

        if (reqUser.getBackgroundImage() != null) {
            user.setBackgroundImage(reqUser.getBackgroundImage());
        }

        if (reqUser.getBirthDate() != null) {
            user.setBirthDate(reqUser.getBirthDate());
        }

        if (reqUser.getLocation() != null) {
            user.setLocation(reqUser.getLocation());
        }

        if (reqUser.getBio() != null) {
            user.setBio(reqUser.getBio());
        }

        if (reqUser.getWebsite() != null) {
            user.setWebsite(reqUser.getWebsite());
        }

        return userRepository.save(user);
    }

    @Override
    public User followUser(Long userId, User user) throws UserException {
        User followToUser = findUserById(userId);
        if (user.getFollowings().contains(followToUser) && followToUser.getFollowers().contains(user)) {
            user.getFollowings().remove(followToUser);
            followToUser.getFollowers().remove(user);
        } else {
            user.getFollowings().add(followToUser);
            followToUser.getFollowers().add(user);
        }
        userRepository.save(user);
        userRepository.save(followToUser);

        return followToUser;
    }

    @Override
    public List<User> searchUser(String query) {
        return userRepository.searchUser(query);
    }
}
