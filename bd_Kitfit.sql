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
   id				INT				IDENTITY,
   nome				VARCHAR(100)	NOT NULL,
   email			VARCHAR(100)	UNIQUE NOT NULL,
   senha			VARCHAR(100)	NOT NULL,
   nivelAcesso		VARCHAR(10)		NULL, -- ADMIN ou CLIENTE
   foto				VARBINARY(MAX)	NULL,
   dataCadastro		SMALLDATETIME	NOT NULL,
   statusUsuario	VARCHAR(20)		NOT NULL, -- ATIVO ou INATIVO ou TROCAR_SENHA

   PRIMARY KEY (id)
)
GO
INSERT Usuario (nome, email, senha, nivelAcesso, foto, dataCadastro, statusUsuario)
VALUES ('Fulano da Silva', 'fulano@email.com.br', 'MTIzNDU2Nzg=', 'ADMIN', NULL, GETDATE(), 'ATIVO')
INSERT Usuario (nome, email, senha, nivelAcesso, foto, dataCadastro, statusUsuario)
VALUES ('Beltrana de Sá', 'beltrana@email.com.br', 'MTIzNDU2Nzg=', 'CLIENTE', NULL, GETDATE(), 'ATIVO')
INSERT Usuario (nome, email, senha, nivelAcesso, foto, dataCadastro, statusUsuario)
VALUES ('Sicrana de Oliveira', 'sicrana@email.com.br', 'MTIzNDU2Nzg=', 'CLIENTE', NULL, GETDATE(), 'ATIVO')
INSERT Usuario (nome, email, senha, nivelAcesso, foto, dataCadastro, statusUsuario)
VALUES ('Ordnael Zurc', 'ordnael@email.com.br', 'MTIzNDU2Nzg=', 'CLIENTE', NULL, GETDATE(), 'TROCAR_SENHA')
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
VALUES ('Mega Power Horse', 'teste', 'prod1, prod2, prod3', NULL, 199.99, 'ATIVO')

CREATE TABLE Assinatura
(
	id				 INT		    IDENTITY,
	dataAssinatura	 SMALLDATETIME	NOT NULL,
	codigo			 VARCHAR(10)		NULL,
	usuario_id		 INT			NOT NULL,
	kit_id			 INT			NOT NULL,
	statusAssinatura VARCHAR(10)	NOT NULL, -- ATIVO ou INATIVO

	PRIMARY KEY (id),
	FOREIGN KEY (usuario_id) REFERENCES Usuario(id),
	FOREIGN KEY (kit_id) REFERENCES Kit(id)
)
GO
INSERT Assinatura (dataAssinatura, codigo, usuario_id, kit_id, statusAssinatura)
VALUES (GETDATE(), NULL, 2, 1, 'ATIVO')

CREATE TABLE Mensalidade
(
	id				  INT		    IDENTITY,
	mesRef			  VARCHAR(20)	NOT NULL,
	dataVcto		  SMALLDATETIME	NOT NULL,
	dataPgto		  SMALLDATETIME	NULL,
	valor			  DECIMAL(8,2)	NULL,
	assinatura_id	  INT			NOT NULL,
	statusMensalidade VARCHAR(10)	NOT NULL, -- PAGO ou ABERTO ou VENCIDO

	PRIMARY KEY (id),
	FOREIGN KEY (assinatura_id) REFERENCES Assinatura(id)
)
GO
INSERT Mensalidade (mesRef, dataVcto, dataPgto, valor, assinatura_id, statusMensalidade)
VALUES ('AGOSTO', '10/08/2024', '10/08/2024', 199.99, 1, 'PAGO')
INSERT Mensalidade (mesRef, dataVcto, dataPgto, valor, assinatura_id, statusMensalidade)
VALUES ('SETEMBRO', '10/09/2024', NULL, NULL, 1, 'ABERTO')
INSERT Mensalidade (mesRef, dataVcto, dataPgto, valor, assinatura_id, statusMensalidade)
VALUES ('OUTUBRO', '10/10/2024', NULL, NULL, 1, 'ABERTO')

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


use bd_Kitfit
SELECT * FROM Usuario
SELECT * FROM Mensagem
SELECT * FROM Kit
SELECT * FROM Assinatura
SELECT * FROM Mensalidade




 

 





