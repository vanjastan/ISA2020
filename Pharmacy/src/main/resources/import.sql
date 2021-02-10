INSERT INTO `authorities` (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO `authorities` (id, name) VALUES (2, 'ROLE_PATIENT');
INSERT INTO `authorities` (id, name) VALUES (3, 'ROLE_PHARMACIST');
INSERT INTO `authorities` (id, name) VALUES (4, 'ROLE_DERMATOLOGIST');
INSERT INTO `authorities` (id, name) VALUES (5, 'ROLE_SUPPLIER');
INSERT INTO `authorities` (id, name) VALUES (6, 'ROLE_ADMINPH');

INSERT INTO `users` (user_type, id, name, surname, username, address, city, country, number, email, password, role_type, last_password_reset_date, enabled, is_admin) VALUES (0, 1, 'Vanja', 'Stan', 'admin1', 'Olge Petrov 25', 'Novi Sad','Srbija' ,'890102', 'admin@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'ROLE_ADMIN', '2017-10-01 21:58:58', true, true);
INSERT INTO `users` (user_type, id, name, surname, username, address, city, country, number, email, password, role_type, last_password_reset_date, enabled, is_admin) VALUES (0, 2, 'Pera', 'Peric', 'supplier1', 'Olge 25', 'Novi Sad','Srbija' ,'890106782', 'supplier@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'ROLE_SUPPLIER', '2017-10-01 21:58:58', true, false);
INSERT INTO users (user_type, id, name, surname, username, address, city, country, number, email, password, role_type, last_password_reset_date, enabled, is_admin) VALUES (0, 3, 'Maja', 'Peric', 'patient1', 'Olge 25', 'Novi Sad','Srbija' ,'8901067889782', 'patient@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'ROLE_PATIENT', '2017-10-01 21:58:58', true, false);
INSERT INTO `users` (user_type, id, name, surname, username, address, city, country, number, email, password, role_type, last_password_reset_date, enabled, is_admin) VALUES (0, 4, 'Perica', 'Peric', 'adminph1', 'Olge 25', 'Novi Sad','Srbija' ,'890106562', 'adminph@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'ROLE_ADMINPH', '2017-10-01 21:58:58', true, false);
INSERT INTO `users` (user_type, id, name, surname, username, address, city, country, number, email, password, role_type, last_password_reset_date, enabled, is_admin) VALUES (0, 5, 'Petar', 'Perisic', 'adminph2', 'Kisacka 5', 'Novi Sad','Srbija' ,'895556562', 'adminph2@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'ROLE_ADMINPH', '2017-10-01 21:58:58', true, false);
INSERT INTO `users` (user_type, id, name, surname, username, address, city, country, number, email, password, role_type, last_password_reset_date, enabled, is_admin) VALUES (0, 6, 'Petra', 'Sojic', 'adminph3', 'Kisacka 15', 'Novi Sad','Srbija' ,'844456562', 'adminph3@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'ROLE_ADMINPH', '2017-10-01 21:58:58', true, false);
INSERT INTO users (user_type, id, name, surname, username, address, city, country, number, email, password, role_type, last_password_reset_date, enabled, is_admin) VALUES (0, 7, 'Jelena', 'Stojanovic', 'jeca', 'Jovana Cvijica 3', 'Novi Sad','Srbija' ,'065448224', 'jeca@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'ROLE_PATIENT', '2020-10-10 10:00:58', true, false);
INSERT INTO `users` (user_type, id, name, surname, username, address, city, country, number, email, password, role_type, last_password_reset_date, enabled, is_admin) VALUES (0, 8, 'Milivoje', 'Kojic', 'dermatologist', 'Kisacka 25', 'Novi Sad','Srbija' ,'021556644', 'dacaa9977@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'ROLE_DERMATOLOGIST', '2017-10-01 21:58:58', true, false);
INSERT INTO `users` (user_type, id, name, surname, username, address, city, country, number, email, password, role_type, last_password_reset_date, enabled, is_admin) VALUES (0, 9, 'Milunka', 'Bojic', 'dermatologist2', 'Cara Dusana 5', 'Novi Sad','Srbija' ,'021669977', 'pharmacysistem@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'ROLE_DERMATOLOGIST', '2017-10-01 21:58:58', true, false);
INSERT INTO `users` (user_type, id, name, surname, username, address, city, country, number, email, password, role_type, last_password_reset_date, enabled, is_admin) VALUES (0, 10, 'Spomenka', 'Predojevic', 'pharmacist', 'Temerinska 5', 'Novi Sad','Srbija' ,'021599874', 'spomenka@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'ROLE_PHARMACIST', '2017-10-01 21:58:58', true, false);
INSERT INTO `users` (user_type, id, name, surname, username, address, city, country, number, email, password, role_type, last_password_reset_date, enabled, is_admin) VALUES (0, 11, 'Jelisaveta', 'Milusnic', 'pharmacist2', 'Cara Dusana 25', 'Novi Sad','Srbija' ,'021663314', 'jelisaveta@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'ROLE_PHARMACIST', '2017-10-01 21:58:58', true, false);

INSERT INTO `user_authority` (user_id, authority_id) VALUES (1, 1);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (2, 5);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (3, 2);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (4, 6);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (5, 6);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (6, 6);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (7, 2);

INSERT INTO `hospitals` (id, name, api) VALUES (1, 'Bolnica1', '12345');

INSERT INTO `medicament` (id, name, quantity) VALUES (1, 'Aspirin', 40);

INSERT INTO `medicaments` (id, name, code, type, contradictions, ingredients, dailydose, replacement, shape, manufacturer, issuing, notes, reserved, patient_id, allergic_reaction, grade, p_id) VALUES (1, 'Aspirin', 'Asp1', 'Antipireptik', 'Umor i malaksalost', 'Salicilat', '2 puta dnevno', 'Brufen', 'Tableta', 'Bayer', 'Bez recepta', 'Herbal medicament', false, 3, true,5, null);
INSERT INTO `medicaments` (id, name, code, type, contradictions, ingredients, dailydose, replacement, shape, manufacturer, issuing, notes, reserved, patient_id, allergic_reaction, grade, p_id) VALUES (2, 'Defrinol', 'Def', 'Antipireptik', 'Prehlada i malaksalost', 'Salicilat', '3 puta dnevno', 'Panadol', 'Tableta', 'Bayer', 'Bez recepta', 'Herbal medicament', true, 5, false, 3, null);
INSERT INTO `medicaments` (id, name, code, type, contradictions, ingredients, dailydose, replacement, shape, manufacturer, issuing, notes, reserved, patient_id, allergic_reaction, grade, p_id) VALUES (3, 'Brufen', 'Brufen', 'Antipireptik', 'Umor i malaksalost', 'Salicilat', '2 puta dnevno', 'Paracetamol', 'Tableta', 'Bayer', 'Bez recepta', 'Herbal medicament', true, 3, false, 4, null);
INSERT INTO `medicaments` (id, name, code, type, contradictions, ingredients, dailydose, replacement, shape, manufacturer, issuing, notes, reserved, patient_id, allergic_reaction, grade, p_id) VALUES (4, 'Brufen', 'Brufen', 'Antipireptik', 'Umor i malaksalost', 'Salicilat', '2 puta dnevno', 'Paracetamol', 'Tableta', 'Bayer', 'Bez recepta', 'Herbal medicament', true, 3, false, 5, null);

INSERT INTO `pharmacies` (id, name, address, city, rate, description, admin_id) VALUES (1,  'Benu', 'Jovana Cvijica 10', 'Beograd', 'Very well', 'Herbal medicaments', 4);
INSERT INTO `pharmacies` (id, name, address, city, rate, description, admin_id) VALUES (2,  'Benu', 'Savanova 10', 'Beograd', 'Excellent', 'Medicaments on prescriptions', 5);

INSERT INTO `examinations` (exam_id, price, duration, date_examination, rate, time_exam, patient_id) VALUES (1, 2000, '1h', '11.11.2020.', 'Excellent', '11:03', 3);
INSERT INTO `examinations` (exam_id, price, duration, date_examination, rate, time_exam, patient_id) VALUES (2, 5000, '2h', '11.02.2021.', 'Not bad', '12:00', 5);
INSERT INTO `examinations` (exam_id, price, duration, date_examination, rate, time_exam, patient_id) VALUES (3, 4000, '1h', '10.01.2021.', 'Very good', '15:00', null);
INSERT INTO `examinations` (exam_id, price, duration, date_examination, rate, time_exam, patient_id) VALUES (4, 2000, '1h', '15.03.2021.', 'Excellent', '15:30', null);

INSERT INTO `examinations_p` (id, price, duration, date_examination, patient_id) VALUES (1, 2500, '1h', '08.12.2020.', 3);
INSERT INTO `examinations_p` (id, price, duration, date_examination, patient_id) VALUES (2, 3000, '1h', '05.01.2021.', 5);
INSERT INTO `examinations_p` (id, price, duration, date_examination, patient_id) VALUES (3, 2000, '1h', '12.02.2021.', null);

INSERT INTO `orderform` (id, medicament_name, quantity, end_date) VALUES (1, 'Aspirin', 40, '12-03-2021.');

INSERT INTO `customer_order` (id, name, quantity) VALUES (2, 'Aspirin', 40);

INSERT INTO `prescription` (prescription_id, date_of_pub, status, patient_id) VALUES (1, '05.01.2021.', 'NEW', 3);
INSERT INTO `prescription` (prescription_id, date_of_pub, status, patient_id) VALUES (2, '12.12.2020.', 'REJECTED', 5);
INSERT INTO `prescription` (prescription_id, date_of_pub, status, patient_id) VALUES (3, '10.11.2020.', 'PROCESSED', 5);

INSERT INTO `actions_and_promotions` (name, end_date) VALUES ( "Brufen na akciji 20%", '05.04.2021.');
INSERT INTO `actions_and_promotions` (name, end_date) VALUES ( "Akcija na sve 5%", '15.04.2021.');

INSERT INTO `complaints` (complaint_id, date_of_complaint, content, patient_id) VALUES (1, '12-01-2021.', 'Doctor Milan was very impolite.', 3);
INSERT INTO `complaints` (complaint_id, date_of_complaint, content, patient_id) VALUES (2, '03-11-2020.', 'Doctor Jovana was not paying attention to me at all.', 5);

INSERT INTO `complaintss` (id, text, user_id, answered) VALUES (1, 'Dermatologist was wery impolite', 8, false);

INSERT INTO `pricelist` (price, from_date, to_date, medicament_id, pharmacy_id) VALUES ( 120, '15.09.2020.', '28.11.2021.', 1, 1);
INSERT INTO `pricelist` (price, from_date, to_date, medicament_id, pharmacy_id) VALUES ( 130, '19.10.2020.', '19.10.2021.', 2, 1);
INSERT INTO `pricelist` (price, from_date, to_date, medicament_id, pharmacy_id) VALUES ( 180, '12.10.2020.', '09.10.2021.', 2, 2);


INSERT INTO `subscribed` (email, patient_id) VALUES ('dacaa9977@gmail.com', 3);

INSERT INTO `pharmacy_dermatologist` (dermatologist_id, pharmacy_id) VALUES (8, 1);
INSERT INTO `pharmacy_dermatologist` (dermatologist_id, pharmacy_id) VALUES (8, 2);
INSERT INTO `pharmacy_dermatologist` (dermatologist_id, pharmacy_id) VALUES (9, 1);

INSERT INTO `pharmacy_pharmacists` (pharmacist_id, pharmacy_id) VALUES (10, 1);
INSERT INTO `pharmacy_pharmacists` (pharmacist_id, pharmacy_id) VALUES (10, 2);
INSERT INTO `pharmacy_pharmacists` (pharmacist_id, pharmacy_id) VALUES (11, 2);

INSERT INTO `pharmacy_meds` (medicament_id, pharmacy_id) VALUES (1, 1);
INSERT INTO `pharmacy_meds` (medicament_id, pharmacy_id) VALUES (1, 2);
INSERT INTO `pharmacy_meds` (medicament_id, pharmacy_id) VALUES (2, 1);
INSERT INTO `pharmacy_meds` (medicament_id, pharmacy_id) VALUES (2, 2);

INSERT INTO `vacation_request` ( confirmed, from_date, to_date, user_id) VALUES ( false, '12.07.2021', '31.07.2021', 8);
INSERT INTO `vacation_request` ( confirmed, from_date, to_date, user_id) VALUES ( false, '12.05.2021', '01.07.2021', 9);
INSERT INTO `vacation_request` ( confirmed, from_date, to_date, user_id) VALUES ( false, '10.08.2021', '01.09.2021', 10);
