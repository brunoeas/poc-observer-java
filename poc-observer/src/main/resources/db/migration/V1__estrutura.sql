CREATE TABLE IF NOT EXISTS usuario (
    id_usuario Serial PRIMARY KEY,
    nm_usuario Character varying(100) NOT NULL,
    dt_nascimento Date
);

CREATE TABLE IF NOT EXISTS endereco (
    id_endereco Serial PRIMARY KEY,
    ds_rua Character varying(100) NOT NULL,
    nr_endereco INTEGER NOT NULL,
    ds_bairro Character varying(100) NOT NULL,
    tp_endereco INTEGER NOT NULL,
    id_usuario INTEGER NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
);