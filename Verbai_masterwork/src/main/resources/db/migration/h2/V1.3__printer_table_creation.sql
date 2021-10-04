DROP TABLE IF EXISTS `printer`;
CREATE TABLE `printer` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT,
                            `name` varchar(255) NOT NULL,
                            `printer_type` varchar(255) NOT NULL,
                            `print_size` DOUBLE NOT NULL,
                            `accepted_filament_diameter` DOUBLE NOT NULL,
                            `max_temperature` DOUBLE NOT NULL,
                            `operation_cost_per_hour` varchar(255) NOT NULL,
                            PRIMARY KEY (`id`)
);