CREATE TABLE ${SCHEMA_NAME}.TAB_USUARIO
(
    IDT_USUARIO   BIGINT       NOT NULL,
    IDT_PERFIL    BIGINT       NOT NULL,
    NM_USUARIO    VARCHAR(80)  NOT NULL,
    DS_EMAIL      VARCHAR(50)  NOT NULL,
    DS_SENHA      VARCHAR(120) NOT NULL,
    FLG_ATIVO     VARCHAR(1)   NOT NULL,
    DAT_INCLUSAO  TIMESTAMP    NOT NULL,
    DAT_ALTERACAO TIMESTAMP
);

COMMENT ON TABLE ${SCHEMA_NAME}.TAB_USUARIO IS 'Armazena informações de conta de usuário';
COMMENT ON COLUMN ${SCHEMA_NAME}.TAB_USUARIO.IDT_USUARIO
    IS 'Identificador artificial do usuário (Preenchido com o valor fornecido pela sequence SQ_USUARIO)';
COMMENT ON COLUMN ${SCHEMA_NAME}.TAB_USUARIO.IDT_PERFIL
    IS 'Identificador do perfil do usuário. Chave estrangeira para a tabela PROFILE.';
COMMENT ON COLUMN ${SCHEMA_NAME}.TAB_USUARIO.NM_USUARIO IS 'Nome do usuário';
COMMENT ON COLUMN ${SCHEMA_NAME}.TAB_USUARIO.DS_EMAIL IS 'Email do usuário';
COMMENT ON COLUMN ${SCHEMA_NAME}.TAB_USUARIO.DS_SENHA IS 'Senha do usuário';
COMMENT ON COLUMN ${SCHEMA_NAME}.TAB_USUARIO.FLG_ATIVO IS 'Indica se usuário está ativo (S-SIM e N-NÃO)';
COMMENT ON COLUMN ${SCHEMA_NAME}.TAB_USUARIO.DAT_INCLUSAO IS 'Data de inclusão do registro';
COMMENT ON COLUMN ${SCHEMA_NAME}.TAB_USUARIO.DAT_ALTERACAO IS 'Data da última alteração do registro';

ALTER TABLE ${SCHEMA_NAME}.TAB_USUARIO
    ADD CONSTRAINT CK_USUARIO_01 CHECK (FLG_ATIVO IN ('S', 'N'));

ALTER TABLE ${SCHEMA_NAME}.TAB_USUARIO
    ADD CONSTRAINT UK_USUARIO_01 UNIQUE (NM_USUARIO, DS_EMAIL);

ALTER TABLE ${SCHEMA_NAME}.TAB_USUARIO
    ADD CONSTRAINT PK_USUARIO PRIMARY KEY (IDT_USUARIO);

CREATE INDEX IX_USUARIO_01
    ON ${SCHEMA_NAME}.TAB_USUARIO (DS_EMAIL);

CREATE SEQUENCE ${SCHEMA_NAME}.SQ_USUARIO
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    NO CYCLE
    OWNED BY ${SCHEMA_NAME}.TAB_USUARIO.IDT_USUARIO;

ALTER TABLE ${SCHEMA_NAME}.TAB_USUARIO
    ADD CONSTRAINT FK_USUARIO_01 FOREIGN KEY (IDT_PERFIL) REFERENCES ${SCHEMA_NAME}.TAB_PERFIL (IDT_PERFIL);

/*-------------------------------------------------------------------------------
-- GRANT'S
-------------------------------------------------------------------------------*/
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE ${SCHEMA_NAME}.TAB_USUARIO TO ${APP_USER};
GRANT USAGE ON SEQUENCE ${SCHEMA_NAME}.SQ_USUARIO TO ${APP_USER};
