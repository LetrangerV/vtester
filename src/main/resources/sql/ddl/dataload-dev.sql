insert into question_types (type) values ('one_answer');
insert into question_types (type) values ('multi_answer');
insert into question_types (type) values ('mapping');
insert into question_types (type) values ('user_input');

insert into quizzes (title) values ('quiz2');
insert into quizzes (title) values ('quiz3');
insert into quizzes (title) values ('quiz1');

insert into classes (name) values ('9а');
insert into classes (name) values ('8б');
insert into classes (name) values ('11в');

insert into questions(text, quiz_id, type_id) values ('question1', 2, 1);
insert into questions(text, quiz_id, type_id) values ('question2', 2, 1);
insert into questions(text, quiz_id, type_id) values ('question3', 2, 1);

insert into options(text, is_right, question_id) values ('option1', true, 1);
insert into options(text, is_right, question_id) values ('option2', false, 1);
insert into options(text, is_right, question_id) values ('option3', false, 1);
insert into options(text, is_right, question_id) values ('option4', true, 2);
insert into options(text, is_right, question_id) values ('option5', true, 3);
insert into options(text, is_right, question_id) values ('option6', false, 3);

insert into students (first_name, last_name, email, class_id) values ('Вася', 'Пупкин', 'pupkin@22', 1);
insert into students (first_name, last_name, email, class_id) values ('Петя', 'Петров', 'petrov@22', 2);
insert into students (first_name, last_name, email, class_id) values ('Иван', 'Иванов', 'iv@i', 1);

insert into assigned_quizzes (quiz_id, student_id) values (2, 1);

insert into passed_quizzes (mark, quiz_id, student_id) values (4, 3, 1);