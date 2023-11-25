package com.mohammad.twitterbackend.service;

import com.mohammad.twitterbackend.exception.TwitException;
import com.mohammad.twitterbackend.exception.UserException;
import com.mohammad.twitterbackend.model.Twit;
import com.mohammad.twitterbackend.model.User;
import com.mohammad.twitterbackend.repository.TwitRepository;
import com.mohammad.twitterbackend.request.TwitReplyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TwitService {

    public Twit createTwit(Twit twit, User user) throws UserException, TwitException;

    public List<Twit> findAllTwits();

    public Twit retwit(Long twitId, User user) throws UserException, TwitException;

    public Twit findById(Long twitId) throws TwitException;

    public void deleteTwitById(Long twitId, Long userId) throws TwitException, UserException;

    public Twit removeFromRetwit(Long twitId, User user) throws TwitException, UserException;

    public Twit createdReply(TwitReplyRequest req, User user) throws TwitException, UserException;

    public List<Twit> getUserTwit(User user);

    public List<Twit> findByLikesContainsUser(User user);

}
