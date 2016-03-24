drop table if exists quizzes;
drop table if exists question_types;
drop table if exists questions;
drop table if exists options;
drop table if exists classes;
drop table if exists students;
drop table if exists assigned_quizzes;
drop table if exists supervisors;

create table quizzes(
  quiz_id int primary key auto_increment,
  title varchar(100)
);

create table question_types(
  question_type_id int primary key auto_increment,
  type varchar(20)
);

create table questions(
  question_id int primary key auto_increment,
  text varchar(350),
  quiz_id int, foreign key (quiz_id) references quizzes(quiz_id) on update cascade on delete cascade,
  type_id int, foreign key (type_id) references question_types(question_type_id) on update cascade on delete cascade
);

create table options(
  option_id int primary key auto_increment,
  text varchar(100),
  is_right boolean,
  question_id int,
  foreign key (question_id) references questions(question_id) on update cascade on delete cascade
);

create table supervisors(
  supervisor_id int primary key auto_increment,
  first_name varchar(35),
  last_name varchar(35),
  email varchar(255) unique
);

create table classes(
  class_id int primary key auto_increment,
  name varchar(4),
  supervisor_id int,
  foreign key (supervisor_id) references supervisors(supervisor_id) on update cascade on delete cascade
);

create table students(
  student_id int primary key auto_increment,
  first_name varchar(35),
  last_name varchar(35),
  email varchar(255) unique,
  class_id int,
  foreign key (class_id) references classes(class_id) on update cascade on delete cascade
);

create table assigned_quizzes(
  assigned_quiz_id int primary key auto_increment,
  mark int,
  is_passed boolean,
  quiz_id int,
  student_id int,
  foreign key (quiz_id) references quizzes(quiz_id) on update cascade on delete cascade,
  foreign key (student_id) references students(student_id) on update cascade on delete cascade
);