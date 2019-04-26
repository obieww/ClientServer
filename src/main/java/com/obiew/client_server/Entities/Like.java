package com.obiew.client_server.Entities;


import java.util.Objects;

public class Like {
    private String likeId;
    private User user;
    private Obiew obiew;

    public Like() {}

    public String getLikeId() {
        return likeId;
    }

    public void setLikeId(String likeId) {
        this.likeId = likeId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Obiew getObiew() {
        return obiew;
    }

    public void setObiew(Obiew obiew) {
        this.obiew = obiew;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Like like = (Like) o;
        return Objects.equals(getLikeId(), like.getLikeId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLikeId(), getUser(), getObiew());
    }
}
