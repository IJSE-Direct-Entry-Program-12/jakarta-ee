CREATE TABLE customer(
    contact VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address  VARCHAR(500) NOT NULL
);

-- 1000000
CREATE TABLE "order"(
    id VARCHAR(10) PRIMARY KEY,
    date DATE NOT NULL,
    total DECIMAL(9, 2),
    customer_contact VARCHAR(20) NOT NULL,
    CONSTRAINT fk_customer FOREIGN KEY (customer_contact) REFERENCES
        customer (contact)
);

ALTER TABLE "order" ALTER COLUMN total SET NOT NULL;