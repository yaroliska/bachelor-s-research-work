INSERT INTO station (name, description) VALUES ('Белозерки', 'Самая преступная станция');
INSERT INTO station (name, description) VALUES ('Марьино', 'Самая хорошая станция');
INSERT INTO station (name, description) VALUES ('Кинель', 'Сортировочная станция');

INSERT INTO traffic_light_type (name) VALUES ('входной');
INSERT INTO traffic_light_type (name) VALUES ('выходной');
INSERT INTO traffic_light_type (name) VALUES ('маршрутный');
INSERT INTO traffic_light_type (name) VALUES ('проходной');

INSERT INTO traffic_light (x,y,traffic_light_type_id) VALUES (10,10,1);
INSERT INTO traffic_light (x,y,traffic_light_type_id) VALUES (10,10,1);

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



