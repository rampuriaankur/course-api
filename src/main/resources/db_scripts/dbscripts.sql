use database course_db;

CREATE TABLE `author` (
  `author_id` varchar(45) NOT NULL,
  `author_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`author_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `category` (
  `category_id` varchar(45) NOT NULL,
  `category_name` varchar(45) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `course` (
  `course_id` varchar(45) NOT NULL,
  `title` varchar(50) NOT NULL,
  `slug` varchar(150) NOT NULL,
  `author_id` varchar(10) NOT NULL,
  `category_id` varchar(10) NOT NULL,
  PRIMARY KEY (`course_id`),
  KEY `aa_idx` (`author_id`),
  KEY `CategoryFK_idx` (`category_id`,`author_id`),
  CONSTRAINT `authorfk` FOREIGN KEY (`author_id`) REFERENCES `author` (`author_id`),
  CONSTRAINT `categoryfk` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



