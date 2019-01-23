-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-01-2019 a las 17:19:15
-- Versión del servidor: 10.1.32-MariaDB
-- Versión de PHP: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `distribuidas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actividad_jlal`
--

CREATE TABLE `actividad_jlal` (
  `CODIGO_ACTIVIDAD` int(11) NOT NULL,
  `NOMBRE_ACTIVIDAD` varchar(254) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `actividad_jlal`
--

INSERT INTO `actividad_jlal` (`CODIGO_ACTIVIDAD`, `NOMBRE_ACTIVIDAD`) VALUES
(1, 'cd');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `activo_jlal`
--

CREATE TABLE `activo_jlal` (
  `CODIGO_ACTIVO` int(11) NOT NULL,
  `NOMBRE_ACTIVO` varchar(254) DEFAULT NULL,
  `FECHA_ACTIVO` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autor_cuda`
--

CREATE TABLE `autor_cuda` (
  `CODIGO_AUTOR` int(11) NOT NULL,
  `NOMBRE_AUTOR` char(50) DEFAULT NULL,
  `APELLIDO_AUTOR` char(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `autor_cuda`
--

INSERT INTO `autor_cuda` (`CODIGO_AUTOR`, `NOMBRE_AUTOR`, `APELLIDO_AUTOR`) VALUES
(1, 'Cristina', 'Diaz'),
(2, 'Juan', 'Lopez');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cabecera_comprobante`
--

CREATE TABLE `cabecera_comprobante` (
  `NUMERO_CABECERA` int(11) NOT NULL,
  `FECHA_CABECERA` datetime DEFAULT NULL,
  `OBSERVACIONES` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cabecera_cuda`
--

CREATE TABLE `cabecera_cuda` (
  `NUMERO_PRESTAMO` int(11) NOT NULL,
  `FECHA_PRESTAMO` datetime DEFAULT NULL,
  `DESCRIPCION_PRESTAMO` char(255) DEFAULT NULL,
  `FECHAENTREGA_PRESTAMO` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta`
--

CREATE TABLE `cuenta` (
  `CODIGO_CUENTA` int(11) NOT NULL,
  `CODIGO_TIPO` int(11) NOT NULL,
  `NOMBRE_CUENTA` varchar(35) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_comprobante`
--

CREATE TABLE `detalle_comprobante` (
  `CODIGO_D_DETALLE` int(11) NOT NULL,
  `NUMERO_CABECERA` int(11) NOT NULL,
  `CODIGO_CUENTA` int(11) NOT NULL,
  `CANTIDAD_DEBE` decimal(10,2) DEFAULT NULL,
  `CANTIDAD_HABER` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_cuda`
--

CREATE TABLE `detalle_cuda` (
  `NUMERO_PRESTAMO` int(11) NOT NULL,
  `ISBN_LIBRO` decimal(8,0) NOT NULL,
  `CANTIDAD` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_mantenimiento_jlal`
--

CREATE TABLE `detalle_mantenimiento_jlal` (
  `CODIGO_ACTIVIDAD` int(11) NOT NULL,
  `CODIGO_ACTIVO` int(11) NOT NULL,
  `NUMERO_MANTENIMIENTO` int(11) NOT NULL,
  `VALOR_D_MANTENIMIENTO` decimal(8,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro_cuda`
--

CREATE TABLE `libro_cuda` (
  `ISBN_LIBRO` decimal(8,0) NOT NULL,
  `CODIGO_AUTOR` int(11) NOT NULL,
  `TITULO_LIBRO` char(255) DEFAULT NULL,
  `VALOR_LIBRO` decimal(10,0) DEFAULT NULL,
  `CANTIDAD_LIBRO` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mantenimiento_jlal`
--

CREATE TABLE `mantenimiento_jlal` (
  `NUMERO_MANTENIMIENTO` int(11) NOT NULL,
  `FECHA_MANTENIMIENTO` datetime DEFAULT NULL,
  `RESPONSABLE_MANTENIMIENTO` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `soporte`
--

CREATE TABLE `soporte` (
  `codigo` int(10) UNSIGNED NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `mensaje` varchar(60) NOT NULL,
  `fecha` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `soporte`
--

INSERT INTO `soporte` (`codigo`, `nombre`, `mensaje`, `fecha`) VALUES
(1, 'cristina', 'buenas noches', '23-01-2019'),
(2, 'cristina', 'buenas noche', '23-01-2019'),
(3, 'juan', 'Escribe aqui tus solicitudes', '23-1-2019'),
(4, 'juana', 'holaaaa', '23-1-2019');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_cuenta`
--

CREATE TABLE `tipo_cuenta` (
  `CODIGO_TIPO` int(11) NOT NULL,
  `NOMBRE_TIPO` varchar(35) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `CODIGO` int(11) NOT NULL,
  `NOMBRE` char(255) DEFAULT NULL,
  `CONTRASENA` char(255) DEFAULT NULL,
  `PERMISOS` char(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `actividad_jlal`
--
ALTER TABLE `actividad_jlal`
  ADD PRIMARY KEY (`CODIGO_ACTIVIDAD`);

--
-- Indices de la tabla `activo_jlal`
--
ALTER TABLE `activo_jlal`
  ADD PRIMARY KEY (`CODIGO_ACTIVO`);

--
-- Indices de la tabla `autor_cuda`
--
ALTER TABLE `autor_cuda`
  ADD PRIMARY KEY (`CODIGO_AUTOR`);

--
-- Indices de la tabla `cabecera_comprobante`
--
ALTER TABLE `cabecera_comprobante`
  ADD PRIMARY KEY (`NUMERO_CABECERA`);

--
-- Indices de la tabla `cabecera_cuda`
--
ALTER TABLE `cabecera_cuda`
  ADD PRIMARY KEY (`NUMERO_PRESTAMO`);

--
-- Indices de la tabla `cuenta`
--
ALTER TABLE `cuenta`
  ADD PRIMARY KEY (`CODIGO_CUENTA`),
  ADD KEY `FK_CUENTA_FK_CUENTA_TIPO_CUE` (`CODIGO_TIPO`);

--
-- Indices de la tabla `detalle_comprobante`
--
ALTER TABLE `detalle_comprobante`
  ADD PRIMARY KEY (`CODIGO_D_DETALLE`),
  ADD KEY `FK_DETALLE__FK_DETALL_CABECERA` (`NUMERO_CABECERA`),
  ADD KEY `FK_DETALLE__FK_DETALL_CUENTA` (`CODIGO_CUENTA`);

--
-- Indices de la tabla `detalle_cuda`
--
ALTER TABLE `detalle_cuda`
  ADD PRIMARY KEY (`NUMERO_PRESTAMO`,`ISBN_LIBRO`),
  ADD KEY `FK_DETALLE__FK_DETALL_LIBRO_CU` (`ISBN_LIBRO`);

--
-- Indices de la tabla `detalle_mantenimiento_jlal`
--
ALTER TABLE `detalle_mantenimiento_jlal`
  ADD PRIMARY KEY (`CODIGO_ACTIVIDAD`,`CODIGO_ACTIVO`,`NUMERO_MANTENIMIENTO`),
  ADD KEY `FK_DETALLE__DETALLE_M_MANTENIM` (`NUMERO_MANTENIMIENTO`);

--
-- Indices de la tabla `libro_cuda`
--
ALTER TABLE `libro_cuda`
  ADD PRIMARY KEY (`ISBN_LIBRO`);

--
-- Indices de la tabla `mantenimiento_jlal`
--
ALTER TABLE `mantenimiento_jlal`
  ADD PRIMARY KEY (`NUMERO_MANTENIMIENTO`);

--
-- Indices de la tabla `soporte`
--
ALTER TABLE `soporte`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `tipo_cuenta`
--
ALTER TABLE `tipo_cuenta`
  ADD PRIMARY KEY (`CODIGO_TIPO`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`CODIGO`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cabecera_comprobante`
--
ALTER TABLE `cabecera_comprobante`
  MODIFY `NUMERO_CABECERA` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cuenta`
--
ALTER TABLE `cuenta`
  MODIFY `CODIGO_CUENTA` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `detalle_comprobante`
--
ALTER TABLE `detalle_comprobante`
  MODIFY `CODIGO_D_DETALLE` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `mantenimiento_jlal`
--
ALTER TABLE `mantenimiento_jlal`
  MODIFY `NUMERO_MANTENIMIENTO` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `soporte`
--
ALTER TABLE `soporte`
  MODIFY `codigo` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tipo_cuenta`
--
ALTER TABLE `tipo_cuenta`
  MODIFY `CODIGO_TIPO` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `CODIGO` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cuenta`
--
ALTER TABLE `cuenta`
  ADD CONSTRAINT `FK_CUENTA_FK_CUENTA_TIPO_CUE` FOREIGN KEY (`CODIGO_TIPO`) REFERENCES `tipo_cuenta` (`CODIGO_TIPO`);

--
-- Filtros para la tabla `detalle_comprobante`
--
ALTER TABLE `detalle_comprobante`
  ADD CONSTRAINT `FK_DETALLE__FK_DETALL_CABECERA` FOREIGN KEY (`NUMERO_CABECERA`) REFERENCES `cabecera_comprobante` (`NUMERO_CABECERA`),
  ADD CONSTRAINT `FK_DETALLE__FK_DETALL_CUENTA` FOREIGN KEY (`CODIGO_CUENTA`) REFERENCES `cuenta` (`CODIGO_CUENTA`);

--
-- Filtros para la tabla `detalle_cuda`
--
ALTER TABLE `detalle_cuda`
  ADD CONSTRAINT `FK_DETALLE__FK_DETALL_LIBRO_CU` FOREIGN KEY (`ISBN_LIBRO`) REFERENCES `libro_cuda` (`ISBN_LIBRO`);

--
-- Filtros para la tabla `detalle_mantenimiento_jlal`
--
ALTER TABLE `detalle_mantenimiento_jlal`
  ADD CONSTRAINT `FK_DETALLE__DETALLE_M_MANTENIM` FOREIGN KEY (`NUMERO_MANTENIMIENTO`) REFERENCES `mantenimiento_jlal` (`NUMERO_MANTENIMIENTO`),
  ADD CONSTRAINT `FK_DETALLE__FK_DETALL_ACTIVIDA` FOREIGN KEY (`CODIGO_ACTIVIDAD`) REFERENCES `actividad_jlal` (`CODIGO_ACTIVIDAD`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
