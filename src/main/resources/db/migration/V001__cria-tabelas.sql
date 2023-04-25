create table atendimento (
	id bigint not null auto_increment,
	inicio_atendimento datetime,
	final_atendimento datetime,
	status_atendimento varchar(20),
	senha varchar(30),
	
	primary key (id)
)engine=InnoDB default charset=utf8;

create table chamada_senha (
	id bigint not null auto_increment,
	senha varchar(30),
	nivel_prioridade varchar(60),
	data_hora_emissao datetime,
	
	primary key (id)
)engine=InnoDB default charset=utf8;

create table senha (
	id bigint not null auto_increment,
	senha varchar(30),
	data_hora_emissao datetime,
	tipo_senha varchar(60),
	
	primary key (id)
)engine=InnoDB default charset=utf8;


	