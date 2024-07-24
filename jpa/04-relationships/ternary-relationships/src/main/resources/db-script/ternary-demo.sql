CREATE TABLE customer(
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    contact VARCHAR(15) NOT NULL UNIQUE
);

CREATE TABLE product(
    code VARCHAR(10) PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE supplier(
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE purchase
(
    customer_id  VARCHAR(10) NOT NULL,
    product_code VARCHAR(10) NOT NULL,
    supplier_id  VARCHAR(10) NOT NULL,
    CONSTRAINT pk_purchase PRIMARY KEY (customer_id, product_code, supplier_id),
    CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES customer (id),
    CONSTRAINT fk_product FOREIGN KEY (product_code) REFERENCES product (code),
    CONSTRAINT fk_supplier FOREIGN KEY (supplier_id) REFERENCES supplier (id),
    discount INT NOT NULL,
    price DECIMAL(9, 2) NOT NULL
);
