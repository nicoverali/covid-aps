CREATE TABLE "Distrito" (
 "id"            bigint NOT NULL,
 "superficie"    varchar(50) NOT NULL,
 "zipCode"       integer NOT NULL,
 "Nombre"        varchar(50) NOT NULL,
 "poblacion"     bigint NOT NULL,
 "id_provincia"  bigint NOT NULL,
 "id_intendente" bigint NOT NULL,
 CONSTRAINT "PK_distrito" PRIMARY KEY ( "id" ),
 CONSTRAINT "FK_39" FOREIGN KEY ( "id_provincia" ) REFERENCES "Provincia" ( "id" ),
 CONSTRAINT "FK_42" FOREIGN KEY ( "id_intendente" ) REFERENCES "Intendente" ( "id" )
);

CREATE TABLE "Establecimiento" (
 "id"        bigint NOT NULL,
 "direccion" varchar(50) NOT NULL,
 "is_valid"  boolean NOT NULL,
 "nombre"    varchar(50) NOT NULL,
 "id_1"      bigint NOT NULL,
 CONSTRAINT "PK_table_70" PRIMARY KEY ( "id" ),
 CONSTRAINT "FK_76" FOREIGN KEY ( "id_1" ) REFERENCES "Distrito" ( "id" )
);

CREATE INDEX "fkIdx_76" ON "Establecimiento" (
 "id_1"
);

CREATE TABLE "Intendente" (
 "id"              bigint NOT NULL,
 "Nombre"          varchar(50) NOT NULL,
 "Apellido"        varchar(50) NOT NULL,
 "FechaNacimiento" date NOT NULL,
 CONSTRAINT "PK_intendente" PRIMARY KEY ( "id" )
);

CREATE TABLE "Provincia" (
 "id"     bigint NOT NULL,
 "nombre" varchar(50) NOT NULL,
 CONSTRAINT "PK_provincia" PRIMARY KEY ( "id" )
);

CREATE TABLE "region_sanitaria" (
 "id"     bigint NOT NULL,
 "nombre" varchar(50) NOT NULL,
 "id_1"   bigint NOT NULL,
 CONSTRAINT "PK_region_sanitaria" PRIMARY KEY ( "id" ),
 CONSTRAINT "FK_52" FOREIGN KEY ( "id_1" ) REFERENCES "Distrito" ( "id" )
);

CREATE TABLE "Rol" (
 "tipo" varchar(50) NOT NULL,
 CONSTRAINT "PK_rol" PRIMARY KEY ( "tipo" )
);

CREATE TABLE "Usuario" (
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