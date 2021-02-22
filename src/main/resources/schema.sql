--DROP TABLE IF EXISTS employee;

CREATE TABLE IF NOT EXISTS employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    surname VARCHAR(250) NOT NULL,
    birthdate DATE NULL,
    description varchar(1000) NULL,
    salary DECIMAL(5,2) NOT NULL
);