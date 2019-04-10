INSERT INTO `cliente` (`id`, `nome`, `email`, `senha`, `cpf`, `cidade`, `estado`, `bairro`, `rua`, `numero`, `cep`, `telefone`) 
VALUES (1, 'João da Silva', 'joao@gmail.com', '123', '12345678912', 'Juiz de Fora', 'Minas Gerais', 'Fabrica', 'Bernardo Mascarenhas', '2000', '36080000', '3233332222');

INSERT INTO `proprietario` (`id`, `nome`, `email`, `senha`, `cpf`, `cidade`, `estado`, `bairro`, `rua`, `numero`, `cep`, `telefone`) VALUES
(1, 'Joaquim Pereira', 'joaquim@gmail.com', '123', '98765432198', 'Três Rios', 'Rio de Janeiro', 'Trevo de Quatro Folhas', '1234', '45098123', '4399994444', '1231231');

INSERT INTO `restaurante` (`id`, `nome`, `email`, `cnpj`, `cidade`, `estado`, `bairro`, `rua`, `numero`, `cep`, `telefone`, `descricao`, `proprietario_id`) VALUES
(1, 'Pizzaria São José', NULL, '1231231212332/342000', 'Rio de Janeiro', 'Rio de Janeiro', 'Flor de Luz', 'Caramelo', '354', '99988832', '4499992222', 'Nós da Pizzaria São José amamos pizza! E temos muito orgulho de como preparamos a autêntica pizza americana. Feira diariamente na loja com ingredientes frescos e de qualidade. Assada em forno especial para oferecer uma pizza com massa pan aerada, crocante e com muito queijo derretido!. Pizzaria São José ajuda a transformar um simples momento em uma deliciosa experiência. Aproveite e peça a sua!', 1);

INSERT INTO `pedido` (`id`, `data_pedido`, `hora_pedido`, `valor`, `pago`, `data_pagamento`, `estado`, `restaurante_id`, `cliente_id`) VALUES
(1, '05/04/2019', '20:27', 39.90+22.90, 1, '05/04/2019', 'Processando', 1, 1),
(2, '04/04/2019', '19:30', (2*14.50)+(3*22.90), 1, '04/04/2019', 'Processando', 1, 1);

INSERT INTO `categoria` (`id`, `nome`, `restaurante_id`) VALUES
(1, 'Almoço', 1),
(2, 'Lanches', 1),
(3, 'Pizzas', 1),
(4, 'Sobremesas', 1);

INSERT INTO `produto` (`id`, `nome`, `descricao`, `preco`, `imagem`, `promocao`, `categoria_id`, `restaurante_id`) VALUES
(1, 'Pizza de Pepperoni', 'Deliciosas fatias de pepperoni (salame especial com páprica) e mussarela', 39.90, 'uploads/produtos/PRODUTO-2019-3-31_19-42-20_999.png', 'PromocaoUnitario', 3,1),
(2, 'Feijoada da Boa', 'Feijão vermelho com linguiças picadas e pé de porco', 14.50, 'uploads/produtos/PRODUTO-2019-3-31_18-43-26_779.jpg', NULL, 1, 1),
(3, 'Combo Lanche Médio', 'Hamgurguer, Refrigerante e Batata Frita', 22.90, 'uploads/produtos/PRODUTO-2019-04-6_12-37-36_126.jpg', 'PromocaoCombo', 2, 1);

INSERT INTO `pedido_produto` (`pedido_id`, `produto_id`, `quantidade`, `preco`) VALUES
(1, 1, 1, 39.90),
(1, 3, 1, 22.90),
(2, 2, 2, 14.50),
(2, 3, 3, 22.90);