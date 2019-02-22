ALTER TABLE NOT_NOTIFICACIO ADD RETARD_POSTAL NUMBER(10);
ALTER TABLE NOT_NOTIFICACIO ADD CADUCITAT DATE;

ALTER TABLE NOT_NOTIFICACIO_ENV ADD TITULAR_RAOSOC VARCHAR2(100);
ALTER TABLE NOT_NOTIFICACIO_ENV ADD TITULAR_CODDES VARCHAR2(9);
ALTER TABLE NOT_NOTIFICACIO_ENV ADD DESTINATARI_RAOSOC VARCHAR2(100);
ALTER TABLE NOT_NOTIFICACIO_ENV ADD DESTINATARI_CODDES VARCHAR2(9);
ALTER TABLE NOT_NOTIFICACIO_ENV ADD NOTIFICA_ESTAT_ERROR VARCHAR2(255);
ALTER TABLE NOT_NOTIFICACIO_ENV ADD FORMAT_SOBRE VARCHAR2(10);
ALTER TABLE NOT_NOTIFICACIO_ENV ADD FORMAT_FULLA VARCHAR2(10);
ALTER TABLE NOT_NOTIFICACIO_ENV ADD DOM_NUM_QUALIF VARCHAR2(3);

ALTER TABLE NOT_NOTIFICACIO ADD COM_TIPUS NUMBER(10);
UPDATE NOT_NOTIFICACIO SET COM_TIPUS = 0;
ALTER TABLE NOT_NOTIFICACIO MODIFY COM_TIPUS NOT NULL;
ALTER TABLE NOT_NOTIFICACIO ADD NOT_ERROR_TIPUS NUMBER(10);
ALTER TABLE NOT_NOTIFICACIO RENAME COLUMN NOT_DATENV TO NOT_ENV_DATA;
ALTER TABLE NOT_NOTIFICACIO RENAME COLUMN NOT_REINTENTS TO NOT_ENV_INTENT;
ALTER TABLE NOT_NOTIFICACIO ADD NOT_REENV_DATA TIMESTAMP(6);

ALTER TABLE NOT_NOTIFICACIO_ENV ADD NOTIFICA_DATCAD TIMESTAMP(6);
ALTER TABLE NOT_NOTIFICACIO_ENV ADD NOTIFICA_EMI_DIR3NIF VARCHAR2(9);
ALTER TABLE NOT_NOTIFICACIO_ENV ADD NOTIFICA_ARR_DIR3NIF VARCHAR2(9);
ALTER TABLE NOT_NOTIFICACIO_ENV DROP COLUMN NOTIFICA_DES_DIR3CODI;
ALTER TABLE NOT_NOTIFICACIO_ENV DROP COLUMN NOTIFICA_DES_DIR3DESC;
ALTER TABLE NOT_NOTIFICACIO_ENV RENAME COLUMN NOTIFICA_ESTAT_ORIGEN TO NOTIFICA_DATAT_ORIGEN;
ALTER TABLE NOT_NOTIFICACIO_ENV RENAME COLUMN NOTIFICA_ESTAT_RECNIF TO NOTIFICA_DATAT_RECNIF;
ALTER TABLE NOT_NOTIFICACIO_ENV RENAME COLUMN NOTIFICA_ESTAT_RECNOM TO NOTIFICA_DATAT_RECNOM;
ALTER TABLE NOT_NOTIFICACIO_ENV RENAME COLUMN NOTIFICA_ESTAT_NUMSEG TO NOTIFICA_DATAT_NUMSEG;
ALTER TABLE NOT_NOTIFICACIO_ENV RENAME COLUMN NOTIFICA_ESTAT_ERROR TO NOTIFICA_DATAT_ERRDES;

ALTER TABLE NOT_NOTIFICACIO MODIFY DOC_HASH VARCHAR2(100);
ALTER TABLE NOT_NOTIFICACIO_ENV MODIFY NOTIFICA_CER_HASH VARCHAR2(100);

ALTER TABLE NOT_NOTIFICACIO_ENV ADD NOTIFICA_ESTAT_FINAL NUMBER(1);
UPDATE NOT_NOTIFICACIO_ENV SET NOTIFICA_ESTAT_FINAL = 0;
ALTER TABLE NOT_NOTIFICACIO_ENV ADD NOTIFICA_ESTAT_DATAACT TIMESTAMP(6);
--
--ALTER TABLE NOT_NOTIFICACIO ADD REGISTRE_OFICINA VARCHAR2(64);
--ALTER TABLE NOT_NOTIFICACIO ADD REGISTRE_LLIBRE VARCHAR2(64);
--ALTER TABLE NOT_NOTIFICACIO ADD REGISTRE_EXTRACTE VARCHAR2(64);
--ALTER TABLE NOT_NOTIFICACIO ADD REGISTRE_DOC_FISICA VARCHAR2(64);
--ALTER TABLE NOT_NOTIFICACIO ADD REGISTRE_IDIOMA VARCHAR2(2);
--ALTER TABLE NOT_NOTIFICACIO ADD REGISTRE_TIPUS_ASSUMPTE NUMBER(1);
--ALTER TABLE NOT_NOTIFICACIO ADD REGISTRE_NUM_EXPEDIENT VARCHAR2(20);
--ALTER TABLE NOT_NOTIFICACIO ADD REGISTRE_REF_EXTERNA VARCHAR2(64);
--ALTER TABLE NOT_NOTIFICACIO ADD REGISTRE_CODI_ASSUMPTE VARCHAR2(20);
--ALTER TABLE NOT_NOTIFICACIO ADD REGISTRE_OBSERVACIONS VARCHAR2(256);
--
--ALTER TABLE NOT_NOTIFICACIO ADD GRUP_CODI VARCHAR2(64);
--ALTER TABLE NOT_PROCEDIMENT ADD DATA_PROGRAMADA TIMESTAMP(6);
--ALTER TABLE NOT_PROCEDIMENT ADD RETARD NUMBER(19);
--ALTER TABLE NOT_PROCEDIMENT ADD LLIBRE VARCHAR2(64);
--ALTER TABLE NOT_PROCEDIMENT ADD OFICINA VARCHAR2(64);
--ALTER TABLE NOT_PROCEDIMENT ADD TIPUSASSUMPTE NUMBER(1);
--
--ALTER TABLE NOT_NOTIFICACIO MODIFY DOC_ARXIU_NOM VARCHAR2(256);
