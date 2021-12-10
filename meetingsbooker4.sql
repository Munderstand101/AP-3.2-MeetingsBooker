-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 10, 2021 at 12:41 PM
-- Server version: 5.7.24
-- PHP Version: 7.2.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `meetingsbooker`
--

-- --------------------------------------------------------

--
-- Table structure for table `date_contact`
--

CREATE TABLE `date_contact` (
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `date_contact`
--

INSERT INTO `date_contact` (`date`) VALUES
('2021-11-19');

-- --------------------------------------------------------

--
-- Table structure for table `duree`
--

CREATE TABLE `duree` (
  `idDuree` int(11) NOT NULL,
  `libelleDuree` varchar(128) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `duree`
--

INSERT INTO `duree` (`idDuree`, `libelleDuree`) VALUES
(1, 'matin'),
(2, 'apres-midi'),
(3, 'toute la journée');

-- --------------------------------------------------------

--
-- Table structure for table `entreprise`
--

CREATE TABLE `entreprise` (
  `idEntreprise` int(11) NOT NULL,
  `idVille` int(11) NOT NULL,
  `nomEntreprise` varchar(128) DEFAULT NULL,
  `adresseEntreprise` varchar(128) DEFAULT NULL,
  `telEntreprise` varchar(10) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `entreprise`
--

INSERT INTO `entreprise` (`idEntreprise`, `idVille`, `nomEntreprise`, `adresseEntreprise`, `telEntreprise`, `email`) VALUES
(1, 1, 'test', 'test', '50500.00', 'test@test.com'),
(2, 2, 'test bacau', '2 strada dtfhgf', '6666.00', 'test@bacau.com');

-- --------------------------------------------------------

--
-- Table structure for table `lieu`
--

CREATE TABLE `lieu` (
  `idLieu` int(11) NOT NULL,
  `idVille` int(11) NOT NULL,
  `idEntreprise` int(11) NOT NULL,
  `libelleLieu` varchar(128) DEFAULT NULL,
  `adresseLieu` varchar(50) DEFAULT NULL,
  `coordX` decimal(10,2) DEFAULT NULL,
  `coordY` decimal(10,2) DEFAULT NULL,
  `annulationGratuite` tinyint(1) DEFAULT NULL,
  `nbEtoiles` int(2) DEFAULT NULL,
  `descriptif` varchar(128) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lieu`
--

INSERT INTO `lieu` (`idLieu`, `idVille`, `idEntreprise`, `libelleLieu`, `adresseLieu`, `coordX`, `coordY`, `annulationGratuite`, `nbEtoiles`, `descriptif`) VALUES
(1, 2, 2, 'test', 'test', '555.00', '556.00', 1, 5, 'test'),
(2, 2, 2, 'vnvbn', 'vbnvbn', '55.00', '22.00', 0, 3, 'lieu magnifique');

-- --------------------------------------------------------

--
-- Table structure for table `loueur`
--

CREATE TABLE `loueur` (
  `idLoueur` int(11) NOT NULL,
  `IdEntreprise` int(11) NOT NULL,
  `Nom` varchar(128) DEFAULT NULL,
  `Prenom` varchar(128) DEFAULT NULL,
  `contact?` tinyint(1) DEFAULT NULL,
  `telContact` varchar(10) DEFAULT NULL,
  `mailContact` varchar(128) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `loueur`
--

INSERT INTO `loueur` (`idLoueur`, `IdEntreprise`, `Nom`, `Prenom`, `contact?`, `telContact`, `mailContact`) VALUES
(1, 1, 'cletest', 'thetest', 1, '0100000000', 'lemail@wanadoo.com');

-- --------------------------------------------------------

--
-- Table structure for table `pays`
--

CREATE TABLE `pays` (
  `idPays` int(11) NOT NULL,
  `nomPays` varchar(128) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pays`
--

INSERT INTO `pays` (`idPays`, `nomPays`) VALUES
(1, 'France'),
(2, 'Roumanie'),
(3, 'Armenie'),
(4, 'Alemagne'),
(5, 'Espagne');

-- --------------------------------------------------------

--
-- Table structure for table `photo`
--

CREATE TABLE `photo` (
  `idPhoto` int(11) NOT NULL,
  `idSalle` int(11) NOT NULL,
  `lienPhoto` varchar(128) DEFAULT NULL,
  `estPrincipale?` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `reservant`
--

CREATE TABLE `reservant` (
  `idEntreprise` int(11) NOT NULL,
  `idReservant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reservant`
--

INSERT INTO `reservant` (`idEntreprise`, `idReservant`) VALUES
(2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `idResa` int(11) NOT NULL,
  `idSalle` int(11) NOT NULL,
  `idDuree` int(11) NOT NULL,
  `idEntreprise` int(11) NOT NULL,
  `nbPersonnes` smallint(1) DEFAULT NULL,
  `dateResa` date DEFAULT NULL,
  `dateDebut` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`idResa`, `idSalle`, `idDuree`, `idEntreprise`, `nbPersonnes`, `dateResa`, `dateDebut`) VALUES
(1, 1, 1, 1, 2, '2021-11-29', '2021-12-08'),
(2, 1, 1, 1, 5, '2021-11-14', '2021-12-01');

-- --------------------------------------------------------

--
-- Table structure for table `salle`
--

CREATE TABLE `salle` (
  `idSalle` int(11) NOT NULL,
  `idLieu` int(11) NOT NULL,
  `nomSalle` varchar(128) DEFAULT NULL,
  `largeur` int(10) DEFAULT NULL,
  `longueur` int(10) DEFAULT NULL,
  `surface` int(10) DEFAULT NULL,
  `hauteur` int(10) DEFAULT NULL,
  `capacité` smallint(1) DEFAULT NULL,
  `tarifDemiJournée` decimal(13,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salle`
--

INSERT INTO `salle` (`idSalle`, `idLieu`, `nomSalle`, `largeur`, `longueur`, `surface`, `hauteur`, `capacité`, `tarifDemiJournée`) VALUES
(1, 2, 'ghjgh', 99, 20, 90, 15, 150, '80.00');

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `idUtilisateur` int(11) NOT NULL,
  `Login` varchar(128) DEFAULT NULL,
  `mdp` varchar(128) DEFAULT NULL,
  `statut` varchar(128) DEFAULT NULL,
  `nom` varchar(128) DEFAULT NULL,
  `prenom` varchar(128) DEFAULT NULL,
  `adresse` varchar(128) DEFAULT NULL,
  `codepostal` varchar(5) DEFAULT NULL,
  `tel` varchar(10) DEFAULT NULL,
  `mail` varchar(128) DEFAULT NULL,
  `pourcentage` varchar(128) DEFAULT NULL,
  `idEntreprise` int(11) DEFAULT NULL,
  `dateInscription` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`idUtilisateur`, `Login`, `mdp`, `statut`, `nom`, `prenom`, `adresse`, `codepostal`, `tel`, `mail`, `pourcentage`, `idEntreprise`, `dateInscription`) VALUES
(1, 'valentin', 'valentin', 'commerciaux', 'anchidin', 'valentin stefan', 'route incroyable', '33555', '0606060606', 'themail@gmail.com', '10%', 2, '2021-11-15'),
(2, 'd', 'd', 'commerciaux', 'Frindel', 'Arthur', 'aeae', '55555', '0440404040', 'laelaelae@gmail.com', '8%', 1, '2021-12-01');

-- --------------------------------------------------------

--
-- Table structure for table `ville`
--

CREATE TABLE `ville` (
  `idVille` int(11) NOT NULL,
  `idPays` int(11) NOT NULL,
  `nomVille` varchar(128) DEFAULT NULL,
  `codePostal` bigint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ville`
--

INSERT INTO `ville` (`idVille`, `idPays`, `nomVille`, `codePostal`) VALUES
(1, 1, 'Bordeaux', 33310),
(2, 2, 'Bacau', 88999);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `date_contact`
--
ALTER TABLE `date_contact`
  ADD PRIMARY KEY (`date`);

--
-- Indexes for table `duree`
--
ALTER TABLE `duree`
  ADD PRIMARY KEY (`idDuree`);

--
-- Indexes for table `entreprise`
--
ALTER TABLE `entreprise`
  ADD PRIMARY KEY (`idEntreprise`),
  ADD KEY `I_FK_ENTREPRISE_VILLE` (`idVille`);

--
-- Indexes for table `lieu`
--
ALTER TABLE `lieu`
  ADD PRIMARY KEY (`idLieu`),
  ADD KEY `I_FK_LIEU_LOUEUR` (`idEntreprise`),
  ADD KEY `I_FK_LIEU_VILLE` (`idVille`);

--
-- Indexes for table `loueur`
--
ALTER TABLE `loueur`
  ADD PRIMARY KEY (`idLoueur`),
  ADD KEY `I_FK_LOUEUR_UTILISATEUR` (`idLoueur`),
  ADD KEY `I_FK_LOUEUR_ENTREPRISE` (`IdEntreprise`);

--
-- Indexes for table `pays`
--
ALTER TABLE `pays`
  ADD PRIMARY KEY (`idPays`);

--
-- Indexes for table `photo`
--
ALTER TABLE `photo`
  ADD PRIMARY KEY (`idPhoto`),
  ADD KEY `I_FK_PHOTO_SALLE` (`idSalle`);

--
-- Indexes for table `reservant`
--
ALTER TABLE `reservant`
  ADD PRIMARY KEY (`idReservant`),
  ADD KEY `I_FK_RESERVANT_ENTREPRISE` (`idEntreprise`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`idResa`),
  ADD KEY `I_FK_RESERVATION_SALLE` (`idSalle`),
  ADD KEY `I_FK_RESERVATION_ENTREPRISE` (`idEntreprise`),
  ADD KEY `I_FK_RESERVATION_DUREE` (`idDuree`);

--
-- Indexes for table `salle`
--
ALTER TABLE `salle`
  ADD PRIMARY KEY (`idSalle`),
  ADD KEY `I_FK_SALLE_LIEU` (`idLieu`);

--
-- Indexes for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`idUtilisateur`),
  ADD KEY `I_FK_ENTREPRISE_UTILISATEUR` (`idEntreprise`);

--
-- Indexes for table `ville`
--
ALTER TABLE `ville`
  ADD PRIMARY KEY (`idVille`),
  ADD KEY `I_FK_VILLE_PAYS` (`idPays`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `duree`
--
ALTER TABLE `duree`
  MODIFY `idDuree` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `entreprise`
--
ALTER TABLE `entreprise`
  MODIFY `idEntreprise` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `lieu`
--
ALTER TABLE `lieu`
  MODIFY `idLieu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `pays`
--
ALTER TABLE `pays`
  MODIFY `idPays` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `photo`
--
ALTER TABLE `photo`
  MODIFY `idPhoto` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `reservant`
--
ALTER TABLE `reservant`
  MODIFY `idReservant` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `idResa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `salle`
--
ALTER TABLE `salle`
  MODIFY `idSalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `idUtilisateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `ville`
--
ALTER TABLE `ville`
  MODIFY `idVille` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `entreprise`
--
ALTER TABLE `entreprise`
  ADD CONSTRAINT `entreprise_ibfk_1` FOREIGN KEY (`idVille`) REFERENCES `ville` (`idVille`);

--
-- Constraints for table `lieu`
--
ALTER TABLE `lieu`
  ADD CONSTRAINT `lieu_ibfk_1` FOREIGN KEY (`idEntreprise`) REFERENCES `entreprise` (`idEntreprise`),
  ADD CONSTRAINT `lieu_ibfk_2` FOREIGN KEY (`idVille`) REFERENCES `ville` (`idVille`);

--
-- Constraints for table `loueur`
--
ALTER TABLE `loueur`
  ADD CONSTRAINT `loueur_ibfk_1` FOREIGN KEY (`idLoueur`) REFERENCES `utilisateur` (`idUtilisateur`),
  ADD CONSTRAINT `loueur_ibfk_2` FOREIGN KEY (`IdEntreprise`) REFERENCES `entreprise` (`idEntreprise`);

--
-- Constraints for table `photo`
--
ALTER TABLE `photo`
  ADD CONSTRAINT `photo_ibfk_1` FOREIGN KEY (`idSalle`) REFERENCES `salle` (`idSalle`);

--
-- Constraints for table `reservant`
--
ALTER TABLE `reservant`
  ADD CONSTRAINT `reservant_ibfk_1` FOREIGN KEY (`idEntreprise`) REFERENCES `entreprise` (`idEntreprise`);

--
-- Constraints for table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`idSalle`) REFERENCES `salle` (`idSalle`),
  ADD CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`idEntreprise`) REFERENCES `entreprise` (`idEntreprise`),
  ADD CONSTRAINT `reservation_ibfk_3` FOREIGN KEY (`idDuree`) REFERENCES `duree` (`idDuree`);

--
-- Constraints for table `salle`
--
ALTER TABLE `salle`
  ADD CONSTRAINT `salle_ibfk_1` FOREIGN KEY (`idLieu`) REFERENCES `lieu` (`idLieu`);

--
-- Constraints for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `cleetrangere` FOREIGN KEY (`idEntreprise`) REFERENCES `entreprise` (`idEntreprise`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ville`
--
ALTER TABLE `ville`
  ADD CONSTRAINT `ville_ibfk_1` FOREIGN KEY (`idPays`) REFERENCES `pays` (`idPays`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
