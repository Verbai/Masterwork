DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                          `id` bigint(20) NOT NULL AUTO_INCREMENT,
                          `name` varchar(255) NOT NULL,
                          `mail` varchar(255) NOT NULL,
                          PRIMARY KEY (`id`)
);
