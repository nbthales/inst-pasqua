# inst-project
<pre>
<code>
use inst;

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE `clientes` (
  `codcliente` int(11) NOT NULL,
  `nomecliente` varchar(40) DEFAULT NULL,
  `cpfcnpjclientes` varchar(20) DEFAULT NULL,
  `datacclientes` date DEFAULT NULL,
  PRIMARY KEY (`codcliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
</code>
</pre>
