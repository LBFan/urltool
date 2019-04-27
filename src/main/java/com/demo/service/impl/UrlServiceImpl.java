package com.demo.service.impl;

import com.demo.utils.HttpRequestUtils;
import com.demo.dao.UrlDao;
import com.demo.entry.Response;
import com.demo.service.UrlService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * service实现类
 * Created by : PF
 * Date on : 2019-04-27.
 */
@Service
@Slf4j
public class UrlServiceImpl implements UrlService {

    @Autowired
    private UrlDao urlDao;

    @Override
    public boolean exist(String url) {
        Response urls = urlDao.findByLongUrl(url);
        if (urls != null){
            return true;
        }
        return false;
    }

    @Override
    public String getShortUrl(String longUrl, String params) {
        Response response = new Response();
        // 1.先判断DB中是否存在
        // 2.若存在，直接取;若不存在，则生成(包括自定义和非自定义)
        if (exist(longUrl)) {
            response = urlDao.findByLongUrl(longUrl);
            System.out.printf(response.toString());
            return response.getShortUrl();
        }
        // 不存在于DB中，调用接口生成短链接，返回短链接并且插入DB中
        // TODO : 调用接口生成短链接
        /**
         * 判断： 如果params字段为空，则生成短链
         *       如果params字段不为空，则生成自定义短链
         * 生成成功后，将链接存入DB
         */
        if (params != null && (params.length() > 0 && params.length() <= 10))  { // 自定义后缀
            response.setShortUrl("https://dwz.mn/" + params);

        } else {
            String param = "url=" + longUrl;
            String url = "https://dwz.mn/create.aspx";
            String result = HttpRequestUtils.sendGet(url, param);
            Map<String, Object> map = new Gson().fromJson(result, new TypeToken<HashMap>(){}.getType());
            System.out.println("用JSON类的parseObject来解析JSON字符串!!!");
            for (Object obj : map.keySet()) {
                if (obj.equals("tinyurl")) {
                     response.setShortUrl((String) map.get(obj));
                }
            }
        }
        // 将链接存入DB
        urlDao.addUrl(longUrl, response.getShortUrl());
        return response.getShortUrl();
    }

    @Override
    public String getLongUrl(String shortUrl) {
        Response response = urlDao.findByShortUrl(shortUrl);
        if (response != null) {
            urlDao.updateViewTimes(shortUrl);
            return response.getLongUrl();
        }
        return null;
    }

    @Override
    public Integer getViewTimesByLongUrl(String longUrl) {
        Integer times = urlDao.findViewTimesByLongUrl(longUrl);
        System.out.println(times);
        return times;
    }


    @Override
    public List<Response> listAll() {
        return urlDao.listAll();
    }

}

