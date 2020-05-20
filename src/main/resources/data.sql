INSERT INTO spring.user (`id`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`, `password`, `username`) VALUES (1, TRUE, TRUE, TRUE, TRUE, 'admin', 'admin');
INSERT INTO spring.user (`id`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`, `password`, `username`) VALUES (2, TRUE, TRUE, TRUE, TRUE, 'user', 'user');
INSERT INTO spring.authority (`id`, `authority`) VALUES (1, 'ROLE_ADMIN');
INSERT INTO spring.authority (`id`, `authority`) VALUES (2, 'ROLE_USER');
INSERT INTO spring.user_authority (`user_id`, `authority_id`) VALUES (1, 1);
INSERT INTO spring.user_authority (`user_id`, `authority_id`) VALUES (1, 2);
INSERT INTO spring.user_authority (`user_id`, `authority_id`) VALUES (2, 2);

