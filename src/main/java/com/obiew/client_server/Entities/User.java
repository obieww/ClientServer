package com.obiew.client_server.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class User {
    private String userId;
    private String username;
    private String password;
    private List<Obiew> obiewList;
    private List<User> followingList;
    private List<User> followerList;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.obiewList = new LinkedList<>();
        this.followerList = new LinkedList<>();
        this.followingList = new LinkedList<>();
    }

    public void addObiew(Obiew obiew) {
        obiewList.add(obiew);
        obiew.setUser(this);
    }

    public void addFollowing(User following) {
        followingList.add(following);
        following.followerList.add(this);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Obiew> getObiewList() {
        return obiewList;
    }

    public void setObiewList(List<Obiew> obiewList) {
        this.obiewList = obiewList;
    }

    public List<User> getFollowingList() {
        return followingList;
    }

    public void setFollowingList(List<User> followingList) {
        this.followingList = followingList;
    }

    public List<User> getFollowerList() {
        return followerList;
    }

    public void setFollowerList(List<User> followerList) {
        this.followerList = followerList;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getUsername(), user.getUsername()) &&
                Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getUsername(), getPassword());
    }
}
