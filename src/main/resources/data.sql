insert into HOSPITAL (ID, HOSPITAL_NAME, ADDRESS, TEL_NO, CAPACITY, FREE_PARKING_AVAILABLE,
                      CITY, DISTANCE_FROM_PUBLIC_TRANSPORT_IN_KM)
values (1, 'Middleheim', 'Lindendreef 1, 2020', '032803111', 750, true, 'Antwerpen', 0.2);



insert into HOSPITAL (ID, HOSPITAL_NAME, ADDRESS, TEL_NO, CAPACITY, FREE_PARKING_AVAILABLE,
                      CITY, DISTANCE_FROM_PUBLIC_TRANSPORT_IN_KM)
values (2, 'Oud Militair Hospitaal Antwerpen', 'Artsen zonder Grenzenstraat 2, 2018', '', 100, false, 'Antwerpen', 0.5);



insert into HOSPITAL (ID, HOSPITAL_NAME, ADDRESS, TEL_NO, CAPACITY, FREE_PARKING_AVAILABLE,
                      CITY, DISTANCE_FROM_PUBLIC_TRANSPORT_IN_KM)
values (3, 'Fertiliteit SA', 'Oosterveldlaan 24, 2610', '034433549', 500, true, 'Antwerpen', 0.3);



insert into DEPARTMENT (ID, DEPARTMENT_NAME, INLINE_PHONE_NO, HOSPITAL_ID)
values (1, 'General internal medicine and infectious disease', '401', 1);

insert into DEPARTMENT (ID, DEPARTMENT_NAME, INLINE_PHONE_NO, HOSPITAL_ID)
values (2, 'Laboratory of Pathological Anatomy PA2', '402', 2);

insert into DEPARTMENT (ID, DEPARTMENT_NAME, INLINE_PHONE_NO, HOSPITAL_ID)
values (3, 'Cardiologie', '403', 3);

insert into DOCTOR (ID, DOCTOR_NAME, SPECIALIZATION, BIO, INLINE_PHONE_NO, DEPARTMENT_ID)
values (1, 'Nicolaas Aerts', 'Overarching Head of Service
General rheumatology',
        'Doctor of Medicine (abbreviated M.D., from the Latin Medicinae Doctor) is a medical degree, the meaning of which varies between different jurisdictions. In the United States, and some other countries, the M.D. denotes a professional degree. This generally arose because many in 18th-century medical professions trained in Scotland, which used the M.D. degree nomenclature. In England, however, Bachelor of Medicine, Bachelor of Surgery was used and eventually in the 19th century became the standard in Scotland too.',
        '501', 1);

insert into DOCTOR (ID, DOCTOR_NAME, SPECIALIZATION, BIO, INLINE_PHONE_NO, DEPARTMENT_ID)
values (2, 'Sophie Bare', 'Algemene pediatrie
Neonatologie',
        'Doctor of Medicine (abbreviated M.D., from the Latin Medicinae Doctor) is a medical degree, the meaning of which varies between different jurisdictions. In the United States, and some other countries, the M.D. denotes a professional degree. This generally arose because many in 18th-century medical professions trained in Scotland, which used the M.D. degree nomenclature. In England, however, Bachelor of Medicine, Bachelor of Surgery was used and eventually in the 19th century became the standard in Scotland too.',
        '502', 3);

insert into DOCTOR (ID, DOCTOR_NAME, SPECIALIZATION, BIO, INLINE_PHONE_NO, DEPARTMENT_ID)
values (3, 'Mary-Louise Bonduelle', '
Gynecology and Obstetrics
Medical genetics
Medical oncology',
        'Doctor of Medicine (abbreviated M.D., from the Latin Medicinae Doctor) is a medical degree, the meaning of which varies between different jurisdictions. In the United States, and some other countries, the M.D. denotes a professional degree. This generally arose because many in 18th-century medical professions trained in Scotland, which used the M.D. degree nomenclature. In England, however, Bachelor of Medicine, Bachelor of Surgery was used and eventually in the 19th century became the standard in Scotland too.',
        '503', 2);

insert into DOCTOR (ID, DOCTOR_NAME, SPECIALIZATION, BIO, INLINE_PHONE_NO, DEPARTMENT_ID)
values (4, 'Jens De Cock', 'General radiology',
        'Doctor of Medicine (abbreviated M.D., from the Latin Medicinae Doctor) is a medical degree, the meaning of which varies between different jurisdictions. In the United States, and some other countries, the M.D. denotes a professional degree. This generally arose because many in 18th-century medical professions trained in Scotland, which used the M.D. degree nomenclature. In England, however, Bachelor of Medicine, Bachelor of Surgery was used and eventually in the 19th century became the standard in Scotland too.',
        '504', 3);


INSERT INTO USER
(ID, username, password, role)
VALUES
    (nextval('USER_SEQ'), 'admin', '$2a$10$183YgFb7h2Meicizr0S6bO.v5wUky9lELv5b8UdCBdY7FueSDGTKm', 'ROLE_ADMIN');
INSERT INTO USER
(ID, username, password, role)
VALUES
    (nextval('USER_SEQ'), 'sroscop', 'Yunus033.', 'ROLE_USER');

INSERT INTO USER
(ID, username, password, role)
VALUES
    (nextval('USER_SEQ'), 'gabriel', '$2a$10$qkYEzClRvGL03mzmKI1Tw.WGRKzm19S5aqQUeFb7x5/pGw/bhq96K', 'ROLE_USER');

insert into PATIENT (ID, PATIENT_NAME, GENDER, PHONE_NO,user_id)
values (nextval('patient_seq'), 'Gabriel Riquelme', 'M',
        '0488001265',3);

INSERT INTO USER
(ID, username, password, role)
VALUES
    (nextval('USER_SEQ'), 'pedro', '$2a$10$qkYEzClRvGL03mzmKI1Tw.WGRKzm19S5aqQUeFb7x5/pGw/bhq96K', 'ROLE_USER');

insert into PATIENT (ID, PATIENT_NAME, GENDER, PHONE_NO,user_id)
values (nextval('patient_seq'), 'Pedro Ancelotti', 'M',
        '04880012616',4);

INSERT INTO USER
(ID, username, password, role)
VALUES
    (nextval('USER_SEQ'), 'casillas', '$2a$10$qkYEzClRvGL03mzmKI1Tw.WGRKzm19S5aqQUeFb7x5/pGw/bhq96K', 'ROLE_USER');

insert into PATIENT (ID, PATIENT_NAME, GENDER, PHONE_NO,USER_ID)
values (nextval('patient_seq'), 'Iker Casillas', 'M',
        '04885151265',5);

INSERT INTO USER
(ID, username, password, role)
VALUES
    (nextval('USER_SEQ'), 'ronaldo', '$2a$10$qkYEzClRvGL03mzmKI1Tw.WGRKzm19S5aqQUeFb7x5/pGw/bhq96K', 'ROLE_USER');

insert into PATIENT (ID, PATIENT_NAME, GENDER,  PHONE_NO,USER_ID)
values (nextval('patient_seq'), 'Cristiano Ronaldo', 'M',
        '04880511265',6);
INSERT INTO USER
(ID, username, password, role)
VALUES
    (nextval('USER_SEQ'), 'monica', '$2a$10$qkYEzClRvGL03mzmKI1Tw.WGRKzm19S5aqQUeFb7x5/pGw/bhq96K', 'ROLE_USER');

insert into PATIENT (ID, PATIENT_NAME, GENDER,  PHONE_NO,USER_ID)
values (nextval('patient_seq'), 'Monica Pelluci', 'F',
        '0488511265',7);


insert into APPOINTMENT (ID, INFO, DATE, TIME, DOCTOR_ID, PATIENT_ID)
values (nextval('APPOINTMENT_SEC'), 'Patient has a headache', '2023-02-28',
        '10:00',1, 1);

insert into APPOINTMENT (ID, INFO, DATE, TIME, DOCTOR_ID, PATIENT_ID)
values (nextval('APPOINTMENT_SEC'), 'Patient has a headache', '2023-02-28',
        '11:00',1, 2);

insert into APPOINTMENT (ID, INFO, DATE, TIME, DOCTOR_ID, PATIENT_ID)
values (nextval('APPOINTMENT_SEC'), 'Patient has a headache', '2023-02-28',
        '10:00',2, 3);

insert into APPOINTMENT (ID, INFO, DATE, TIME, DOCTOR_ID, PATIENT_ID)
values (nextval('APPOINTMENT_SEC'), 'Patient has a headache', '2023-02-28',
        '10:00',3, 4);

insert into APPOINTMENT (ID, INFO, DATE, TIME, DOCTOR_ID, PATIENT_ID)
values (nextval('APPOINTMENT_SEC'), 'Patient has a headache', '2023-02-28',
        '11:00',3, 5);

insert into APPOINTMENT (ID, INFO, DATE, TIME, DOCTOR_ID, PATIENT_ID)
values (nextval('APPOINTMENT_SEC'), 'Patient has a headache', '2023-02-07',
        '11:00',1, 5);