package com.example.shortlink.service;

import com.example.shortlink.dao.LinkDao;
import com.example.shortlink.model.Link;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class LinkService {
    private final LinkDao linkDao = new LinkDao();
    public LinkService() {}


    public Link saveLink(Link link) throws SQLException {
        return linkDao.save(link);
    }

    public Link findByShort(String shortLink) throws SQLException {
        return linkDao.getOne(shortLink);
    }
}
