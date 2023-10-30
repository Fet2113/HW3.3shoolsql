-- liquibase formatted sql

-- changeset afetisov:1
create index student_name_idx on student (name);

create index faculty_name_color_idx on faculty (name, color);