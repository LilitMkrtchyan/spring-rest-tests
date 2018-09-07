--  Inserts dummy data into account
INSERT INTO account (id, type, number, is_active, created_at, balance) VALUES ('1', 'SAVING', '01000251215', true, now(), 4210.42);
INSERT INTO account (id, type, number, is_active, created_at, balance) VALUES ('2', 'CURRENT', '01000251216', false, now(), 25.12);

--  Inserts dummy data into transaction
INSERT INTO transaction (id, number, account_id, balance) VALUES ('1', '12151885120', '1', 42.12);
INSERT INTO transaction (id, number, account_id, balance) VALUES ('2', '12151885121', '1', 456.00);
INSERT INTO transaction (id, number, account_id, balance) VALUES ('3', '12151885122', '1', -12.12);