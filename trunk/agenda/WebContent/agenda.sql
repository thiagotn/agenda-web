create database agenda;

create table contatos (
	id BIGINT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(255),
	email VARCHAR(255),
	endereco VARCHAR(255),
	dataNascimento DATE,
	primary key (id)
);

create table usuario (
  login VARCHAR(255) NOT NULL,
  senha VARCHAR(255) default NULL,
  nome VARCHAR(255) default NULL,
  primary key (login)
); 