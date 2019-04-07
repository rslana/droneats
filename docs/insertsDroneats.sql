INSERT INTO `cliente` (`id`, `nome`, `email`, `senha`, `cpf`, `cidade`, `estado`, `bairro`, `rua`, `numero`, `cep`, `telefone`) 
VALUES (999, 'João da Silva', 'joao@gmail.com', '123', '12345678912', 'Juiz de Fora', 'Minas Gerais', 'Fabrica', 'Bernardo Mascarenhas', '2000', '36080000', '3233332222');

INSERT INTO `proprietario` (`id`, `nome`, `email`, `senha`, `cpf`, `cidade`, `estado`, `bairro`, `rua`, `numero`, `cep`, `telefone`) VALUES
(999, 'Joaquim Pereira', 'joaquim@gmail.com', '123', '98765432198', 'Três Rios', 'Rio de Janeiro', 'Trevo de Quatro Folhas', '1234', '45098123', '4399994444', '1231231');

INSERT INTO `restaurante` (`id`, `nome`, `email`, `cnpj`, `cidade`, `estado`, `bairro`, `rua`, `numero`, `cep`, `telefone`, `descricao`, `proprietario_id`) VALUES
(999, 'Pizzaria São José', NULL, '1231231212332/342000', 'Rio de Janeiro', 'Rio de Janeiro', 'Flor de Luz', 'Caramelo', '354', '99988832', '4499992222', 'Nós da Pizzaria São José amamos pizza! E temos muito orgulho de como preparamos a autêntica pizza americana. Feira diariamente na loja com ingredientes frescos e de qualidade. Assada em forno especial para oferecer uma pizza com massa pan aerada, crocante e com muito queijo derretido!. Pizzaria São José ajuda a transformar um simples momento em uma deliciosa experiência. Aproveite e peça a sua!', 999);

INSERT INTO `pedido` (`id`, `data_pedido`, `hora_pedido`, `valor`, `pago`, `data_pagamento`, `estado`, `restaurante_id`, `cliente_id`) VALUES
(998, '05/04/2019', '20:27', 39.90+22.90, 1, '05/04/2019', 'Processando', 999, 999),
(999, '04/04/2019', '19:30', (2*14.50)+(3*22.90), 1, '04/04/2019', 'Processando', 999, 999);

INSERT INTO `categoria` (`id`, `nome`, `restaurante_id`) VALUES
(996, 'Almoço', 999),
(997, 'Lanches', 999),
(998, 'Pizzas', 999),
(999, 'Sobremesas', 999);

INSERT INTO `produto` (`id`, `nome`, `descricao`, `preco`, `imagem`, `promocao`, `categoria_id`, `restaurante_id`) VALUES
(997, 'Pizza de Pepperoni', 'Deliciosas fatias de pepperoni (salame especial com páprica) e mussarela', 39.90, 'uploads/produtos/PRODUTO-2019-3-31_19-42-20_999.png', 'Unitario', 998,999),
(998, 'Feijoada da Boa', 'Feijão vermelho com linguiças picadas e pé de porco', 14.50, 'uploads/produtos/PRODUTO-2019-3-31_18-43-26_779.jpg', NULL, 996, 999),
(999, 'Combo Lanche Médio', 'Hamgurguer, Refrigerante e Batata Frita', 22.90, 'uploads/produtos/PRODUTO-2019-04-6_12-37-36_126.jpg', NULL, 996, 999);

INSERT INTO `pedido_produto` (`pedido_id`, `produto_id`, `quantidade`, `preco`) VALUES
(998, 997, 1, 39.90),
(998, 999, 1, 22.90),
(999, 998, 2, 14.50),
(999, 999, 3, 22.90);