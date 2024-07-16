CREATE TYPE GENDER AS ENUM ('MALE', 'FEMALE');

CREATE TABLE "user"
(
    nic         VARCHAR(12) PRIMARY KEY,
    name        VARCHAR(200) NOT NULL,
    address     VARCHAR(500) NOT NULL,
    dob         DATE         NOT NULL,
    gender      GENDER       NOT NULL,
    partner_nic VARCHAR(12) UNIQUE,
    date        DATE,
    CONSTRAINT fk_user FOREIGN KEY (partner_nic) REFERENCES "user" (nic)
);