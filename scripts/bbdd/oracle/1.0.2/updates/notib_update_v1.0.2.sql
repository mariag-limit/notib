-- Update for version (1.0.1 -> 1.0.2)
-- #109
ALTER TABLE NOT_PERSONA ADD INCAPACITAT NUMBER(1,0) DEFAULT 0;

-- #115
ALTER TABLE NOT_NOTIFICACIO DROP (
    SEU_EXP_SERDOC, 
    SEU_EXP_UNIORG, 
    SEU_EXP_IDENI, 
    SEU_EXP_TITOL, 
    SEU_REG_OFICINA, 
    SEU_REG_LLIBRE,
    SEU_REG_ORGAN,
    SEU_IDIOMA,
    SEU_AVIS_TITOL,
    SEU_AVIS_TEXT,
    SEU_AVIS_MOBIL,
    SEU_OFICI_TITOL,
    SEU_OFICI_TEXT,
    SEU_PROC_CODI);

ALTER TABLE NOT_NOTIFICACIO DROP (
   	REGISTRE_OFICINA,
   	REGISTRE_ORGAN,
   	REGISTRE_LLIBRE,
   	REGISTRE_EXTRACTE,
   	REGISTRE_DOC_FISICA,
   	REGISTRE_IDIOMA,
   	REGISTRE_TIPUS_ASSUMPTE,
   	REGISTRE_REF_EXTERNA,
   	REGISTRE_CODI_ASSUMPTE,
   	REGISTRE_OBSERVACIONS);
   	
ALTER TABLE NOT_NOTIFICACIO DROP (
   	PROC_CODI_SIA);
   	
ALTER TABLE NOT_NOTIFICACIO_ENV DROP (
    SEU_REG_NUMERO, 
    SEU_REG_DATA, 
    SEU_DATA_FI, 
    SEU_ESTAT, 
    SEU_ERROR, 
    SEU_ERROR_EVENT_ID,
    SEU_DATA_ESTAT,
    SEU_DATA_NOTINF,
    SEU_DATA_NOTIDP,
    SEU_INTENT_DATA,
    SEU_FITXER_CODI,
    SEU_FITXER_CLAU);