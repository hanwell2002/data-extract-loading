-- DROP TABLE CITY CASCADE CONSTRAINTS;
-- DROP TABLE COUNTRY CASCADE CONSTRAINTS;
-- DROP TABLE COUNTRYLANGUAGE CASCADE CONSTRAINTS;

--------------------------------------------------------
--  DDL for Table CITY
--------------------------------------------------------
CREATE TABLE CITY
(	"ID" NUMBER(*,0)  NOT NULL,
     "NAME" VARCHAR2(50 BYTE)  NOT NULL,
     "COUNTRYCODE" CHAR(3 BYTE)  NOT NULL,
	"DISTRICT" VARCHAR2(100 BYTE)  NOT NULL,
	"POPULATION" NUMBER(*,0)  NOT NULL
   );

--------------------------------------------------------
--  DDL for Table COUNTRY
--------------------------------------------------------
CREATE TABLE COUNTRY
(	"CODE" CHAR(3 BYTE) NOT NULL,
	"NAME" VARCHAR2(100 BYTE) NOT NULL,
	"CONTINENT" VARCHAR2(100 BYTE) NOT NULL,
	"REGION" VARCHAR2(100 BYTE) NOT NULL,
	"SURFACEAREA" FLOAT(63) NOT NULL,
	"INDEPYEAR" NUMBER(*,0),
	"POPULATION" NUMBER(*,0) NOT NULL,
	"LIFEEXPECTANCY" FLOAT(63),
	"GNP" NUMBER(*,0),
	"GNPOLD" NUMBER(*,0),
	"LOCALNAME" VARCHAR2(100 BYTE) NOT NULL,
	"GOVERNMENTFORM" VARCHAR2(100 BYTE) NOT NULL,
	"HEADOFSTATE" VARCHAR2(100 BYTE),
	"CAPITAL" NUMBER(*,0),
	"CODE2" CHAR(2 BYTE)
   );

--------------------------------------------------------
--  DDL for Table COUNTRYLANGUAGE
--------------------------------------------------------
CREATE TABLE COUNTRYLANGUAGE
(	"COUNTRYCODE" CHAR(3 BYTE),
	"LANGUAGE" VARCHAR2(100 BYTE),
	"ISOFFICIAL" NUMBER(1,0),
	"PERCENTAGE" FLOAT(63)
   );

--------------------------------------------------------
--  DDL for constrains
--------------------------------------------------------

ALTER TABLE city
    ADD CONSTRAINT city_pkey PRIMARY KEY (id);

ALTER TABLE country
    ADD CONSTRAINT country_pkey PRIMARY KEY (code);

ALTER TABLE countrylanguage
    ADD CONSTRAINT countrylanguage_pkey PRIMARY KEY (countrycode, language);

ALTER TABLE country
    ADD CONSTRAINT country_capital_fkey FOREIGN KEY (capital) REFERENCES city(id);

ALTER TABLE countrylanguage
    ADD CONSTRAINT countrylanguage_countrycode_fkey FOREIGN KEY (countrycode) REFERENCES country(code);

COMMIT;

--ANALYZE;



