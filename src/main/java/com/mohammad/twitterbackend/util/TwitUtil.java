package com.mohammad.twitterbackend.util;

import com.mohammad.twitterbackend.model.Like;
import com.mohammad.twitterbackend.model.Twit;
import com.mohammad.twitterbackend.model.User;

public class TwitUtil {

    public static boolean isLikedByReqUser(User reqUser, Twit twit) {

        for (Like like : twit.getLikes()) {
            if (like.getUser().getId().equals(reqUser.getId())) {
                return true;
            }
        }

        return false;

    }

    public static boolean isRetwitedByReqUser(User reqUser, Twit twit) {

        for (User user : twit.getRetwitUser()) {
            if (user.getId().equals(reqUser.getId())) {
                return true;
            }
        }

        return false;

    }

}
