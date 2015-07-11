-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 11, 2015 at 09:46 AM
-- Server version: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `blogdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `article`
--

CREATE TABLE IF NOT EXISTS `article` (
  `id` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `user_id` int(11) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `article`
--

INSERT INTO `article` (`id`, `title`, `content`, `user_id`, `date`) VALUES
(1, 'Article A', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas est metus, ultrices eget dignissim in, euismod id neque. Nullam porttitor nibh sed sapien facilisis vestibulum. Curabitur dignissim lectus sit amet neque tristique, ut elementum enim luctus. Sed convallis arcu at leo eleifend sollicitudin. Nunc ipsum augue, maximus quis ligula sed, volutpat facilisis sapien. Pellentesque urna ligula, maximus quis ornare vel, pellentesque in nisi. Cras congue pharetra blandit. Sed fringilla massa nec sodales elementum. Sed est sapien, vestibulum at tincidunt ut, ultrices non neque. Aliquam facilisis imperdiet gravida. Nam porta massa tempor, aliquam nibh quis, elementum eros. Fusce quis ornare magna. Nunc sed nisl nisi. Nullam et gravida eros. Donec consectetur nisl eu augue ultrices, non imperdiet est tempus. Nam mollis lectus erat, ut semper elit eleifend egestas.', 1, '2015-07-11'),
(2, 'Article B', 'Nulla dictum ut lorem non tempor. Integer auctor, velit sed molestie egestas, enim nulla blandit massa, sed feugiat mauris metus eu ex. Sed congue lacus vitae dui porta lobortis. Maecenas tristique tristique arcu, in interdum nisl finibus non. Sed dignissim vel lorem id fringilla. Vestibulum eu pulvinar nunc. Morbi accumsan dolor urna, at imperdiet erat luctus et.', 1, '2015-07-20'),
(3, 'Article Vincent', 'Proin fermentum lacinia dapibus. Aliquam in tempus nibh. Etiam in odio id eros congue posuere. Pellentesque vestibulum mollis massa, ut iaculis eros commodo vitae. Duis lectus est, blandit ac tempus quis, sagittis sed turpis. Sed nec felis id mauris efficitur suscipit nec quis augue. In hac habitasse platea dictumst. Cras id nulla scelerisque arcu pellentesque vestibulum ut ut purus. Donec ac tellus ut ligula vulputate egestas non eu quam.', 2, '2015-07-21'),
(4, 'Blablabla', 'Suspendisse lacus ipsum, volutpat sit amet varius nec, sodales in ligula. Integer at finibus velit, at porta velit. Maecenas fermentum a diam id hendrerit. Sed commodo erat eget tortor sollicitudin, at lobortis erat porta. Nunc metus nisi, congue vitae dolor vitae, semper vestibulum nisi. Vestibulum ut nibh ut tellus ultrices facilisis. Praesent maximus eros ac ex sagittis, et lobortis ex tincidunt. Sed dignissim finibus metus, vitae mollis eros convallis quis. Donec quis cursus lacus. Cras laoreet dui ac augue placerat maximus. Suspendisse luctus turpis non mauris faucibus, sit amet lacinia dui vulputate. Suspendisse aliquet est quis quam commodo, at gravida mi mollis. Fusce at mauris feugiat, convallis dolor eget, sagittis lacus. Integer nec dapibus sem, nec porttitor sem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed nunc ante, lacinia et imperdiet a, cursus in dui.', 1, '2015-07-06');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE IF NOT EXISTS `comment` (
  `id` int(11) NOT NULL,
  `content` text NOT NULL,
  `date` date NOT NULL,
  `user_id` int(11) NOT NULL,
  `article_id` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `comment`
--

INSERT INTO `comment` (`id`, `content`, `date`, `user_id`, `article_id`) VALUES
(1, 'Mon commentaire est trop génial', '2015-07-28', 1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `email`) VALUES
(1, 'edouarddurieux', 'root', 'edouarddurieux@gmail.com'),
(2, 'vincentmolinie', 'root', 'vincentmolinie@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`id`), ADD KEY `fk_article_user_id_idx` (`user_id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`id`), ADD KEY `fk_comment_articleId_idx` (`article_id`), ADD KEY `fk_comment_user_id_idx` (`user_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `article`
--
ALTER TABLE `article`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `comment`
--
ALTER TABLE `comment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `article`
--
ALTER TABLE `article`
ADD CONSTRAINT `fk_article_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `comment`
--
ALTER TABLE `comment`
ADD CONSTRAINT `fk_comment_article_id` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_comment_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
