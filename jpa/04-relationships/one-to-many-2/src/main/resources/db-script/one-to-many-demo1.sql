CREATE TABLE lawyer(
    reg_number VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE law_suite(
    id VARCHAR(20) PRIMARY KEY,
    type VARCHAR(50) NOT NULL,
    description VARCHAR(500) NOT NULL,
    filed_date DATE NOT NULL
);

CREATE TABLE lawyer_law_suite
(
    lawyer_reg_number VARCHAR(20) NOT NULL,
    law_suite_id      VARCHAR(20) PRIMARY KEY,
    CONSTRAINT fk_lawyer FOREIGN KEY (lawyer_reg_number) REFERENCES lawyer (reg_number),
    CONSTRAINT fk_law_suite FOREIGN KEY (law_suite_id) REFERENCES law_suite(id)
);
