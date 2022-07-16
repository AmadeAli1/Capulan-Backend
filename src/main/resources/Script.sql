create table TERMINAL
(
    ID_TERMINAL NUMBER       not null
        primary key,
    NOME        VARCHAR2(50) not null,
    REGIAO      VARCHAR2(50) not null
)
/

create trigger INSERTTERMINAL
    before insert
    on TERMINAL
    for each row
BEGIN
    :new.id_terminal := TERMINAL_ID.nextval;
end;
/

create table CATEGORIA
(
    ID_CATEGORIA NUMBER       not null
        primary key,
    NOME         VARCHAR2(50) not null,
    TIPO         VARCHAR2(20) not null
)
/

create trigger INSERTCATEGORIA
    before insert
    on CATEGORIA
    for each row
BEGIN
    :new.id_categoria := categoria_id.Nextval;
END;
/

create table USUARIO
(
    ID_USUARIO  NUMBER       not null
        primary key,
    NOME        VARCHAR2(50) not null,
    BI          VARCHAR2(13) not null
        unique,
    SEXO        VARCHAR2(10),
    TIPO        VARCHAR2(15) not null,
    SENHA       VARCHAR2(50) not null,
    ID_TERMINAL NUMBER       not null
        references TERMINAL
            on delete cascade
)
/

create trigger INSERTUSUARIO
    before insert
    on USUARIO
    for each row
BEGIN
    :new.id_usuario := USUARIO_ID.nextval;
end;
/

create table CLIENTE
(
    ID_CLIENTE    NUMBER       not null
        primary key,
    EMAIL         VARCHAR2(50) not null
        unique,
    CODIGO_POSTAL VARCHAR2(10) not null,
    CIDADE        VARCHAR2(50) not null,
    ID_USUARIO    NUMBER       not null
        references USUARIO
            on delete cascade
)
/

create trigger CLIENTE
???
on CLIENTE
begin
    -- missing source code
end
/

create trigger CLIENTE
    before insert
    on CLIENTE
    for each row
BEGIN
    :new.id_cliente:=cliente_id.Nextval;
END;
/

create table FUNCIONARIO
(
    ID_FUNCIONARIO NUMBER       not null
        primary key,
    SALARIO        NUMBER       not null,
    AREA_TRABALHO  VARCHAR2(50) not null,
    ID_USUARIO     NUMBER       not null
        references USUARIO
            on delete cascade
)
/

create trigger INSERTFUNCIONARIO
    before insert
    on FUNCIONARIO
    for each row
BEGIN
    :new.id_funcionario := funcionario_id.Nextval;
END;
/

create table FORNECEDOR
(
    ID_FORNECEDOR NUMBER       not null
        primary key,
    NOME_EMPRESA  VARCHAR2(50) not null
        unique,
    CONTACTO      VARCHAR2(50) not null,
    EMAIL         VARCHAR2(50) not null
        unique
)
/

create trigger INSERTFORNECEDOR
    before insert
    on FORNECEDOR
    for each row
BEGIN
    :new.id_fornecedor := fornecedor_id.nextval;
end;
/

create table STOCK_MZ
(
    ID_STOCK      NUMBER not null
        primary key,
    QUANTIDADE    NUMBER not null,
    DATA_CHEGADA  DATE   not null,
    PRECO         NUMBER not null,
    ID_TERMINAL   NUMBER not null
        references TERMINAL
            on delete cascade,
    ID_FORNECEDOR NUMBER not null
        references FORNECEDOR
            on delete cascade
)
/

create trigger INSERTSTOCKMZ
    before insert
    on STOCK_MZ
    for each row
BEGIN
    :new.id_stock := stock_id_mz.nextval;
end;
/

create table PRODUTO_MZ_ST
(
    ID_PRODUTO            NUMBER       not null
        primary key,
    NOME                  VARCHAR2(50) not null,
    PRECO                 NUMBER       not null,
    QUANTIDADE_DISPONIVEL NUMBER       not null,
    ID_CATEGORIA          NUMBER       not null
        references CATEGORIA
            on delete cascade,
    ID_STOCK              NUMBER       not null
        references STOCK_MZ
            on delete cascade
)
/

create trigger INSERTPRODUTO_MZ_ST
    before insert
    on PRODUTO_MZ_ST
    for each row
BEGIN
    :new.id_produto := produto_id_mz_st.nextval;
end;
/

create table ENCOMENDA
(
    ID_ENCOMENDA NUMBER       not null
        primary key,
    DATA_ENTREGA DATE         not null,
    QUANTIDADE   NUMBER       not null,
    PRECO        NUMBER       not null,
    ESTADO       VARCHAR2(50) not null,
    ID_USUARIO   NUMBER       not null
        references USUARIO
            on delete cascade,
    ID_PRODUTO   NUMBER       not null
        references PRODUTO_MZ_ST
            on delete cascade,
    ID_TERMINAL  NUMBER       not null
        references TERMINAL
            on delete cascade
)
/

create trigger INSERTENCOMENDAST
    before insert
    on ENCOMENDA
    for each row
BEGIN
    :new.id_encomenda := encomenda_id.nextval;
end;
/

create table HISTORICO_VENDAS
(
    ID_HISTORICO NUMBER not null
        primary key,
    QUANTIDADE   NUMBER not null,
    DATA_VENDA   DATE   not null,
    PRECO        NUMBER not null,
    ID_PRODUTO   NUMBER not null
        references PRODUTO_MZ_ST
            on delete cascade
)
/

create trigger INSERTHISTORIO_VENDA
    before insert
    on HISTORICO_VENDAS
    for each row
BEGIN
    :new.id_historico := historico_id.nextval;
end;
/

create table FUNCIONARIO_HISTORICO
(
    ID_HISTORICO   NUMBER not null
        references HISTORICO_VENDAS
            on delete cascade,
    ID_FUNCIONARIO NUMBER not null
        references FUNCIONARIO
            on delete cascade
)
/

create table CLIENTE_HISTORICO
(
    ID_HISTORICO NUMBER not null
        references HISTORICO_VENDAS
            on delete cascade,
    ID_CLIENTE   NUMBER not null
        references CLIENTE
            on delete cascade
)
/

create table FUNCIONARIO_ENCOMENDA
(
    ID_FUNCIONARIO NUMBER not null
        references FUNCIONARIO
            on delete cascade,
    ID_ENCOMENDA   NUMBER not null
        references ENCOMENDA
            on delete cascade
)
/

