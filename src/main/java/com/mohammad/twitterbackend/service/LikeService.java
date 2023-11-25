package com.mohammad.twitterbackend.service;

import com.mohammad.twitterbackend.exception.TwitException;
import com.mohammad.twitterbackend.exception.UserException;
import com.mohammad.twitterbackend.model.Like;
import com.mohammad.twitterbackend.model.User;

import java.util.List;

public interface LikeService {

    public Like likeTwit(Long twitId, User user) throws UserException, TwitException;

    public List<Like> getAllLikes(Long twitId) throws TwitException;
}
