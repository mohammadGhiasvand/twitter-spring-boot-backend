package com.mohammad.twitterbackend.dto.mapper;

import com.mohammad.twitterbackend.dto.TwitDto;
import com.mohammad.twitterbackend.dto.UserDto;
import com.mohammad.twitterbackend.model.Twit;
import com.mohammad.twitterbackend.model.User;
import com.mohammad.twitterbackend.util.TwitUtil;

import java.util.ArrayList;
import java.util.List;

public class TwitDtoMapper {

    public static TwitDto toTwitDto(Twit twit, User reqUser) {

        UserDto user = UserDtoMapper.toUserDto(twit.getUser());

        boolean isLiked = TwitUtil.isLikedByReqUser(reqUser, twit);
        boolean isReteited = TwitUtil.isRetwitedByReqUser(reqUser, twit);

        List<Long> retwitUserId = new ArrayList<>();

        for (User user1 : twit.getRetwitUser()) {
            retwitUserId.add(user1.getId());
        }

        TwitDto twitDto = new TwitDto();

        twitDto.setId(twit.getId());
        twitDto.setContent(twit.getContent());
        twitDto.setCreatedAt(twit.getCreatedAt());
        twitDto.setImage(twit.getImage());
        twitDto.setTotalLikes(twit.getLikes().size());
        twitDto.setTotalReplies(twit.getReplyTwits().size());
        twitDto.setTotalRetweets(twit.getRetwitUser().size());
        twitDto.setUser(user);
        twitDto.setLiked(isLiked);
        twitDto.setRetwit(isReteited);
        twitDto.setRetwitUsersId(retwitUserId);
        twitDto.setReplyTwits(toTwitDtos(twit.getReplyTwits(), reqUser));
        twitDto.setVideo(twit.getVideo());
        
        return twitDto;
    }

    public static List<TwitDto> toTwitDtos(List<Twit> twits, User reqUser) {
        List<TwitDto> twitDtos = new ArrayList<>();

        for (Twit twit : twits) {
            TwitDto twitDto = toReplyTwitDto(twit, reqUser);
            twitDtos.add(twitDto);
        }

        return twitDtos;
    }

    private static TwitDto toReplyTwitDto(Twit twit, User reqUser) {

        UserDto user = UserDtoMapper.toUserDto(twit.getUser());

        boolean isLiked = TwitUtil.isLikedByReqUser(reqUser, twit);
        boolean isReteited = TwitUtil.isRetwitedByReqUser(reqUser, twit);

        List<Long> retwitUserId = new ArrayList<>();

        for (User user1 : twit.getRetwitUser()) {
            retwitUserId.add(user1.getId());
        }

        TwitDto twitDto = new TwitDto();

        twitDto.setId(twit.getId());
        twitDto.setContent(twit.getContent());
        twitDto.setCreatedAt(twit.getCreatedAt());
        twitDto.setImage(twit.getImage());
        twitDto.setTotalLikes(twit.getLikes().size());
        twitDto.setTotalReplies(twit.getReplyTwits().size());
        twitDto.setTotalRetweets(twit.getRetwitUser().size());
        twitDto.setUser(user);
        twitDto.setLiked(isLiked);
        twitDto.setRetwit(isReteited);
        twitDto.setRetwitUsersId(retwitUserId);
        twitDto.setVideo(twit.getVideo());

        return twitDto;
    }

}
