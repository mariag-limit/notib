
CREATE TABLE NOT_USUARI
(
  CODI          VARCHAR2(64)                    NOT NULL,
  NOM           VARCHAR2(100),
  LLINATGES     VARCHAR2(100),
  NOM_SENCER    VARCHAR2(200),
  EMAIL         VARCHAR2(200),
  VERSION       NUMBER(19)                      NOT NULL
);

CREATE TABLE NOT_ENTITAT
(
  ID                   NUMBER(19)               NOT NULL,
  CODI                 VARCHAR2(64)             NOT NULL,
  NOM                  VARCHAR2(256)            NOT NULL,
  TIPUS                VARCHAR2(32)             NOT NULL,
  DIR3_CODI            VARCHAR2(9)              NOT NULL,
  DESCRIPCIO           VARCHAR2(1024),
  ACTIVA               NUMBER(1)                NOT NULL,
  VERSION              NUMBER(19)               NOT NULL,
  CREATEDBY_CODI       VARCHAR2(64),
  CREATEDDATE          TIMESTAMP(6),
  LASTMODIFIEDBY_CODI  VARCHAR2(64),
  LASTMODIFIEDDATE     TIMESTAMP(6)
);

CREATE TABLE NOT_APLICACIO
(
  ID                   NUMBER(19)               NOT NULL,
  USUARI_CODI          VARCHAR2(64)             NOT NULL,
  CALLBACK_URL         VARCHAR2(256),
  CREATEDBY_CODI       VARCHAR2(64),
  CREATEDDATE          TIMESTAMP(6),
  LASTMODIFIEDBY_CODI  VARCHAR2(64),
  LASTMODIFIEDDATE     TIMESTAMP(6)
);

CREATE TABLE NOT_NOTIFICACIO 
(
  ID                   NUMBER(19)               NOT NULL,
  EMISOR_DIR3CODI      VARCHAR2(9)              NOT NULL,
  ENV_TIPUS            NUMBER(10)               NOT NULL,
  ENV_DATA_PROG        DATE,
  CONCEPTE             VARCHAR2(50)             NOT NULL,
  DESCRIPCIO           VARCHAR2(100),
  PAGCOR_DIR3          VARCHAR2(9),
  PAGCOR_NUMCONT       VARCHAR2(20),
  PAGCOR_CODI_CLIENT   VARCHAR2(20),
  PAGCOR_DATA_VIG      DATE,
  PAGCIE_DIR3          VARCHAR2(9),
  PAGCIE_DATA_VIG      DATE,
  PROC_CODI_SIA        VARCHAR2(6)              NOT NULL,
  PROC_DESC_SIA        VARCHAR2(256),
  RETARD_POSTAL        NUMBER(10),
  CADUCITAT            DATE,
  DOC_ARXIU_NOM        VARCHAR2(256)            NOT NULL,
  DOC_ARXIU_ID         VARCHAR2(64)             NOT NULL,
  DOC_HASH             VARCHAR2(40),
  DOC_NORMALITZAT      NUMBER(1)                NOT NULL,
  DOC_GEN_CSV          NUMBER(1)                NOT NULL,
  SEU_EXP_SERDOC       VARCHAR2(10)             NOT NULL,
  SEU_EXP_UNIORG       VARCHAR2(10)             NOT NULL,
  SEU_EXP_IDENI        VARCHAR2(52)             NOT NULL,
  SEU_EXP_TITOL        VARCHAR2(256)            NOT NULL,
  SEU_REG_OFICINA      VARCHAR2(256)            NOT NULL,
  SEU_REG_LLIBRE       VARCHAR2(256)            NOT NULL,
  SEU_IDIOMA           VARCHAR2(256)            NOT NULL,
  SEU_AVIS_TITOL       VARCHAR2(256)            NOT NULL,
  SEU_AVIS_TEXT        VARCHAR2(256)            NOT NULL,
  SEU_AVIS_MOBIL       VARCHAR2(256),
  SEU_OFICI_TITOL      VARCHAR2(256)            NOT NULL,
  SEU_OFICI_TEXT       VARCHAR2(256)            NOT NULL,
  ESTAT                NUMBER(10)               NOT NULL,
  NOT_ERROR            NUMBER(1)                NOT NULL,
  NOT_DATENV           TIMESTAMP(6),
  NOT_REINTENTS        NUMBER(10)               NOT NULL,
  NOT_ERROR_EVENT_ID   NUMBER(19),
  ENTITAT_ID           NUMBER(19)               NOT NULL,
  CREATEDBY_CODI       VARCHAR2(64),
  CREATEDDATE          TIMESTAMP(6),
  LASTMODIFIEDBY_CODI  VARCHAR2(64),
  LASTMODIFIEDDATE     TIMESTAMP(6)
);

CREATE TABLE NOT_NOTIFICACIO_ENV
(
  ID                   NUMBER(19)               NOT NULL,
  TITULAR_NIF          VARCHAR2(9)              NOT NULL,
  TITULAR_NOM          VARCHAR2(100),
  TITULAR_LLINATGE1    VARCHAR2(100),
  TITULAR_LLINATGE2    VARCHAR2(100),
  TITULAR_RAOSOC       VARCHAR2(100),
  TITULAR_CODDES       VARCHAR2(9),
  TITULAR_TELEFON      VARCHAR2(16),
  TITULAR_EMAIL        VARCHAR2(100),
  DESTINATARI_NOM      VARCHAR2(100),
  DESTINATARI_LLINATGE1 VARCHAR2(100),
  DESTINATARI_LLINATGE2 VARCHAR2(100),
  DESTINATARI_RAOSOC   VARCHAR2(100),
  DESTINATARI_CODDES   VARCHAR2(9),
  DESTINATARI_NIF      VARCHAR2(9),
  DESTINATARI_TELEFON  VARCHAR2(16),
  DESTINATARI_EMAIL    VARCHAR2(100),
  DOM_TIPUS            NUMBER(10),
  DOM_CON_TIPUS        NUMBER(10),
  DOM_VIA_TIPUS        NUMBER(10),
  DOM_VIA_NOM          VARCHAR2(100),
  DOM_NUM_TIPUS        NUMBER(10),
  DOM_NUM_NUM          VARCHAR2(10),
  DOM_NUM_QUALIF       VARCHAR2(3),
  DOM_NUM_PUNTKM       VARCHAR2(10),
  DOM_APARTAT          VARCHAR2(10),
  DOM_BLOC             VARCHAR2(50),
  DOM_PORTAL           VARCHAR2(50),
  DOM_ESCALA           VARCHAR2(50),
  DOM_PLANTA           VARCHAR2(50),
  DOM_PORTA            VARCHAR2(50),
  DOM_COMPLEM          VARCHAR2(250),
  DOM_POBLACIO         VARCHAR2(30),
  DOM_MUN_CODINE       VARCHAR2(6),
  DOM_MUN_NOM          VARCHAR2(64),
  DOM_CODI_POSTAL      VARCHAR2(10),
  DOM_PRV_CODI         VARCHAR2(2),
  DOM_PRV_NOM          VARCHAR2(64),
  DOM_PAI_CODISO       VARCHAR2(3),
  DOM_PAI_NOM          VARCHAR2(64),
  DOM_LINEA1           VARCHAR2(50),
  DOM_LINEA2           VARCHAR2(50),
  DOM_CIE              NUMBER(10),
  DEH_OBLIGAT          NUMBER(1),
  DEH_NIF              VARCHAR2(9),
  DEH_PROC_CODI        VARCHAR2(6), 
  SERVEI_TIPUS         NUMBER(10),
  FORMAT_SOBRE         VARCHAR2(10),
  FORMAT_FULLA         VARCHAR2(10),
  NOTIFICA_ID          VARCHAR2(20),
  NOTIFICA_REF         VARCHAR2(20),
  NOTIFICA_DATCRE      TIMESTAMP(6),
  NOTIFICA_DATDISP     TIMESTAMP(6),
  NOTIFICA_EMI_DIR3CODI VARCHAR2(9),
  NOTIFICA_EMI_DIR3DESC VARCHAR2(50),
  NOTIFICA_ARR_DIR3CODI VARCHAR2(9),
  NOTIFICA_ARR_DIR3DESC VARCHAR2(50),
  NOTIFICA_DES_DIR3CODI VARCHAR2(9),
  NOTIFICA_DES_DIR3DESC VARCHAR2(50),
  NOTIFICA_ESTAT       NUMBER(10),
  NOTIFICA_ESTAT_DESC  VARCHAR2(50),
  NOTIFICA_ESTAT_DATA  TIMESTAMP(6),
  NOTIFICA_ESTAT_ORIGEN VARCHAR2(20),
  NOTIFICA_ESTAT_RECNIF VARCHAR2(9),
  NOTIFICA_ESTAT_RECNOM VARCHAR2(100),
  NOTIFICA_ESTAT_NUMSEG VARCHAR2(50),
  NOTIFICA_ESTAT_ERROR VARCHAR2(255),
  NOTIFICA_CER_ARXIUID VARCHAR2(64),
  NOTIFICA_CER_HASH    VARCHAR2(50),
  NOTIFICA_CER_DATA    TIMESTAMP(6),
  NOTIFICA_CER_ORIGEN  VARCHAR2(50),
  NOTIFICA_CER_METAS   VARCHAR2(255),
  NOTIFICA_CER_CSV     VARCHAR2(50),
  NOTIFICA_CER_MIME    VARCHAR2(20),
  NOTIFICA_CER_TAMANY  NUMBER(10),
  NOTIFICA_CER_TIPUS   NUMBER(10),
  NOTIFICA_CER_ARXTIP  NUMBER(10),
  NOTIFICA_CER_NUMSEG  VARCHAR2(50),
  NOTIFICA_ERROR       NUMBER(1)               NOT NULL,
  NOTIFICA_ERROR_EVENT_ID  NUMBER(19),
  SEU_REG_NUMERO       VARCHAR2(50),
  SEU_REG_DATA         TIMESTAMP(6),
  SEU_DATA_FI          TIMESTAMP(6),
  SEU_ESTAT            NUMBER(10)               NOT NULL,
  SEU_ERROR            NUMBER(1)                NOT NULL,
  SEU_ERROR_EVENT_ID   NUMBER(19),
  SEU_DATA_ENVIAM      TIMESTAMP(6),
  SEU_DATA_ESTAT       TIMESTAMP(6),
  SEU_DATA_NOTINF      TIMESTAMP(6),
  SEU_DATA_NOTIDP      TIMESTAMP(6),
  NOTIFICACIO_ID       NUMBER(19)               NOT NULL,
  CREATEDBY_CODI       VARCHAR2(64),
  CREATEDDATE          TIMESTAMP(6),
  LASTMODIFIEDBY_CODI  VARCHAR2(64),
  LASTMODIFIEDDATE     TIMESTAMP(6)
);

CREATE TABLE NOT_NOTIFICACIO_EVENT
(
  ID                   NUMBER(19)               NOT NULL,
  TIPUS                NUMBER(10)               NOT NULL,
  DATA                 TIMESTAMP(6)             NOT NULL,
  DESCRIPCIO           VARCHAR2(256),
  ERROR                NUMBER(1)                NOT NULL,
  ERROR_DESC           VARCHAR2(2048),
  NOTIFICACIO_ID       NUMBER(19)               NOT NULL,
  NOTIFICACIO_ENV_ID   NUMBER(19),
  CALLBACK_ESTAT       VARCHAR2(10),
  CALLBACK_DATA        TIMESTAMP(6),
  CALLBACK_INTENTS     NUMBER(10),
  CALLBACK_ERROR_DESC  VARCHAR2(2048),
  CREATEDBY_CODI       VARCHAR2(64),
  CREATEDDATE          TIMESTAMP(6),
  LASTMODIFIEDBY_CODI  VARCHAR2(64),
  LASTMODIFIEDDATE     TIMESTAMP(6)
);


CREATE TABLE NOT_ACL_CLASS
(
  ID     NUMBER(19)                             NOT NULL,
  CLASS  VARCHAR2(100)                          NOT NULL
);


CREATE TABLE NOT_ACL_SID
(
  ID         NUMBER(19)                         NOT NULL,
  PRINCIPAL  NUMBER(1)                          NOT NULL,
  SID        VARCHAR2(100)                      NOT NULL
);


CREATE TABLE NOT_ACL_ENTRY
(
  ID                   NUMBER(19)               NOT NULL,
  ACL_OBJECT_IDENTITY  NUMBER(19)               NOT NULL,
  ACE_ORDER            NUMBER(19)               NOT NULL,
  SID                  NUMBER(19)               NOT NULL,
  MASK                 NUMBER(19)               NOT NULL,
  GRANTING             NUMBER(1)                NOT NULL,
  AUDIT_SUCCESS        NUMBER(1)                NOT NULL,
  AUDIT_FAILURE        NUMBER(1)                NOT NULL
);


CREATE TABLE NOT_ACL_OBJECT_IDENTITY
(
  ID                  NUMBER(19)                NOT NULL,
  OBJECT_ID_CLASS     NUMBER(19)                NOT NULL,
  OBJECT_ID_IDENTITY  NUMBER(19)                NOT NULL,
  PARENT_OBJECT       NUMBER(19),
  OWNER_SID           NUMBER(19)                NOT NULL,
  ENTRIES_INHERITING  NUMBER(1)                 NOT NULL
);
