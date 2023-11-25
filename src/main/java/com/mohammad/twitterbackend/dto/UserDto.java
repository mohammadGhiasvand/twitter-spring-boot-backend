package com.mohammad.twitterbackend.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDto {

    private Long id;

    private String fullName;
    private String location;
    private String website;
    private String birthDate;
    private String email;
    private String mobile;
    private String image;
    private String backgroundImage;
    private String bio;

    private boolean req_user;
    private boolean login_with_google;

    private List<UserDto> followers = new ArrayList<>();
    private List<UserDto> followings = new ArrayList<>();

    private boolean followed;
    private boolean isVerified;
}
