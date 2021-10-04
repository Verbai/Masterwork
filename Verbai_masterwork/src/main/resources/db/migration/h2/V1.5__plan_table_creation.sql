DROP TABLE IF EXISTS `print_plan`;
CREATE TABLE `print_plan`
(
    `id`              bigint(20)   NOT NULL AUTO_INCREMENT,
    `project_name`    varchar(255) NOT NULL,
    `filament_length` DOUBLE       NOT NULL,
    `time`            DOUBLE       NOT NULL,
    `all_costs`       DOUBLE       NOT NULL,
    `print_status`    varchar(255) NOT NULL,
    `file_name`       varchar(255) NOT NULL,
    `printer_id`      bigint(20)   NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (printer_id) references printer(id)
);