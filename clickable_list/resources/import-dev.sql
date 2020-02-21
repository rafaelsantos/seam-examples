-- SQL statements which are executed at application startup if hibernate.hbm2ddl.auto is 'create' or 'create-drop'
INSERT INTO messages(finished, period, text, title) VALUES(0, '2020-02-19 04:30', 'This is another example of a message', 'Greetings Earthling');
INSERT INTO messages(finished, period, text, title) VALUES(0, '2020-01-21 05:40', 'Simple demonstration of clickable list in JBoss Seam', 'Hello World');
INSERT INTO messages(finished, period, text, title) VALUES(0, '2020-01-20 06:40', 'Clickable List example', 'This example is written in JBoss Seam');
INSERT INTO messages(finished, period, text, title) VALUES(0, '2020-01-19 06:40', 'Database automation', 'This application uses some automation scripts to insert data in database');
