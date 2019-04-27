package com.demo.service;

import com.demo.entry.Response;

import java.util.List;

/**
 * service接口
 * Created by : PF
 * Date on : 2019-04-27.
 */

public interface UrlService {

    /**
     *  判断长短网址是否在数据库中存储
     * @param longUrl 长网址
     * @return {
     *     存在对应网址 : true,
     *     不存在 ： false
     * }
     */
    boolean exist(String longUrl);

    /**
     *  根据所给定的长网址和自定义key值获取短网址
     * @param longUrl 长网址
     * @return 短网址
     */
    String getShortUrl(String longUrl, String params);

    /**
     *  根据所给定的短网址获取长网址
     * @param shorturl 短网址
     * @return 长网址
     */
    String getLongUrl(String shorturl);

    /**
     * 通过长链获取访问次数
     * @param longUrl 长链接
     * @return 访问次数
     */
    Integer getViewTimesByLongUrl(String longUrl);

    /**
     * 查询所有数据
     * @return
     */
    List<Response> listAll();
}

