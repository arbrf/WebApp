-- Inserting a user with ID 1, name "John Doe", and birth date "1990-01-01"
INSERT INTO user_details (id, name, birth_date) VALUES (1001, 'John Doe', '1990-01-01');

-- Inserting another user with ID 2, name "Jane Smith", and birth date "1985-05-15"
INSERT INTO user_details (id, name, birth_date) VALUES (1002, 'Jane Smith', '1985-05-15');

-- Inserting one more user without specifying ID (assuming auto-increment in the database)
INSERT INTO user_details (id,name, birth_date) VALUES (1003,'Alice Johnson', '1988-07-20');


INSERT INTO Post (id, description, user_id) VALUES (2001, 'Iam on a Hikin', 1001);
INSERT INTO Post (id, description, user_id) VALUES (2002, 'I am on a Trekking', 1002);
INSERT INTO Post (id, description, user_id) VALUES (2003, 'Iam Camping in a Forest', 1001);
INSERT INTO Post (id, description, user_id) VALUES (2004, 'I am drinking coffee', 1003);
INSERT INTO Post (id, description, user_id) VALUES (2005, 'I reached top of mountain', 1002);
