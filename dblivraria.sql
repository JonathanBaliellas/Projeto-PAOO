create schema dblivraria;
use dblivraria;

-- CRIAÇÃO DAS TABELAS
create table cliente(
	id int primary key auto_increment,
    nome varchar(80),
    cpf varchar(11),
    logradouro varchar(100),
    bairro varchar(30),
    cidade varchar(30),
    uf varchar(2),
    telefone varchar(11),
    email varchar(30),
    senha varchar(16)
);
create table editora(
	id int primary key auto_increment,
    nome varchar(80),
    email varchar(30),
    telefone varchar(11)
);
create table estoque(
	id int primary key auto_increment,
    livro_id long,
    quant int
);
create table livro(
	id int primary key auto_increment,
    titulo varchar(50),
    isbn varchar(13),
    autor varchar(80),
    categoria varchar(30),
    editora_id long,
    ano_publicacao int,
    valor double
);
create table pedido(
	id int primary key auto_increment,
    cliente_id long,
    data date,
    valor double
);
create table pedido_livro(
	id int primary key auto_increment,
    pedido_id long,
    livro_id long
);

-- INSERÇÃO DE DADOS
insert into cliente
	(nome, cpf, logradouro, bairro, cidade, uf, telefone, email, senha)
values 
	("Jeremias", "12345678998", "Rua Um, 0", "Jd. Fatec", "Fatecópolis", "SP", "11987654321", "jeremias@xyz.com", "123456"),
    ("Jessé", "91192843061", "Rua Dois, 1", "Jd. Fatec", "Fatecópolis", "SP", "11991577933", "jesse@xyz.com", "123456"),
    ("Josué", "66241393073", "Rua Três, 2", "Jd. Fatec", "Fatecópolis", "SP", "11997057486", "josue@xyz.com", "123456"),
    ("Josias", "39571399027", "Rua Quatro, 3", "Jd. Fatec", "Fatecópolis", "SP", "11970518247", "josias@xyz.com", "123456"),
    ("Julia", "64788728079", "Rua Cinco, 4", "Jd. Fatec", "Fatecópolis", "SP", "11936554358", "julia@xyz.com", "123456"),
    ("Jussara", "24118108062", "Rua Seis, 5", "Jd. Fatec", "Fatecópolis", "SP", "11993753844", "jussara@xyz.com", "123456"),
    ("Jacó", "19535067044", "Rua Sete, 6", "Jd. Fatec", "Fatecópolis", "SP", "11938417544", "jaco@xyz.com", "123456"),
    ("Jessica", "91975082095", "Rua Oito, 7", "Jd. Fatec", "Fatecópolis", "SP", "11905993561", "jessica@xyz.com", "123456"),
    ("Joana", "16908776000", "Rua Nova, 8", "Jd. Fatec", "Fatecópolis", "SP", "11918370903", "joana@xyz.com", "123456"),
    ("Jacobias", "56126021037", "Rua Dez, 9", "Jd. Fatec", "Fatecópolis", "SP", "11900290850", "jacobias@xyz.com", "123456")
;
insert into editora
	(nome, email, telefone)
values
	("Editora Novton", "contato@editoranovton.com", "11987654321"),
    ("Livros Alecrim Dourado", "contato@alecrimdourado.com", "11987654321"),
    ("Publicações Mukilon", "contato@publicacoesmukilon.com", "11987654321"),
    ("Fuboca Books", "contato@fubocabooks.com", "11987654321"),
    ("Leitura PreSonus", "contato@leiturapresonus.com", "11987654321"),
    ("Pardal Leitor", "contato@pardaleitor.com", "11987654321"),
    ("Jeremias Livros", "contato@jeremiaslivros.com", "11987654321"),
    ("Editora da Esquina", "contato@editoraesquina.com", "11987654321"),
    ("My Publisher", "contato@mypublisher.com", "11987654321"),
    ("Editora Plágios", "contato@editoraplagios.com", "11987654321")
;
insert into livro
	(titulo, isbn, autor, categoria, editora_id, ano_publicacao, valor)
values
	("Tia Susto","1234567891234","Juliana","Terror",1,2023,39.90),
    ("Não respire","1234567891234","Jailson","Suspense",1,2023,39.90),
    ("Amar é viver","1234567891234","Jociara","Romance",1,2023,39.90),
    ("Teletransporte Microbiano","1234567891234","Josias","Tecnologia",1,2023,39.90),
    ("Estrela da Morte","1234567891234","Josué","Ficção",1,2023,39.90),
    ("Nasci há 10 mil anos","1234567891234","Jobson","Biografia",1,2023,39.90),
    ("Lei Seu Madruga","1234567891234","Juliete","Direito",1,2023,39.90),
    ("Cócegas Matam","1234567891234","Juca","Comédia",1,2023,39.90),
    ("Rindo sem Parar","1234567891234","João","Comédia",1,2023,39.90),
    ("I Don't Understand Anything","1234567891234","Peter Peterson","Estrangeiro",1,2023,39.90)
;
insert into estoque
	(livro_id, quant)
values
	(1,45),
    (2,3),
    (3,34),
    (4,99),
    (5,4),
    (6,45),
    (7,98),
    (8,23),
    (9,55),
    (10,34)
;
insert into pedido
	(cliente_id, data, valor)
values
	(1,"2023-11-01",70.11),
    (2,"2023-11-01",357.45),
    (3,"2023-11-01",110.8),
    (4,"2023-11-01",109.98),
    (5,"2023-11-01",105.28),
    (6,"2023-11-01",142.94),
    (7,"2023-11-01",112.60),
    (8,"2023-11-01",59.97),
    (9,"2023-11-01",63.28),
    (10,"2023-11-01",22.92)
;
insert into pedido_livro
	(pedido_id, livro_id)
values
	(1,1),
    (1,2),
    (1,3),
    (2,1),
    (2,5),
    (3,6),
    (4,1),
    (5,8),
    (6,3),
    (6,1),
    (7,2),
    (8,2),
    (9,9),
    (10,7)
;

-- TRIGGERS
DROP TRIGGER IF EXISTS inserir_estoque;
	
DELIMITER $$
USE `dblivraria`$$
CREATE DEFINER = CURRENT_USER TRIGGER inserir_estoque AFTER INSERT ON LIVRO FOR EACH ROW
BEGIN
	insert into estoque(livro_id, quant)
    values(new.id, 10);
END$$
DELIMITER ;