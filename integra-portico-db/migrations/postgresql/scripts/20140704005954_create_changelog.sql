-- // Create Changelog

-- Default DDL for changelog table that will keep
-- a record of the migrations that have been run.

-- You can modify this to suit your database before
-- running your first migration.

-- Be sure that ID and DESCRIPTION fields exist in
-- BigInteger and String compatible fields respectively.

CREATE SCHEMA portico;

GRANT USAGE ON SCHEMA portico TO portico;

GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA portico TO portico;




CREATE TABLE portico.tbl_changelog_chng (
ID NUMERIC(20,0) NOT NULL,
APPLIED_AT VARCHAR(25) NOT NULL,
DESCRIPTION VARCHAR(255) NOT NULL
)
;

ALTER TABLE portico.tbl_changelog_chng
ADD CONSTRAINT pk_chng
PRIMARY KEY (id);

-- //@UNDO

DROP TABLE portico.tbl_changelog_chng;


DROP SCHEMA portico;