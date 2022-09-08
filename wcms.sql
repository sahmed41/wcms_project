-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 04, 2022 at 09:41 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `wcms`
--

-- --------------------------------------------------------

--
-- Table structure for table `elephant`
--

CREATE TABLE `elephant` (
  `id` int(11) NOT NULL,
  `picture` varchar(100) NOT NULL,
  `chip_number` varchar(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `height` varchar(50) NOT NULL,
  `weight` varchar(50) NOT NULL,
  `habitat` int(11) NOT NULL,
  `status` varchar(5) NOT NULL,
  `registered_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `elephant`
--

INSERT INTO `elephant` (`id`, `picture`, `chip_number`, `name`, `gender`, `height`, `weight`, `habitat`, `status`, `registered_date`) VALUES
(5, 'xxx', '111', 'Boba', 'Male', '3 Meters', '1.2 Ton', 5, 'Alive', '2022-01-29'),
(6, 'xxx', '111', 'boba', 'Male', '3 Meters', '1.2 Tons', 5, 'Alive', '2022-01-29'),
(7, 'xxx', '2222', 'Ahsoka', 'Female', '3.5 Meter', '1 Ton', 6, 'Alive', '2022-01-29'),
(8, 'xxx', '333', 'Kyla', 'Female', '3', '1.1', 7, 'Alive', '2022-01-29'),
(11, 'xxx', '111', 'Boba', 'Male', '3 Meters', '1.2 Ton', 5, 'Dead', '2022-01-29'),
(14, 'xxx', '777', 'Lando', 'Male', '3 M', '0.9 T', 8, 'Alive', '2022-01-30'),
(15, 'xxx', '999', 'jlj', 'Male', '9', '9', 7, 'Alive', '2022-01-30'),
(16, 'xxx', '345', 'Ray', 'Female', '3 M', '1.1 T', 6, 'Alive', '2022-01-31'),
(17, 'xxx', 'xxx9', 'Fett', 'Male', '3M', '1.5 T', 21, 'Alive', '2022-02-02'),
(18, 'xxx', 'xx89', 'Mate', 'Male', '3 Meters', '1.4T', 8, 'Alive', '2022-02-03'),
(19, 'xxx', '897', 'Giridar', 'Male', '3M', '67', 8, 'Alive', '2022-02-03'),
(20, 'xxx', 'jj', 'Geep', 'Female', '34', '4', 8, 'Alive', '2022-02-03'),
(21, 'xxx', 'iii', 'jj', 'Male', '0', '0', 7, 'Alive', '2022-02-03'),
(22, 'xxx', 'jjj', 'j', 'Male', 'j', 'j', 7, 'Alive', '2022-02-03'),
(23, 'xxx', '7898', 'Joker', 'Male', '8M', '3T', 8, 'Alive', '2022-02-04'),
(24, 'xxx', '786', 'Kam', 'Male', '8m', '6t', 7, 'Alive', '2022-02-04'),
(25, 'xxx', 'h', 'j', 'Male', 'j', 'j', 7, 'Alive', '2022-02-04'),
(26, 'xxx', 'jklj', 'Km', 'Female', '5', '2', 8, 'Alive', '2022-02-04');

-- --------------------------------------------------------

--
-- Table structure for table `elephantlocation`
--

CREATE TABLE `elephantlocation` (
  `id` int(11) NOT NULL,
  `geographic_coordinates` varchar(100) NOT NULL,
  `time` varchar(50) NOT NULL,
  `elephant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `elephantlocation`
--

INSERT INTO `elephantlocation` (`id`, `geographic_coordinates`, `time`, `elephant`) VALUES
(4, '7, 7', '2022-01-30T06:39:35.688564300', 8),
(7, '6.5, 4.5', '2022-01-30T06:50:16.791989500', 7),
(8, '7.8, 6.8', '2022-01-30T13:13:16.925844200', 11),
(9, '5, 4', '2022-01-31T07:22:34.467911800', 7),
(11, '-7, 6.6', '2022-02-04T00:03:26.729901500', 5),
(12, '8, 9', '2022-02-04T08:36:49.390003', 5),
(13, '-7, 8', '2022-02-04T09:53:36.627977200', 5);

-- --------------------------------------------------------

--
-- Table structure for table `elephantpopulation`
--

CREATE TABLE `elephantpopulation` (
  `id` int(11) NOT NULL,
  `wpa` int(11) NOT NULL,
  `date` date NOT NULL,
  `population` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `elephantpopulation`
--

INSERT INTO `elephantpopulation` (`id`, `wpa`, `date`, `population`) VALUES
(3, 10, '2022-01-28', 5),
(6, 11, '2021-02-11', 6),
(8, 11, '2021-03-12', 12),
(9, 11, '2021-04-15', 7),
(10, 11, '2022-01-30', 9),
(11, 11, '2022-01-30', 4),
(12, 10, '2022-01-30', 2),
(13, 11, '2022-02-02', 6),
(14, 12, '2022-02-02', 1),
(15, 10, '2022-02-03', 6),
(17, 11, '2022-02-03', 7),
(18, 11, '2022-02-03', 5),
(19, 11, '2022-02-03', 5),
(20, 11, '2022-02-03', 5),
(21, 11, '2022-02-03', 6),
(22, 11, '2022-02-03', 8),
(23, 11, '2022-02-03', 7),
(24, 11, '2022-02-03', 9),
(25, 11, '2022-02-03', 1),
(26, 11, '2022-02-04', 9);

-- --------------------------------------------------------

--
-- Table structure for table `habitat`
--

CREATE TABLE `habitat` (
  `id` int(11) NOT NULL,
  `location` varchar(50) NOT NULL,
  `wpa` int(11) NOT NULL,
  `registered_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `habitat`
--

INSERT INTO `habitat` (`id`, `location`, `wpa`, `registered_date`) VALUES
(5, '7.2, 8.5', 10, '2022-01-24'),
(6, '7.2, 8.5', 10, '2022-01-25'),
(7, '7.2, j', 11, '2022-01-26'),
(8, '7.21, 8.51', 11, '2022-01-29'),
(11, '7.11, 8.0564', 11, '2022-01-29'),
(12, '7.4, 8.4', 11, '2022-01-29'),
(13, '4.5, 7.5', 11, '2022-01-30'),
(14, '45, 45', 11, '2022-01-30'),
(15, '7.9, 8.9', 11, '2022-01-30'),
(16, '7, 7', 11, '2022-01-30'),
(17, '9, 9', 11, '2022-01-30'),
(19, '9, 9', 11, '2022-01-30'),
(21, '6.4, 3.4', 12, '2022-02-02'),
(22, '7.2, 7.8', 11, '2022-02-04'),
(23, 'j, j', 11, '2022-02-04'),
(24, '4, j', 11, '2022-02-04'),
(25, '9, 4', 11, '2022-02-04'),
(26, '8, -9', 11, '2022-02-04'),
(27, '9, -9', 11, '2022-02-04');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `dob` date NOT NULL,
  `email` varchar(100) NOT NULL,
  `nic` varchar(20) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role` varchar(25) NOT NULL,
  `registered_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `address`, `dob`, `email`, `nic`, `password`, `role`, `registered_date`) VALUES
(35, 'Thomas', 'Phone', 'top', 'Earth', '1978-04-04', 'tphone@wcms.lk', '896878700', '111111', 'Director General', '2022-02-04'),
(41, 'Ahmed', 'Tendulkar', 'atulku', 'Oxford', '1984-05-23', 'atendulkar@wcms.lk', 'xxx', '654321', 'Department Officer', '2022-01-22'),
(52, 'First ', 'Last ', 'flast', 'kk', '2022-01-06', 'kk', 'kk', 'Last aa11@@', 'Wildlife Ranger', '2022-01-27'),
(58, 'Moo', 'Amar', 'mamar1', 'Duke, SA', '2022-01-06', 'jjjjj', 'jjjjj', 'Amaraa11@@', 'Wildlife Ranger', '2022-01-28'),
(59, 'Moo', 'Amar', 'mamar12', 'Duke, SA', '2022-01-04', 'jjjjj', 'jjjjj', 'Amaraa11@@', 'Wildlife Ranger', '2022-01-28'),
(61, 'Xaviour', 'Charles', 'xj', 'Cardiff, Scottland', '1978-12-29', 'xcharles@wcms.lk', '232332323', 'jaa11@@', 'Wildlife Ranger', '2022-01-28'),
(62, 'Moo', 'Amar', 'mamar123', 'Brisband', '2022-01-06', 'jjj', 'jjjjj', 'Amaraa11@@', 'Wildlife Ranger', '2022-01-28'),
(63, 'Victor', 'Gabrial', 'vgabrial', 'Brisband', '1978-07-19', 'vgabrial@wcms.lk', '197802295467', 'gabrialaa11@@', 'Wildlife Ranger', '2022-01-28'),
(64, 'victor', 'gabrial', 'vgabrial1', 'Brisband', '2022-01-06', 'jjj', 'jjjjj', 'gabrialaa11@@', 'Wildlife Ranger', '2022-01-28'),
(65, 'victor', 'gabrials', 'vgabrials', 'Brisband', '2022-01-06', 'jjj', 'jjjjj', 'gabrialsaa11@@', 'Wildlife Ranger', '2022-01-28'),
(66, 'victor', 'gabriala', 'vgabriala', 'Brisband', '2022-01-06', 'jjj', 'jjjjj', 'gabrialaaa11@@', 'Wildlife Ranger', '2022-01-28'),
(67, 'First Nam1', 'Last Nam1', 'flastnam1', 'jjjjj', '2022-01-06', 'jjj', 'jjj', 'Last Nam1aa11@@', 'Wildlife Ranger', '2022-01-28'),
(68, 'First Nam1', 'Last Nam1', 'flastnam11', 'jjjjj', '2022-01-06', 'jjj', 'jjj', 'Last Nam1aa11@@', 'Wildlife Ranger', '2022-01-28'),
(69, 'Fom1', 'Lom1', 'flom1', 'jjj', '2022-01-13', 'jj', 'jjj', 'Lom1aa11@@', 'Wildlife Ranger', '2022-01-28'),
(70, 'Fom1', 'Lom1', 'flome1', 'jjj', '2022-01-13', 'jj', 'jjj', 'Lom1aa11@@', 'Wildlife Ranger', '2022-01-28'),
(71, 'Gabrialle', 'Joseph', 'gjoseph', 'London, Ontario', '2022-01-04', 'gjoseph', '239792387297', 'Josephaa11@@', 'Wildlife Ranger', '2022-01-28'),
(72, 'Gabrialle', 'Joseph', 'gjosep1', 'London, Ontario', '2022-01-04', 'gjoseph', '239792387297', 'Josephaa11@@', 'Wildlife Ranger', '2022-01-28'),
(73, 'Gabrialle', 'Joseph', 'gjosep2', 'London, Ontario', '2022-01-04', 'gjoseph', '239792387297', 'Josephaa11@@', 'Wildlife Ranger', '2022-01-28'),
(74, 'Junaid', 'Ansari', 'jansari', 'Abhu Dhabi, Dhubai', '2022-01-01', 'jjj', '239792387297', 'Ansariaa11@@', 'Wildlife Ranger', '2022-01-28'),
(75, 'Junaid', 'Ansari', 'jansar1', 'Canada', '2022-01-05', 'jjj', '2397923872978', 'Ansariaa11@@', 'Wildlife Ranger', '2022-01-28'),
(79, 'Firjjjst Name', 'Last Njjjame', 'flastnjjjame', 'jjj', '2022-01-04', 'jj@lksd.lk', '797', 'Last Njjjameaa11@@', 'Wildlife Ranger', '2022-01-28'),
(80, 'First Najjme', 'Last Najjjme', 'flastnajjjme', 'jj', '2022-01-04', 'jj@jfkd.com', 'ntendulkar@email.com', 'Last Najjjmeaa11@@', 'Wildlife Ranger', '2022-01-28'),
(83, 'Micheal', 'Joseph', 'mjh', 'Prague, Chezch Republic', '1978-12-30', 'mjoseph@wcms.lk', 'nnnn', '654321', 'Wildlife Ranger', '2022-01-28'),
(84, 'John', 'Mathews', 'jmathews', 'Mumbai, India', '1980-08-30', 'jmathews@wcms.lk', '198002700887', 'Mathewsaa11@@', 'Wildlife Ranger', '2022-01-28'),
(85, 'First Namejj', 'Last Njjame', 'flastnjjame', 'jj', '2022-01-01', 'jj@jj.com', '83434987', 'Last Njjameaa11@@', 'Wildlife Ranger', '2022-01-28'),
(86, 'First Namej', 'Lasjt Name', 'flasjtname', 'jj', '2022-01-14', 'jj@slkjfdlj.lk', '2222', 'Lasjt Nameaa11@@', 'Wildlife Ranger', '2022-01-28'),
(87, 'Namal', 'Hajeed', 'nhajeed', 'Kandy, Sri Lanka', '1984-01-27', 'nhajeed@wcms.lk', '198400010876', 'xx', 'Wildlife Ranger', '2022-01-28'),
(96, 'Anu', 'Rathn', 'arathn', 'Colombo', '1987-02-18', 'arathn@wcms.lk', '198705787645', 'Rathnaa11@@', 'Wildlife Ranger', '2022-02-03'),
(97, 'Ban', 'Mathews', 'bmathews', 'Kerela', '1991-02-02', 'bmethews@wcms.lk', '199100627865', 'Mathewsaa11@@', 'Wildlife Ranger', '2022-02-03'),
(98, 'Barney', 'Stanly', 'bstanly', 'NY,USA', '1977-06-22', 'bstanley@wcms.lk', '197702028899', 'Stanlyaa11@@', 'Wildlife Ranger', '2022-02-04'),
(99, 'V', 'G', 'vg', 'j', '2022-02-12', 'j@wcmm.lh', 'j', 'gaa11@@', 'Wildlife Ranger', '2022-02-04'),
(100, 'Fam', 'Nam', 'fnam', 'Fana	', '2022-02-05', 'fan@wcms.lk', 'sldflkdj', 'namaa11@@', 'Wildlife Ranger', '2022-02-04'),
(102, 'Dep', 'Of', 'dof', 'Jungel', '2022-02-11', 'l@w.lk', 'jjjj', 'ofaaAA11@@', 'Department Officer', '2022-02-04'),
(103, 'First ', 'Last ', 'flas1', 'Nowhere', '2022-02-12', 'lkjdsf@ljdsf.clkj', '7612453236', 'last aa11@@', 'Wildlife Ranger', '2022-02-04');

-- --------------------------------------------------------

--
-- Table structure for table `wildlifeprotectedarea`
--

CREATE TABLE `wildlifeprotectedarea` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `area` int(11) NOT NULL,
  `date_of_declaration` date NOT NULL,
  `province` varchar(50) NOT NULL,
  `department_officer` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `wildlifeprotectedarea`
--

INSERT INTO `wildlifeprotectedarea` (`id`, `name`, `area`, `date_of_declaration`, `province`, `department_officer`) VALUES
(10, 'Yala', 172, '2022-01-30', 'Northern', 41),
(11, 'Galaga', 547, '2022-01-27', 'Eastern', 41),
(12, 'Ramba', 240, '2022-01-30', 'Northern', 41),
(20, 'Gama', 34, '2022-02-04', 'Central', 102);

-- --------------------------------------------------------

--
-- Table structure for table `wildliferanger`
--

CREATE TABLE `wildliferanger` (
  `user` int(11) NOT NULL,
  `urrn` int(11) NOT NULL,
  `wpa` int(11) NOT NULL,
  `department_officer` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `wildliferanger`
--

INSERT INTO `wildliferanger` (`user`, `urrn`, `wpa`, `department_officer`) VALUES
(61, 3699, 12, 41),
(63, 7207, 10, 41),
(65, 301, 10, 41),
(66, 3021, 10, 41),
(67, 8789, 10, 41),
(68, 1367, 10, 41),
(69, 8457, 10, 41),
(70, 4822, 10, 41),
(71, 1864, 10, 41),
(72, 9657, 10, 41),
(73, 8655, 10, 41),
(74, 3746, 10, 41),
(75, 6999, 10, 41),
(79, 4503, 10, 41),
(80, 8458, 10, 41),
(83, 6412, 11, 41),
(84, 4143, 10, 41),
(85, 9072, 11, 41),
(86, 9315, 10, 41),
(87, 3410, 11, 41),
(96, 2081, 11, 41),
(97, 2627, 12, 41),
(98, 4452, 11, 41),
(99, 1915, 11, 41),
(100, 5569, 10, 41),
(103, 6745, 20, 102);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `elephant`
--
ALTER TABLE `elephant`
  ADD PRIMARY KEY (`id`),
  ADD KEY `elephant_habitat` (`habitat`);

--
-- Indexes for table `elephantlocation`
--
ALTER TABLE `elephantlocation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `elephantLocation_elephant` (`elephant`);

--
-- Indexes for table `elephantpopulation`
--
ALTER TABLE `elephantpopulation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `elephantPopulation_wpa` (`wpa`);

--
-- Indexes for table `habitat`
--
ALTER TABLE `habitat`
  ADD PRIMARY KEY (`id`),
  ADD KEY `habitat_wpa` (`wpa`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `wildlifeprotectedarea`
--
ALTER TABLE `wildlifeprotectedarea`
  ADD PRIMARY KEY (`id`),
  ADD KEY `wpa_do` (`department_officer`);

--
-- Indexes for table `wildliferanger`
--
ALTER TABLE `wildliferanger`
  ADD PRIMARY KEY (`user`),
  ADD KEY `ranger_do` (`department_officer`),
  ADD KEY `ranger_wpa` (`wpa`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `elephant`
--
ALTER TABLE `elephant`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `elephantlocation`
--
ALTER TABLE `elephantlocation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `elephantpopulation`
--
ALTER TABLE `elephantpopulation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `habitat`
--
ALTER TABLE `habitat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=104;

--
-- AUTO_INCREMENT for table `wildlifeprotectedarea`
--
ALTER TABLE `wildlifeprotectedarea`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `elephant`
--
ALTER TABLE `elephant`
  ADD CONSTRAINT `elephant_habitat` FOREIGN KEY (`habitat`) REFERENCES `habitat` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `elephantlocation`
--
ALTER TABLE `elephantlocation`
  ADD CONSTRAINT `elephantLocation_elephant` FOREIGN KEY (`elephant`) REFERENCES `elephant` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `elephantpopulation`
--
ALTER TABLE `elephantpopulation`
  ADD CONSTRAINT `elephantPopulation_wpa` FOREIGN KEY (`wpa`) REFERENCES `wildlifeprotectedarea` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `habitat`
--
ALTER TABLE `habitat`
  ADD CONSTRAINT `habitat_wpa` FOREIGN KEY (`wpa`) REFERENCES `wildlifeprotectedarea` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `wildlifeprotectedarea`
--
ALTER TABLE `wildlifeprotectedarea`
  ADD CONSTRAINT `wpa_do` FOREIGN KEY (`department_officer`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `wildliferanger`
--
ALTER TABLE `wildliferanger`
  ADD CONSTRAINT `ranger_do` FOREIGN KEY (`department_officer`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `ranger_wpa` FOREIGN KEY (`wpa`) REFERENCES `wildlifeprotectedarea` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `wildliferanger_ibfk_1` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
