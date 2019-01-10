INSERT INTO arrow (arrow_x_coordinate,arrow_y_coordinate,arrow_number,arrow_type) VALUES (0,0,1,'одиночная,обыкновенная');
INSERT INTO arrow (arrow_x_coordinate,arrow_y_coordinate,arrow_number,arrow_type) VALUES (10,20,2,'двойная');
INSERT INTO arrow (arrow_x_coordinate,arrow_y_coordinate,arrow_number,arrow_type) VALUES (-6,8,3,'одиночная,симметричная');

INSERT INTO arrow_version (arrow_version_name, arrow_date, arrow_id) VALUES ('версия 1', '14.12.2018', 1);
INSERT INTO arrow_version (arrow_version_name, arrow_date, arrow_id) VALUES ('версия 2', '10.11.2018', 2);
INSERT INTO arrow_version (arrow_version_name, arrow_date, arrow_id) VALUES ('версия 3', '7.09.2018', 3);
INSERT INTO arrow_version (arrow_version_name, arrow_date, arrow_id) VALUES ('версия 4', '18.12.2018', 1);

INSERT INTO department (number) VALUES ('6412');
INSERT INTO department (number) VALUES ('6413');
INSERT INTO department (number) VALUES ('6414');

INSERT INTO student (first_name, last_name, age, department_id) VALUES ('Иванов', 'Иван', 18, 1);
INSERT INTO student (first_name, last_name, age, department_id) VALUES ('Сидоров', 'Владимир', 18, 1);
INSERT INTO student (first_name, last_name, age, department_id) VALUES ('Петров', 'Олег', 19, 1);
INSERT INTO student (first_name, last_name, age, department_id) VALUES ('Лебедев', 'Роман', 21, 2);
INSERT INTO student (first_name, last_name, age, department_id) VALUES ('Галанова', 'Дарья', 21, 2);
INSERT INTO student (first_name, last_name, age, department_id) VALUES ('Голов', 'Максим', 21, 2);
INSERT INTO student (first_name, last_name, age, department_id) VALUES ('Каймаков', 'Кирилл', 20, 2);
INSERT INTO student (first_name, last_name, age, department_id) VALUES ('Козлова', 'Ярославна', 21, 3);
INSERT INTO student (first_name, last_name, age, department_id) VALUES ('Юдина', 'Елизавета', 21, 3);
INSERT INTO student (first_name, last_name, age, department_id) VALUES ('Олег', 'Бонарь', 21, 3);
INSERT INTO student (first_name, last_name, age, department_id) VALUES ('Иван', 'Богданов', 21, 3);



