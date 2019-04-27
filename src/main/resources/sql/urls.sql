CREATE TABLE `urls` (
  `id` int(11) NOT NULL AUTO_INCREMENT comment '自增主键ID',
  `longUrl` varchar(255) COLLATE utf8_bin NOT NULL comment '长链接',
  `shortUrl` varchar(255) COLLATE utf8_bin NOT NULL comment '短链接',
  `viewTimes` int(11) NOT NULL comment '访问计数',
  PRIMARY KEY (`id`),
  KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin