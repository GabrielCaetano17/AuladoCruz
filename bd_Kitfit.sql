USE master IF EXISTS(select * from sys.databases where name='bd_Kitfit') 
DROP DATABASE bd_Kitfit
GO 
-- CRIAR UM BANCO DE DADOS
CREATE DATABASE bd_Kitfit
GO
-- ACESSAR O BANCO DE DADOS
USE bd_Kitfit
GO
 
CREATE TABLE Usuario
( 
   id            INT			IDENTITY,
   nome          VARCHAR(100)	NOT NULL,
   email         VARCHAR(100)	UNIQUE NOT NULL,
   senha         VARCHAR(100)	NOT NULL,
   nivelAcesso   VARCHAR(10)    NULL, -- ADMIN ou CLIENTE
   foto			 VARBINARY(MAX) NULL,
   dataCadastro	 SMALLDATETIME	NOT NULL,
   statusUsuario VARCHAR(20)    NOT NULL, -- ATIVO ou INATIVO ou TROCAR_SENHA
 
   PRIMARY KEY (id)
)
GO
INSERT Usuario (nome, email, senha, nivelAcesso, foto, dataCadastro, statusUsuario)
VALUES ('Fulano da Silva', 'fulano@email.com.br', 'MTIzNDU2Nzg=', 'ADMIN', NULL, GETDATE(), 'ATIVO')
GO
 
CREATE TABLE Kit
(
	id			 INT		    IDENTITY,
	nome	     VARCHAR(100)	NOT NULL,
	descricao	 VARCHAR(400)	NOT NULL,
	produtos	 VARCHAR(400)	NOT NULL,
	foto		 VARBINARY(max) NULL,
	preco		 DECIMAL(8,2)	NOT NULL,
	statusKit	 VARCHAR(10)	NOT NULL, -- ATIVO ou INATIVO
 
	PRIMARY KEY (id)
)
GO
INSERT Kit (nome, descricao, produtos, foto, preco, statusKit)
VALUES ('Kit legal', 'teste', 'prod1, prod2, prod3', NULL, 199.99, 'ATIVO')
INSERT Kit (nome, descricao, produtos, foto, preco, statusKit)
values ('Kit azul', 'teste2', 'prod1, prod2, prod3', null, 179.99, 'ATIVO')
INSERT Kit (nome, descricao, produtos, foto, preco, statusKit)
values ('basic kit', 'teste3', 'prod1, prod2, prod3', null, 139.99, 'ATIVO')
INSERT Kit (nome, descricao, produtos, foto, preco, statusKit)
values ('mega kit ', 'testemax', 'prod1, prod2, prod3', null, 249.99, 'ATIVO')
 
CREATE TABLE Assinatura
(
	id				 INT		    IDENTITY,
	codigo			 Varchar(10)      NOT NULL,
	dataAssinatura	 SMALLDATETIME	NOT NULL,
	valor			  DECIMAL(8,2)	NOT NULL,
	emailUsu         VARCHAR(100)	UNIQUE NOT NULL,
	kit_id			 INT			NOT NULL,
	statusAssinatura VARCHAR(10)	NOT NULL, -- ATIVO ou INATIVO
 
	PRIMARY KEY (id),
	FOREIGN KEY (emailUsu) REFERENCES Usuario(email),
	FOREIGN KEY (kit_id) REFERENCES Kit(id)
)
GO
INSERT Assinatura (dataAssinatura,codigo, emailUsu, kit_id,valor, statusAssinatura)
VALUES (GETDATE(),'1982525262', 'beltrana@email.com.br', 1, 199.00 , 'ATIVO')
 
 
CREATE TABLE Mensagem
(
	id	            INT			  IDENTITY,
	dataMensagem    SMALLDATETIME NOT NULL,
	emissorMensagem VARCHAR(100)  NOT NULL,
	email 	        VARCHAR(100)  NOT NULL,
	telefone	    VARCHAR(20)       NULL,
	texto 	        VARCHAR(400)  NOT NULL,
	statusMensagem  VARCHAR(10)   NOT NULL, -- ATIVO ou INATIVO
 
	PRIMARY KEY (id)
)
GO
INSERT Mensagem (dataMensagem, emissorMensagem, email, telefone, texto, statusMensagem) 
VALUES (GETDATE(), 'Ordnael Zurc', 'ordnael@email.com', '(11) 98765-4123', 'Mensagem de teste', 'ATIVO')
INSERT Mensagem (dataMensagem, emissorMensagem, email, telefone, texto, statusMensagem) 
VALUES (GETDATE(), 'Maria Onete', 'maria@email.com', null, 'Segunda mensagem de teste', 'ATIVO')
GO
 
 
SELECT * FROM Mensagem
SELECT * FROM Kit
select * from Usuario
 
 
select nome from Usuario where email = 'fulano@email.com.br'
 
update Usuario set senha = '123456' where email = 'amo@'
 
Select nome, email From Usuario where email = '1@' AND senha = '12'
 
Select email From Usuario where email = 'amo@'
 
delete Assinatura where emailUsu = 'amo@'

INSERT Usuario (nome, email, senha, nivelAcesso, foto, dataCadastro, statusUsuario)
VALUES ('Gabriel', 'gabriela@email.com.br', '123', 'CLIENTE', NULL, GETDATE(), 'ATIVO')