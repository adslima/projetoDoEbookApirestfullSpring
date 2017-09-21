CREATE TABLE empresa
  (
     id BIGINT (20) NOT NULL,
     cnpj VARCHAR (255) NOT NULL,
     data_atualizacao DATETIME NOT NULL,
     data_criacao DATETIME NOT NULL,
     razao_social VARCHAR (255) NOT NULL
  )
  
engine = innodb
DEFAULT charset = utf8; 

ALTER TABLE empresa 
ADD PRIMARY KEY (id);
ALTER TABLE empresa
MODIFY id bigint ( 20 ) NOT NULL AUTO_INCREMENT;
INSERT INTO empresa ( id,cnpj,data_atualizacao, data_criacao, razao_social)
VALUES ( NULL , '82198127000121' , CURRENT_DATE (), CURRENT_DATE (), 'Empresa
ADMIN' );