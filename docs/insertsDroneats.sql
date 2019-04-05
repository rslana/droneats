INSERT INTO `cliente` (`id`, `nome`, `email`, `senha`, `cpf`, `cidade`, `estado`, `bairro`, `rua`, `numero`, `cep`, `telefone`) 
VALUES (999, 'João da Silva', 'joao@gmail.com', '123', '12345678912', 'Juiz de Fora', 'Minas Gerais', 'Fabrica', 'Bernardo Mascarenhas', '2000', '36080000', '3233332222');

INSERT INTO `proprietario` (`id`, `nome`, `email`, `senha`, `cpf`, `cidade`, `estado`, `bairro`, `rua`, `numero`, `cep`, `telefone`) VALUES
(999, 'Joaquim Pereira', 'joaquim@gmail.com', '123', '98765432198', 'Três Rios', 'Rio de Janeiro', 'Trevo de Quatro Folhas', '1234', '45098123', '4399994444', '1231231');

INSERT INTO `restaurante` (`id`, `nome`, `email`, `cnpj`, `cidade`, `estado`, `bairro`, `rua`, `numero`, `cep`, `telefone`, `descricao`, `proprietario_id`) VALUES
(999, 'Pizzaria São José', NULL, '1231231212332/342000', 'Rio de Janeiro', 'Rio de Janeiro', 'Flor de Luz', 'Caramelo', '354', '99988832', '4499992222', 'Nós da Pizzaria São José amamos pizza! E temos muito orgulho de como preparamos a autêntica pizza americana. Feira diariamente na loja com ingredientes frescos e de qualidade. Assada em forno especial para oferecer uma pizza com massa pan aerada, crocante e com muito queijo derretido!. Pizzaria São José ajuda a transformar um simples momento em uma deliciosa experiência. Aproveite e peça a sua!', 999);

INSERT INTO `pedido` (`id`, `data_pedido`, `hora_pedido`, `valor`, `pago`, `data_pagamento`, `restaurante_id`, `cliente_id`) VALUES
(999, '04/04/2019', '19:30', 0.00, 1, NULL, 999, 999);

INSERT INTO `produto` (`id`, `nome`, `descricao`, `preco`, `imagem`, `restaurante_id`) VALUES
(998, 'Pizza de Pepperoni', 'Deliciosas fatias de pepperoni (salame especial com páprica) e mussarela', 39.90, 'uploads/produtos/PRODUTO-2019-3-31_19-42-20_999.png', 999),
(999, 'Feijoada da Boa', 'Feijão vermelho com linguiças picadas e pé de porco', 14.50, 'uploads/produtos/PRODUTO-2019-3-31_18-43-26_779.jpg', 999);

INSERT INTO `pedido_produto` (`pedido_id`, `produto_id`, `quantidade`, `preco`) VALUES
(999, 998, 2, 22.90),
(999, 999, 3, 14.50);