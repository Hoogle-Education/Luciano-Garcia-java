CREATE TABLE agendamento (
  id INT PRIMARY KEY AUTO_INCREMENT,
  titulo VARCHAR(255),
  link VARCHAR(255),
  modelo_encontro ENUM('ONLINE' , 'PRESENCIAL' , 'HIBRIDO'),
  descricao TEXT,
  inicio DATETIME,
  fim DATETIME
);