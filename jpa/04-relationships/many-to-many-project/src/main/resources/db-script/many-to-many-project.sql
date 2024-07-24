CREATE DATABASE dep12_jpa_many2many;

USE dep12_jpa_many2many;

CREATE TABLE student(
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    address VARCHAR(500) NOT NULL,
    contact_number VARCHAR(13) NOT NULL,
    dob DATE NOT NULL,
    gender ENUM('MALE', 'FEMALE') NOT NULL
);

CREATE TABLE course(
    code VARCHAR(10) PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    duration VARCHAR(20) NOT NULL
);

CREATE TABLE enrollment(
    student_id VARCHAR(10) NOT NULL,
    course_code VARCHAR(10) NOT NULL,
    CONSTRAINT pk_enrollment PRIMARY KEY (student_id, course_code),
    CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES student (id),
    CONSTRAINT fk_course FOREIGN KEY (course_code) REFERENCES course (code),
    date DATE NOT NULL,
    registered_by VARCHAR(100) NOT NULL
);