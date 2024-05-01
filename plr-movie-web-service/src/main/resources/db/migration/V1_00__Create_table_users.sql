CREATE TABLE IF NOT EXISTS users
(
    id             BIGINT AUTO_INCREMENT,
    username       VARCHAR(50)  NOT NULL UNIQUE,
    password       VARCHAR(255) NOT NULL,
    full_name      VARCHAR(100),
    email          VARCHAR(100) UNIQUE,
    phone          VARCHAR(10) UNIQUE,
    remember_token VARCHAR(255),
    is_activated   BIT,
    is_deleted     BIT,
    CONSTRAINT users_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS roles
(
    id         BIGINT AUTO_INCREMENT,
    name       VARCHAR(20),
    is_deleted BIT,
    CONSTRAINT roles_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS user_roles
(
    user_id BIGINT,
    role_id BIGINT,
    CONSTRAINT user_role_id_pk PRIMARY KEY (user_id, role_id),
    CONSTRAINT user_id_fk FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT role_id_fk FOREIGN KEY (role_id) REFERENCES roles (id)
);