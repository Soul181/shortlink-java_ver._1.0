package com.example.shortlink.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name ="links")
public class Link {
    @Id
    @Column(name = "short_link")
    private String shortLink;

    @Column(name = "original_link")
    private String originalLink;

    @Column(name = "time_create")
    private Long timeCreate;

    public String getOriginalLink() {
        return originalLink;
    }

    public void setOriginalLink(String originalLink) {
        this.originalLink = originalLink;
    }

    public String getShortLink() {
        return shortLink;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }

    public Long getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(Long timeCreate) {
        this.timeCreate = timeCreate;
    }
}
