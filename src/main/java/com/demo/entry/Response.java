package com.demo.entry;

//import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by : PF
 * Date on : 2019-04-27.
 */
@Data
public class Response implements Serializable {
    // 主键
    @Id
    @GeneratedValue
    private Integer id;

    // 长链接
    private String longUrl;

    // 短链接
    private String shortUrl;

    // 状态码
//    private Integer status;

    // 访问次数
    private Integer viewTimes;
}

