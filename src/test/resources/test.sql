set FOREIGN_KEY_CHECKS = 0;
truncate project_module;
truncate module;
truncate project;
set FOREIGN_KEY_CHECKS = 1;

insert into module (name) values ('module1');
insert into module (name) values ('module2');
insert into module (name) values ('module3');
insert into module (name) values ('module4');
insert into module (name) values ('module5');
insert into module (name) values ('module6');
insert into module (name) values ('module7');
insert into module (name) values ('module8');
insert into module (name) values ('module9');
insert into project (id, name) values (1,'test');
insert into project_module (module_id, project_id) values (3, 1);
insert into project_module (module_id, project_id) values (1, 1);
insert into project_module (module_id, project_id) values (2, 1);