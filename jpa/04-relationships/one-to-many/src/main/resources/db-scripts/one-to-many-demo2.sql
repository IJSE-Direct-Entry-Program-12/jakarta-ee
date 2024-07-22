CREATE TABLE lawyer(
    reg_number VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE law_suite(
    id VARCHAR(20) PRIMARY KEY,
    type VARCHAR(50) NOT NULL,
    description VARCHAR(500) NOT NULL,
    filed_date DATE NOT NULL,
    lawyer_reg_number VARCHAR(20),
    lawyer_retainer_date DATE,
    lawyer_fee DECIMAL(9,2),
    CONSTRAINT fk_lawyer FOREIGN KEY (lawyer_reg_number) REFERENCES lawyer (reg_number)
);