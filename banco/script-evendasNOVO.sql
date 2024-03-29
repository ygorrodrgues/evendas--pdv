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
/*create table CARTAO (
ID_CARTAO            int                  not null identity,
ID_CLIENTE           bigint               not null,
LIMITE				decimal(10,2)			not null,
constraint PK_CARTAO primary key  (ID_CARTAO),
constraint FK_CARTAO_RELATIONS_CLIENTE foreign key (ID_CLIENTE)
      references CLIENTE (ID_CLIENTE)
)
go
*/
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
ID_ESTADO_ITEM_VENDA smallint             not null  DEFAULT ((2)),
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
/*create table PARCELAS (
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
*/
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
/* Table: ENDERECO_CLIENTE                                      */
/*==============================================================*/
create table ENDERECO_CLIENTE (
ID_ENDERECO_CLIENTE           bigint               not null identity,
ID_CLIENTE      bigint               not null,
ID_MUNICIPIO      INT               not null,
LOGRADOURO [varchar] (250) NOT NULL,
BAIRRO [varchar] (250) NOT NULL,
NUMERO INT NOT NULL,
CEP bigint NOT NULL,
constraint PK_ENDERECO_CLIENTE primary key  (ID_ENDERECO_CLIENTE),
constraint FK_ENDERECO_CLIENTE_RELATIONS_CLIENTE foreign key (ID_CLIENTE)
      references CLIENTE (ID_CLIENTE),
constraint FK_ENDERECO_CLIENTE_RELATIONS_MUNICIPIO foreign key (ID_MUNICIPIO)
      references MUNICIPIO (ID_MUNICIPIO)
)
go


/*==============================================================*/
/* Table: ENDERECO_FUNCIONARIO                                  */
/*==============================================================*/
create table ENDERECO_FUNCIONARIO (
ID_ENDERECO_FUNCIONARIO           bigint               not null identity,
ID_FUNC      bigint               not null,
ID_MUNICIPIO      INT               not null,
LOGRADOURO [varchar] (250) NOT NULL,
BAIRRO [varchar] (250) NOT NULL,
NUMERO INT NOT NULL,
CEP bigint NOT NULL,
constraint PK_ENDERECO_FUNCIONARIO primary key  (ID_ENDERECO_FUNCIONARIO),
constraint FK_ENDERECO_FUNC_RELATIONS_FUNCIONARIO foreign key (ID_FUNC)
      references FUNCIONARIO (ID_FUNC),
constraint FK_ENDERECO_FUNC_RELATIONS_MUNICIPIO foreign key (ID_MUNICIPIO)
      references MUNICIPIO (ID_MUNICIPIO)
)
go


/*==============================================================*/
/* Table: ENDERECO_LOJA                                         */
/*==============================================================*/
create table ENDERECO_LOJA (
ID_ENDERECO_LOJA          bigint               not null identity,
ID_LOJA        int               not null,
ID_MUNICIPIO      INT               not null,
LOGRADOURO [varchar] (250) NOT NULL,
BAIRRO [varchar] (250) NOT NULL,
NUMERO INT NOT NULL,
CEP bigint NOT NULL,
constraint PK_ENDERECO_LOJA primary key  (ID_ENDERECO_LOJA),
constraint FK_ENDERECO_LOJA_RELATIONS_LOJA foreign key (ID_LOJA)
      references LOJA (ID_LOJA),
constraint FK_ENDERECO_LOJA_RELATIONS_MUNICIPIO foreign key (ID_MUNICIPIO)
      references MUNICIPIO (ID_MUNICIPIO)
)
go

/*==============================================================*/
/* Table: TELEFONE_CLIENTE                                      */
/*==============================================================*/
create table TELEFONE_CLIENTE (
ID_TELEFONE_CLIENTE           int               not null identity,
ID_CLIENTE      bigint               not null,
DDD SMALLINT NOT NULL,
NUMERO INT NOT NULL,
constraint PK_TELEFONE_CLIENTE primary key  (ID_TELEFONE_CLIENTE),
constraint FK_TELEFONE_CLIENTE_RELATIONS_CLIENTE foreign key (ID_CLIENTE)
      references CLIENTE (ID_CLIENTE)
)
go

/*==============================================================*/
/* Table: TELEFONE_FUNCIONARIO                                  */
/*==============================================================*/
create table TELEFONE_FUNCIONARIO (
ID_TELEFONE_FUNCIONARIO           int               not null identity,
ID_FUNC      bigint               not null,
DDD SMALLINT NOT NULL,
NUMERO INT NOT NULL,
constraint PK_TELEFONE_FUNCIONARIO primary key  (ID_TELEFONE_FUNCIONARIO),
constraint FK_TELEFONE_FUNC_RELATIONS_FUNCIONARIO foreign key (ID_FUNC)
      references FUNCIONARIO (ID_FUNC)
)
go

/*==============================================================*/
/* Table: TELEFONE_LOJA                                         */
/*==============================================================*/
create table TELEFONE_LOJA (
ID_TELEFONE_LOJA           int               not null identity,
ID_LOJA             int               not null,
DDD SMALLINT NOT NULL,
NUMERO INT NOT NULL,
constraint PK_TELEFONE_LOJA primary key  (ID_TELEFONE_LOJA),
constraint FK_TELEFONE_LOJA_RELATIONS_LOJA foreign key (ID_LOJA)
      references LOJA (ID_LOJA)
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
/* Procedure: spSelectCategoria - CategoriaDaoSgbd.obterPorId   */
/*==============================================================*/
create procedure [dbo].[spSelectCategoria]
	@codCategoria int
AS
	select id_categoria, descricao_categoria from Categoria_produto where id_categoria = @codCategoria
go

--exec spSelectCategoria 1
/*==============================================================*/
/* Procedure: sp_Inserir_Categoria - CategoriaDaoSgbd.inserir   */
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

--exec sp_Inserir_Categoria 'teste'
/*==============================================================*/
/* Procedure: sp_Deletar_Categoria - CategoriaDaoSgbd.deletar   */
/*==============================================================*/
CREATE procedure [dbo].[sp_Deletar_Categoria]
	@ID_CATEGORIA bigint
AS
	DELETE FROM CATEGORIA_PRODUTO WHERE ID_CATEGORIA = @ID_CATEGORIA
go

--exec sp_Deletar_Categoria 2
/*==============================================================*/
/* Procedure: sp_Select_Categoria - CategoriaDaoSgbd.recuperarCategorias   */
/*==============================================================*/
CREATE procedure sp_Select_Categoria
AS
	select id_categoria, descricao_categoria from categoria_produto
go
select * from categoria_produto
--exec sp_Select_Categoria
/*==============================================================*/
/* PROCEDURE spLigarTrocaAoPagamento - CupomDeTrocaDaoSgbd.ligarTrocaAoPagamento  */
/*==============================================================*/
CREATE PROCEDURE spLigarTrocaAoPagamento
@idTroca bigint,
@idPagamento bigint
AS
UPDATE TROCA SET ID_PAGAMENTO = @idPagamento WHERE(ID_TROCA = @idTroca)
go

--exec spLigarTrocaAoPagamento 1,1
--select * from troca
/*==============================================================*/
/* Procedure: spSelectTroca - CupomDeTrocaDaoSgbd.existe        */
/*==============================================================*/
create procedure [dbo].[spSelectTroca]
	@codCupom int
AS
	declare @id int 
	select @id = id_troca from Troca where id_troca = @codCupom
	return @id
go

--exec spSelectTroca 1
/*==============================================================*/
/* Procedure: spInserirCupom - CupomDeTrocaDaoSgbd.inserir      */
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

--exec spInserirCupom 1,10
/*==============================================================*/
/* Procedure: sp_RegistrarItemTrocado - CupomDeTrocaDaoSgbd.registraItemTrocado     */
/*==============================================================*/
CREATE procedure [dbo].[sp_RegistrarItemTrocado]
	@ID_ITEM_VENDA bigint, @id_troca int
AS
	insert into item_troca (id_item_venda, id_troca) values (@ID_ITEM_VENDA, @id_troca)
go

--exec sp_RegistrarItemTrocado 2,1

/*==============================================================*/
/* Procedure: sp_Inserir_Item_Produto - ItemProdutoDaoSgbd.inserir */
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

--exec sp_Inserir_Item_Produto 1,1,11,10
/*==============================================================*/
/* Procedure: sp_Deletar_Item_Produto - ItemProdutoDaoSgbd.deletar  */
/*==============================================================*/
CREATE procedure [dbo].[sp_Deletar_Item_Produto]
	@ID_ITEM_PRODUTO bigint
AS
	DELETE FROM ITEM_PRODUTO WHERE ID_ITEM_PRODUTO = @ID_ITEM_PRODUTO
go


--exec sp_Deletar_Item_Produto 3
/*==============================================================*/
/* Procedure: sp_SelectItemProdutoByCodigoProduto - ItemProdutoDaoSgbd.SelectItemProdutoByCodigoProduto*/
/*==============================================================*/
create procedure sp_SelectItemProdutoByCodigoProduto
@codProduto bigint, @idLoja int
as
select ip.* from item_produto ip
join produto p on p.id_produto = ip.id_produto
where p.codigo_Produto = @codproduto and ip.id_loja = @idLoja
go

--exec sp_SelectItemProdutoByCodigoProduto 2,1
/*==============================================================*/
/* Procedure: sp_SelectItensProduto - ItemProdutoDaoSgbd.recuperarItensProduto*/
/*==============================================================*/
create procedure sp_SelectItensProduto
as
select * from item_produto 
go

--exec sp_SelectItensProduto
/*==============================================================*/
/* PROCEDURE spRegistrarItemVenda - ItemVendaDaoSgbd.registrarItemDeVenda  */
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

--exec spRegistrarItemVenda 1,1,'entregue',10
/*==============================================================*/
/* Procedure: spObterItensDeVendaPorVenda - ItemVendaDaoSgbd.obterItensPorVenda */
/*==============================================================*/
CREATE procedure [dbo].[spObterItensDeVendaPorVenda]
	@codVenda int
as
	print @codVenda
	select codigo, descricao, quantidade, valor from V_Item_Venda where id_Venda =  @codVenda
go

--exec spObterItensDeVendaPorVenda 1
/*==============================================================*/
/* Procedure: spTrocarItemDeVenda - ItemVendaDaoSgbd.trocar    */
/*==============================================================*/
CREATE procedure [dbo].[spTrocarItemDeVenda]
	@ID_ITEM_VENDA bigint
AS
	UPDATE ITEM_VENDA SET ID_ESTADO_ITEM_VENDA = 3 WHERE ID_ITEM_VENDA = @ID_ITEM_VENDA
go

--exec spTrocarItemDeVenda 4
--select * from item_Venda
/*==============================================================*/
/* Procedure: spBuscarLojaById - LojaDaoSgbd.buscarLojaById */
/*==============================================================*/
CREATE PROCEDURE spBuscarLojaById
@id int
AS
SELECT *FROM LOJA WHERE ID_LOJA=@id
go

--exec spBuscarLojaById 1
/*==============================================================*/
/* Procedure: sp_Inserir_Medida - MedidaDaoSgbd.inserir         */
/*==============================================================*/
create procedure sp_Inserir_Medida
@DESCRICAO_MEDIDA varchar(50)
as
	insert into MEDIDA ( descricao_medida)values (@DESCRICAO_MEDIDA)
	declare @id_medida int
	SET @id_medida = (SELECT MAX(id_medida) FROM MEDIDA)
	return @id_medida
go

--exec sp_Inserir_Medida 'teste'
--exec spSelectMedidas
/*==============================================================*/
/* Procedure: sp_Deletar_Medida - MedidaDaoSgbd.deletar         */
/*==============================================================*/
create procedure sp_Deletar_Medida
@codigo int
as
	delete from Medida where id_medida = @codigo
go

--exec sp_Deletar_Medida 6
/*==============================================================*/
/* Procedure: spSelectMedidas - MedidaDaoSgbd.recuperarMedidas         */
/*==============================================================*/
create procedure spSelectMedidas
as
	select id_medida, descricao_medida from medida
go

--exec spSelectMedidas
/*==============================================================*/
/* PROCEDURE spRegistrarPagamento - PagamentoDaoSgbd.registrarPagamento */
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

--exec spRegistrarPagamento 'dinheiro',1,2
--select *  from tipo_pagamento
--select * from pagamento
/*==============================================================*/
/* PROCEDURE spRegistrarParcela - ParcelaDaoSgbd.registrarParcela */
/*==============================================================*/
/*CREATE PROCEDURE spRegistrarParcela
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
*/
--exec spRegistrarParcela 
/*==============================================================*/
/* Procedure: spSelectProdutosBySubCategoria - ProdutoDaoSgbd.recuperarProdutosSubCategoria */
/*==============================================================*/
CREATE procedure [dbo].[spSelectProdutosBySubCategoria]
	@codsubcategoria int
AS
	select id,codigo, nome, descricao, quantidade, preco from v_produto_Categoria 
		where cod_subcategoria = @codsubcategoria
go

--exec spSelectProdutosBySubCategoria 1
/*==============================================================*/
/* Procedure: spSelectProdutoById - ProdutoDaoSgbd.recuperarProduto */
/*==============================================================*/
CREATE procedure [dbo].[spSelectProdutoById]
	@id int
AS
	select id,codigo, nome, descricao, quantidade, preco, cod_subcategoria from v_produto_Categoria 
		where id = @id
go

--exec spSelectProdutoById 1
/*==============================================================*/
/* Procedure: spRecuperarProdutoById - ProdutoDaoSgbd.buscarProduto*/
/*==============================================================*/
CREATE PROCEDURE spRecuperarProdutoById
@id bigint
AS
	select *from produto where id_produto = @id
go

--exec spRecuperarProdutoById 2
/*==============================================================*/
/* Procedure: spSelectProdutos - ProdutoDaoSgbd.recuperarProdutos*/
/*==============================================================*/
CREATE PROCEDURE spSelectProdutos
AS
	select id,codigo, nome, descricao, quantidade, preco, cod_subcategoria from v_produto_Categoria 
go

--exec spSelectProdutos
/*==============================================================*/
/* Procedure: spSelectProdutosByCategoria - ProdutoDaoSgbd.recuperarProdutosCategoria */
/*==============================================================*/
CREATE procedure [dbo].[spSelectProdutosByCategoria]
	@codCategoria int
AS
	select id,codigo, nome, descricao, quantidade, preco, cod_subcategoria from v_produto_Categoria 
		where cod_categoria = @codcategoria
go

--exec spSelectProdutosByCategoria 1
/*==============================================================*/
/* Procedure: sp_Inserir_Produto - ProdutoDaoSgbd.inserir       */
/*==============================================================*/
CREATE procedure [dbo].[sp_Inserir_Produto]
	@codigo_produto bigint,@ID_SUBCATEGORIA bigint, @ID_MEDIDA int, @NOME_PRODUTO varchar(50), 
	@DESCRICAO_PRODUTO varchar(250), @CUSTO decimal(10,2)
AS
	declare @id_produto bigint
	insert into produto (codigo_produto,id_subcategoria,id_medida,nome_produto, descricao_produto, custo) 
		values (@codigo_produto,@ID_SUBCATEGORIA,@ID_MEDIDA,@NOME_PRODUTO,@DESCRICAO_PRODUTO,@CUSTO)
	select @id_produto = id_produto from produto where NOME_PRODUTO = @NOME_PRODUTO
	return @id_produto
go

--select * from produto
--exec sp_Inserir_Produto 123456789,1,1,'teste','teste',10
/*==============================================================*/
/* Procedure: sp_Deletar_Produto - ProdutoDaoSgbd.deletar       */
/*==============================================================*/
CREATE procedure [dbo].[sp_Deletar_Produto]
	@ID_PRODUTO bigint
AS
	DELETE FROM PRODUTO WHERE ID_PRODUTO = @ID_PRODUTO
go

--exec sp_Deletar_Produto 3
/*==============================================================*/
/* Procedure: spSelectSubCategoria - SubCategoriaDaoSgbd.obterPorId */
/*==============================================================*/
create procedure [dbo].[spSelectSubCategoria]
	@codSubCategoria int
AS
	select id_categoria, descricao_subcategoria from SubCategoria_produto where id_subcategoria = @codSubCategoria
go

--exec spSelectSubCategoria 1
/*==============================================================*/
/* Procedure: sp_Inserir_SubCategoria - SubCategoriaDaoSgbd.inserir */
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

--exec sp_Inserir_SubCategoria 1,'teste'
--exec spSelectSubCategorias
/*==============================================================*/
/* Procedure: sp_Deletar_SubCategoria - SubCategoriaDaoSgbd.deletar */
/*==============================================================*/
CREATE procedure [dbo].[sp_Deletar_SubCategoria]
	@ID_SUBCATEGORIA bigint
AS
	DELETE FROM SUBCATEGORIA_PRODUTO WHERE ID_SUBCATEGORIA = @ID_SUBCATEGORIA
go

--exec sp_Deletar_SubCategoria 2
/*==============================================================*/
/* Procedure: spSelectSubCategorias - SubCategoriaDaoSgbd.recuperarSubCategorias*/
/*==============================================================*/
create procedure spSelectSubCategorias
as
select id_subcategoria , id_categoria, descricao_subcategoria from subcategoria_produto
go

--exec spSelectSubCategorias
/*==============================================================*/
/* Procedure: spSelectSubCategoriasByCategoria - SubCategoriaDaoSgbd.recuperarSubCategoriasPorCategoria*/
/*==============================================================*/
create procedure spSelectSubCategoriasByCategoria
@codCategoria int
as
select id_subcategoria , descricao_subcategoria from subcategoria_produto where id_categoria = @codCategoria
go

--exec spSelectSubCategoriasByCategoria 1
/*==============================================================*/
/* PROCEDURE spRegistrarVenda - VendaDaoSgbd.registrarVenda     */
/*==============================================================*/
CREATE PROCEDURE spRegistrarVenda
@idFunc int,
@idPDV int,
@idCliente bigint,
@dataVenda datetime
AS
	DECLARE @retorno bigint
	DECLARE @dataV datetime
	/* N�o sei como coverter o Date do java para o datetime do sql server */
	SET @dataVenda = (select convert(varchar(20), getdate()))
	INSERT INTO Venda(ID_FUNC, ID_PDV, ID_CLIENTE, DATA_VENDA) VALUES(@idFunc, @idPDV, @idCliente, @dataVenda)
	SET @retorno = (SELECT MAX(id_venda) FROM Venda)
	RETURN(@retorno)
go

--declare @date datetime
--set @date = getdate()
--exec spRegistrarVenda 1,1,1,@date
--select * from venda
/*==============================================================*/
/* Procedure: spRealizarTroca - VendaDaoSgbd.realizarTroca      */
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

--select * from produto
--select * from item_venda
--exec spRealizarTroca 1,2,5
/*==============================================================*/
/* Procedure: spObterVendaPorCod - VendaDaoSgbd.obterPorCodigo  */
/*==============================================================*/
create procedure [dbo].[spObterVendaPorCod]
	@codVenda int
AS
SELECT v.id_venda as codigo, v.data_venda as data , dbo.precoVenda(v.id_venda) AS valor 
FROM venda v WHERE v.id_venda = @codVenda 
go

--exec spObterVendaPorCod 1
/*==============================================================*/
/* Procedure: sp_Inserir_Cliente                                */
/*==============================================================*/
CREATE procedure [dbo].[sp_Inserir_Cliente]
	@NOME_CLIENTE varchar(100),@CPF varchar(11),@ID_USUARIO int
AS
	INSERT INTO cliente (NOME_CLIENTE, CPF, ID_USUARIO) 
		VALUES (@NOME_CLIENTE, @CPF, @ID_USUARIO)
go

--exec 
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
SELECT p.id_produto as id,p.codigo_produto as codigo, p.nome_produto as nome,p.descricao_produto as descricao, 
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
select iv.id_item_venda as codigo, p.descricao_produto as descricao, iv.qtd_item_venda as quantidade, 
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
/*==============================================================*/
/* View: SelectClienteEndereco									*/
/*==============================================================*/
CREATE VIEW SelectClienteEndereco
AS
SELECT U.ID_USUARIO, NOME_CLIENTE, EMAIL, CPF, LOGRADOURO, BAIRRO, NUMERO, CEP, M.NOME AS MUNICIPIO, NOME_ESTADO
FROM USUARIO U
INNER JOIN CLIENTE C ON C.ID_USUARIO = U.ID_USUARIO
INNER JOIN ENDERECO_CLIENTE E ON C.ID_CLIENTE = E.ID_CLIENTE
INNER JOIN MUNICIPIO M ON M.ID_MUNICIPIO = E.ID_MUNICIPIO
INNER JOIN ESTADO EST ON EST.ID_ESTADO = M.ID_ESTADO
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
returns decimal(12,2)
as
begin
	return @qtd*@preco
end
go


/*==============================================================*/
/* Function: precoVenda                                         */
/*==============================================================*/
CREATE function [dbo].[precoVenda] (@codVenda int)
returns decimal(12,2)
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
		RAISERROR('Erro de Processamento � Chame o Administrador', 16,1)
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
		RAISERROR('Erro de Processamento � Chame o Administrador', 16,1)
		RETURN
	END
go


/*==============================================================*/
/* Trigger: t_tel_prop                                          */
/*==============================================================*/
/*create trigger [dbo].[t_tel_prop]
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
		RAISERROR('Erro de Processamento � erro de integridade', 16,1)
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
		RAISERROR('Erro de Processamento � erro de integridade', 16,1)
		RETURN
	END
go*/


/*======================================================================================================================*/
/*======================================================================================================================*/
/*======================================================================================================================*/
/*==============================               INSERTS            ======================================================*/
/*======================================================================================================================*/
/*======================================================================================================================*/
/*======================================================================================================================*/

INSERT INTO TIPO_PAGAMENTO(DESCRICAO_TIPO_PAGAMENTO) VALUES('Cartao')
INSERT INTO TIPO_PAGAMENTO(DESCRICAO_TIPO_PAGAMENTO) VALUES('Dinheiro')
INSERT INTO TIPO_PAGAMENTO(DESCRICAO_TIPO_PAGAMENTO) VALUES('Troca')

INSERT INTO ESTADO_ITEM_VENDA (DESCRICAO_ESTADO_ITEM_VENDA) VALUES ('DEVOLVIDO')
INSERT INTO ESTADO_ITEM_VENDA (DESCRICAO_ESTADO_ITEM_VENDA) VALUES ('ENTREGUE')
INSERT INTO ESTADO_ITEM_VENDA (DESCRICAO_ESTADO_ITEM_VENDA) VALUES ('TROCADO')

INSERT INTO LOJA (NOME_LOJA) VALUES ('Loja 1')

INSERT INTO PDV(ID_LOJA) VALUES (1)

INSERT INTO USUARIO(LOGIN,SENHA, EMAIL) VALUES ('rafael',CONVERT(VARBINARY(255), PWDENCRYPT('rafael123')),'r4faelmf@gmail.com')

INSERT INTO ESTADO(NOME_ESTADO) VALUES ('RN')

INSERT INTO MUNICIPIO (NOME,ID_ESTADO) VALUES ('Natal',1)

INSERT INTO CLIENTE (NOME_CLIENTE,CPF) VALUES ('Fulano de Tal', '01234567891')

INSERT INTO FUNCIONARIO(ID_LOJA,ID_USUARIO,MATRICULA_FUNC,NOME_FUNC) VALUES (1,1,'2008','Beltrano')

INSERT INTO MEDIDA(DESCRICAO_MEDIDA) VALUES ('Kg')
INSERT INTO MEDIDA(DESCRICAO_MEDIDA) VALUES ('Lata')
INSERT INTO MEDIDA(DESCRICAO_MEDIDA) VALUES ('Litro')
INSERT INTO MEDIDA(DESCRICAO_MEDIDA) VALUES ('Grade')
INSERT INTO MEDIDA(DESCRICAO_MEDIDA) VALUES ('Caixa')

INSERT INTO CATEGORIA_PRODUTO(DESCRICAO_CATEGORIA) VALUES ('Alimentos')

INSERT INTO SUBCATEGORIA_PRODUTO(ID_CATEGORIA,DESCRICAO_SUBCATEGORIA) VALUES (1,'Massas')


INSERT INTO PRODUTO (CODIGO_PRODUTO,ID_SUBCATEGORIA,ID_MEDIDA,DESCRICAO_PRODUTO,NOME_PRODUTO,CUSTO) 
	VALUES (12345,1,1,'P�o de forma integral X sem fermento','P�o Integral X',0.03)
INSERT INTO PRODUTO (CODIGO_PRODUTO,ID_SUBCATEGORIA,ID_MEDIDA,DESCRICAO_PRODUTO,NOME_PRODUTO,CUSTO) 
	VALUES (54321,1,1,'Pizza de chocolate X, sem gordural trans','Pizza Choc X',1.59)

INSERT INTO ITEM_PRODUTO(ID_PRODUTO,ID_LOJA,QTD_ITEM_PRODUTO,PRECO_ITEM_PRODUTO) VALUES (1,1,200,0.12)
INSERT INTO ITEM_PRODUTO(ID_PRODUTO,ID_LOJA,QTD_ITEM_PRODUTO,PRECO_ITEM_PRODUTO) VALUES (2,1,20,5.55)
	


