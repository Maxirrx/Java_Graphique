CREATE TABLE SECTION(
   idSection serial,
   libelleSection VARCHAR(50),
   CONSTRAINT Section_PK PRIMARY KEY(idSection)
);

CREATE TABLE COURS(
   idCours serial,
   libelleCours VARCHAR(20) NOT NULL,
   DescriptionCours VARCHAR(100) NOT NULL,
   idSection INT NOT NULL,
   CONSTRAINT cours_PK PRIMARY KEY(idCours),
   CONSTRAINT cours_section_FK FOREIGN KEY(idSection) REFERENCES SECTION(idSection)
);

CREATE TABLE ETUDIANT(
   idEtudiant serial,
   nomEtudiant VARCHAR(50) NOT NULL,
   prenomEtudiant VARCHAR(50) NOT NULL,
   datedenaissance date not null,
   idSection INT NOT NULL,
   CONSTRAINT eleve_PK PRIMARY KEY(idEtudiant),
   CONSTRAINT eleve_section_FK FOREIGN KEY(idSection) REFERENCES SECTION(idSection)
);


CREATE TABLE UTILISATEUR(
   idUtilisateur serial,
   loginUtilisateur VARCHAR(50) NOT NULL,
   mdpUtilisateur VARCHAR(255) NOT NULL,
   CONSTRAINT utilisateur_PK PRIMARY KEY(idUtilisateur)
);

CREATE TABLE LOG (
    LOG_ID serial,
    TABLE_NAME VARCHAR(50) NOT NULL,
    OPERATION_NAME VARCHAR(50) NOT NULL,
    DATE TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);


/* ALTER*/

ALTER TABLE ETUDIANT ADD COLUMN datedenaissance DATE NOT NULL DEFAULT '2000-01-01';

/* TRIGGER FUNCTION */


CREATE OR REPLACE FUNCTION log_table_changes()
RETURNS TRIGGER AS $$
BEGIN
  IF TG_OP = 'INSERT' THEN
    INSERT INTO log (table_name, OPERATION_NAME)
      VALUES (TG_TABLE_NAME, TG_OP);
RETURN NEW;

ELSIF TG_OP = 'UPDATE' THEN
    INSERT INTO log (table_name, OPERATION_NAME)
      VALUES (TG_TABLE_NAME, TG_OP);
RETURN NEW;

ELSIF TG_OP = 'DELETE' THEN
    INSERT INTO log (table_name, OPERATION_NAME)
      VALUES (TG_TABLE_NAME, TG_OP);
RETURN OLD;

END IF;

RETURN NULL;
END;
$$ LANGUAGE plpgsql;


/* TRIGGER */

CREATE TRIGGER trigger_section
    AFTER INSERT OR UPDATE OR DELETE ON section
    FOR EACH ROW
    EXECUTE FUNCTION log_table_changes();

CREATE TRIGGER trigger_cours
    AFTER INSERT OR UPDATE OR DELETE ON cours
    FOR EACH ROW
    EXECUTE FUNCTION log_table_changes();

CREATE TRIGGER trigger_etudiant
    AFTER INSERT OR UPDATE OR DELETE ON etudiant
    FOR EACH ROW
    EXECUTE FUNCTION log_table_changes();

CREATE TRIGGER trigger_utilisateur
    AFTER INSERT OR UPDATE OR DELETE ON utilisateur
    FOR EACH ROW
    EXECUTE FUNCTION log_table_changes();