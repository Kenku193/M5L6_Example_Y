CREATE SCHEMA M5L6;

CREATE TABLE IF NOT EXISTS humans (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    age INT,
    balance DECIMAL(15,2)
);

CREATE TABLE cars (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    model VARCHAR(50),
    cost DECIMAL(15,2),
    human_id BIGINT NOT NULL,
    CONSTRAINT FK_HumanCar FOREIGN KEY (human_id) REFERENCES humans(id)
);

CREATE TABLE IF NOT EXISTS deal_history (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    date DATE,
    status VARCHAR(50),
    seller_id BIGINT,
    buyer_id BIGINT,
    car_id BIGINT
);

INSERT INTO humans(name, age, balance) VALUE ('Dima', 25, 10000.00);
INSERT INTO humans(name, age, balance) VALUE ('Anya', 30, 200000.90);

INSERT INTO cars(model, cost, human_id)
VALUES
    ('Audi', 50000, 1),
    ('BMW', 100000, 2),
    ('Ferrari', 3500000, 1);