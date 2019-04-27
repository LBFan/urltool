package com.demo.controller;

import com.demo.entry.Response;
import com.demo.service.UrlService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by : PF
 * Date on : 2019-04-27.
 */

@RestController
@RequestMapping("/url")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping("/getShortUrl")
    public String getShortUrl(@Param("longUrl") String longUrl, @RequestParam(required = false, value = "params") String params) {
        String shortUrl = urlService.getShortUrl(longUrl, params);
        return shortUrl;
    }

    @PostMapping("/getLongUrl")
    public String getLongUrl(@Param("shortUrl") String shortUrl) {
        String longUrl = urlService.getLongUrl(shortUrl);
        return longUrl;
    }

    @PostMapping("/getViewTimes")
    public Integer getViewTimesByLongUrl(@Param("longUrl") String longUrl) {
        return urlService.getViewTimesByLongUrl(longUrl);
    }

    @GetMapping("/listAll")
    public List<Response> listAll() {
        return urlService.listAll();
    }
}

