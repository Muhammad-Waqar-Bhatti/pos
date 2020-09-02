CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `roles` (
  `role_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  PRIMARY KEY (`role_id`));

CREATE TABLE `user_role` (
  `user_id` INT NOT NULL,
  `role_id` INT NULL,
  PRIMARY KEY (`user_id`),
  INDEX `role_fk_idx` (`role_id` ASC) VISIBLE,
  CONSTRAINT `user_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `hrcp_db`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `role_fk`
    FOREIGN KEY (`role_id`)
    REFERENCES `hrcp_db`.`roles` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



INSERT INTO `roles` (`role_id`, `name`) VALUES ('1', 'ADMIN');
INSERT INTO `roles` (`role_id`, `name`) VALUES ('2', 'SALES');


INSERT INTO `user` (`user_id`, `username`, `password`) VALUES ('1', 'mohammadwaqar401@gmail.com', '$2a$10$cTUErxQqYVyU2qmQGIktpup5chLEdhD2zpzNEyYqmxrHHJbSNDOG.');
INSERT INTO `user` (`user_id`, `username`, `password`) VALUES ('2', 'amjad4dahri@gmail.com', '$2a$10$.tP2OH3dEG0zms7vek4ated5AiQ.EGkncii0OpCcGq4bckS9NOULu');

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('1', '1');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('2', '2');
