CREATE TABLE usuarios (
                          id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
                          email varchar(255) NOT NULL,
                          contrasena varchar(255) NOT NULL
);

CREATE TABLE personas (
                          id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
                          nombre varchar(255) NOT NULL,
                          profesion varchar(255) NOT NULL,
                          url_foto_perfl varchar (1000)NOT NULL,
                          descripcion_breve varchar (1000)NOT NULL,
                          url_imagen_presentacion varchar(1000)NOT NULL,
                          decripcion_completa varchar(5000)NOT NULL,
                          id_usuarios int
);
ALTER table personas add constraint fk_id_persona foreign key (id_usuarios)
    REFERENCES usuarios(id);


CREATE TABLE estudios (
                          id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
                          url_logo varchar(255) NOT NULL,
                          titulo varchar(100) NOT NULL,
                          nombre_institucion varchar (100) NOT NULL,
                          direccion varchar (100),
                          telefono varchar(100),
                          ciudad varchar(100),
                          sitio_web varchar(100),
                          ano_inicio date NOT NULL,
                          ano_fin date,
                          id_persona int
);
ALTER table estudios add constraint fk_id_estudios foreign key (id_persona)
    REFERENCES personas(id);


CREATE TABLE soft_skills (
                             id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
                             nombre varchar(255) NOT NULL,
                             porcentaje varchar (255) NOT NULL,
                             id_persona int
);
ALTER table soft_skills add constraint fk_id_soft_skills foreign key (id_persona)
    REFERENCES personas(id);


CREATE TABLE hard_skills (
                             id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
                             nombre varchar(255) NOT NULL,
                             porcentaje varchar (255) NOT NULL,
                             id_persona int
);
ALTER table hard_skills  add constraint fk_id_hard_skills foreign key (id_persona)
    REFERENCES personas(id);


CREATE TABLE proyectos (
                           id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
                           url_imagen varchar(255) NOT NULL,
                           nombre varchar(50) NOT NULL,
                           descripcion varchar (1000) NOT NULL,
                           url varchar (100) not null,
                           id_persona int
);
ALTER table proyectos add constraint fk_id_proyectos foreign key (id_persona)
    REFERENCES personas(id);


CREATE TABLE redes_sociales (
                                id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                nombre_red_social varchar(255) NOT NULL,
                                url_red_social varchar(255) NOT NULL,
                                id_persona int
);
ALTER table redes_sociales  add constraint fk_id_redes_sociales foreign key (id_persona)
    REFERENCES personas(id);

CREATE TABLE experiencias_laborales (
                                        id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                        empresa varchar(255) NOT NULL,
                                        inicio date NOT NULL,
                                        fin date,
                                        funciones varchar (1000)NOT NULL,
                                        puesto varchar(255)NOT NULL,
                                        es_trabajo_actual TINYINT NOT NULL,
                                        id_persona int
);

ALTER table experiencias_laborales add constraint fk_id_experiencia_laboral foreign key (id_persona)
    REFERENCES personas(id);