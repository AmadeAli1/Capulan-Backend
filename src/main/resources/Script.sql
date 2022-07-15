CREATE TABLE Terminal
(
    id_terminal Integer PRIMARY KEY,
    nome        VARCHAR(50) NOT NULL,
    regiao      VARCHAR(50) NOT NULL
);
CREATE SEQUENCE terminal_id start with 1;
CREATE TABLE Categoria
(
    id_categoria INTEGER PRIMARY KEY,
    nome         VARCHAR(50) NOT NULL,
    tipo         VARCHAR(20) NOT NULL
);
CREATE SEQUENCE categoria_id start with 1;
CREATE OR REPLACE TRIGGER insertTerminal
    BEFORE INSERT
    ON TERMINAL
    FOR EACH ROW
BEGIN
    :new.id_terminal := TERMINAL_ID.nextval;
end;
CREATE OR REPLACE TRIGGER insertCategoria
    BEFORE INSERT
    ON Categoria
    For each row
BEGIN
    :new.id_categoria := categoria_id.Nextval;
END;
CREATE TABLE Usuario
(
    id_usuario Integer PRIMARY KEY,
    nome       VARCHAR(50)        NOT NULL,
    bi         VARCHAR(13) UNIQUE NOT NULL,
    sexo       VARCHAR(10),
    tipo       VARCHAR(15)        NOT NULL,
    senha      VARCHAR(50)        NOT NULL,
    id_terminal                   NOT NULL REFERENCES Terminal (id_terminal) ON DELETE CASCADE
);
CREATE SEQUENCE usuario_id start with 1;
CREATE OR REPLACE TRIGGER insertUsuario
    BEFORE INSERT
    ON Usuario
    FOR EACH ROW
BEGIN
    :new.id_usuario := USUARIO_ID.nextval;
end;
CREATE SEQUENCE cliente_id start with 1;
CREATE OR REPLACE TRIGGER Cliente
    BEFORE INSERT
    ON Cliente
    For each row
BEGIN
    :new.id_cliente := cliente_id.Nextval;
END;
CREATE TABLE Cliente
(
    id_cliente    Integer PRIMARY KEY,
    email         VARCHAR(50) UNIQUE NOT NULL,
    codigo_postal VARCHAR(10)        NOT NULL,
    cidade        VARCHAR(50)        NOT NULL,
    id_usuario                       NOT NULL REFERENCES Usuario (id_usuario) ON DELETE CASCADE
);
CREATE OR REPLACE TRIGGER Cliente
    BEFORE INSERT
    ON Cliente
    For each row
BEGIN
    :new.id_cliente := cliente_id.Nextval;
END;
CREATE TABLE Funcionario
(
    id_funcionario Integer PRIMARY KEY,
    salario        INTEGER     NOT NULL,
    area_trabalho  VARCHAR(50) NOT NULL,
    id_usuario                 NOT NULL REFERENCES Usuario (id_usuario) ON DELETE CASCADE
);
CREATE SEQUENCE funcionario_id start with 1;
CREATE OR REPLACE TRIGGER insertFuncionario
    BEFORE INSERT
    ON Funcionario
    For each row
BEGIN
    :new.id_funcionario := funcionario_id.Nextval;
END;
CREATE SEQUENCE stock_id_mz start with 1;
CREATE OR REPLACE TRIGGER insertStockMZ
    BEFORE INSERT
    ON Stock_MZ
    FOR EACH ROW
BEGIN
    :new.id_stock := stock_id_mz.nextval;
end;

CREATE TABLE Encomenda
(
    id_encomenda Integer PRIMARY KEY,
    data_entrega DATE        NOT NULL,
    quantidade   INTEGER     NOT NULL,
    preco        INTEGER     NOT NULL,
    estado       VARCHAR(50) NOT NULL,
    id_usuario   INTEGER     NOT NULL REFERENCES Usuario (id_usuario) ON DELETE CASCADE,
    id_produto   INTEGER     NOT NULL REFERENCES Produto_MZ_ST (id_produto) ON DELETE CASCADE,
    id_terminal  INTEGER     NOT NULL REFERENCES Terminal (id_terminal) ON DELETE CASCADE
);
CREATE SEQUENCE encomenda_id start with 1;
CREATE OR REPLACE TRIGGER insertEncomendaSt
    BEFORE INSERT
    ON Encomenda
    FOR EACH ROW
BEGIN
    :new.id_encomenda := encomenda_id.nextval;
end;


CREATE TABLE Historico_Vendas
(
    id_historico Integer PRIMARY KEY,
    quantidade   INTEGER NOT NULL,
    data_venda   DATE    NOT NULL,
    preco        INTEGER NOT NULL,
    id_produto           NOT NULL REFERENCES PRODUTO_MZ_ST (id_produto) ON DELETE CASCADE
);
CREATE SEQUENCE historico_id start with 1;

CREATE OR REPLACE TRIGGER insertHistorio_Venda
    BEFORE INSERT
    ON Historico_Vendas
    FOR EACH ROW
BEGIN
    :new.id_historico := historico_id.nextval;
end;