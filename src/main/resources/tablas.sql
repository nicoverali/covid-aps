CREATE TABLE "District" (
 "id"            INTEGER PRIMARY KEY,
 "superficie"    varchar(50) NOT NULL,
 "zipCode"       integer NOT NULL,
 "Nombre"        varchar(50) NOT NULL,
 "poblacion"     bigint NOT NULL,
 "id_provincia"  bigint NOT NULL,
 "id_intendente" bigint NOT NULL,
 CONSTRAINT "FK_39" FOREIGN KEY ( "id_provincia" ) REFERENCES "State" ( "id" ),
 CONSTRAINT "FK_42" FOREIGN KEY ( "id_intendente" ) REFERENCES "Mayor" ( "id" )
);

CREATE TABLE "Establishment" (
 "id"        INTEGER PRIMARY KEY,
 "direccion" varchar(50) NOT NULL,
 "is_valid"  boolean NOT NULL,
 "nombre"    varchar(50) NOT NULL,
 "id_1"      bigint NOT NULL,
 CONSTRAINT "FK_76" FOREIGN KEY ( "id_1" ) REFERENCES "District" ( "id" )
);

CREATE INDEX "fkIdx_76" ON "Establishment" (
 "id_1"
);

CREATE TABLE "Mayor" (
 "id"              INTEGER PRIMARY KEY,
 "Nombre"          varchar(50) NOT NULL,
 "Apellido"        varchar(50) NOT NULL,
 "FechaNacimiento" date NOT NULL
);

CREATE TABLE "State" (
 "id"     INTEGER PRIMARY KEY,
 "nombre" varchar(50) NOT NULL
);

CREATE TABLE "region_sanitaria" (
 "id"     INTEGER PRIMARY KEY,
 "nombre" varchar(50) NOT NULL,
 "id_1"   bigint NOT NULL,
 CONSTRAINT "FK_52" FOREIGN KEY ( "id_1" ) REFERENCES "District" ( "id" )
);

CREATE TABLE "Rol" (
 "tipo" varchar(50) NOT NULL,
 CONSTRAINT "PK_rol" PRIMARY KEY ( "tipo" )
);

CREATE TABLE "User" (
 "dni"       bigint NOT NULL,
 "password"  varchar(50) NOT NULL,
 "nombre"    varchar(50) NOT NULL,
 "mail"      varchar(50) NOT NULL,
 "telefono"  varchar(50) NOT NULL,
 "categoria" varchar(50) NOT NULL,
 "is_valid"  boolean NOT NULL,
 "tipo"      varchar(50) NOT NULL,
 CONSTRAINT "PK_usuario" PRIMARY KEY ( "dni" ),
 CONSTRAINT "FK_67" FOREIGN KEY ( "tipo" ) REFERENCES "Rol" ( "tipo" )
);