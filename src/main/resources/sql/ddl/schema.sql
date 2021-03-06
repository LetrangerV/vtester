drop database if exists vtester;
CREATE DATABASE vtester CHARACTER SET utf8 COLLATE utf8_general_ci;

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
  quiz_id int,
  type_id int,
  constraint 'fk__questions__quizzes' foreign key (quiz_id) references quizzes(quiz_id) on update cascade on delete cascade,
  constraint 'fk__questions__question_types' foreign key (type_id) references question_types(question_type_id) on update cascade on delete cascade
);

create table options(
  option_id int primary key auto_increment,
  text varchar(100),
  is_right boolean,
  question_id int,
  constraint 'fk__options__questions' foreign key (question_id) references questions(question_id) on update cascade on delete cascade
);

create table supervisors(
  supervisor_id int primary key auto_increment,
  first_name varchar(35),
  last_name varchar(35),
  email varchar(255),
  constraint 'unique_supervisor' unique (email)
);

create table classes(
  class_id int primary key auto_increment,
  name varchar(4),
  supervisor_id int,
  constraint 'fk__classes__supervisors' foreign key (supervisor_id) references supervisors(supervisor_id) on update cascade on delete cascade
);

create table students(
  student_id int primary key auto_increment,
  first_name varchar(35),
  last_name varchar(35),
  email varchar(255),
  class_id int,
  constraint 'fk__students__classes' foreign key (class_id) references classes(class_id) on update cascade on delete cascade,
  constraint 'unique_student' unique (email)
);

create table assigned_quizzes(
  assigned_quiz_id int primary key auto_increment,
  mark int,
  is_passed boolean,
  quiz_id int,
  student_id int,
  constraint 'fk__assigned_quizzes__quizzes' foreign key (quiz_id) references quizzes(quiz_id) on update cascade on delete cascade,
  constraint 'fk__assigned_quizzes__students' foreign key (student_id) references students(student_id) on update cascade on delete cascade
);

create table marks(
  mark_id int primary key auto_increment,
  mark int,
  lower_bound int,
  upper_bound int
);