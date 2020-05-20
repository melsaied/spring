CREATE TABLE spring.user (
  `id` bigint(20) NOT NULL,
  `account_non_expired` bit(1) NOT NULL,
  `account_non_locked` bit(1) NOT NULL,
  `credentials_non_expired` bit(1) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE spring.authority (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)

CREATE TABLE spring.user_authority (
  `user_id` bigint(20) NOT NULL,
  `authority_id` bigint(20) NOT NULL,
  UNIQUE KEY (`user_id`, `authority_id`),
  KEY (`authority_id`),
  CONSTRAINT FOREIGN KEY (`authority_id`) REFERENCES `authority` (`id`),
  CONSTRAINT FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
);
