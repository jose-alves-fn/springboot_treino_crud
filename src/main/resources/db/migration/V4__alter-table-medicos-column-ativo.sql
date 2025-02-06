alter table medicos add ativo tinyint;

-- Como uma nova coluna vai ser criada, os registros anteriores ficariam vazios, devemos gerar um update para evitar isso
update medicos set ativo = 1;