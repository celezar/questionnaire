CREATE TABLE `Answer` (
  `id` bigint(20) NOT NULL,
  `answerText` varchar(255) DEFAULT NULL,
  `correct` bit(1) NOT NULL,
  `question` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_10px8tkuusw0b830rg9eei5so` (`question`),
  CONSTRAINT `FK_10px8tkuusw0b830rg9eei5so` FOREIGN KEY (`question`) REFERENCES `Question` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ;

CREATE TABLE `Question` (
  `id` bigint(20) NOT NULL,
  `questionText` varchar(255) DEFAULT NULL,
  `questionSet` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_621y4292cwkkj15u7e3rfv6ws` (`questionSet`),
  CONSTRAINT `FK_621y4292cwkkj15u7e3rfv6ws` FOREIGN KEY (`questionSet`) REFERENCES `QuestionSet` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ;

CREATE TABLE `QuestionSet` (
  `id` bigint(20) NOT NULL,
  `decsription` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ;
