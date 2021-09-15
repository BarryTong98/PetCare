SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` INT(10) NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(25) NOT NULL,
	`nick_name` VARCHAR(25) DEFAULT NULL,
  `password` VARCHAR(25) NOT NULL,
  `phone_number` VARCHAR(25) DEFAULT NULL,
	`email` VARCHAR(25) DEFAULT NULL,
	`image_url` VARCHAR(100) DEFAULT NULL COMMENT '用户头像的URL',
  PRIMARY KEY (`uid`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user`(`user_name`,`nick_name`,`password`, `phone_number`,`email`) VALUES ('user1', 'Bob', '123456', '02987654321', '123@qq.com');
INSERT INTO `user`(`user_name`,`nick_name`,`password`, `phone_number`,`email`) VALUES ('user2', 'Anna', '123456', '35335342424', '1234@qq.com');


-- ----------------------------
-- Table structure for service_provider
-- ----------------------------
DROP TABLE IF EXISTS `service_provider`;
CREATE TABLE `service_provider` (
  `spid` INT(10) NOT NULL AUTO_INCREMENT,
  `service_provider_name` VARCHAR(25) NOT NULL,
	`address` VARCHAR(100) DEFAULT NULL,
  `contact_number` VARCHAR(25) DEFAULT NULL,
	`type` INT(1) NOT NULL COMMENT '1 健康 2 美容',
	`service_content` VARCHAR(100) DEFAULT NULL COMMENT '提供的具体服务内容 搜索匹配字段  健康: 医院 绝育 体检 疫苗 美容：美容 洗澡 驱虫 洁牙',
	`average_price` DOUBLE(8,2) DEFAULT NULL,
	`description` VARCHAR(100) DEFAULT NULL COMMENT '商家的自我描述信息 搜索匹配字段',
	`sales` INT(4) DEFAULT NULL,
	`rating` DOUBLE(4,2) DEFAULT NULL,
	`region` VARCHAR(50) DEFAULT NULL,
  `business_hours` VARCHAR(50) DEFAULT NULL,
	`latitude` VARCHAR(50) DEFAULT NULL,
	`longitude` VARCHAR(50) DEFAULT NULL,
	`image_url` VARCHAR(100) DEFAULT NULL COMMENT '商家照片的URL',
  PRIMARY KEY (`spid`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of service_provioder
-- ----------------------------

INSERT INTO `service_provider`(`service_provider_name`,`address`,`contact_number`,`type`,`service_content`,`average_price`,`description`,`sales`,`rating`,`region`,`business_hours`)
VALUES ('service_providerA', '1101 S Main St APT 203 Milpitas CA 95035', '02987654321', '1', 'pet hospitals medical check-ups vaccinations sterilisation', 50,'the best pet hospital',500,4.3,'Carlingford','Monday to Friday 9am to 17pm');

INSERT INTO `service_provider`(`service_provider_name`,`address`,`contact_number`,`type`,`service_content`,`average_price`,`description`,`sales`,`rating`,`region`,`business_hours`)
VALUES ('service_providerB', '1 Infinite Loop Cupertino CA 95014', '02987654321', '2', 'Pet beauty Bathing Teething Worming ', 80,'the best pet beauty',1000,4.2,'Kogarah','Monday to Friday 9am to 17pm');

-- ----------------------------
-- Table structure for review
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review` (
  `rid` INT(10) NOT NULL AUTO_INCREMENT,
  `user_id` INT(10) NOT NULL,
	`service_provider_id` INT(10) NOT NULL,
  `rating` DOUBLE(4,2) DEFAULT NULL,
	`content` VARCHAR(500) DEFAULT NULL,
  `create_time` TIMESTAMP DEFAULT NOW(),
	`number_of_likes` INT(4) DEFAULT NULL COMMENT '点赞数',
  PRIMARY KEY (`rid`),
	FOREIGN KEY(`user_id`) REFERENCES user(`uid`),
	FOREIGN KEY(`service_provider_id`) REFERENCES service_provider(`spid`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of review
-- ----------------------------
INSERT INTO `review`(`user_id`,`service_provider_id`,`rating`, `content`,`number_of_likes`) VALUES (1, 1, 3.2, 'This is a good hospital',20);
INSERT INTO `review`(`user_id`,`service_provider_id`,`rating`, `content`,`number_of_likes`) VALUES (1, 2, 4.2, 'This is a good hospital',30);


-- ----------------------------
-- Table structure for service
-- ----------------------------
DROP TABLE IF EXISTS `service`;
CREATE TABLE `service` (
  `sid` INT(10) NOT NULL AUTO_INCREMENT,
  `service_provider_id` INT(10) NOT NULL,
	`service_name` VARCHAR(50) DEFAULT NULL,
  `price` DOUBLE(8,2) DEFAULT NULL,
	`status` INT(2) NOT NULL COMMENT '1 可预定 0 已预订',
	`service_date` date DEFAULT NULL,
	`service_time` VARCHAR(50) DEFAULT NULL, 
  PRIMARY KEY (`sid`),
	FOREIGN KEY(`service_provider_id`) REFERENCES service_provider(`spid`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of service
-- ----------------------------
INSERT INTO `service`(`service_provider_id`,`service_name`,`price`, `status`,`service_date`,`service_time`) VALUES (1, 'pet medical check-ups', 200,1,'2021-09-14','9am - 11am');
INSERT INTO `service`(`service_provider_id`,`service_name`,`price`, `status`,`service_date`,`service_time`) VALUES (1, 'pet vaccination', 100,0,'2021-09-16','1pm - 3pm');


-- ----------------------------
-- Table structure for user order
-- ----------------------------
DROP TABLE IF EXISTS `user_order`;
CREATE TABLE `user_order` (
  `oid` INT(10) NOT NULL AUTO_INCREMENT,
  `service_id` INT(10) NOT NULL,
	`user_id` INT(10) NOT NULL,
  `amount` DOUBLE(8,2) DEFAULT NULL,
	`status` INT(2) NOT NULL COMMENT '1 未开始 2 已完成 3  已取消',
	`service_start_time` VARCHAR(50) DEFAULT NULL,
	`create_time` TIMESTAMP DEFAULT NOW(), 
  PRIMARY KEY (`oid`),
	FOREIGN KEY(`service_id`) REFERENCES service(`sid`),
	FOREIGN KEY(`user_id`) REFERENCES user(`uid`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user order
-- ----------------------------
INSERT INTO `user_order`(`service_id`,`user_id`, `amount`,`status`,`service_start_time`) VALUES (1, 1,200,2,'14 September 2021 9am');
INSERT INTO `user_order`(`service_id`,`user_id`, `amount`,`status`,`service_start_time`) VALUES (2, 1,100,1,'16 September 2021 1pm');




