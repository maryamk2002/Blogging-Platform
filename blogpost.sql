-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 04, 2024 at 09:25 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `blogpost`
--
CREATE DATABASE IF NOT EXISTS `blogpost` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `blogpost`;

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE `author` (
  `author_id` int(11) NOT NULL,
  `author_name` varchar(40) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `author`
--

INSERT INTO `author` (`author_id`, `author_name`, `email`, `password`) VALUES
(1, 'Maryam Kamal', 'maryamkamal@gmail.com', 'maryam123'),
(2, 'Faiza Ashfaq', 'faizaashfaq@gmail.com', 'faiza123'),
(3, 'Zahid Ali', 'zahidali@gmail.com', 'password123'),
(4, 'Syed Adeel', 'adeel@gmail.com', 'adeel123'),
(5, 'Farhat Ahmed', 'farhat@gmail.com', 'password123');

-- --------------------------------------------------------

--
-- Table structure for table `blog`
--

CREATE TABLE `blog` (
  `post_id` int(11) NOT NULL,
  `author_id` int(11) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp(),
  `status` varchar(20) DEFAULT 'Pending',
  `analysis_result` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `blog`
--

INSERT INTO `blog` (`post_id`, `author_id`, `title`, `content`, `timestamp`, `status`, `analysis_result`) VALUES
(1, 4, 'Remote Work Revolution: Redefining the Traditional Office Space', 'The rise of remote work is reshaping the landscape of traditional office environments, challenging established norms and ushering in a new era of flexibility and adaptability. As technology continues to bridge the gap between physical and virtual workspaces, the remote work revolution is not just a response to global circumstances but a transformative shift in the way we perceive and engage with work.\r\n\r\nThe Emergence of Remote Work Culture: Explore how remote work is not just a logistical change but a cultural shift. Discuss the impact of flexible work hours, asynchronous communication, and the blending of professional and personal spaces on organizational culture.\r\n\r\nTechnological Enablers: Delve into the technological advancements that have facilitated the remote work revolution. Discuss the role of collaboration tools, video conferencing platforms, and project management software in connecting remote teams seamlessly.\r\n\r\nBalancing Work and Well-being: Examine the challenges and benefits of remote work on employee well-being. Discuss strategies for maintaining work-life balance, combating isolation, and promoting mental health in a remote work environment.\r\n\r\nGlobal Talent Pool: Explore how remote work opens the door to a global talent pool. Discuss the advantages of accessing diverse skills and perspectives, breaking down geographical barriers, and fostering a more inclusive work environment.\r\n\r\nRedefining Office Spaces: Discuss the evolving role of physical office spaces in a remote work landscape. Explore concepts such as hybrid work models, flexible office arrangements, and the transformation of offices into collaborative hubs rather than daily workstations.\r\n\r\nChallenges of Remote Leadership: Delve into the challenges faced by leaders in managing remote teams. Discuss strategies for effective communication, team building, and fostering a sense of connection and belonging among distributed team members.\r\n\r\nImpact on Commuting and the Environment: Explore how the remote work revolution is influencing commuting patterns and reducing the environmental impact of daily travel. Discuss the potential long-term benefits for both individuals and the planet.\r\n\r\nLegal and Security Considerations: Examine the legal and security implications of remote work. Discuss data protection, cybersecurity measures, and the need for clear remote work policies to ensure compliance and mitigate risks.\r\n\r\nUpskilling and Digital Literacy: Discuss the importance of upskilling and digital literacy in a remote work environment. Explore how employees and organizations are adapting to new technologies and developing the skills required for effective virtual collaboration.\r\n\r\nThe Future of Work: Peer into the future of work as the remote revolution continues to unfold. Discuss potential trends, challenges, and opportunities that may shape the way we work in the years to come.\r\n\r\nThe remote work revolution is not just a temporary response to global events but a transformative force that is reshaping the future of work. By embracing flexibility, leveraging technology, and fostering a culture of trust, organizations can thrive in this new era of work.', '2024-01-13 14:19:39', 'pending', 'null'),
(3, 3, 'Cybersecurity in the Digital Age: Protecting Personal and Organizational Data', '**Cybersecurity in the Digital Age: Protecting Personal and Organizational Data**\r\n\r\nIn an era dominated by digital connectivity, the safeguarding of personal and organizational data has become paramount. Cybersecurity stands as the frontline defense against an array of sophisticated threats, ranging from phishing attacks to ransomware. As we navigate the complex landscape of the digital age, understanding and implementing robust cybersecurity measures are essential for ensuring the integrity and confidentiality of sensitive information.\r\n\r\n1. **The Evolving Threat Landscape:** Delve into the ever-changing nature of cybersecurity threats. Explore how cybercriminals adapt their tactics and techniques, from traditional malware to more advanced strategies like social engineering and zero-day vulnerabilities.\r\n\r\n2. **Protecting Personal Information:** Discuss practical tips and best practices for individuals to protect their personal information online. Cover topics such as strong password creation, two-factor authentication, and awareness of phishing attempts.\r\n\r\n3. **Securing Organizational Assets:** Examine the crucial role of cybersecurity in protecting organizational data. Discuss the implementation of firewalls, intrusion detection systems, and regular security audits to identify and address vulnerabilities in corporate networks.\r\n\r\n4. **Data Privacy Regulations:** Explore the landscape of data privacy regulations, such as GDPR and CCPA, and their impact on businesses. Discuss the importance of compliance and the consequences of failing to protect customer data.\r\n\r\n5. **The Human Factor:** Highlight the role of employees in maintaining cybersecurity. Discuss the significance of cybersecurity training programs to educate staff about potential threats and foster a culture of security awareness within organizations.\r\n\r\n6. **Ransomware Preparedness:** With the rise of ransomware attacks, provide insights into creating effective backup strategies, incident response plans, and the importance of regularly updating and patching software to mitigate the risk of falling victim to ransomware.\r\n\r\n7. **Emerging Technologies in Cybersecurity:** Explore cutting-edge technologies such as artificial intelligence and machine learning in enhancing cybersecurity measures. Discuss how these technologies can detect and respond to threats in real-time.\r\n\r\n8. **Mobile Security Challenges:** As mobile devices become ubiquitous, discuss the unique challenges and security considerations associated with smartphones and tablets. Provide practical tips for securing mobile devices in both personal and professional settings.\r\n\r\n9. **The Role of Cybersecurity Professionals:** Shed light on the demand for skilled cybersecurity professionals. Discuss the various roles within the cybersecurity field and the skills required to build a successful career in this rapidly evolving domain.\r\n\r\n10. **The Future of Cybersecurity:** Explore emerging trends and predictions for the future of cybersecurity. Discuss topics such as quantum computing threats, the integration of cybersecurity into the Internet of Things (IoT), and the continuous evolution of cyber threats.\r\n\r\nBy addressing these aspects, individuals and organizations can better navigate the digital landscape, fortifying themselves against cyber threats and contributing to the overall resilience of our interconnected world.', '2023-12-27 16:16:51', 'pending', NULL),
(5, 5, 'The Future of Artificial Intelligence', 'In the relentless pursuit of technological advancement, Artificial Intelligence (AI) stands at the forefront, poised to redefine the very fabric of our existence. As we delve into the future, the trajectory of AI promises a landscape transformed by intelligent systems, automation, and unprecedented possibilities.\r\n\r\nOne of the key facets of the future of AI lies in its ability to augment human capabilities. As AI technologies mature, they will become integral partners in various fields, enhancing our problem-solving capacities, optimizing workflows, and contributing to scientific breakthroughs. Human-AI collaboration is not just a possibility but a necessity in unlocking new frontiers of innovation.\r\n\r\nMachine Learning, a subset of AI, will play a pivotal role in shaping the future. Algorithms capable of learning from data will lead to predictive analytics, personalized user experiences, and autonomous decision-making. The convergence of AI with other technologies like the Internet of Things (IoT) will create interconnected ecosystems, where devices seamlessly communicate and adapt to user needs.\r\n\r\nEthical considerations in AI development will become increasingly crucial. As AI systems become more sophisticated, addressing concerns related to bias, transparency, and accountability becomes imperative. Striking a balance between innovation and ethical responsibility will define the ethical framework within which AI evolves.\r\n\r\nThe integration of AI into healthcare holds immense promise. From diagnosis to personalized treatment plans, AI-powered systems will revolutionize patient care. Robotics, guided by AI, will perform intricate surgeries with precision, while AI algorithms analyze vast medical datasets, uncovering patterns and accelerating medical research.\r\n\r\nWhile the future of AI is undeniably exciting, it also brings forth challenges. The potential displacement of jobs due to automation, concerns about AI ethics, and the need for robust cybersecurity measures are areas that demand careful consideration and proactive solutions.\r\n\r\nIn conclusion, the future of Artificial Intelligence is a journey into uncharted territory, where the synergy between human intelligence and machine capabilities holds boundless potential. By navigating the ethical complexities and embracing responsible innovation, we can shape an AI-driven future that enhances our lives, pushing the boundaries of what is possible in the realm of technology.\r\n\r\n\r\n\r\n\r\n\r\n', '2024-01-04 17:49:03', 'Approved', NULL),
(7, 2, 'Unlocking the Secrets of Creativity', 'Creativity, a force that propels us beyond the ordinary, lies within the depths of our minds, waiting to be unleashed. It is the spark that turns the mundane into the extraordinary, the key to unlocking doors to new possibilities. So, how do we unravel the secrets of creativity and tap into its boundless potential?\r\n\r\nFirstly, creativity thrives in an environment that encourages exploration and embraces failure. Often, the fear of making mistakes stifles creativity. Embrace the idea that failure is a stepping stone to success, a valuable lesson in the creative process.\r\n\r\nSecondly, diverse experiences fuel the creative mind. Expose yourself to different cultures, disciplines, and perspectives. The amalgamation of varied influences cultivates a rich soil for creative ideas to flourish.\r\n\r\nAdditionally, allocate time for contemplation and reflection. In our fast-paced world, the constant stream of information can drown out the whispers of our creative thoughts. Set aside moments of solitude to let your mind wander, allowing creativity to bubble to the surface.\r\n\r\nCollaboration is another catalyst for creativity. Engage with a diverse group of individuals, each bringing their unique insights to the table. The exchange of ideas often sparks a creative synergy that elevates the collective thinking beyond individual capacities.\r\n\r\nLastly, embrace discomfort. Creativity thrives outside comfort zones. Challenge yourself to tackle problems from different angles, explore unfamiliar territories, and be open to unconventional ideas.\r\n\r\nIn conclusion, unlocking the secrets of creativity involves fostering an environment of experimentation, embracing diversity, allocating time for reflection, encouraging collaboration, and embracing discomfort. As we embark on this journey of unlocking creativity, let us remember that within every challenge lies an opportunity for innovation and artistic expression.', '2024-01-04 18:49:07', 'Approved', NULL),
(41, 1, 'How to Write SQL Queries', 'In this blog post, we will learn how to write SQL queries for various scenarios.', '2024-02-04 20:23:37', 'pending', NULL),
(42, 1, 'The Art of Data Visualization', 'Explore the beauty of data visualization and its importance in decision-making.', '2024-02-04 20:23:37', 'pending', NULL),
(43, 1, 'Machine Learning Fundamentals', 'An introduction to the fundamentals of machine learning and its real-world applications.', '2024-02-04 20:23:37', 'pending', NULL),
(44, 1, 'Web Development Best Practices', 'Learn about best practices and tips for efficient web development.', '2024-02-04 20:23:37', 'pending', NULL),
(45, 1, 'Exploring Quantum Computing', 'Dive deep into the fascinating world of quantum computing, understanding qubits, quantum gates, and their potential impact on the future of technology.', '2024-02-04 20:25:14', 'pending', NULL),
(46, 2, 'The Power of Artificial Intelligence in Healthcare', 'Discover how artificial intelligence is revolutionizing healthcare, from diagnostics to personalized treatment plans, and its ethical considerations.', '2024-02-04 20:25:14', 'pending', NULL),
(47, 3, 'Cybersecurity Best Practices for Individuals and Businesses', 'Learn essential cybersecurity practices to safeguard your personal information and protect your business from cyber threats in an increasingly digital world.', '2024-02-04 20:25:14', 'pending', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`author_id`);

--
-- Indexes for table `blog`
--
ALTER TABLE `blog`
  ADD PRIMARY KEY (`post_id`),
  ADD KEY `author_id` (`author_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `author`
--
ALTER TABLE `author`
  MODIFY `author_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `blog`
--
ALTER TABLE `blog`
  MODIFY `post_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `blog`
--
ALTER TABLE `blog`
  ADD CONSTRAINT `blog_ibfk_1` FOREIGN KEY (`author_id`) REFERENCES `author` (`author_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
