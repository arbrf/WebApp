-- Inserting a user with ID 1, name "John Doe", and birth date "1990-01-01"
INSERT INTO user_details (id, name, birth_date) VALUES (1, 'John Doe', '1990-01-01');

-- Inserting another user with ID 2, name "Jane Smith", and birth date "1985-05-15"
INSERT INTO user_details (id, name, birth_date) VALUES (2, 'Jane Smith', '1985-05-15');

-- Inserting one more user without specifying ID (assuming auto-increment in the database)
INSERT INTO user_details (id,name, birth_date) VALUES (3,'Alice Johnson', '1988-07-20');
