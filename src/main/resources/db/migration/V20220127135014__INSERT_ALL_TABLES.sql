-- PERFILS
INSERT INTO ${SCHEMA_NAME}.TAB_PERFIL
VALUES (nextval('${SCHEMA_NAME}.SQ_PERFIL'), 'OPERADOR', 'Operador do sistema', 'OPERADOR', 'S', now(), now());
INSERT INTO ${SCHEMA_NAME}.TAB_PERFIL
VALUES (nextval('${SCHEMA_NAME}.SQ_PERFIL'), 'ASSOCIADO', 'clientes da empresa', 'ASSOCIADO', 'S', now(), now());
INSERT INTO ${SCHEMA_NAME}.TAB_PERFIL
VALUES (nextval('${SCHEMA_NAME}.SQ_PERFIL'), 'CONVENIADO', 'laboratórios, hospitais e clínicas', 'CONVENIADO', 'S',
        now(), now());
INSERT INTO ${SCHEMA_NAME}.TAB_PERFIL
VALUES (nextval('${SCHEMA_NAME}.SQ_PERFIL'), 'PRESTADOR',
        'médicos, enfermeiros, fisioterapeutas, dentistas e outros profissinais da área de saúde', 'PRESTADOR',
        'S', now(), now());

-- USUARIOS
INSERT INTO ${SCHEMA_NAME}.TAB_USUARIO
VALUES (nextval('${SCHEMA_NAME}.SQ_USUARIO'), 1, 'Operador do Sistema', 'operador@boasaude.com.br', '12345', 'S', now
    (), now());
