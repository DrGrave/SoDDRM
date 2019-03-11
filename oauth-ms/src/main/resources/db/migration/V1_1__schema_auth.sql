CREATE TABLE users(
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(50) UNIQUE,
  password VARCHAR(255)
);

CREATE TABLE roles
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    authority VARCHAR(256) NOT NULL
);
CREATE UNIQUE INDEX roles_authority_uindex ON roles (authority);


CREATE TABLE users_to_roles
(
    id_user BIGINT,
    id_role BIGINT,
    CONSTRAINT users_to_roles_id_user_id_role_pk PRIMARY KEY (id_user, id_role),
    CONSTRAINT users_to_roles_users_id_fk FOREIGN KEY (id_user) REFERENCES users (id),
    CONSTRAINT users_to_roles_roles_id_fk FOREIGN KEY (id_role) REFERENCES roles (id)
);