package com.mohammad.twitterbackend.util;

import com.mohammad.twitterbackend.model.User;

public class UserUtil {

    public static boolean isReqUser(User reqUser, User searchUser) {
        return reqUser.getId().equals(searchUser.getId());
    }

    public static final boolean isFollowedByReqUser(User reqUser, User searchUser) {
        return reqUser.getFollowings().contains(searchUser);
    }

}
