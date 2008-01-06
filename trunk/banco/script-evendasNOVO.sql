use master
go
drop database evendas
go
create database evendas
go
use evendas
go

/*==============================================================*/
/* Table: CATEGORIA_PRODUTO                                     */
/*==============================================================*/
create table CATEGORIA_PRODUTO (
ID_CATEGORIA         bigint               not null identity,
DESCRICAO_CATEGORIA  varchar(50)          not null,
constraint PK_CATEGORIA_PRODUTO primary key  (ID_CATEGORIA),
constraint UK_DESCRICAO_CATEGORIA UNIQUE  (DESCRICAO_CATEGORIA)
)
go

/*==============================================================*/
/* Table: SUBCATEGORIA_PRODUTO                                  */
/*==============================================================*/
create table SUBCATEGORIA_PRODUTO (
ID_SUBCATEGORIA      bigint               not null identity,
ID_CATEGORIA         bigint               not null,
DESCRICAO_SUBCATEGORIA varchar(50)          not null,
constraint PK_SUBCATEGORIA_PRODUTO primary key  (ID_SUBCATEGORIA),
constraint UK_DESCRICAO_SUBCATEGORIA UNIQUE  (DESCRICAO_SUBCATEGORIA),
constraint FK_SUBCATEG_RELATIONS_CATEGORI foreign key (ID_CATEGORIA)
      references CATEGORIA_PRODUTO (ID_CATEGORIA)
)
go


/*==============================================================*/
/* Table: MEDIDA                                              */
/*==============================================================*/
CREATE TABLE [MEDIDA] (
	[ID_MEDIDA] [int] NOT NULL identity ,
	[DESCRICAO_MEDIDA] [varchar] (50) COLLATE Latin1_General_CI_AS NOT NULL ,
constraint PK_medida primary key  (ID_MEDIDA)
) ON [PRIMARY]
GO

/*==============================================================*/
/* Table: RELACAO_MEDIDA                                        */
/*==============================================================*/
CREATE TABLE [RELACAO_MEDIDA] (
	[ID_MEDIDA_DE] [int] NOT NULL ,
	[ID_MEDIDA_P] [int] NOT NULL ,
	[FATOR_RELACAO] [float] NOT NULL,
constraint UK_RELACAO_MEDIDA UNIQUE (ID_MEDIDA_DE, ID_MEDIDA_P),

constraint FK_RELACAO_MEDIDA_RELATIONS_medida1 foreign key (ID_MEDIDA_DE)
      references MEDIDA (ID_MEDIDA),
constraint FK_RELACAO_MEDIDA_RELATIONS_medida2 foreign key (ID_MEDIDA_DE)
      references MEDIDA (ID_MEDIDA)

) ON [PRIMARY]
GO

/*==============================================================*/
/* Table: PRODUTO                                               */
/*==============================================================*/
create table PRODUTO (
ID_PRODUTO           bigint               not null identity,
CODIGO_PRODUTO		bigint					not null,
ID_SUBCATEGORIA      bigint               not null,
ID_MEDIDA			int               not null,
DESCRICAO_PRODUTO    varchar(250)          not null,
NOME_PRODUTO    varchar(50)          not null,
IMAGEM_CAMINHO    varchar(255)       DEFAULT('~/images/produtos/default.jpg'),
CUSTO                decimal(10,2)        not null,
constraint PK_PRODUTO primary key  (ID_PRODUTO),
constraint UK_NOME UNIQUE  (NOME_PRODUTO),
constraint UK_CODIGO UNIQUE  (CODIGO_PRODUTO),
constraint UK_DESCRICAO UNIQUE  (DESCRICAO_PRODUTO),
constraint FK_PRODUTO_RELATIONS_SUBCATEG foreign key (ID_SUBCATEGORIA)
      references SUBCATEGORIA_PRODUTO (ID_SUBCATEGORIA),
constraint FK_PRODUTO_RELATIONS_MEDIDA foreign key (ID_MEDIDA)
      references MEDIDA (ID_MEDIDA)
)
go

/*==============================================================*/
/* Table: LOJA                                                  */
/*==============================================================*/
create table LOJA (
ID_LOJA              int                  not null identity,
NOME_LOJA            varchar(50)          not null,
constraint PK_LOJA primary key  (ID_LOJA)
)
go

/*==============================================================*/
/* Table: ITEM_PRODUTO                                          */
/*==============================================================*/
create table ITEM_PRODUTO (
ID_ITEM_PRODUTO      bigint               not null identity,
ID_PRODUTO           bigint               not null,
ID_LOJA              int                  not null,
QTD_ITEM_PRODUTO     int                  not null,
PRECO_ITEM_PRODUTO   decimal(10,2)        not null,
constraint PK_ITEM_PRODUTO primary key  (ID_ITEM_PRODUTO),
constraint FK_ITEM_PRO_RELATIONS_PRODUTO foreign key (ID_PRODUTO)
      references PRODUTO (ID_PRODUTO),
constraint FK_ITEM_PRO_RELATIONS_LOJA foreign key (ID_LOJA)
      references LOJA (ID_LOJA)
)
go

/*==============================================================*/
/* Table: ESTADO_ITEM_VENDA                                     */
/*==============================================================*/
create table ESTADO_ITEM_VENDA (
ID_ESTADO_ITEM_VENDA smallint             not null identity,
DESCRICAO_ESTADO_ITEM_VENDA varchar(15)          not null,
constraint PK_ESTADO_ITEM_VENDA primary key  (ID_ESTADO_ITEM_VENDA)
)
go

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO (
ID_USUARIO           int                  not null identity,
LOGIN                varchar(50)          not null,
SENHA                varbinary(255)         not null,
EMAIl				 varchar(255)		  not null,
constraint PK_USUARIO primary key  (ID_USUARIO),
CONSTRAINT UK_LOGIN UNIQUE (LOGIN)
)
go

/*==============================================================*/
/* Table: CLIENTE                                               */
/*==============================================================*/
/*UM CLIENTE SOH PODE TER UM USUARIO*/
create table CLIENTE (
ID_CLIENTE           bigint               not null identity, 
NOME_CLIENTE         varchar(100)         not null,
CPF                  varchar(11)          not null,
ID_USUARIO           int                  null,
constraint PK_CLIENTE primary key  (ID_CLIENTE),
CONSTRAINT UK_CPF UNIQUE (CPF),
constraint FK_CLIENTE_RELATIONS_USUARIO foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO)
)
go

/*==============================================================*/
/* Table: FUNCIONARIO                                           */
/*==============================================================*/
create table FUNCIONARIO (
ID_FUNC              bigint               not null identity,
ID_LOJA              int                  not null,
ID_USUARIO           int                  null,
MATRICULA_FUNC       bigint               not null,
NOME_FUNC            varchar(100)         not null,
constraint PK_FUNCIONARIO primary key  (ID_FUNC),
constraint FK_FUNCIONA_RELATIONS_USUARIO foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO),
constraint FK_FUNCIONA_RELATIONS_LOJA foreign key (ID_LOJA)
      references LOJA (ID_LOJA)
)
go

/*==============================================================*/
/* Table: CARTAO                                                */
/*==============================================================*/
create table CARTAO (
ID_CARTAO            int                  not null identity,
ID_CLIENTE           bigint               not null,
LIMITE				decimal(10,2)			not null,
constraint PK_CARTAO primary key  (ID_CARTAO),
constraint FK_CARTAO_RELATIONS_CLIENTE foreign key (ID_CLIENTE)
      references CLIENTE (ID_CLIENTE)
)
go

/*==============================================================*/
/* Table: TIPO_PAGAMENTO                                        */
/*==============================================================*/
create table TIPO_PAGAMENTO (
ID_TIPO_PAGAMENTO    smallint             not null identity,
DESCRICAO_TIPO_PAGAMENTO char(10)             not null,
constraint PK_TIPO_PAGAMENTO primary key  (ID_TIPO_PAGAMENTO),
CONSTRAINT UK_DESCRICAO_TIPO_PAGAMENTO UNIQUE (DESCRICAO_TIPO_PAGAMENTO)
)
go

/*==============================================================*/
/* Table: PDV                                                   */
/*==============================================================*/
create table PDV (
ID_PDV               int               not null identity,
ID_LOJA              int               not null,
constraint PK_PDV primary key  (ID_PDV),
constraint FK_PDV_RELATIONS_LOJA foreign key (ID_LOJA)
      references LOJA (ID_LOJA)
)
go

/*==============================================================*/
/* Table: VENDA                                                 */
/*==============================================================*/
create table VENDA (
ID_VENDA             bigint               not null identity,
ID_FUNC              bigint               not null,
ID_PDV               int               	  not null,
ID_CLIENTE           bigint               null,
DATA_VENDA           datetime             not null,
constraint PK_VENDA primary key  (ID_VENDA),
constraint FK_VENDA_RELATIONS_FUNCIONA foreign key (ID_FUNC)
      references FUNCIONARIO (ID_FUNC),
constraint FK_VENDA_RELATIONS_PDV foreign key (ID_PDV)
      references PDV (ID_PDV),
constraint FK_VENDA_RELATIONS_CLIENTE foreign key (ID_CLIENTE)
      references CLIENTE (ID_CLIENTE)  
)
go

/*==============================================================*/
/* Table: ITEM_VENDA                                            */
/*==============================================================*/
create table ITEM_VENDA (
ID_ITEM_VENDA        int                  not null identity,
ID_VENDA             bigint               not null,
ID_ITEM_PRODUTO      bigint               not null,
ID_ESTADO_ITEM_VENDA smallint             not null,
QTD_ITEM_VENDA       int                  not null,
constraint PK_ITEM_VENDA primary key  (ID_ITEM_VENDA),
constraint FK_ITEM_VEN_RELATIONS_VENDA foreign key (ID_VENDA)
      references VENDA (ID_VENDA),
constraint FK_ITEM_VEN_RELATIONS_ITEM_PRO foreign key (ID_ITEM_PRODUTO)
      references ITEM_PRODUTO (ID_ITEM_PRODUTO),
constraint FK_ITEM_VEN_REFERENCE_ESTADO_I foreign key (ID_ESTADO_ITEM_VENDA)
      references ESTADO_ITEM_VENDA (ID_ESTADO_ITEM_VENDA)
)
go


/*==============================================================*/
/* Table: PAGAMENTO                                             */
/*==============================================================*/
create table PAGAMENTO (
ID_PAGAMENTO         bigint               not null identity,
ID_TIPO_PAGAMENTO    smallint             not null,
ID_VENDA             bigint               not null,
VALOR_PAGAMENTO      decimal(10,2)        not null,
constraint PK_PAGAMENTO primary key  (ID_PAGAMENTO),
constraint FK_PAGAMENT_RELATIONS_VENDA foreign key (ID_VENDA)
      references VENDA (ID_VENDA),
constraint FK_PAGAMENT_RELATIONS_TIPO_PAG foreign key (ID_TIPO_PAGAMENTO)
      references TIPO_PAGAMENTO (ID_TIPO_PAGAMENTO)
)
go


/*==============================================================*/
/* Table: TROCA                                                 */
/*==============================================================*/
create table TROCA (
ID_TROCA             int                  not null identity,
ID_VENDA             bigint               not null,
DATA_TROCA           datetime             not null,
VALOR_TROCA          decimal(10,2)        not null,
ID_PAGAMENTO		bigint					null,
constraint PK_TROCA primary key  (ID_TROCA),
constraint FK_TROCA_RELATIONS_VENDA foreign key (ID_VENDA)
      references VENDA (ID_VENDA),
constraint FK_TROCA_RELATIONS_PAG foreign key (ID_PAGAMENTO)
      references PAGAMENTO (ID_PAGAMENTO)
)
go

/*==============================================================*/
/* Table: ITEM_TROCA                                            */
/*==============================================================*/
create table ITEM_TROCA (
ID_ITEM_TROCA        bigint             not null identity,
ID_ITEM_VENDA        int                  not null,
ID_TROCA             int                  not null,
constraint PK_ITEM_TROCA primary key  (ID_ITEM_TROCA),
constraint FK_ITEM_TRO_RELATIONS_TROCA foreign key (ID_TROCA)
      references TROCA (ID_TROCA),
constraint FK_ITEM_TRO_RELATIONS_ITEM_VEN foreign key (ID_ITEM_VENDA)
      references ITEM_VENDA (ID_ITEM_VENDA)
)
go



/*==============================================================*/
/* Table: PARCELAS                                              */
/*==============================================================*/
create table PARCELAS (
ID_PARCELAS          bigint               not null identity,
ID_PAGAMENTO         bigint               not null,
ID_CARTAO            int                  not null,
DATA_VENC            datetime             not null,
VALOR_VENC           decimal(10,2)        not null,
DATA_PGTO            datetime             null,
VALOR_PQTO           decimal(10,2)        null,
constraint PK_PARCELAS primary key  (ID_PARCELAS),
constraint FK_PARCELAS_RELATIONS_CARTAO foreign key (ID_CARTAO)
      references CARTAO (ID_CARTAO),
constraint FK_PARCELAS_RELATIONS_PAGAMENT foreign key (ID_PAGAMENTO)
      references PAGAMENTO (ID_PAGAMENTO)
)
go

/*==============================================================*/
/* Table: ACAO_LOG                                              */
/*==============================================================*/
create table ACAO_LOG (
ID_ACAO_LOG          smallint             not null identity,
DESCRICAO_ACAO_LOG   varchar(15)          not null,
constraint PK_ACAO_LOG primary key  (ID_ACAO_LOG),
constraint UK_DESCRICAO_ACAO_LOG UNIQUE (DESCRICAO_ACAO_LOG)
)
go

/*==============================================================*/
/* Table: LOG                                                   */
/*==============================================================*/
create table LOG (
ID_LOG               int                  not null identity,
ID_USUARIO           int                  not null,
ID_ACAO_LOG          smallint             not null,
ID_PDV               int               not null,
DATA_ACAO            datetime             not null,
constraint PK_LOG primary key  (ID_LOG),
constraint FK_LOG_RELATIONS_PDV foreign key (ID_PDV)
      references PDV (ID_PDV),
constraint FK_LOG_RELATIONS_ACAO_LOG foreign key (ID_ACAO_LOG)
      references ACAO_LOG (ID_ACAO_LOG),
constraint FK_LOG_RELATIONS_USUARIO foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO)	  
)
go

/*==============================================================*/
/* Table: TIPO_PROPRIETARIO                                     */
/*==============================================================*/
create table TIPO_PROPRIETARIO (
ID_TIPO_PROP         int                  not null identity,
DESCRICAO_TIPO       varchar(15)          not null,
constraint PK_TIPO_PROPRIETARIO primary key  (ID_TIPO_PROP),
constraint UK_DESCRICAO_TIPO UNIQUE (DESCRICAO_TIPO)
)
go

/*==============================================================*/
/* Table: TELEFONE                                              */
/*==============================================================*/
create table TELEFONE (
ID_TELEFONE           bigint               not null identity,
ID_TIPO_PROP         int                  not null,
ID_PROPRIETARIO      bigint               not null,
DDD SMALLINT NOT NULL,
NUMERO INT NOT NULL,
constraint PK_TELEFONE primary key  (ID_TELEFONE),
constraint FK_TELEFONE_RELATIONS_TIPO_PRO foreign key (ID_TIPO_PROP)
      references TIPO_PROPRIETARIO (ID_TIPO_PROP)
)
go


/*==============================================================*/
/* Table: ESTADO                                                */
/*==============================================================*/
CREATE TABLE [ESTADO] (
	[ID_ESTADO] [int] NOT NULL identity,
	[NOME_ESTADO] [varchar] (50) COLLATE Latin1_General_CI_AS NOT NULL ,
constraint PK_ESTADO primary key (ID_ESTADO)
) ON [PRIMARY]
GO



/*==============================================================*/
/* Table: MUNICIPIO                                             */
/*==============================================================*/
CREATE TABLE [MUNICIPIO] (
	[ID_MUNICIPIO] [int] NOT NULL identity,
	[NOME] [char] (10) COLLATE Latin1_General_CI_AS NOT NULL ,
	[ID_ESTADO] [int] NOT NULL 
constraint PK_MUNICIPIO primary key (ID_MUNICIPIO),
constraint FK_Municipio_RELATIONS_estado foreign key (ID_ESTADO)
      references estado (ID_ESTADO)
) ON [PRIMARY]
GO


/*==============================================================*/
/* Table: ENDERECO                                              */
/*==============================================================*/
create table ENDERECO (
ID_ENDERECO           bigint               not null identity,
ID_TIPO_PROP         int                  not null,
ID_PROPRIETARIO      bigint               not null,
ID_MUNICIPIO      INT               not null,
LOGRADOURO [varchar] (250) NOT NULL,
BAIRRO [varchar] (250) NOT NULL,
NUMERO INT NOT NULL,
CEP bigint NOT NULL,
constraint PK_ENDERECO primary key  (ID_ENDERECO),
constraint FK_ENDERECO_RELATIONS_TIPO_PRO foreign key (ID_TIPO_PROP)
      references TIPO_PROPRIETARIO (ID_TIPO_PROP),
constraint FK_ENDERECO_RELATIONS_MUNICIPIO foreign key (ID_MUNICIPIO)
      references MUNICIPIO (ID_MUNICIPIO)
)
go





/*======================================================================================================================*/
/*======================================================================================================================*/
/*======================================================================================================================*/
/*==============================               PROCEDURES           ====================================================*/
/*======================================================================================================================*/
/*======================================================================================================================*/
/*======================================================================================================================*/
/*==============================================================*/
/*                      PROCEDURE popularBanco                  */
/*==============================================================*/
/* ?????????????????????????????????????????????????????????????
CREATE PROCEDURE popularBanco
AS
DECLARE @ID_CATEGORIA bigint
DECLARE @ID_SUBCATEGORIA bigint
DECLARE @ID_LOJA int
DECLARE @ID_PDV int
DECLARE @ID_USUARIO int
DECLARE @ID_FUNCIONARIO int
DECLARE @ID_CLIENTE bigint
*/


/*==============================================================*/
/*                      PROCEDURE spRegistrarVenda              */
/*==============================================================*/
CREATE PROCEDURE spRegistrarVenda
@idFunc int,
@idPDV int,
@idCliente bigint,
@dataVenda datetime
AS
	DECLARE @retorno bigint
	DECLARE @dataV datetime
	/* Não sei como coverter o Date do java para o datetime do sql server */
	SET @dataVenda = (select convert(varchar(20), getdate()))
	INSERT INTO Venda(ID_FUNC, ID_PDV, ID_CLIENTE, DATA_VENDA) VALUES(@idFunc, @idPDV, @idCliente, @dataVenda)
	SET @retorno = (SELECT MAX(id_venda) FROM Venda)
	RETURN(@retorno)
go

/*==============================================================*/
/*                      PROCEDURE spRegistrarItemVenda                                      */
/*==============================================================*/
CREATE PROCEDURE spRegistrarItemVenda
@idVenda bigint,
@idItemProduto bigint,
@descricaoEstadoItemVenda varchar(10),
@qtde int
AS
DECLARE @idEstadoItemVenda smallInt
SET @idEstadoItemVenda = (select ID_ESTADO_ITEM_VENDA 
	FROM ESTADO_ITEM_VENDA where(DESCRICAO_ESTADO_ITEM_VENDA = @descricaoEstadoItemVenda))
INSERT INTO Item_Venda(ID_VENDA, ID_ITEM_PRODUTO, ID_ESTADO_ITEM_VENDA, QTD_ITEM_VENDA) 
	VALUES(@idVenda, @idItemProduto, @idEstadoItemVenda, @qtde)
go

/*==============================================================*/
/*                      PROCEDURE spRegistrarParcela                                      */
/*==============================================================*/
CREATE PROCEDURE spRegistrarParcela
@idPagamento bigint,
@idCartao bigint,
@dataVenc datetime,
@valorVenc decimal(10,2),
@numeroParcela int
AS
SET @dataVenc = getDate()+30*@numeroParcela;
insert into parcelas(ID_PAGAMENTO, ID_CARTAO, DATA_VENC, VALOR_VENC) 
	VALUES(@idPagamento, @idCartao, @dataVenc, @valorVenc)
go
	
/*==============================================================*/
/*                      PROCEDURE spLigarTrocaAoPagamento                                    */
/*==============================================================*/
CREATE PROCEDURE spLigarTrocaAoPagamento
@idTroca bigint,
@idPagamento bigint
AS
UPDATE TROCA SET ID_PAGAMENTO = @idPagamento WHERE(ID_TROCA = @idTroca)
go
/*==============================================================*/
/*                      PROCEDURE spRegistrarPagamento                                      */
/*==============================================================*/
CREATE PROCEDURE spRegistrarPagamento
@descricaoTipo varchar(15),
@idVenda bigint,
@valorPagamento decimal(10,2)
AS
	DECLARE @retorno bigint	
	DECLARE @idTipo smallInt
	SET @idTipo = (select ID_TIPO_PAGAMENTO 
		FROM TIPO_PAGAMENTO  where(DESCRICAO_TIPO_PAGAMENTO = @descricaoTipo))
	INSERT INTO Pagamento(ID_TIPO_PAGAMENTO, ID_VENDA, VALOR_PAGAMENTO) VALUES(@idTipo, @idVenda, @valorPagamento)
	SET @retorno = (SELECT MAX(id_pagamento) FROM pagamento)
	RETURN(@retorno)
go

/*==============================================================*/
/* Procedure: spSelectTroca                                     */
/*==============================================================*/
create procedure [dbo].[spSelectTroca]
	@codCupom int
AS
	declare @id int 
	select @id = id_troca from Troca where id_troca = @codCupom
	return @id
go


/*==============================================================*/
/* Procedure: spRealizarTroca                                   */
/*==============================================================*/
create procedure [dbo].[spRealizarTroca]
	@numCupomTroca int, @codProduto int, @qtd int
AS
	Declare @codVenda int
	set @codVenda = 0
	select @codVenda = id_Venda from Troca where id_troca = @numCupomTroca
	if @codVenda <> 0
		insert into Item_Venda (id_Venda, id_Item_Produto,id_estado_item_venda, qtd_item_venda) values (@codVenda, @codProduto,1, @qtd)
go


/*==============================================================*/
/* Procedure: spObterItensDeVendaPorVenda                       */
/*==============================================================*/
CREATE procedure [dbo].[spObterItensDeVendaPorVenda]
	@codVenda int
as
	print @codVenda
	select codigo, descricao, quantidade, valor from V_Item_Venda where id_Venda =  @codVenda
go


/*==============================================================*/
/* Procedure: spObterVendaPorCod                                */
/*==============================================================*/
create procedure [dbo].[spObterVendaPorCod]
	@codVenda int
AS
SELECT v.id_venda as codigo, v.data_venda as data , dbo.precoVenda(v.id_venda) AS valor 
FROM venda v WHERE v.id_venda = @codVenda 
go


/*==============================================================*/
/* Procedure: spInserirCupom                                    */
/*==============================================================*/
CREATE procedure [dbo].[spInserirCupom]
	@idVenda int, @valor decimal(12,2)
AS
	declare @id int
	declare @data datetime 

	set @data = getdate()

	INSERT INTO Troca (valor_troca,data_troca,id_venda) VALUES (@valor,@data, @idVenda)

	select @id = id_troca from Troca where data_troca = @data
	return @id
go


/*==============================================================*/
/* Procedure: spSelectCategoria                                 */
/*==============================================================*/
create procedure [dbo].[spSelectCategoria]
	@codCategoria int
AS
	select id_categoria, descricao_categoria from Categoria_produto where id_categoria = @codCategoria
go


/*==============================================================*/
/* Procedure: spSelectSubCategoria                              */
/*==============================================================*/
create procedure [dbo].[spSelectSubCategoria]
	@codSubCategoria int
AS
	select id_categoria, descricao_subcategoria from SubCategoria_produto where id_subcategoria = @codSubCategoria
go


/*==============================================================*/
/* Procedure: spSelectProdutosBySubCategoria                    */
/*==============================================================*/
CREATE procedure [dbo].[spSelectProdutosBySubCategoria]
	@codsubcategoria int
AS
	select codigo, nome, descricao, quantidade, preco from v_produto_Categoria 
		where cod_subcategoria = @codsubcategoria
go


/*==============================================================*/
/* Procedure: spSelectProdutoById                              */
/*==============================================================*/
CREATE procedure [dbo].[spSelectProdutoById]
	@id int
AS
	select codigo, nome, descricao, quantidade, preco, cod_subcategoria from v_produto_Categoria 
		where codigo = @id
go
/*==============================================================*/
/* Procedure: spRecuperarProdutoById                             */
/*==============================================================*/
CREATE PROCEDURE spRecuperarProdutoById
@id bigint
AS
	select *from produto where id_produto = @id
go

/*==============================================================*/
/* Procedure: spBuscarLojaById                             */
/*==============================================================*/
CREATE PROCEDURE spBuscarLojaById
@id int
AS
SELECT *FROM LOJA WHERE ID_LOJA=@id
go
/*==============================================================*/
/* Procedure: spSelectProdutosByCategoria                       */
/*==============================================================*/
CREATE procedure [dbo].[spSelectProdutosByCategoria]
	@codCategoria int
AS
	select codigo, nome, descricao, quantidade, preco, cod_subcategoria from v_produto_Categoria 
		where cod_categoria = @codcategoria
go


/*==============================================================*/
/* Procedure: sp_Deletar_SubCategoria                           */
/*==============================================================*/
CREATE procedure [dbo].[sp_Deletar_SubCategoria]
	@ID_SUBCATEGORIA bigint
AS
	DELETE FROM SUBCATEGORIA WHERE ID_SUBCATEGORIA = @ID_SUBCATEGORIA
go


/*==============================================================*/
/* Procedure: sp_Deletar_Produto                                */
/*==============================================================*/
CREATE procedure [dbo].[sp_Deletar_Produto]
	@ID_PRODUTO bigint
AS
	DELETE FROM PRODUTO WHERE ID_PRODUTO = @ID_PRODUTO
go


/*==============================================================*/
/* Procedure: sp_Inserir_Produto                                */
/*==============================================================*/
CREATE procedure [dbo].[sp_Inserir_Produto]
	@ID_SUBCATEGORIA bigint, @ID_MEDIDA int, @NOME_PRODUTO varchar(50), 
	@DESCRICAO_PRODUTO varchar(250), @CUSTO decimal(10,2)
AS
	declare @id_produto bigint
	insert into produto (id_subcategoria,id_medida,nome_produto, descricao_produto, custo) 
		values (@ID_SUBCATEGORIA,@ID_MEDIDA,@NOME_PRODUTO,@DESCRICAO_PRODUTO,@CUSTO)
	select @id_produto = id_produto from produto where NOME_PRODUTO = @NOME_PRODUTO
	return @id_produto
go


/*==============================================================*/
/* Procedure: sp_Inserir_Item_Produto                           */
/*==============================================================*/
CREATE procedure [dbo].[sp_Inserir_Item_Produto]
	@ID_PRODUTO bigint, @ID_LOJA int, @QTD_ITEM_PRODUTO int, @PRECO_ITEM_PRODUTO decimal(10,2)
AS
	insert into item_produto (ID_PRODUTO,ID_LOJA,QTD_ITEM_PRODUTO,PRECO_ITEM_PRODUTO) 
		values (@ID_PRODUTO,@ID_LOJA,@QTD_ITEM_PRODUTO,@PRECO_ITEM_PRODUTO)
	declare @id_item_produto bigint
	SET @id_item_produto = (SELECT MAX(id_item_produto) FROM item_produto)
	return @id_item_produto
go


/*==============================================================*/
/* Procedure: sp_Deletar_Item_Produto                           */
/*==============================================================*/
CREATE procedure [dbo].[sp_Deletar_Item_Produto]
	@ID_ITEM_PRODUTO bigint
AS
	DELETE FROM ITEM_PRODUTO WHERE ID_ITEM_PRODUTO = @ID_ITEM_PRODUTO
go


/*==============================================================*/
/* Procedure: sp_Inserir_Cliente                                */
/*==============================================================*/
CREATE procedure [dbo].[sp_Inserir_Cliente]
	@NOME_CLIENTE varchar(100),@CPF varchar(11),@ID_USUARIO int
AS
	INSERT INTO cliente (NOME_CLIENTE, CPF, ID_USUARIO) 
		VALUES (@NOME_CLIENTE, @CPF, @ID_USUARIO)
go


/*==============================================================*/
/* Procedure: sp_Deletar_Cliente                                */
/*==============================================================*/
CREATE procedure [dbo].[sp_Deletar_Cliente]
	@ID_CLIENTE bigint
AS
	DELETE FROM CLIENTE WHERE ID_CLIENTE = @ID_CLIENTE
go


/*==============================================================*/
/* Procedure: sp_Inserir_Item_Troca                             */
/*==============================================================*/
CREATE procedure [dbo].[sp_Inserir_Item_Troca]
	@id_item_venda int, @id_troca int
AS
	INSERT INTO Item_Troca (id_item_venda, id_troca) VALUES (@id_item_venda,@id_troca)
go


/*==============================================================*/
/* Procedure: sp_Deletar_Categoria                              */
/*==============================================================*/
CREATE procedure [dbo].[sp_Deletar_Categoria]
	@ID_CATEGORIA bigint
AS
	DELETE FROM CATEGORIA_PRODUTO WHERE ID_CATEGORIA = @ID_CATEGORIA
go


/*==============================================================*/
/* Procedure: sp_Inserir_Categoria                              */
/*==============================================================*/
CREATE procedure [dbo].[sp_Inserir_Categoria]
	@DESCRICAO_CATEGORIA varchar(50)
AS
	insert into CATEGORIA_PRODUTO (descricao_categoria) 
		values (@DESCRICAO_CATEGORIA )
	declare @id_categoria int
	SET @id_categoria = (SELECT MAX(id_categoria) FROM CATEGORIA_PRODUTO)
	return @id_categoria
go


/*==============================================================*/
/* Procedure: sp_Inserir_SubCategoria                           */
/*==============================================================*/
CREATE procedure [dbo].[sp_Inserir_SubCategoria]
	@ID_CATEGORIA bigint, @DESCRICAO_SUBCATEGORIA varchar(50)
AS
	insert into SUBCATEGORIA_PRODUTO (id_categoria, descricao_subcategoria) 
		values (@ID_CATEGORIA, @DESCRICAO_SUBCATEGORIA)
	declare @id_subCategoria int
	SET @id_subCategoria = (SELECT MAX(id_subcategoria) FROM SubCATEGORIA_PRODUTO)
	return @id_subCategoria
go

/*==============================================================*/
/* Procedure: spTrocarItemDeVenda                               */
/*==============================================================*/
CREATE procedure [dbo].[spTrocarItemDeVenda]
	@ID_ITEM_VENDA bigint
AS
	UPDATE ITEM_VENDA SET ID_ESTADO_ITEM_VENDA = 3 WHERE ID_ITEM_VENDA = @ID_ITEM_VENDA
go


/*==============================================================*/
/* Procedure: sp_RegistrarItemTrocado                           */
/*==============================================================*/
CREATE procedure [dbo].[sp_RegistrarItemTrocado]
	@ID_ITEM_VENDA bigint, @id_troca int
AS
	insert into item_troca (id_item_venda, id_troca) values (@ID_ITEM_VENDA, @id_troca)
go

/*==============================================================*/
/* Procedure: sp_SelectItemProdutoByCodigoProduto               */
/*==============================================================*/
create procedure sp_SelectItemProdutoByCodigoProduto
@codProduto bigint, @idLoja int
as
select ip.* from item_produto ip
join produto p on p.id_produto = ip.id_produto
where p.codigo_Produto = @codproduto and ip.id_loja = @idLoja
go

/*==============================================================*/
/* Procedure: spSelectSubCategoriasByCategoria                  */
/*==============================================================*/
create procedure spSelectSubCategoriasByCategoria
@codCategoria int
as
select id_subcategoria , descricao_subcategoria from subcategoria_produto where id_categoria = @codCategoria
go

/*==============================================================*/
/* Procedure: sp_Inserir_Medida                                 */
/*==============================================================*/
create procedure sp_Inserir_Medida
@DESCRICAO_MEDIDA varchar(50)
as
	insert into MEDIDA ( descricao_medida)values (@DESCRICAO_MEDIDA)
	declare @id_medida int
	SET @id_medida = (SELECT MAX(id_medida) FROM MEDIDA)
	return @id_medida
go

/*==============================================================*/
/* Procedure: sp_Deletar_Medida                                 */
/*==============================================================*/
create procedure sp_Deletar_Medida
@codigo int
as
	delete from Medida where id_medida = @codigo
go

/*==============================================================*/
/* Procedure: AutenticarUsuario									*/
/*==============================================================*/
CREATE PROCEDURE AutenticarUsuario
@login varchar(255),
@senha varchar(255)
AS
DECLARE @resultado bit
SELECT @resultado = PWDCOMPARE(@senha,senha, 0) FROM USUARIO WHERE login = @login
IF(@resultado = 1)
  SELECT id_usuario, email FROM USUARIO WHERE login = @login
GO

/*======================================================================================================================*/
/*======================================================================================================================*/
/*======================================================================================================================*/
/*================================               VIEW           ========================================================*/
/*======================================================================================================================*/
/*======================================================================================================================*/
/*======================================================================================================================*/

/*==============================================================*/
/* View: v_produto_Categoria                                    */
/*==============================================================*/
create view [dbo].[v_produto_Categoria]
as
SELECT p.id_produto as codigo, p.nome_produto as nome,p.descricao_produto as descricao, 
	ip.qtd_item_Produto as quantidade, p.custo as preco, 
	p.id_subcategoria as cod_subcategoria,c.id_categoria as cod_categoria
from produto p
	join item_produto ip on ip.id_produto = p.id_produto
	join subcategoria_produto s on s.id_subcategoria = p.id_subcategoria
	join categoria_produto c on c.id_categoria = s.id_categoria
go

/*==============================================================*/
/* View: V_Item_Venda                                           */
/*==============================================================*/
create view V_Item_Venda
as
select ip.id_item_produto as codigo, p.descricao_produto as descricao, iv.qtd_item_venda as quantidade, 
	ip.preco_item_produto as valor, iv.id_Venda
from Item_Venda iv
	join item_produto ip on ip.id_item_produto = iv.id_item_produto
	join produto p on p.id_produto = ip.id_produto
go

/*==============================================================*/  
/* View: SelectProduto											*/  
/*==============================================================*/  
CREATE VIEW SelectProduto  
AS  
SELECT * FROM PRODUTO
GO
/*==============================================================*/
/* View: SelectCategoriaProduto									*/
/*==============================================================*/
CREATE VIEW SelectCategoriaProduto   
AS    
SELECT * FROM CATEGORIA_PRODUTO
GO

/*======================================================================================================================*/
/*======================================================================================================================*/
/*======================================================================================================================*/
/*==============================               FUNCTION           ======================================================*/
/*======================================================================================================================*/
/*======================================================================================================================*/
/*======================================================================================================================*/

/*==============================================================*/
/* Function: precoItemDeVenda                                   */
/*==============================================================*/
create function [dbo].[precoItemDeVenda](@qtd int, @preco decimal(12,2))
returns decimal
as
begin
	return @qtd*@preco
end
go


/*==============================================================*/
/* Function: precoVenda                                         */
/*==============================================================*/
CREATE function [dbo].[precoVenda] (@codVenda int)
returns decimal
as
begin

	DECLARE @qtd int
	DECLARE @preco decimal(12,2)
	DECLARE @precoVenda decimal(12,2)
	
	set @precoVenda = 0
	
	DECLARE valorItem CURSOR
		LOCAL
		STATIC
		FOR select iv.qtd_item_venda, ip.preco_item_produto from item_venda iv 
			JOIN item_produto ip on ip.id_item_produto = iv.id_item_produto
			where iv.id_venda = @codVenda
	OPEN valorItem
	FETCH FIRST FROM valorItem INTO @qtd,@preco
	WHILE (@@FETCH_STATUS=0)
	begin
		set @precoVenda = @precoVenda + dbo.precoItemDeVenda(@qtd, @preco)
		FETCH NEXT FROM valorItem INTO @qtd,@preco
	end
	CLOSE valorItem
	DEALLOCATE valorItem

	return @precoVenda
end
go
/*==============================================================*/
/* Function: fcSelectItemProdutoByCodigoProduto                                         */
/*==============================================================*/
CREATE FUNCTION [dbo].fcSelectItemProdutoByCodigoProduto(@codProduto bigint, @idLoja int)
RETURNS @ItemProduto Table(
	ID_ITEM_PRODUTO      bigint               not null,
	ID_PRODUTO           bigint               not null,
	ID_LOJA              int                  not null,
	QTD_ITEM_PRODUTO     int                  not null,
	PRECO_ITEM_PRODUTO   decimal(10,2)        not null
 )  
AS
BEGIN
	DECLARE @idProduto bigint
	SET @idProduto = (SELECT ID_PRODUTO FROM PRODUTO WHERE CODIGO_PRODUTO=@codProduto)
    INSERT @ItemProduto  SELECT *FROM ITEM_PRODUTO WHERE ID_PRODUTO=@idProduto AND ID_LOJA = @idLoja
	RETURN
END
go
/*======================================================================================================================*/
/*======================================================================================================================*/
/*======================================================================================================================*/
/*==============================               TRIGGER            ======================================================*/
/*======================================================================================================================*/
/*======================================================================================================================*/
/*======================================================================================================================*/

/*==============================================================*/
/* Trigger: t_baixa_estoque                                     */
/*==============================================================*/
create trigger [dbo].[t_baixa_estoque]
on [dbo].[ITEM_VENDA]
for insert
as
	UPDATE Item_produto SET
	qtd_item_produto = qtd_item_produto-Inserted.qtd_item_venda
	FROM item_produto, Inserted
	Where item_produto.id_item_produto = inserted.id_item_produto
	IF @@ERROR <> 0
	BEGIN
		ROLLBACK TRANSACTION
		RAISERROR('Erro de Processamento – Chame o Administrador', 16,1)
		RETURN
	END
go


/*==============================================================*/
/* Trigger: t_alta_estoque                                      */
/*==============================================================*/
create trigger [dbo].[t_alta_estoque]
on [dbo].[ITEM_TROCA]
for insert
as
	UPDATE Item_produto SET
	qtd_item_produto = qtd_item_produto-item_venda.qtd_item_venda
	FROM item_produto, Inserted, item_venda
	Where inserted.id_item_venda = item_venda.id_item_venda
		and item_produto.id_item_produto = item_venda.id_item_produto
	IF @@ERROR <> 0
	BEGIN
		ROLLBACK TRANSACTION
		RAISERROR('Erro de Processamento – Chame o Administrador', 16,1)
		RETURN
	END
go


/*==============================================================*/
/* Trigger: t_tel_prop                                          */
/*==============================================================*/
create trigger [dbo].[t_tel_prop]
on [dbo].[TELEFONE]
for insert
as
	declare @prop varchar(15)
	declare @id_prop bigint

	select @prop = descricao_tipo from tipo_proprietario,inserted  
		where tipo_proprietario.id_tipo_prop = inserted.id_proprietario

	set @id_prop = 0

	if @prop = 'cliente'
		select @id_prop = id_cliente from cliente,inserted  where id_cliente = inserted.id_proprietario
	else if @prop = 'funcionario'
		select @id_prop = id_func from funcionario,inserted  where id_func = inserted.id_proprietario
	else if @prop = 'loja'
		select @id_prop = id_loja from loja,inserted where id_loja = inserted.id_proprietario

	IF @id_prop = 0
	BEGIN
		ROLLBACK TRANSACTION
		RAISERROR('Erro de Processamento – erro de integridade', 16,1)
		RETURN
	END
go


/*==============================================================*/
/* Trigger: t_endereco_prop                                     */
/*==============================================================*/
create trigger [dbo].[t_endereco_prop]
on [dbo].[ENDERECO]
for insert
as
	declare @prop varchar(15)
	declare @id_prop bigint

	select @prop = descricao_tipo from tipo_proprietario,inserted  
		where tipo_proprietario.id_tipo_prop = inserted.id_proprietario

	set @id_prop = 0

	if @prop = 'cliente'
		select @id_prop = id_cliente from cliente,inserted  where id_cliente = inserted.id_proprietario
	else if @prop = 'funcionario'
		select @id_prop = id_func from funcionario,inserted  where id_func = inserted.id_proprietario
	else if @prop = 'loja'
		select @id_prop = id_loja from loja,inserted where id_loja = inserted.id_proprietario

	IF @id_prop = 0
	BEGIN
		ROLLBACK TRANSACTION
		RAISERROR('Erro de Processamento – erro de integridade', 16,1)
		RETURN
	END
go


/*======================================================================================================================*/
/*======================================================================================================================*/
/*======================================================================================================================*/
/*==============================               INSERTS            ======================================================*/
/*======================================================================================================================*/
/*======================================================================================================================*/
/*======================================================================================================================*/

INSERT INTO ESTADO_ITEM_VENDA (DESCRICAO_ESTADO_ITEM_VENDA) VALUES ('DEVOLVIDO')
INSERT INTO ESTADO_ITEM_VENDA (DESCRICAO_ESTADO_ITEM_VENDA) VALUES ('ENTREGUE')
INSERT INTO ESTADO_ITEM_VENDA (DESCRICAO_ESTADO_ITEM_VENDA) VALUES ('TROCADO')



