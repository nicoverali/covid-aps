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
 "is_valid"  boolean NOT NULL,

 CONSTRAINT "FK_76" FOREIGN KEY ( "district" ) REFERENCES "District" ( "id" )
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