CREATE TABLE "District" (
 "id"            INTEGER PRIMARY KEY,
 "name"        varchar(50) NOT NULL,
 "state"  bigint NOT NULL,
 "sanitary_region" bigint NOT NULL,
 "zip_code"       integer NOT NULL,
 "population"     bigint NOT NULL,

 CONSTRAINT "FK_39" FOREIGN KEY ( "state" ) REFERENCES "State" ( "id" ),
 CONSTRAINT "FK_40" FOREIGN KEY ( "sanitary_region" ) REFERENCES "SanitaryRegion" ( "id" )
);

CREATE TABLE "Establishment" (
 "id"        INTEGER PRIMARY KEY,
 "name"    varchar(50) NOT NULL,
 "address" varchar(50) NOT NULL,
 "district"      bigint NOT NULL,
 "is_valid"  boolean NOT NULL
);

CREATE TABLE "EstablishmentPatients" (
    "id"        INTEGER PRIMARY KEY,
    "establishment_id"  bigint NOT NULL,
    "contagiados" bigint NOT NULL,
    "sospechosos" bigint NOT NULL,
    "recuperados" bigint NOT NULL,
    "fallecidos" bigint NOT NULL,

    CONSTRAINT "FK_86" FOREIGN KEY ( "establishment_id" ) REFERENCES "Establishment" ( "id" )
);

CREATE TABLE "EstablishmentResources" (
    "id"        INTEGER PRIMARY KEY,
    "establishment_id"  bigint NOT NULL,
    "camas_simples" bigint NOT NULL,
    "camas_uti" bigint NOT NULL,
    "respiradores_en_uso" bigint NOT NULL,

    CONSTRAINT "FK_87" FOREIGN KEY ( "establishment_id" ) REFERENCES "Establishment" ( "id" )
);

CREATE INDEX "fkIdx_76" ON "Establishment" (
 "district"
);

CREATE TABLE "State" (
 "id"     INTEGER PRIMARY KEY,
 "name" varchar(50) NOT NULL
);

CREATE TABLE "SanitaryRegion" (
 "id"     INTEGER PRIMARY KEY,
 "name" varchar(50) NOT NULL,
 "district"   bigint NOT NULL,

 CONSTRAINT "FK_52" FOREIGN KEY ( "district" ) REFERENCES "District" ( "id" )
);

CREATE TABLE "Role" (
 "role" varchar(50) NOT NULL,

 CONSTRAINT "PK_rol" PRIMARY KEY ( "role" )
);

CREATE TABLE "User" (
 "dni"       bigint NOT NULL,
 "name"    varchar(50) NOT NULL,
 "email"      varchar(50) NOT NULL,
 "password"  varchar(50) NOT NULL,
 "phonenumber"  varchar(50) NOT NULL,
 "category" varchar(50) NOT NULL,
 "role"      varchar(50) NOT NULL,
 "is_valid"  boolean NOT NULL,

 CONSTRAINT "PK_usuario" PRIMARY KEY ( "dni" ),
 CONSTRAINT "FK_67" FOREIGN KEY ( "role" ) REFERENCES "Role" ( "role" )
);