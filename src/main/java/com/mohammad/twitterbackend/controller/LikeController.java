package com.mohammad.twitterbackend.controller;

import com.mohammad.twitterbackend.dto.LikeDto;
import com.mohammad.twitterbackend.dto.mapper.LikeDtoMapper;
import com.mohammad.twitterbackend.exception.TwitException;
import com.mohammad.twitterbackend.exception.UserException;
import com.mohammad.twitterbackend.model.Like;
import com.mohammad.twitterbackend.model.User;
import com.mohammad.twitterbackend.response.ApiResponse;
import com.mohammad.twitterbackend.service.LikeService;
import com.mohammad.twitterbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LikeController {

    @Autowired
    private UserService userService;

    @Autowired
    private LikeService likeService;

    @PostMapping("/{twitId}/likes")
    public ResponseEntity<LikeDto> likeTwit(@PathVariable Long twitId,
                                            @RequestHeader("Authorization") String jwt ) throws UserException, TwitException {
        User user = userService.findUserProfileByJwt(jwt);

        Like like = likeService.likeTwit(twitId, user);

        LikeDto likeDto = LikeDtoMapper.toLikeDto(like, user);

        return new ResponseEntity<>(likeDto, HttpStatus.CREATED);
    }

    @PostMapping("/twit/{twitId}")
    public ResponseEntity<List<LikeDto>> getAllLikes(@PathVariable Long twitId,
                                            @RequestHeader("Authorization") String jwt ) throws UserException, TwitException {
        User user = userService.findUserProfileByJwt(jwt);

        List<Like> likes = likeService.getAllLikes(twitId);

        List<LikeDto> likeDtos = LikeDtoMapper.toLikeDtos(likes, user);

        return new ResponseEntity<>(likeDtos, HttpStatus.CREATED);
    }


}
