/*==============================================================*/
/* Table: CATEGORIA_PRODUTO                                     */
/*==============================================================*/
create table CATEGORIA_PRODUTO (
ID_CATEGORIA         bigint               not null identity,
DESCRICAO_CATEGORIA  varchar(50)          not null,
constraint PK_CATEGORIA_PRODUTO primary key  (ID_CATEGORIA)
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
constraint FK_SUBCATEG_RELATIONS_CATEGORI foreign key (ID_CATEGORIA)
      references CATEGORIA_PRODUTO (ID_CATEGORIA)
)
go

/*==============================================================*/
/* Table: PRODUTO                                               */
/*==============================================================*/
create table PRODUTO (
ID_PRODUTO           bigint               not null identity,
ID_SUBCATEGORIA      bigint               not null,
DESCRICAO_SUBCATEGORIA varchar(50)          not null,
CUSTO                decimal(10,2)        not null,
constraint PK_PRODUTO primary key  (ID_PRODUTO),
constraint FK_PRODUTO_RELATIONS_SUBCATEG foreign key (ID_SUBCATEGORIA)
      references SUBCATEGORIA_PRODUTO (ID_SUBCATEGORIA)
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
ID_ESTADO_ITEM_VENDA smallint             not null,
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
SENHA                varchar(250)         not null,
constraint PK_USUARIO primary key  (ID_USUARIO)
)
go

/*==============================================================*/
/* Table: CLIENTE                                               */
/*==============================================================*/
create table CLIENTE (
ID_CLIENTE           bigint               not null identity, 
NOME_CLIENTE         varchar(100)         not null,
CPF                  varchar(11)          not null,
ID_USUARIO           int                  null,
constraint PK_CLIENTE primary key  (ID_CLIENTE),
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

//*==============================================================*/
/* Table: CARTAO                                                */
/*==============================================================*/
create table CARTAO (
ID_CARTAO            int                  not null identity,
ID_CLIENTE           bigint               not null,
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
constraint PK_TIPO_PAGAMENTO primary key  (ID_TIPO_PAGAMENTO)
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
constraint PK_TROCA primary key  (ID_TROCA),
constraint FK_TROCA_RELATIONS_VENDA foreign key (ID_VENDA)
      references VENDA (ID_VENDA)
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
constraint PK_ACAO_LOG primary key  (ID_ACAO_LOG)
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

/*==============================================================*/
/* Table: TIPO_PROPRIETARIO                                     */
/*==============================================================*/
create table TIPO_PROPRIETARIO (
ID_TIPO_PROP         int                  not null identity,
DESCRICAO_TIPO       varchar(15)          not null,
constraint PK_TIPO_PROPRIETARIO primary key  (ID_TIPO_PROP)
)
go

/*==============================================================*/
/* Table: TELEFONE                                              */
/*==============================================================*/
create table TELEFONE (
ID_TELEFONE           bigint               not null identity,
ID_TIPO_PROP         int                  not null,
ID_PROPRIETARIO      bigint               not null,
constraint PK_TELEFONE primary key  (ID_TELEFONE),
constraint FK_TELEFONE_RELATIONS_TIPO_PRO foreign key (ID_TIPO_PROP)
      references TIPO_PROPRIETARIO (ID_TIPO_PROP)
)
go


/*==============================================================*/
/* Table: ENDERECO                                              */
/*==============================================================*/
create table ENDERECO (
ID_ENDERECO           bigint               not null identity,
ID_TIPO_PROP         int                  not null,
constraint PK_ENDERECO primary key  (ID_ENDERECO),
constraint FK_ENDERECO_RELATIONS_TIPO_PRO foreign key (ID_TIPO_PROP)
      references TIPO_PROPRIETARIO (ID_TIPO_PROP)
)
go







