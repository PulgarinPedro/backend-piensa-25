CREATE TABLE IF NOT EXISTS usuario(
id SERIAL,
nombre VARCHAR(100) NOT NULL,
apellido VARCHAR(100) NOT NULL,
edad INT NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS preguntas(
id SERIAL,
descripcion VARCHAR(100) NOT NULL,
opcionone VARCHAR(100) NOT NULL,
opciontwo VARCHAR (100) NOT NULL,
opcionthree VARCHAR (100) NOT NULL,
respuesta VARCHAR (100) NOT NULL,
tipo VARCHAR (100) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS evaluacion(
id SERIAL,
fecha DATE NOT NULL,
valido VARCHAR(100) NOT NULL,
error VARCHAR (100) NOT NULL,   
PRIMARY KEY (id),
usuario_id INT NOT NULL,
FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

CREATE TABLE IF NOT EXISTS detail(
id SERIAL,
iscorrect boolean NOT NULL,
PRIMARY KEY (id),
evaluacion_id INT NOT NULL,
FOREIGN KEY (evaluacion_id) REFERENCES evaluacion (id),
preguntas_id INT NOT NULL,
FOREIGN KEY (preguntas_id) REFERENCES preguntas (id)
);
