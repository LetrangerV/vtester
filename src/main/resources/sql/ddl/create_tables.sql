create table quizzes(
  quiz_id int primary key auto_increment,
  title varchar(100)
);

create table questions(
  question_id int primary key auto_increment,
  text varchar(350),
  quiz_id int,
  type_id int,
  constraint 'fk_quiz' foreign key (quiz_id) references quizzes(quiz_id) on update cascade on delete cascade,
  constraint 'fk_type' foreign key (type_id) references question_types(question_type_id) on update cascade on delete cascade
);

create table question_types(
  question_type_id int primary key auto_increment,
  type varchar(20)
);

insert into question_types (type) values ('one_answer');
insert into question_types (type) values ('multi_answer');
insert into question_types (type) values ('mapping');
insert into question_types (type) values ('user_input');

create table options(
  option_id int primary key auto_increment,
  text varchar(100),
  is_right boolean,
  question_id int,
  constraint 'fk_question' foreign key (question_id) references questions(question_id) on update cascade on delete cascade
);