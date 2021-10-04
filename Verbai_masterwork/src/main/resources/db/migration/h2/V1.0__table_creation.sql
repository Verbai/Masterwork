DROP TABLE IF EXISTS `filament`;
CREATE TABLE `filament` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT,
                            `weight` DOUBLE NOT NULL,
                            `Length` DOUBLE NOT NULL,
                            `density` DOUBLE NOT NULL,
                            `price` DOUBLE NOT NULL,
                            `diameter` DOUBLE NOT NULL,
                            `producer` varchar(255) NOT NULL,
                            `material` varchar(255) NOT NULL,
                            `user_id` bigint(20) NOT NULL,
                            PRIMARY KEY (`id`),
                            FOREIGN KEY (user_id) REFERENCES user(id)
);