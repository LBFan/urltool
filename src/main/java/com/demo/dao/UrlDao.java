package com.demo.dao;

import com.demo.entry.Response;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * mybatis mapper
 * Created by : PF
 * Date on : 2019-04-27.
 */

@Mapper
@Repository
public interface UrlDao {

    // 插入数据库
    @Insert("insert into urls(longUrl, shortUrl,viewTimes) values(#{longUrl}, #{shortUrl}, 0)")
    void addUrl(@Param("longUrl") String longUrl, @Param("shortUrl") String shortUrl);

    // 通过长链接查找
    @Select("select id, longUrl, shortUrl,viewTimes from urls where longUrl = #{longUrl}")
    Response findByLongUrl(@Param("longUrl") String longUrl);

    // 通过短链接查找
    @Select("select id, longUrl, shortUrl,viewTimes from urls where shortUrl = #{shortUrl}")
    Response findByShortUrl(@Param("shortUrl") String shortUrl);

    // 根据短链更新访问链接次数
    @Update("update urls set viewTimes = viewTimes + 1 where shortUrl = #{shortUrl}")
    void updateViewTimes(@Param("shortUrl") String shortUrl);

    // 查找所有数据
    @Select("select * from urls")
    List<Response> listAll();

    // 根据长链接获取访问次数
    @Select("select viewTimes from urls where longUrl = #{longUrl}")
    Integer findViewTimesByLongUrl(@Param("longUrl") String longUrl);
}

