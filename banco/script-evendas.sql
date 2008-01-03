/*==============================================================*/
/* Table: CATEGORIA_PRODUTO                                     */
/*==============================================================*/
create table CATEGORIA_PRODUTO (
ID_CATEGORIA         bigint               not null identity(1,1),
DESCRICAO_CATEGORIA  varchar(50)       COLLATE Latin1_General_CI_AS   not null,
constraint PK_CATEGORIA_PRODUTO primary key  (ID_CATEGORIA)
) ON [PRIMARY]
go

/*==============================================================*/
/* Table: SUBCATEGORIA_PRODUTO                               [dbo.] necessario?   */
/*==============================================================*/
create table SUBCATEGORIA_PRODUTO (
ID_SUBCATEGORIA      bigint               not null identity(1,1),
ID_CATEGORIA         bigint               not null,
DESCRICAO_SUBCATEGORIA varchar(50)      COLLATE Latin1_General_CI_AS  not null,
constraint PK_SUBCATEGORIA_PRODUTO primary key  (ID_SUBCATEGORIA),
constraint FK_SUBCATEG_RELATIONS_CATEGORI foreign key (ID_CATEGORIA)
      references CATEGORIA_PRODUTO (ID_CATEGORIA)
) ON [PRIMARY]
go

/*==============================================================*/
/* Table: MEDIDA                                                  */
/*==============================================================*/
CREATE TABLE [dbo].[MEDIDA] (
	[ID_MEDIDA] [int] NOT NULL identity(1,1),
	[DESCRICAO_MEDIDA] [varchar] (50) COLLATE Latin1_General_CI_AS NOT NULL,
	constraint PK_MEDIDA primary key (ID_MEDIDA)
) ON [PRIMARY]
GO

/*==============================================================*/
/* Table: PRODUTO                                               [dbo.] necessario?     */
/*==============================================================*/
create table PRODUTO (
ID_PRODUTO           bigint               not null identity(1,1),
ID_SUBCATEGORIA      bigint               not null,
NOME_PRODUTO   varchar(50)  COLLATE Latin1_General_CI_AS  not null,
[DESCRICAO_PRODUTO] [varchar] (250) COLLATE Latin1_General_CI_AS NOT NULL ,
[ID_MEDIDA] [int] NOT NULL ,
CUSTO                decimal(10,2)        not null,
constraint PK_PRODUTO primary key  (ID_PRODUTO),
constraint FK_PRODUTO_RELATIONS_SUBCATEG foreign key (ID_SUBCATEGORIA)
      references SUBCATEGORIA_PRODUTO (ID_SUBCATEGORIA),
constraint FK_PRODUTO_RELATIONS_MEDIDA foreign key (ID_MEDIDA)
      references MEDIDA (ID_MEDIDA)
)ON [PRIMARY]
go

/*==============================================================*/
/* Table: LOJA                                                  */
/*==============================================================*/
create table LOJA (
ID_LOJA              int                  not null identity(1,1),
NOME_LOJA            varchar(50) COLLATE Latin1_General_CI_AS not null,
constraint PK_LOJA primary key  (ID_LOJA)
) ON [PRIMARY]
go

/*==============================================================*/
/* Table: ITEM_PRODUTO                                          */
/*==============================================================*/
create table ITEM_PRODUTO (
ID_ITEM_PRODUTO      bigint               not null identity(1,1),
ID_PRODUTO           bigint               not null,
ID_LOJA              int                  not null,
QTD_ITEM_PRODUTO     int                  not null,
PRECO_ITEM_PRODUTO   decimal(10,2)        not null,
constraint PK_ITEM_PRODUTO primary key  (ID_ITEM_PRODUTO),
constraint FK_ITEM_PRO_RELATIONS_PRODUTO foreign key (ID_PRODUTO)
      references PRODUTO (ID_PRODUTO),
constraint FK_ITEM_PRO_RELATIONS_LOJA foreign key (ID_LOJA)
      references LOJA (ID_LOJA)
)ON [PRIMARY]
go


/*==============================================================*/
/* Table: ESTADO_ITEM_VENDA                                     */
/*==============================================================*/
create table ESTADO_ITEM_VENDA (
ID_ESTADO_ITEM_VENDA smallint             not null identity(1,1),
DESCRICAO_ESTADO_ITEM_VENDA varchar(15)  COLLATE Latin1_General_CI_AS  not null,
constraint PK_ESTADO_ITEM_VENDA primary key  (ID_ESTADO_ITEM_VENDA)
) ON [PRIMARY]
go

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO (
ID_USUARIO           int                  not null identity(1,1),
LOGIN                varchar(50) COLLATE Latin1_General_CI_AS  not null,
SENHA                varchar(250) COLLATE Latin1_General_CI_AS not null,
constraint PK_USUARIO primary key  (ID_USUARIO)
) ON [PRIMARY]
go

/*==============================================================*/
/* Table: CLIENTE                                               */
/*==============================================================*/
create table CLIENTE (
ID_CLIENTE           bigint               not null identity(1,1), 
NOME_CLIENTE         varchar(100)    COLLATE Latin1_General_CI_AS     not null,
CPF                  varchar(11)    COLLATE Latin1_General_CI_AS      not null,
ID_USUARIO           int                  null,
constraint PK_CLIENTE primary key  (ID_CLIENTE),
constraint FK_CLIENTE_RELATIONS_USUARIO foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO)
) ON [PRIMARY]
go

/*==============================================================*/
/* Table: FUNCIONARIO                                           */
/*==============================================================*/
create table FUNCIONARIO (
ID_FUNC              bigint               not null identity(1,1),
ID_LOJA              int                  not null,
ID_USUARIO           int                  null,
MATRICULA_FUNC       bigint               not null,
NOME_FUNC            varchar(100)    COLLATE Latin1_General_CI_AS not null,
constraint PK_FUNCIONARIO primary key  (ID_FUNC),
constraint FK_FUNCIONA_RELATIONS_USUARIO foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO),
constraint FK_FUNCIONA_RELATIONS_LOJA foreign key (ID_LOJA)
      references LOJA (ID_LOJA)
) ON [PRIMARY]
go

/*==============================================================*/
/* Table: CARTAO                                                */
/*==============================================================*/
create table CARTAO (
ID_CARTAO            int                  not null identity(1, 1),
ID_CLIENTE           bigint               not null,
LIMITE				decimal(10,2)			not null,
constraint PK_CARTAO primary key  (ID_CARTAO),
constraint FK_CARTAO_RELATIONS_CLIENTE foreign key (ID_CLIENTE)
      references CLIENTE (ID_CLIENTE)
) ON [PRIMARY]
go

/*==============================================================*/
/* Table: TIPO_PAGAMENTO                                        */
/*==============================================================*/
create table TIPO_PAGAMENTO (
ID_TIPO_PAGAMENTO    smallint             not null identity (1, 1),
DESCRICAO_TIPO_PAGAMENTO char(10)    COLLATE Latin1_General_CI_AS          not null,
constraint PK_TIPO_PAGAMENTO primary key  (ID_TIPO_PAGAMENTO)
) ON [PRIMARY]
go

/*==============================================================*/
/* Table: PDV                                                   */
/*==============================================================*/
create table PDV (
ID_PDV               int               not null identity(1, 1),
ID_LOJA              int               not null,
constraint PK_PDV primary key  (ID_PDV),
constraint FK_PDV_RELATIONS_LOJA foreign key (ID_LOJA)
      references LOJA (ID_LOJA)
)ON [PRIMARY]
go

/*==============================================================*/
/* Table: VENDA                                                 */
/*==============================================================*/
create table VENDA (
ID_VENDA             bigint               not null identity(1, 1),
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
	  
)ON [PRIMARY]

/*==============================================================*/
/* Table: ITEM_VENDA                                            */
/*==============================================================*/
create table ITEM_VENDA (
ID_ITEM_VENDA        int                  not null identity(1,1),
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
)ON [PRIMARY]
go

/*==============================================================*/
/* Table: PAGAMENTO                                             */
/*==============================================================*/
create table PAGAMENTO (
ID_PAGAMENTO         bigint               not null identity(1, 1) ,
ID_TIPO_PAGAMENTO    smallint             not null,
ID_VENDA             bigint               not null,
VALOR_PAGAMENTO      decimal(10,2)        not null,
constraint PK_PAGAMENTO primary key  (ID_PAGAMENTO),
constraint FK_PAGAMENT_RELATIONS_VENDA foreign key (ID_VENDA)
      references VENDA (ID_VENDA),
constraint FK_PAGAMENT_RELATIONS_TIPO_PAG foreign key (ID_TIPO_PAGAMENTO)
      references TIPO_PAGAMENTO (ID_TIPO_PAGAMENTO)
)ON [PRIMARY]
go

/*==============================================================*/
/* Table: TROCA                                                 */
/*==============================================================*/
create table TROCA (
ID_TROCA             int                  not null identity(1, 1),
ID_VENDA             bigint               not null,
DATA_TROCA           datetime             not null,
VALOR_TROCA          decimal(10,2)        not null,
ID_PAGAMENTO		bigint					null,
constraint PK_TROCA primary key  (ID_TROCA),
constraint FK_TROCA_RELATIONS_VENDA foreign key (ID_VENDA)
      references VENDA (ID_VENDA),
constraint FK_TROCA_RELATIONS_PAG foreign key (ID_PAGAMENTO)
      references PAGAMENTO (ID_PAGAMENTO)
) ON [PRIMARY]
go


/*==============================================================*/
/* Table: ITEM_TROCA                                            */
/*==============================================================*/
create table ITEM_TROCA (
ID_ITEM_TROCA        bigint             not null identity(1, 1),
ID_ITEM_VENDA        int                  not null,
ID_TROCA             int                  not null,
constraint PK_ITEM_TROCA primary key  (ID_ITEM_TROCA),
constraint FK_ITEM_TRO_RELATIONS_TROCA foreign key (ID_TROCA)
      references TROCA (ID_TROCA),
constraint FK_ITEM_TRO_RELATIONS_ITEM_VEN foreign key (ID_ITEM_VENDA)
      references ITEM_VENDA (ID_ITEM_VENDA)
)ON [PRIMARY]
go

/*==============================================================*/
/* Table: PARCELAS                                              */
/*==============================================================*/
create table PARCELAS (
ID_PARCELAS          bigint               not null identity(1, 1),
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
) ON [PRIMARY]
go

/*==============================================================*/
/* Table: ACAO_LOG                                              */
/*==============================================================*/
create table ACAO_LOG (
ID_ACAO_LOG          smallint             not null identity(1, 1),
DESCRICAO_ACAO_LOG   varchar(15)  COLLATE Latin1_General_CI_AS  not null,
constraint PK_ACAO_LOG primary key  (ID_ACAO_LOG)
) ON [PRIMARY]
go

/*==============================================================*/
/* Table: LOG                                                   */
/*==============================================================*/
create table LOG (
ID_LOG               int                  not null identity(1,1),
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
) ON [PRIMARY]
GO

/*==============================================================*/
/* Table: TIPO_PROPRIETARIO                                     */
/*==============================================================*/
create table TIPO_PROPRIETARIO (
ID_TIPO_PROP         int                  not null identity(1,1),
DESCRICAO_TIPO       varchar(15) COLLATE Latin1_General_CI_AS  not null,
constraint PK_TIPO_PROPRIETARIO primary key  (ID_TIPO_PROP)
)ON [PRIMARY]
go

/*==============================================================*/
/* Table: TELEFONE                                              */
/*==============================================================*/
create table TELEFONE (
ID_TELEFONE           bigint               not null identity(1,1),
ID_TIPO_PROP         int                  not null,
ID_PROPRIETARIO      bigint               not null,
constraint PK_TELEFONE primary key  (ID_TELEFONE),
constraint FK_TELEFONE_RELATIONS_TIPO_PRO foreign key (ID_TIPO_PROP)
      references TIPO_PROPRIETARIO (ID_TIPO_PROP)
)
go

/*==============================================================*/
/* Table: Estado                                            */
/*==============================================================*/
CREATE TABLE [dbo].[ESTADO] (
	[ID_ESTADO] [int] NOT NULL identity(1,1),
	[NOME_ESTADO] [varchar] (50) COLLATE Latin1_General_CI_AS NOT NULL,
	constraint PK_ESTADO primary key  (ID_ESTADO),
) ON [PRIMARY]
GO

/*==============================================================*/
/* Table: Municipio                                             */
/*==============================================================*/
CREATE TABLE [dbo].[MUNICIPIO] (
	[ID_MUNICIPIO] [int] NOT NULL identity(1,1),
	[NOME] [char] (10) COLLATE Latin1_General_CI_AS NOT NULL ,
	[ID_ESTADO] [int] NOT NULL,
	constraint PK_MUNICIPIO primary key  (ID_MUNICIPIO),
	constraint FK_MUNICIPIO_RELATIONS_MUNICIPIO foreign key (ID_ESTADO)
      references ESTADO (ID_ESTADO)
) ON [PRIMARY]
GO

/*==============================================================*/
/* Table: ENDERECO                                              */
/*==============================================================*/
CREATE TABLE [dbo].[ENDERECO] (
	[LOGRADOURO] [char] (10) COLLATE Latin1_General_CI_AS NOT NULL ,
	[BAIRRO] [char] (10) COLLATE Latin1_General_CI_AS NOT NULL ,
	[ID_MUNICIPIO] [int] NOT NULL ,
	[ID_ENDERECO] [bigint] IDENTITY (1, 1) NOT NULL ,
	[ID_TIPO_PROP] [int] NOT NULL,
	constraint PK_ENDERECO primary key  (ID_ENDERECO),
	constraint FK_ENDERECO_RELATIONS_TIPO_PRO foreign key (ID_TIPO_PROP)
      references TIPO_PROPRIETARIO (ID_TIPO_PROP),
	constraint FK_ENDERECO_RELATIONS_MUNICIPIO foreign key (ID_MUNICIPIO)
      references MUNICIPIO(ID_MUNICIPIO)
) ON [PRIMARY]
GO

/*==============================================================*/
/* Table: RELACAO_MEDIDA                                        */
/*==============================================================*/
CREATE TABLE [dbo].[RELACAO_MEDIDA] (
	[ID_MEDIDA_DE] [int] NOT NULL ,/* Quem é medida de?*/
	[ID_MEDIDA_P] [int] NOT NULL ,/* Quem é medida p?*/
	[FATOR_RELACAO] [float] NOT NULL 
) ON [PRIMARY]
GO

/*======================================================================================================================*/
/*======================================================================================================================*/
/*======================================================================================================================*/
/*================================               VIEWs        ========================================================*/
/*======================================================================================================================*/
/*======================================================================================================================*/
/*======================================================================================================================*/

/*==============================================================*/
/* View: v_produto_Categoria                                    */
/*==============================================================*/
create view [dbo].[v_produto_Categoria]
as
	SELECT p.id_produto, p.descricao_produto, ip.qtd_item_Produto, ip.preco_item_produto, p.id_subcategoria, 
		c.id_categoria from produto p
	join item_produto ip on ip.id_produto = p.id_produto
	join subcategoria_produto s on s.id_subcategoria = p.id_subcategoria
	join categoria_produto c on c.id_categoria = s.id_categoria
go

/*======================================================================================================================*/
/*======================================================================================================================*/
/*======================================================================================================================*/
/*==============================               PROCEDURES           ====================================================*/
/*======================================================================================================================*/
/*======================================================================================================================*/
/*======================================================================================================================*/

/*==============================================================*/
/*                      PROCEDURE spRegistrarVenda                                         */
/*==============================================================*/
CREATE PROCEDURE RegistrarVenda
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
	SET @retorno = (SELECT MAX(id_venda) FROM Vendas)
	RETURN(@retorno)
go

/*==============================================================*/
/*                      PROCEDURE spRegistrarItemVenda                                      */
/*==============================================================*/
CREATE PROCEDURE registrarItemVenda
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
CREATE PROCEDURE registrarParcela
@idPagamento bigint,
@idCartao bigint,
@dataVenc datetime,
@valorVenc decimal(10,2),
@numeroParcela int
AS
SET @dataVenc = getDate()+30*@numeroParcela;
insert into parcelas(ID_PAGAMENTO, ID_CARTAO, DATA_VENC, VALOR_VENC) 
	VALUES(@idPagamento, @idCartao, @dataVenc, @valorVenc)
	
/*==============================================================*/
/*                      PROCEDURE spLigarTrocaAoPagamento                                    */
/*==============================================================*/
CREATE PROCEDURE spLigarTrocaAoPagamento
@idTroca bigint,
@idPagamento bigint
AS
UPDATE TROCA SET ID_PAGAMENTO = @idPagamento WHERE(ID_TROCA = @idTroca)

/*==============================================================*/
/*                      PROCEDURE spRegistrarPagamento                                      */
/*==============================================================*/
CREATE PROCEDURE RegistrarPagamento
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
	select @codVenda = id_Venda from CupomDeTroca where id_troca = @numCupomTroca
	insert into Item_Venda (id_Venda, id_Item_Produto, qtd_item_venda) values (@codVenda, @codProduto, @qtd)
go


/*==============================================================*/
/* Procedure: spObterItensDeVendaPorVenda                       */
/*==============================================================*/
CREATE procedure [dbo].[spObterItensDeVendaPorVenda]
	@codVenda int
as
	select ip.id_item_produto, p.descricao_produto, iv.qtd_item_venda, ip.preco_item_produto from Item_Venda iv
	join item_produto ip on ip.id_item_produto = iv.id_item_produto
	join produto p on p.id_produto = ip.id_produto
	where id_Venda = @codVenda
go

/*==============================================================*/
/* Procedure: spObterVendaPorCod      e o retorno? isso não deveria ser uma funcao?                             */
/*==============================================================*/
CREATE procedure [dbo].[spObterVendaPorCod]
	@codVenda int
AS
	SELECT v.id_venda, v.data_venda, dbo.precoItemDeVenda(iv.qtd_item_venda, ip.preco_item_produto) AS preco FROM venda v
	JOIN item_venda iv ON iv.id_venda = v.id_venda
	JOIN item_produto ip on ip.id_item_produto = iv.id_item_produto
	WHERE v.id_venda = @codVenda 
go

/*==============================================================*/
/* Procedure: spInserirCupom                                    */
/*==============================================================*/
CREATE procedure [dbo].[spInserirCupom]
	@idVenda int, @valor decimal(12,2)
AS
	declare @id int
	/*palavra chave como variável */
	declare @data datetime 

	set @data = getdate()

	INSERT INTO Troca (valor_troca,data_troca,id_venda) VALUES (@valor,@data, @idVenda)

	select @id = id_troca from Troca where data_troca = @data
	return @id
go

/*==============================================================*/
/* Procedure: spSelectCategoria              retorno?                   */
/*==============================================================*/
create procedure [dbo].[spSelectCategoria]
	@codCategoria int
AS
	select * from Categoria_produto where id_categoria = @codCategoria
go


/*==============================================================*/
/* Procedure: spSelectSubCategoria                              */
/*==============================================================*/
create procedure [dbo].[spSelectSubCategoria]
	@codSubCategoria int
AS
	select * from SubCategoria_produto where id_subcategoria = @codSubCategoria
go


/*==============================================================*/
/* Procedure: spSelectProdutosBySubCategoria                    */
/*==============================================================*/
CREATE procedure [dbo].[spSelectProdutosBySubCategoria]
	@codsubcategoria int
AS
	select id_produto, descricao_produto, qtd_item_produto, preco_item_produto from v_produto_Categoria 
		where id_subcategoria = @codsubcategoria
go

/*==============================================================*/
/* Procedure: spSelectProdutosBySubCategoria                   retorno? */
/*==============================================================*/
CREATE procedure [dbo].[spSelectProdutosBySubCategoria]
	@codsubcategoria int
AS
	select id_produto, descricao_produto, qtd_item_produto, preco_item_produto from v_produto_Categoria 
		where id_subcategoria = @codsubcategoria

		
/*==============================================================*/
/* Procedure: spSelectProdutosById                  retorno?            */
/*==============================================================*/
CREATE procedure [dbo].[spSelectProdutosById]
	@id int
AS
	select id_produto, descricao_produto, qtd_item_produto, preco_item_produto, id_subcategoria 
		from v_produto_Categoria where id_produto = @id
go

/*==============================================================*/
/* Procedure: spSelectProdutosByCategoria                       */
/*==============================================================*/
CREATE procedure [dbo].[spSelectProdutosByCategoria]
	@codCategoria int
AS
	select id_produto, descricao_produto, qtd_item_produto, preco_item_produto, id_subcategoria from v_produto_Categoria 
		where id_categoria = @codcategoria
go

/*======================================================================================================================*/
/*======================================================================================================================*/
/*======================================================================================================================*/
/*==============================               FUNCTION           ======================================================*/
/*======================================================================================================================*/
/*======================================================================================================================*/
/*======================================================================================================================*/

/*==============================================================*/
/* Function: precoItemDeVenda                      ???             */
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

