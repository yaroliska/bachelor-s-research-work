INSERT INTO park (name) VALUES ('Сортировочный парк');
INSERT INTO park (name) VALUES ('Приемо-отправочный парк');

INSERT INTO station (name, description) VALUES ('Белозерки', 'Самая преступная станция');
INSERT INTO station (name, description) VALUES ('Марьино', 'Самая хорошая станция');
INSERT INTO station (name, description) VALUES ('Кинель', 'Сортировочная станция');

INSERT INTO global_version (creator,date,description, station_id) VALUES ('Вася', TO_DATE('14.12.2018', 'DD/MM/YYYY'),'Первая версия путевого развития', 1);
INSERT INTO global_version (creator,date,description, station_id) VALUES ('Вася', TO_DATE('15.12.2018', 'DD/MM/YYYY'),'Исправлен съезд', 1);

INSERT INTO arrow_type (name) VALUES ('Симметричный тройной');
INSERT INTO arrow_type (name) VALUES ('Несимметричный односторонний');
INSERT INTO arrow_type (name) VALUES ('Несимметричный разносторонний');
INSERT INTO arrow_type (name) VALUES ('Перекрестный одиночный');

INSERT INTO arrow (x,y,arrow_type_id) VALUES (20,5,2);
INSERT INTO arrow (x,y,arrow_type_id) VALUES (30,10,3);

INSERT INTO arrow_version (x,y,arrow_id, global_version_id, arrow_type_id) VALUES (20,5,1,1,2);
INSERT INTO arrow_version (x,y,arrow_id, global_version_id, arrow_type_id) VALUES (30,10,2,1,3);
INSERT INTO arrow_version (x,y,arrow_id, global_version_id, arrow_type_id) VALUES (10,5,1,2,2);
INSERT INTO arrow_version (x,y,arrow_id, global_version_id, arrow_type_id) VALUES (20,10,2,2,2);

INSERT INTO park (name) VALUES ('Сортировочный парк');
INSERT INTO park (name) VALUES ('Приемо-отправочный парк');

INSERT INTO path (number,xbegin,ybegin,xend,yend, park_id) VALUES (1,0,5,40,5,1);
INSERT INTO path (number,xbegin,ybegin,xend,yend, park_id) VALUES (2,0,-5,40,-5,1);
INSERT INTO path (number,xbegin,ybegin,xend,yend, park_id) VALUES (3,0,10,40,10,1);
INSERT INTO path (number,xbegin,ybegin,xend,yend, park_id) VALUES (4,20,5,30,10,1);

INSERT INTO arrow_path(arrow_id,path_id) VALUES (1,1);
INSERT INTO arrow_path(arrow_id,path_id) VALUES (1,4);

INSERT INTO path_version (number,x_begin,y_begin,x_end,y_end,park_id,path_id,global_version_id) VALUES (1,0,5,40,5,1,1,1);
INSERT INTO path_version (number,x_begin,y_begin,x_end,y_end,park_id,path_id,global_version_id) VALUES (1,0,-5,40,5,1,2,1);
INSERT INTO path_version (number,x_begin,y_begin,x_end,y_end,park_id,path_id,global_version_id) VALUES (1,0,10,40,10,1,3,1);

INSERT INTO traffic_light_type (name) VALUES ('входной');
INSERT INTO traffic_light_type (name) VALUES ('выходной');
INSERT INTO traffic_light_type (name) VALUES ('маршрутный');
INSERT INTO traffic_light_type (name) VALUES ('проходной');

INSERT INTO traffic_light (x,y,traffic_light_type_id, path_id) VALUES (10,10,1,1);
INSERT INTO traffic_light (x,y,traffic_light_type_id,path_id) VALUES (10,10,1,2);

INSERT INTO traffic_light_version (traffic_light_id,traffic_light_type_id, path_version_id) VALUES (1,1,1);
INSERT INTO traffic_light_version (traffic_light_id,traffic_light_type_id, path_version_id) VALUES (2,1,2);
INSERT INTO traffic_light_version (traffic_light_id,traffic_light_type_id, path_version_id) VALUES (2,2,2);

INSERT INTO building_type (name, description) VALUES ('локомотивное хозяйство', 'оборотное - производится подготовка локомотивов к следованию с поездами в направлении основного депо');
INSERT INTO building_type (name, description) VALUES('вагонное хозяйство','эксплуатация и ремонт вагонов');
INSERT INTO building_type (name, description) VALUES('диспетчерский центр','арочный');

INSERT INTO building (x,y,description,building_type_id) VALUES(0,-40,'количество рабочих =10, ответственный - Петров П.П.',1);
INSERT INTO building (x,y,description,building_type_id) VALUES(40,100,'количество рабочих установок -5',2);

INSERT INTO building_version (x,y,description,building_type_id, building_id) VALUES(0,-40,'количество рабочих установок -5',1,1);
INSERT INTO building_version (x,y,description,building_type_id, building_id) VALUES(40,100,'количество рабочих =10, ответственный - Петров П.П.',2,2);
INSERT INTO building_version (x,y,description,building_type_id, building_id) VALUES(40,100,'количество рабочих = 12, ответственный - Вечеков З.О.',2,2);


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



