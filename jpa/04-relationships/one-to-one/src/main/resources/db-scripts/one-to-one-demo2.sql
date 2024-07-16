CREATE TABLE customer(
    nic VARCHAR(12) PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    address VARCHAR(500) NOT NULL,
    contact VARCHAR(100),
    dob DATE NOT NULL
);

CREATE TABLE account(
    number VARCHAR(20) PRIMARY KEY,
    type VARCHAR(20) NOT NULL,
    balance DECIMAL(11, 2) NOT NULL,
    customer_nic VARCHAR(12) UNIQUE NOT NULL,
    open_date DATE NOT NULL,
    username VARCHAR(50) NOT NULL,
    CONSTRAINT fk_customer FOREIGN KEY (customer_nic) REFERENCES customer
);