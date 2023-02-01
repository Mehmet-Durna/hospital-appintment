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

insert into PATIENT (ID, PATIENT_NAME, GENDER, COMPLAINTS, PHONE_NO)
values (1, 'Gabriel Riquelme', 'M','Patient has a headache',
        '0488001265');

insert into PATIENT (ID, PATIENT_NAME, GENDER, COMPLAINTS, PHONE_NO)
values (2, 'Pedro Ancelotti', 'M','Patient has a headache',
        '04880012616');

insert into PATIENT (ID, PATIENT_NAME, GENDER, COMPLAINTS, PHONE_NO)
values (3, 'Iker Casillas', 'M','Patient has a headache',
        '04885151265');

insert into PATIENT (ID, PATIENT_NAME, GENDER, COMPLAINTS, PHONE_NO)
values (4, 'Cristiano Ronaldo', 'M','Patient has a headache',
        '04880511265');

insert into PATIENT (ID, PATIENT_NAME, GENDER, COMPLAINTS, PHONE_NO)
values (5, 'Monica Pelluci', 'F','Patient has a headache',
        '0488511265');


insert into APPOINTMENT (ID, INFO, DATE, TIME, DOCTOR_ID, PATIENT_ID)
values (1, 'Patient has a headache', '2023-02-28',
        '10:00',1, 1);

insert into APPOINTMENT (ID, INFO, DATE, TIME, DOCTOR_ID, PATIENT_ID)
values (2, 'Patient has a headache', '2023-02-28',
        '10:00',1, 2);

insert into APPOINTMENT (ID, INFO, DATE, TIME, DOCTOR_ID, PATIENT_ID)
values (3, 'Patient has a headache', '2023-02-28',
        '10:00',2, 3);

insert into APPOINTMENT (ID, INFO, DATE, TIME, DOCTOR_ID, PATIENT_ID)
values (4, 'Patient has a headache', '2023-02-28',
        '10:00',3, 4);

insert into APPOINTMENT (ID, INFO, DATE, TIME, DOCTOR_ID, PATIENT_ID)
values (5, 'Patient has a headache', '2023-02-28',
        '11:00',3, 5);