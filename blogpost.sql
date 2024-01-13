-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 13, 2024 at 09:50 PM
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
(1, 4, 'Remote Work Revolution: Redefining the Traditional Office Space', 'The rise of remote work is reshaping the landscape of traditional office environments, challenging established norms and ushering in a new era of flexibility and adaptability. As technology continues to bridge the gap between physical and virtual workspaces, the remote work revolution is not just a response to global circumstances but a transformative shift in the way we perceive and engage with work.\r\n\r\nThe Emergence of Remote Work Culture: Explore how remote work is not just a logistical change but a cultural shift. Discuss the impact of flexible work hours, asynchronous communication, and the blending of professional and personal spaces on organizational culture.\r\n\r\nTechnological Enablers: Delve into the technological advancements that have facilitated the remote work revolution. Discuss the role of collaboration tools, video conferencing platforms, and project management software in connecting remote teams seamlessly.\r\n\r\nBalancing Work and Well-being: Examine the challenges and benefits of remote work on employee well-being. Discuss strategies for maintaining work-life balance, combating isolation, and promoting mental health in a remote work environment.\r\n\r\nGlobal Talent Pool: Explore how remote work opens the door to a global talent pool. Discuss the advantages of accessing diverse skills and perspectives, breaking down geographical barriers, and fostering a more inclusive work environment.\r\n\r\nRedefining Office Spaces: Discuss the evolving role of physical office spaces in a remote work landscape. Explore concepts such as hybrid work models, flexible office arrangements, and the transformation of offices into collaborative hubs rather than daily workstations.\r\n\r\nChallenges of Remote Leadership: Delve into the challenges faced by leaders in managing remote teams. Discuss strategies for effective communication, team building, and fostering a sense of connection and belonging among distributed team members.\r\n\r\nImpact on Commuting and the Environment: Explore how the remote work revolution is influencing commuting patterns and reducing the environmental impact of daily travel. Discuss the potential long-term benefits for both individuals and the planet.\r\n\r\nLegal and Security Considerations: Examine the legal and security implications of remote work. Discuss data protection, cybersecurity measures, and the need for clear remote work policies to ensure compliance and mitigate risks.\r\n\r\nUpskilling and Digital Literacy: Discuss the importance of upskilling and digital literacy in a remote work environment. Explore how employees and organizations are adapting to new technologies and developing the skills required for effective virtual collaboration.\r\n\r\nThe Future of Work: Peer into the future of work as the remote revolution continues to unfold. Discuss potential trends, challenges, and opportunities that may shape the way we work in the years to come.\r\n\r\nThe remote work revolution is not just a temporary response to global events but a transformative force that is reshaping the future of work. By embracing flexibility, leveraging technology, and fostering a culture of trust, organizations can thrive in this new era of work.', '2024-01-13 14:19:39', 'Rejected', 'not good quality content'),
(2, 2, 'Machine Learning in Blogging', 'abc', '2023-12-27 16:16:51', 'Rejected', 'blah'),
(3, 3, 'Cybersecurity in the Digital Age: Protecting Personal and Organizational Data', '**Cybersecurity in the Digital Age: Protecting Personal and Organizational Data**\r\n\r\nIn an era dominated by digital connectivity, the safeguarding of personal and organizational data has become paramount. Cybersecurity stands as the frontline defense against an array of sophisticated threats, ranging from phishing attacks to ransomware. As we navigate the complex landscape of the digital age, understanding and implementing robust cybersecurity measures are essential for ensuring the integrity and confidentiality of sensitive information.\r\n\r\n1. **The Evolving Threat Landscape:** Delve into the ever-changing nature of cybersecurity threats. Explore how cybercriminals adapt their tactics and techniques, from traditional malware to more advanced strategies like social engineering and zero-day vulnerabilities.\r\n\r\n2. **Protecting Personal Information:** Discuss practical tips and best practices for individuals to protect their personal information online. Cover topics such as strong password creation, two-factor authentication, and awareness of phishing attempts.\r\n\r\n3. **Securing Organizational Assets:** Examine the crucial role of cybersecurity in protecting organizational data. Discuss the implementation of firewalls, intrusion detection systems, and regular security audits to identify and address vulnerabilities in corporate networks.\r\n\r\n4. **Data Privacy Regulations:** Explore the landscape of data privacy regulations, such as GDPR and CCPA, and their impact on businesses. Discuss the importance of compliance and the consequences of failing to protect customer data.\r\n\r\n5. **The Human Factor:** Highlight the role of employees in maintaining cybersecurity. Discuss the significance of cybersecurity training programs to educate staff about potential threats and foster a culture of security awareness within organizations.\r\n\r\n6. **Ransomware Preparedness:** With the rise of ransomware attacks, provide insights into creating effective backup strategies, incident response plans, and the importance of regularly updating and patching software to mitigate the risk of falling victim to ransomware.\r\n\r\n7. **Emerging Technologies in Cybersecurity:** Explore cutting-edge technologies such as artificial intelligence and machine learning in enhancing cybersecurity measures. Discuss how these technologies can detect and respond to threats in real-time.\r\n\r\n8. **Mobile Security Challenges:** As mobile devices become ubiquitous, discuss the unique challenges and security considerations associated with smartphones and tablets. Provide practical tips for securing mobile devices in both personal and professional settings.\r\n\r\n9. **The Role of Cybersecurity Professionals:** Shed light on the demand for skilled cybersecurity professionals. Discuss the various roles within the cybersecurity field and the skills required to build a successful career in this rapidly evolving domain.\r\n\r\n10. **The Future of Cybersecurity:** Explore emerging trends and predictions for the future of cybersecurity. Discuss topics such as quantum computing threats, the integration of cybersecurity into the Internet of Things (IoT), and the continuous evolution of cyber threats.\r\n\r\nBy addressing these aspects, individuals and organizations can better navigate the digital landscape, fortifying themselves against cyber threats and contributing to the overall resilience of our interconnected world.', '2023-12-27 16:16:51', 'Approved', NULL),
(4, 1, 'Exploring Virtual Reality: Beyond Gaming and Entertainment', 'Virtual Reality (VR) is transcending its roots in gaming and entertainment, ushering in a new era of immersive experiences that extend far beyond the confines of virtual worlds. From education to healthcare, VR is reshaping industries, offering innovative solutions and opening doors to possibilities previously deemed unimaginable. Let\'s embark on a journey to explore the diverse and transformative applications of virtual reality.\r\n\r\nImmersive Learning Environments: Dive into the realm of education and training where VR is revolutionizing learning experiences. Explore how virtual classrooms, simulated laboratories, and interactive historical reconstructions are enhancing education across various disciplines.\r\n\r\nVirtual Tourism: Wander through the concept of virtual tourism, where VR transports individuals to far-flung destinations without leaving their homes. Discuss how this technology is providing a glimpse into global cultures, historical sites, and natural wonders.\r\n\r\nTherapeutic Applications: Delve into the therapeutic potential of VR in healthcare. From pain management and exposure therapy to treating PTSD, discuss how VR is being used to improve mental health and aid in rehabilitation.\r\n\r\nArchitectural Visualization: Explore how VR is transforming the field of architecture by enabling architects, designers, and clients to immerse themselves in virtual renderings of buildings and spaces before they are constructed.\r\n\r\nRemote Collaboration: Uncover the role of VR in facilitating remote collaboration. Discuss how virtual meeting spaces and collaborative environments are redefining the way teams work together, irrespective of geographical distances.\r\n\r\nCultural Preservation: Examine how VR is contributing to the preservation of cultural heritage. Discuss projects that use VR to recreate historical events, ancient civilizations, and endangered cultural sites for future generations.\r\n\r\nSports Training and Analysis: Step onto the training ground where VR is enhancing sports training and performance analysis. Discuss how athletes are utilizing virtual simulations to refine their skills and coaches are using VR to strategize and analyze game scenarios.\r\n\r\nVirtual Real Estate Tours: Navigate through the real estate industry where VR is transforming property viewings. Discuss how potential buyers can explore homes and commercial spaces virtually, providing a more immersive and efficient property-shopping experience.\r\n\r\nCorporate Training Simulations: Discuss the implementation of VR in corporate training programs. Explore how simulations and interactive scenarios are helping employees develop skills in a safe and controlled virtual environment.\r\n\r\nSocial VR: Peer into the social aspects of VR, where users can interact with each other in shared virtual spaces. Discuss the emergence of social VR platforms and their potential impact on communication, socialization, and virtual events.\r\n\r\nAs we venture beyond the realms of gaming and entertainment, the applications of virtual reality continue to unfold, promising a future where immersive experiences reshape the way we learn, work, and connect with the world around us.', '2023-12-27 16:16:51', 'Rejected', 'Unnecessary content'),
(5, 5, 'The Future of Artificial Intelligence', 'In the relentless pursuit of technological advancement, Artificial Intelligence (AI) stands at the forefront, poised to redefine the very fabric of our existence. As we delve into the future, the trajectory of AI promises a landscape transformed by intelligent systems, automation, and unprecedented possibilities.\r\n\r\nOne of the key facets of the future of AI lies in its ability to augment human capabilities. As AI technologies mature, they will become integral partners in various fields, enhancing our problem-solving capacities, optimizing workflows, and contributing to scientific breakthroughs. Human-AI collaboration is not just a possibility but a necessity in unlocking new frontiers of innovation.\r\n\r\nMachine Learning, a subset of AI, will play a pivotal role in shaping the future. Algorithms capable of learning from data will lead to predictive analytics, personalized user experiences, and autonomous decision-making. The convergence of AI with other technologies like the Internet of Things (IoT) will create interconnected ecosystems, where devices seamlessly communicate and adapt to user needs.\r\n\r\nEthical considerations in AI development will become increasingly crucial. As AI systems become more sophisticated, addressing concerns related to bias, transparency, and accountability becomes imperative. Striking a balance between innovation and ethical responsibility will define the ethical framework within which AI evolves.\r\n\r\nThe integration of AI into healthcare holds immense promise. From diagnosis to personalized treatment plans, AI-powered systems will revolutionize patient care. Robotics, guided by AI, will perform intricate surgeries with precision, while AI algorithms analyze vast medical datasets, uncovering patterns and accelerating medical research.\r\n\r\nWhile the future of AI is undeniably exciting, it also brings forth challenges. The potential displacement of jobs due to automation, concerns about AI ethics, and the need for robust cybersecurity measures are areas that demand careful consideration and proactive solutions.\r\n\r\nIn conclusion, the future of Artificial Intelligence is a journey into uncharted territory, where the synergy between human intelligence and machine capabilities holds boundless potential. By navigating the ethical complexities and embracing responsible innovation, we can shape an AI-driven future that enhances our lives, pushing the boundaries of what is possible in the realm of technology.\r\n\r\n\r\n\r\n\r\n\r\n', '2024-01-04 17:49:03', 'Approved', NULL),
(7, 2, 'Unlocking the Secrets of Creativity', 'Creativity, a force that propels us beyond the ordinary, lies within the depths of our minds, waiting to be unleashed. It is the spark that turns the mundane into the extraordinary, the key to unlocking doors to new possibilities. So, how do we unravel the secrets of creativity and tap into its boundless potential?\r\n\r\nFirstly, creativity thrives in an environment that encourages exploration and embraces failure. Often, the fear of making mistakes stifles creativity. Embrace the idea that failure is a stepping stone to success, a valuable lesson in the creative process.\r\n\r\nSecondly, diverse experiences fuel the creative mind. Expose yourself to different cultures, disciplines, and perspectives. The amalgamation of varied influences cultivates a rich soil for creative ideas to flourish.\r\n\r\nAdditionally, allocate time for contemplation and reflection. In our fast-paced world, the constant stream of information can drown out the whispers of our creative thoughts. Set aside moments of solitude to let your mind wander, allowing creativity to bubble to the surface.\r\n\r\nCollaboration is another catalyst for creativity. Engage with a diverse group of individuals, each bringing their unique insights to the table. The exchange of ideas often sparks a creative synergy that elevates the collective thinking beyond individual capacities.\r\n\r\nLastly, embrace discomfort. Creativity thrives outside comfort zones. Challenge yourself to tackle problems from different angles, explore unfamiliar territories, and be open to unconventional ideas.\r\n\r\nIn conclusion, unlocking the secrets of creativity involves fostering an environment of experimentation, embracing diversity, allocating time for reflection, encouraging collaboration, and embracing discomfort. As we embark on this journey of unlocking creativity, let us remember that within every challenge lies an opportunity for innovation and artistic expression.', '2024-01-04 18:49:07', 'Approved', NULL),
(8, 4, 'Exciting Journey into the World of Technology', 'In the ever-evolving landscape of technology, our journey into the digital realm is both exhilarating and transformative. From the advent of the internet to the rise of artificial intelligence, each milestone propels us further into a future shaped by innovation.\r\n\r\nThe interconnected world has made information accessible at our fingertips, breaking down barriers and connecting people across continents. Mobile devices have become an extension of ourselves, providing not just communication but a gateway to endless possibilities. As we navigate this digital landscape, we witness the convergence of technologies, giving rise to groundbreaking solutions.\r\n\r\nArtificial Intelligence, once a concept of science fiction, is now a reality, influencing industries from healthcare to finance. Machine learning algorithms analyze vast datasets, unlocking patterns and insights that redefine how we approach complex problems. Automation, powered by technology, streamlines processes, making way for creativity and strategic thinking.\r\n\r\nThe journey into technology is not without challenges. Cybersecurity concerns, ethical dilemmas in AI, and the digital divide are hurdles we must overcome. However, these challenges fuel our determination to build a tech-savvy future that prioritizes inclusivity, ethics, and sustainability.\r\n\r\nIn conclusion, our exciting journey into the world of technology is marked by continuous innovation and the promise of a better, more connected world. As we embrace the digital era, let us strive to harness technology responsibly, shaping a future where the benefits of innovation are felt by all.', '2024-01-13 14:07:55', 'Approved', NULL);

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
  MODIFY `post_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

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
