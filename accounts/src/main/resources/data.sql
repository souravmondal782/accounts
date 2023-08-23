DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
  customer_id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  mobile_number VARCHAR(13) NOT NULL,
  email_id VARCHAR(100) NOT NULL,
  created_date DATE DEFAULT NULL
);

CREATE TABLE ACCOUNTS (
  
  customer_id INT NOT NULL,
  account_number INT AUTO_INCREMENT PRIMARY KEY,
  account_type VARCHAR(50) NOT NULL,
  branch VARCHAR(50) NOT NULL,
  expiry_date DATE DEFAULT (CURRENT_DATE + INTERVAL '1' DAY)
);

INSERT INTO customer (name, mobile_number, email_id, created_date)
VALUES ('robin', '0987654321', 'robin@test.com', CURRENT_DATE );


INSERT INTO ACCOUNTS (customer_id, account_number, account_type, branch, expiry_date)
VALUES ( '1', '1234567890', 'CURRENT', 'delhi', CURRENT_DATE);


INSERT INTO ACCOUNTS (customer_id, account_number, account_type, branch, expiry_date)
VALUES ( '2', '0987654321', 'SAVINGS', 'mumbai', CURRENT_DATE);

 
