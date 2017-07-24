-- phpMyAdmin SQL Dump
-- version 3.2.0.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost:3306
-- Tempo de Geração: Jan 06, 2011 as 06:01 PM
-- Versão do Servidor: 5.1.46
-- Versão do PHP: 5.3.0

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `imobiliaria`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `acesso`
--

CREATE TABLE IF NOT EXISTS `acesso` (
  `idAcesso` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(40) NOT NULL,
  `senha` varchar(40) NOT NULL,
  `tipoDeUsuario` varchar(40) NOT NULL,
  PRIMARY KEY (`idAcesso`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Extraindo dados da tabela `acesso`
--

INSERT INTO `acesso` (`idAcesso`, `login`, `senha`, `tipoDeUsuario`) VALUES
(1, 'errai', 'ross248', 'cliente'),
(2, 'adm', '123', 'administrador'),
(3, 'mario', '123', 'cliente');

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluguel`
--

CREATE TABLE IF NOT EXISTS `aluguel` (
  `idAluguel` int(11) NOT NULL AUTO_INCREMENT,
  `tempoAluguel` int(11) DEFAULT NULL COMMENT 'Tabela a ser avaliada, ver cardinalidade\ne a possibilidade de conflito de dados com as tabelas compartilhada com Vendas',
  `dataAluguel` varchar(50) DEFAULT NULL,
  `idCorretor` int(11) NOT NULL,
  `idImovel` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idPagamento` int(11) NOT NULL,
  PRIMARY KEY (`idAluguel`),
  KEY `fk_Aluguel_Corretor1` (`idCorretor`),
  KEY `fk_Aluguel_Imovel1` (`idImovel`),
  KEY `fk_Aluguel_Cliente1` (`idCliente`),
  KEY `fk_Aluguel_pagamento1` (`idPagamento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Extraindo dados da tabela `aluguel`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nomeCliente` varchar(200) DEFAULT NULL,
  `cpfCliente` varchar(14) DEFAULT NULL,
  `rgCliente` varchar(30) DEFAULT NULL,
  `emailCliente` varchar(200) DEFAULT NULL,
  `idEnderecoCliente` int(11) NOT NULL,
  `idTelefoneCliente` int(11) NOT NULL,
  `idAcesso` int(11) NOT NULL,
  PRIMARY KEY (`idCliente`),
  KEY `fk_Cliente_enderecoCliente` (`idEnderecoCliente`),
  KEY `fk_Cliente_telefoneCliente1` (`idTelefoneCliente`),
  KEY `fk_Cliente_acesso1` (`idAcesso`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`idCliente`, `nomeCliente`, `cpfCliente`, `rgCliente`, `emailCliente`, `idEnderecoCliente`, `idTelefoneCliente`, `idAcesso`) VALUES
(1, 'mario antonio', '01041457499', '5950895', 'marioantonio2007@hotmail.com', 1, 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `corretor`
--

CREATE TABLE IF NOT EXISTS `corretor` (
  `idCorretor` int(11) NOT NULL AUTO_INCREMENT,
  `nomeCorretor` varchar(200) DEFAULT NULL,
  `cpfCorretor` varchar(14) DEFAULT NULL,
  `rgCorretor` varchar(30) DEFAULT NULL,
  `emailCorretor` varchar(200) DEFAULT NULL,
  `idEnderecoCorretor` int(11) NOT NULL,
  `idTelefoneCorretor` int(11) NOT NULL,
  `idAcesso` int(11) NOT NULL,
  PRIMARY KEY (`idCorretor`),
  KEY `fk_Corretor_enderecoCorretor1` (`idEnderecoCorretor`),
  KEY `fk_Corretor_telefoneCorretor1` (`idTelefoneCorretor`),
  KEY `fk_Corretor_acesso1` (`idAcesso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Extraindo dados da tabela `corretor`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `enderecocliente`
--

CREATE TABLE IF NOT EXISTS `enderecocliente` (
  `idEnderecoCliente` int(11) NOT NULL AUTO_INCREMENT,
  `ruaCliente` varchar(200) DEFAULT NULL,
  `numeroCliente` varchar(20) DEFAULT NULL,
  `complementoCliente` varchar(20) DEFAULT NULL,
  `bairroCliente` varchar(200) DEFAULT NULL,
  `cidadeCliente` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idEnderecoCliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `enderecocliente`
--

INSERT INTO `enderecocliente` (`idEnderecoCliente`, `ruaCliente`, `numeroCliente`, `complementoCliente`, `bairroCliente`, `cidadeCliente`) VALUES
(1, 'rua do alecrim', '235', 'casa', 'linha', 'limoeiro'),
(2, 'rua o', '235', 'vaa', 'kjj', 'limoerio');

-- --------------------------------------------------------

--
-- Estrutura da tabela `enderecocorretor`
--

CREATE TABLE IF NOT EXISTS `enderecocorretor` (
  `idenderecoCorretor` int(11) NOT NULL AUTO_INCREMENT,
  `ruaCorretor` varchar(200) DEFAULT NULL,
  `numeroCorretor` varchar(20) DEFAULT NULL,
  `complementoCorretor` varchar(20) DEFAULT NULL,
  `bairroCorretor` varchar(200) DEFAULT NULL,
  `cidadeCorretor` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idenderecoCorretor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Extraindo dados da tabela `enderecocorretor`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `enderecoimovel`
--

CREATE TABLE IF NOT EXISTS `enderecoimovel` (
  `idEnderecoImovel` int(11) NOT NULL AUTO_INCREMENT,
  `ruaImovel` varchar(200) DEFAULT NULL,
  `numeroImovel` varchar(20) DEFAULT NULL,
  `bairroImovel` varchar(200) DEFAULT NULL,
  `cidadeImovel` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idEnderecoImovel`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Extraindo dados da tabela `enderecoimovel`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `imovel`
--

CREATE TABLE IF NOT EXISTS `imovel` (
  `idImovel` int(11) NOT NULL AUTO_INCREMENT,
  `areaImovel` double DEFAULT NULL,
  `qtdComodos` int(11) DEFAULT NULL,
  `valorImovel` double DEFAULT NULL,
  `descricaoImovel` varchar(200) DEFAULT NULL,
  `idEnderecoImovel` int(11) NOT NULL,
  PRIMARY KEY (`idImovel`),
  KEY `fk_Imovel_enderecoImovel1` (`idEnderecoImovel`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Extraindo dados da tabela `imovel`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `pagamento`
--

CREATE TABLE IF NOT EXISTS `pagamento` (
  `idPagamento` int(11) NOT NULL AUTO_INCREMENT,
  `parcelaspagamento` int(11) DEFAULT NULL,
  `valorParcela` double DEFAULT NULL,
  `valorPagamento` double DEFAULT NULL,
  `tipoDetransacao` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`idPagamento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Extraindo dados da tabela `pagamento`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `telefonecliente`
--

CREATE TABLE IF NOT EXISTS `telefonecliente` (
  `idTelefoneCliente` int(11) NOT NULL AUTO_INCREMENT,
  `tipoTelefoneCliente` varchar(20) DEFAULT NULL,
  `dddTelefoneCliente` int(11) DEFAULT NULL,
  `numeroTelefoneCliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTelefoneCliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `telefonecliente`
--

INSERT INTO `telefonecliente` (`idTelefoneCliente`, `tipoTelefoneCliente`, `dddTelefoneCliente`, `numeroTelefoneCliente`) VALUES
(1, 'Celular', 81, 92418230),
(2, 'Fixo', 81, 95632415);

-- --------------------------------------------------------

--
-- Estrutura da tabela `telefonecorretor`
--

CREATE TABLE IF NOT EXISTS `telefonecorretor` (
  `idtelefoneCorretor` int(11) NOT NULL AUTO_INCREMENT,
  `tipoTelefoneCorretor` varchar(20) DEFAULT NULL,
  `dddTelefoneCorretor` int(11) DEFAULT NULL,
  `numeroTelefoneCorretor` int(11) DEFAULT NULL,
  PRIMARY KEY (`idtelefoneCorretor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Extraindo dados da tabela `telefonecorretor`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `venda`
--

CREATE TABLE IF NOT EXISTS `venda` (
  `idVenda` int(11) NOT NULL AUTO_INCREMENT,
  `dataVenda` varchar(20) DEFAULT NULL,
  `idCliente` int(11) NOT NULL,
  `idImovel` int(11) NOT NULL,
  `idCorretor` int(11) NOT NULL,
  `idPagamento` int(11) NOT NULL,
  PRIMARY KEY (`idVenda`),
  KEY `fk_venda_Cliente1` (`idCliente`),
  KEY `fk_venda_Imovel1` (`idImovel`),
  KEY `fk_venda_Corretor1` (`idCorretor`),
  KEY `fk_venda_pagamento1` (`idPagamento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Extraindo dados da tabela `venda`
--


--
-- Restrições para as tabelas dumpadas
--

--
-- Restrições para a tabela `aluguel`
--
ALTER TABLE `aluguel`
  ADD CONSTRAINT `fk_Aluguel_Cliente1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Aluguel_Corretor1` FOREIGN KEY (`idCorretor`) REFERENCES `corretor` (`idCorretor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Aluguel_Imovel1` FOREIGN KEY (`idImovel`) REFERENCES `imovel` (`idImovel`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Aluguel_pagamento1` FOREIGN KEY (`idPagamento`) REFERENCES `pagamento` (`idPagamento`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `fk_Cliente_acesso1` FOREIGN KEY (`idAcesso`) REFERENCES `acesso` (`idAcesso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Cliente_enderecoCliente` FOREIGN KEY (`idEnderecoCliente`) REFERENCES `enderecocliente` (`idEnderecoCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Cliente_telefoneCliente1` FOREIGN KEY (`idTelefoneCliente`) REFERENCES `telefonecliente` (`idTelefoneCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `corretor`
--
ALTER TABLE `corretor`
  ADD CONSTRAINT `fk_Corretor_acesso1` FOREIGN KEY (`idAcesso`) REFERENCES `acesso` (`idAcesso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Corretor_enderecoCorretor1` FOREIGN KEY (`idEnderecoCorretor`) REFERENCES `enderecocorretor` (`idenderecoCorretor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Corretor_telefoneCorretor1` FOREIGN KEY (`idTelefoneCorretor`) REFERENCES `telefonecorretor` (`idtelefoneCorretor`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `imovel`
--
ALTER TABLE `imovel`
  ADD CONSTRAINT `fk_Imovel_enderecoImovel1` FOREIGN KEY (`idEnderecoImovel`) REFERENCES `enderecoimovel` (`idEnderecoImovel`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `venda`
--
ALTER TABLE `venda`
  ADD CONSTRAINT `fk_venda_Cliente1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_venda_Corretor1` FOREIGN KEY (`idCorretor`) REFERENCES `corretor` (`idCorretor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_venda_Imovel1` FOREIGN KEY (`idImovel`) REFERENCES `imovel` (`idImovel`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_venda_pagamento1` FOREIGN KEY (`idPagamento`) REFERENCES `pagamento` (`idPagamento`) ON DELETE NO ACTION ON UPDATE NO ACTION;
