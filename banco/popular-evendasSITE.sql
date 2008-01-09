USE EVENDAS
GO
/*==============================================================*/
/* Table: CATEGORIA_PRODUTO                                     */
/* SELECT * FROM CATEGORIA_PRODUTO                              */
/*==============================================================*/
INSERT INTO CATEGORIA_PRODUTO (DESCRICAO_CATEGORIA) VALUES ('Eletrônicos');
INSERT INTO CATEGORIA_PRODUTO (DESCRICAO_CATEGORIA) VALUES ('Informática');
INSERT INTO CATEGORIA_PRODUTO (DESCRICAO_CATEGORIA) VALUES ('DVDS');

/*==============================================================*/
/* Table: SUBCATEGORIA_PRODUTO                                  */
/* SELECT * FROM SUBCATEGORIA_PRODUTO                           */
/*==============================================================*/
INSERT INTO SUBCATEGORIA_PRODUTO (ID_CATEGORIA, DESCRICAO_SUBCATEGORIA) VALUES (1, 'Televisores');
INSERT INTO SUBCATEGORIA_PRODUTO (ID_CATEGORIA, DESCRICAO_SUBCATEGORIA) VALUES (1, 'DVD Players');
INSERT INTO SUBCATEGORIA_PRODUTO (ID_CATEGORIA, DESCRICAO_SUBCATEGORIA) VALUES (1, 'Áudio');
INSERT INTO SUBCATEGORIA_PRODUTO (ID_CATEGORIA, DESCRICAO_SUBCATEGORIA) VALUES (2, 'Notebooks');
INSERT INTO SUBCATEGORIA_PRODUTO (ID_CATEGORIA, DESCRICAO_SUBCATEGORIA) VALUES (2, 'Apple');
INSERT INTO SUBCATEGORIA_PRODUTO (ID_CATEGORIA, DESCRICAO_SUBCATEGORIA) VALUES (3, 'Filmes');

/*==============================================================*/
/* Table: MEDIDA												*/
/* SELECT * FROM MEDIDA										    */
/*==============================================================*/
INSERT INTO MEDIDA (DESCRICAO_MEDIDA) VALUES ('Unid.');

/*==============================================================*/
/* Table: PRODUTO                                               */
/* SELECT * FROM PRODUTO                                        */
/*==============================================================*/
INSERT INTO PRODUTO (CODIGO_PRODUTO, ID_SUBCATEGORIA, ID_MEDIDA, DESCRICAO_PRODUTO, NOME_PRODUTO, IMAGEM_CAMINHO, CUSTO) VALUES (1, 1, 1, 'TV LCD 20" HDTV Gradiente c/ entrada p/ PC', 'TV LCD Gradiente 20"', '~/images/produtos/tv_lcd_gradiente.jpg', 1099.90);
INSERT INTO PRODUTO (CODIGO_PRODUTO, ID_SUBCATEGORIA, ID_MEDIDA, DESCRICAO_PRODUTO, NOME_PRODUTO, IMAGEM_CAMINHO, CUSTO) VALUES (2, 2, 1, 'Progressive Scan, Divx, MP3 e WMA', 'DVD Player Gradiente', '~/images/produtos/dvd_gradiente.jpg', 299.90);
INSERT INTO PRODUTO (CODIGO_PRODUTO, ID_SUBCATEGORIA, ID_MEDIDA, DESCRICAO_PRODUTO, NOME_PRODUTO, IMAGEM_CAMINHO, CUSTO) VALUES (3, 3, 1, 'Micro System Hi-Fi com MP3 e USB', 'Micro System Gradiente', '~/images/produtos/som_gradiente.jpg', 399.90);
INSERT INTO PRODUTO (CODIGO_PRODUTO, ID_SUBCATEGORIA, ID_MEDIDA, DESCRICAO_PRODUTO, NOME_PRODUTO, IMAGEM_CAMINHO, CUSTO) VALUES (4, 4, 1, 'Notebook Core 2 Duo U7500 1.06GHz 2GB 100GB DVD-RW Vista Business', 'Notebook Sony Vaio', '~/images/produtos/notebook_vaio.jpg', 9999.90);
INSERT INTO PRODUTO (CODIGO_PRODUTO, ID_SUBCATEGORIA, ID_MEDIDA, DESCRICAO_PRODUTO, NOME_PRODUTO, IMAGEM_CAMINHO, CUSTO) VALUES (5, 5, 1, 'iPod Shuffle 1Gb Blue', 'iPod 1GB', '~/images/produtos/ipod.jpg', 369.90);
INSERT INTO PRODUTO (CODIGO_PRODUTO, ID_SUBCATEGORIA, ID_MEDIDA, DESCRICAO_PRODUTO, NOME_PRODUTO, IMAGEM_CAMINHO, CUSTO) VALUES (6, 6, 1, 'Dirigido por José Padilha', 'DVD Tropa de Elite', '~/images/produtos/dvd_tropa_de_elite.jpg', 29.90);

/*==============================================================*/
/* Table: USUARIO												*/
/* SELECT * FROM USUARIO                                        */
/*
 SELECT PWDCOMPARE('rafael123',senha, 0) AS Senha_OK				
   FROM usuario
   WHERE login = 'rafael'								
*/
/*==============================================================*/
INSERT INTO USUARIO (LOGIN, SENHA, EMAIL) VALUES ('rafael', CONVERT(VARBINARY(255), PWDENCRYPT('rafael123')), 'r4faelmf@gmail.com');
INSERT INTO USUARIO (LOGIN, SENHA, EMAIL) VALUES ('web', CONVERT(VARBINARY(255), PWDENCRYPT('web123')), 'web@evendas.com');

/*==============================================================*/
/* Table: CLIENTE												*/
/* SELECT * FROM CLIENTE                                        */
/*==============================================================*/
INSERT INTO CLIENTE (NOME_CLIENTE, CPF, ID_USUARIO) VALUES ('Rafael de Macêdo', '06446411421', 1);

/*==============================================================*/
/* Table: CARTAO												*/
/* SELECT * FROM CARTAO											*/
/*==============================================================*/
INSERT INTO CARTAO (ID_CLIENTE, LIMITE) VALUES (1, 100000);

/*==============================================================*/
/* Table: ESTADO												*/
/* SELECT * FROM ESTADO											*/
/*==============================================================*/
INSERT INTO ESTADO (NOME_ESTADO) VALUES ('RN');

/*==============================================================*/
/* Table: MUNICIPIO												*/
/* SELECT * FROM MUNICIPIO										*/
/*==============================================================*/
INSERT INTO MUNICIPIO (NOME, ID_ESTADO) VALUES ('Natal', 1);
INSERT INTO MUNICIPIO (NOME, ID_ESTADO) VALUES ('Parnamirim', 1);

/*==============================================================*/
/* Table: ENDERECO												*/
/* SELECT * FROM ENDERECO_CLIENTE								*/
/*==============================================================*/
INSERT INTO ENDERECO_CLIENTE (ID_CLIENTE, ID_MUNICIPIO, LOGRADOURO, BAIRRO, NUMERO, CEP) VALUES (1, 2, 'Rua Exp. Fonte Lira', 'Nova Parnamirim', 69, '59151023');

/*==============================================================*/
/* Table: LOJA													*/
/* SELECT * FROM LOJA											*/
/*==============================================================*/
INSERT INTO LOJA (NOME_LOJA) VALUES ('WEB');

/*==============================================================*/
/* Table: ITEM_PRODUTO											*/
/* SELECT * FROM ITEM_PRODUTO									*/
/*==============================================================*/
INSERT INTO ITEM_PRODUTO (ID_PRODUTO, ID_LOJA, QTD_ITEM_PRODUTO, PRECO_ITEM_PRODUTO) VALUES (1, 1, 5, 1099.90);
INSERT INTO ITEM_PRODUTO (ID_PRODUTO, ID_LOJA, QTD_ITEM_PRODUTO, PRECO_ITEM_PRODUTO) VALUES (2, 1, 5, 299.90);
INSERT INTO ITEM_PRODUTO (ID_PRODUTO, ID_LOJA, QTD_ITEM_PRODUTO, PRECO_ITEM_PRODUTO) VALUES (3, 1, 2, 399.90);

/*==============================================================*/
/* Table: PDV													*/
/* SELECT * FROM PDV											*/
/*==============================================================*/
INSERT INTO PDV (ID_LOJA) VALUES (1);

/*==============================================================*/
/* Table: FUNCIONARIO											*/
/* SELECT * FROM FUNCIONARIO									*/
/*==============================================================*/
INSERT INTO FUNCIONARIO (ID_LOJA, ID_USUARIO, MATRICULA_FUNC, NOME_FUNC) VALUES (1, 2, 1, 'Web');

/*
SELECT * FROM VENDA
SELECT * FROM ITEM_VENDA
SELECT * FROM PAGAMENTO
SELECT * FROM PARCELAS
*/

