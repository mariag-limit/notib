-- Variis scripts relacionats amb el registre de notificacions dins regweb3
ALTER TABLE NOT_NOTIFICACIO ADD MOTIU VARCHAR2(255);
ALTER TABLE NOT_USUARI ADD REBRE_EMAILS NUMBER(1,0);