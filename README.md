本demo是一个短网址生成服务，具体使用操作如下：
首先启动，成功后：
- 根据长链接生成短链接 访问接口:
请求方式为POST
  1. 非自定义短链接：
    127.0.0.1:8080/ur/getShortUrl?longUrl=xxx
  2.自定义短链接：
    127.0.0.1:8080/ur/getShortUrl?longUrl=https://www.goole.com&params=xxx

- 根据短链在数据库中查找长链 访问接口:
请求方式为POST
127.0.0.1:8080/url/getLongUrl?shortUrl=xxx

- 根据长链接查询链接访问次数 访问接口：
请求方式为GET
127.0.0.1:8080/url/getViewTimes?longUrl=xxx
