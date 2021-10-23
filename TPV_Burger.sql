-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-10-2021 a las 14:14:35
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tpv_burger`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `Id` int(10) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido1` varchar(45) NOT NULL,
  `apellido2` varchar(45) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `email` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`Id`, `nombre`, `apellido1`, `apellido2`, `telefono`, `email`) VALUES
(1, 'sin registro', '-', '-', '-', '-'),
(18, 'Eduardo', 'Lahuerta', 'Frías', '976000072', 'edu@yahoo.es'),
(19, 'Juanjo', 'Fernández', 'Lacuesta', '975362140', 'juanjo@hotmail.es'),
(20, 'Santiago', 'Frisas', 'Calanda', '976976976', 'santi@gmail.com'),
(21, 'Adrian', 'Puertas', 'Ramírez', '974147852', 'adrian@outlook.es'),
(22, 'Carmen', 'Comet', 'Gabás', '978978978', 'carmen@gmail.com'),
(25, 'Ana', 'García', 'Garralaga', '976258963', 'ana@hotmail.com'),
(26, 'Alberto', 'Minguez', 'Escobar', '974974974', 'alberto@yahoo.com'),
(31, 'Rodrigo', 'Sanz', 'Corredor', '976123456', 'rodrigo@outlook.es'),
(32, 'Fernando', 'Gómez', 'Heras', '975975975', 'fernando@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ticket`
--

CREATE TABLE `ticket` (
  `id` int(10) NOT NULL,
  `id_cliente` int(10) DEFAULT NULL,
  `productos` varchar(400) NOT NULL,
  `fecha` varchar(10) NOT NULL,
  `hora` varchar(10) NOT NULL,
  `total` double(5,1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `ticket`
--

INSERT INTO `ticket` (`id`, `id_cliente`, `productos`, `fecha`, `hora`, `total`) VALUES
(7, 18, '\nHamburguesa sencilla   4.0 €\nHamburguesa con queso   4.5 €\nVino joven   2.0 €\nCaña cerveza   2.0 €\n', '18/01/2021', '22:31:52', 12.5),
(8, 18, '\nMenú nº3   7.5 €\nMenú nº4   8.5 €\nTarta chocolate   4.0 €\ndescuento cliente 10%   -2.0 €\nMenú nº3   7.5 €\nMenú nº6   8.5 €\n', '18/01/2021', '22:35:15', 34.0),
(9, 19, '\nMenú nº1   8.5 €\nMenú nº2   9.5 €\n', '18/01/2021', '23:01:22', 18.0),
(10, 19, '\nMenú nº3   7.5 €\nHamburguesa con bacon   4.5 €\nHamburguesa vegana   4.5 €\nTarta chocolate   4.0 €\ndescuento cliente 10%   -2.05 €\n', '18/01/2021', '23:24:47', 18.4),
(11, 18, '\nHamburguesa sencilla   4.0 €\nHamburguesa con bacon   4.5 €\nEnsalada mediterranea   5.5 €\nVino joven   2.0 €\nCaña cerveza   2.0 €\nCafé   1.5 €\ndescuento cliente 10%   -1.95 €\n', '17/01/2021', '00:05:25', 17.6),
(12, 18, '\nHamburguesa vegana   4.5 €\nInfusión   1.5 €\n', '17/01/2021', '00:17:48', 6.0),
(13, 20, '\nHamburguesa sencilla   4.0 €\nHamburguesa con bacon   4.5 €\nPatatas fritas   2.5 €\nNuggets de pollo   2.5 €\nCaña cerveza   2.0 €\nCaña cerveza   2.0 €\nAgua   1.5 €\ndescuento cliente 10%   -1.9 €\n', '19/01/2021', '01:49:57', 17.1),
(16, 21, '\nMenú nº1   8.5 €\nMenú nº4   8.5 €\nTarta chocolate   4.0 €\n', '19/01/2021', '18:23:55', 21.0),
(18, 18, '\nHamburguesa con bacon   4.5 €\nHamburguesa especial   6.5 €\nCaña cerveza   2.0 €\nVino joven   2.0 €\ndescuento cliente 10%   -1.5 €\n', '19/01/2021', '18:25:57', 13.5),
(20, 22, '\nHamburguesa doble   6.0 €\nHamburguesa especial   6.5 €\nHelado sabores   2.5 €\nRefresco   2.5 €\nAgua   1.5 €\n', '19/01/2021', '18:32:39', 19.0),
(23, 20, '\nHamburguesa sencilla   4.0 €\nMenú nº3   7.5 €\nAlitas de pollo   3.5 €\nRefresco   2.5 €\n', '19/01/2021', '18:48:45', 17.5),
(24, 1, '\nMenú nº3   7.5 €\nMenú nº2   9.5 €\n', '19/01/2021', '18:49:32', 17.0),
(25, 1, '\nHamburguesa con bacon   4.5 €\nHamburguesa con queso   4.5 €\nEnsalada mediterranea   5.5 €\nVino joven   2.0 €\nAgua   1.5 €\ndescuento cliente 10%   -1.8 €\n', '20/01/2021', '18:51:35', 16.2),
(26, 22, '\nMenú nº1   8.5 €\nHamburguesa doble   6.0 €\nPatatas fritas   2.5 €\nCaña cerveza   2.0 €\ndescuento cliente 10%   -1.9 €\n', '20/01/2021', '20:56:03', 17.1),
(29, 21, '\nHamburguesa sencilla   4.0 €\nHamburguesa con bacon   4.5 €\nZumo   2.0 €\nBatido   2.0 €\n', '19/01/2021', '21:46:30', 12.5),
(30, 22, '\nHamburguesa con bacon   4.5 €\nHamburguesa vegana   4.5 €\nAlitas de pollo   3.5 €\nVino joven   2.0 €\nCaña cerveza   2.0 €\ndescuento cliente 10%   -1.65 €\n', '19/01/2021', '21:59:00', 14.8),
(32, 18, '\nMenú nº4   8.5 €\nHamburguesa con bacon   4.5 €\nPatatas fritas   2.5 €\nCaña cerveza sin alcohol   2.0 €\ndescuento cliente 10%   -1.75 €\n', '21/01/2021', '21:35:37', 15.8),
(33, 25, '\nMenú nº4   8.5 €\nHamburguesa con bacon   4.5 €\nEnsalada mediterranea   5.5 €\nHelado sabores   2.5 €\nVino joven   2.0 €\nAgua   1.5 €\n', '21/01/2021', '23:13:43', 24.5),
(34, 1, '\nHamburguesa doble   6.0 €\nHamburguesa vegana   4.5 €\nCaña cerveza   2.0 €\nCaña cerveza   2.0 €\n', '21/01/2021', '23:15:14', 14.5),
(35, 21, '\nHamburguesa con queso   4.5 €\nHamburguesa doble   6.0 €\nPatatas fritas   2.5 €\nTarta chocolate   4.0 €\nCaña cerveza   2.0 €\nCaña cerveza sin alcohol   2.0 €\nCafé   1.5 €\nInfusión   1.5 €\ndescuento cliente 10%   -2.4 €\n', '21/01/2021', '23:17:13', 21.6),
(36, 22, '\nMenú nº1   8.5 €\nHamburguesa vegana   4.5 €\nAlitas de pollo   3.5 €\nRefresco   2.5 €\nBatido   2.0 €\n', '21/01/2021', '23:19:08', 21.0),
(37, 1, '\nHamburguesa con bacon   4.5 €\nHamburguesa doble   6.0 €\nPatatas fritas   2.5 €\nCaña cerveza   2.0 €\nCaña cerveza   2.0 €\n', '23/10/2021', '14:01:10', 17.0),
(38, 32, '\nHamburguesa con bacon   4.5 €\nHamburguesa doble   6.0 €\nEnsalada mediterranea   5.5 €\nVino joven   2.0 €\nRefresco   2.5 €\n', '23/10/2021', '14:02:15', 20.5),
(39, 31, '\nMenú nº3   7.5 €\nHamburguesa vegana   4.5 €\nVino joven   2.0 €\n', '23/10/2021', '14:03:12', 14.0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `telefono` (`telefono`);

--
-- Indices de la tabla `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_TICKET` (`id_cliente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT de la tabla `ticket`
--
ALTER TABLE `ticket`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `FK_TICKET` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
