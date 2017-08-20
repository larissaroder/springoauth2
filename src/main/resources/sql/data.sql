INSERT INTO user_account (id, name, login, password) VALUES (1, 'admin', 'admin', '123456');

INSERT INTO authority (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO authority (id, name) VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_authority (id_user_account,authority) VALUES (1, 2);