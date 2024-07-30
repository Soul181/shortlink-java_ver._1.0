package com.example.shortlink.utils;

import com.example.shortlink.model.Link;
import com.example.shortlink.service.LinkService;
import org.apache.commons.lang3.RandomStringUtils;

import java.sql.SQLException;

public class GenerationUniqueShort {

    public static String generateString() throws SQLException {
        LinkService linkService = new LinkService();
        String generatedString = RandomStringUtils.random(6, true, true);
        Link link = linkService.findByShort(generatedString);
        if (link != null) {
            generateString();
        }
        return generatedString;
    }
}