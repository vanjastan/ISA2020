INSERT INTO `authorities` (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO `authorities` (id, name) VALUES (2, 'ROLE_PATIENT');
INSERT INTO `authorities` (id, name) VALUES (3, 'ROLE_PHARMACIST');
INSERT INTO `authorities` (id, name) VALUES (4, 'ROLE_DERMATOLOGIST');
INSERT INTO `authorities` (id, name) VALUES (5, 'ROLE_SUPPLIER');
INSERT INTO `authorities` (id, name) VALUES (6, 'ROLE_ADMINPH');

INSERT INTO `users` (user_type, id, name, surname, username, address, city, country, number, email, password, role_type, last_password_reset_date, enabled, is_admin) VALUES (0, 1, 'Vanja', 'Stan', 'admin1', 'Olge Petrov 25', 'Novi Sad','Srbija' ,'890102', 'admin@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'ROLE_ADMIN', '2017-10-01 21:58:58', true, true);
INSERT INTO `users` (user_type, id, name, surname, username, address, city, country, number, email, password, role_type, last_password_reset_date, enabled, is_admin) VALUES (0, 2, 'Pera', 'Peric', 'supplier1', 'Olge 25', 'Novi Sad','Srbija' ,'890106782', 'supplier@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'ROLE_SUPPLIER', '2017-10-01 21:58:58', true, false);
INSERT INTO users (user_type, id, name, surname, username, address, city, country, number, email, password, role_type, last_password_reset_date, enabled, is_admin) VALUES (0, 3, 'Maja', 'Peric', 'patient1', 'Olge 25', 'Novi Sad','Srbija' ,'8901067889782', 'patient@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'ROLE_PATIENT', '2017-10-01 21:58:58', true, false);

INSERT INTO `user_authority` (user_id, authority_id) VALUES (1, 1);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (2, 5);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (3, 2);

INSERT INTO `hospitals` (id, name, api) VALUES (1, 'Bolnica1', '12345');

INSERT INTO `medicament` (id, name, quantity) VALUES (1, 'Aspirin', 40);

INSERT INTO `medicaments` (id, name, code, type, contradictions, ingredients, dailydose, replacement, shape, manufacturer, issuing, notes) VALUES (1, 'Aspirin', 'Asp1', 'Antipireptik', 'Umor i malaksalost', 'Salicilat', '2 puta dnevno', 'Brufen', 'Tableta', 'Bayer', 'Bez recepta', '/');

INSERT INTO `pharmacies` (id, name, address, city, rate) VALUES (1, 'Benu', 'Jovana Cvijica 10', 'Beograd', 'Very well');
INSERT INTO `pharmacies` (id, name, address, city, rate) VALUES (2, 'Jankovic', 'Preradoviceva 21a', 'Petrovaradin', 'Excellent');
INSERT INTO `pharmacies` (id, name, address, city, rate) VALUES (3, 'Benu', 'Savanova 10', 'Beograd', 'Excellent');

INSERT INTO `examinations` (exam_id, price, duration, dateE) VALUES (1, 2000, '1h', '11.11.2020.');
INSERT INTO `examinations` (exam_id, price, duration, dateE) VALUES (2, 5000, '2h', '01.01.2021.');

INSERT INTO `examinations_p` (id, price, duration, date_examination) VALUES (1, 2500, '1h', '08.12.2020.');
INSERT INTO `examinations_p` (id, price, duration, date_examination) VALUES (2, 3000, '1h', '05.01.2021.');
