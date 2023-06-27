use db_pessoas;
#SET SQL_SAFE_UPDATES = 0;
#DELETE FROM jogo;
#ALTER TABLE pontuacao
#RENAME COLUMN codigo TO  id;

ALTER TABLE pontuacao ADD CONSTRAINT fk_nome FOREIGN KEY ( nome ) REFERENCES jogador ( nome ) ;
SELECT * FROM pontuacao;