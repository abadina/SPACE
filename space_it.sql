-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mer. 03 fév. 2021 à 20:47
-- Version du serveur :  10.4.8-MariaDB
-- Version de PHP :  7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `space_it`
--

-- --------------------------------------------------------

--
-- Structure de la table `choisir`
--

CREATE TABLE `choisir` (
  `nom` varchar(254) NOT NULL,
  `username` varchar(254) NOT NULL,
  `score` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `estcompose`
--

CREATE TABLE `estcompose` (
  `texte` varchar(254) NOT NULL,
  `nom` varchar(254) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `estcompose`
--

INSERT INTO `estcompose` (`texte`, `nom`) VALUES
(' HTTP est un est un protocole de communication client-serveur développé pour le World Wide Web mais ça signifie :', 'General'),
(' Il préférable d’utiliser des variable :', 'C'),
(' Lequel de ces définitions de fonctions dont correctes si elles sont sensées calculer « X » élevé à la puissance « N »entière ?', 'C'),
(' les variables booléennes (bool) valent :', 'C++'),
(' Où est stockée une variable ?', 'C'),
(' Si i et d sont définis par int i; double d; alors l’expression (int)i%d est du type :  ', 'C++'),
('-Lequel de ces types d’événements \"bouillonne\" (se propage) ?', 'JS'),
('1-Le nombre binaire 1011 vaut en décimal :', 'General'),
('A quoi sert une adresse ip ?', 'General'),
('après l’exécution du code suivant la variable m vaut :\r\nint i = 4, j = 3, n = 0 ;\r\nfloat m ;\r\nj = n*j+i-3 ;\r\nn = i/4 ; \r\nm = i*j+n/2 ;\r\n', 'C++'),
('c\'est quoi WWW?', 'General'),
('Comment s\'écrit la commande qui permet d\'afficher un texte à l\'écran ?', 'C'),
('Comment s’appelle un logiciel malveillant installé dans un ordinateur dans le but de collecter et transférer des informations sans que l’utilisateur en ait connaissance ?', 'General'),
('Comment tester si un objet \"File\" est un répertoire ?', 'JAVA'),
('Compiler du Java donne:', 'JAVA'),
('Correction de cette ligne : printf(\'Bonjour\'\\n)', 'C'),
('Dans \"throws ClasseA\", ClasseA\r\n', 'JAVA'),
('Dans le langage C, tout part d’une seule fonction. Laquelle ?\r\n', 'General'),
('Dans quel ordre s\'effectue une compilation ?', 'C'),
('Dans un fichier JavaScript externe (.js), il faut :', 'JS'),
('En quelle année a été créé le langage C ?', 'General'),
('En quoi consiste <<l\'overcloaking>>?\r\n', 'General'),
('Java est un langage développé par \r\n', 'General'),
('Laquelle de ces expressions est évaluée à false ?\r\n', 'JS'),
('Le package \"javax.swing\" est utilisé pour', 'JAVA'),
('Le terme \"polymorphisme\" s\'emploie pour', 'JAVA'),
('Le type \"float\" est codé sur combien d\'octets ?\r\n', 'JAVA'),
('le type du résultat de la division de deux entiers (int) : ', 'C++'),
('Lequel de ces types d\'événements n\'existe pas :\r\n', 'JS'),
('Lequel de ces types d\'événements n\'existe pas :', 'JS'),
('Lequel des énoncés suivants n’est pas une déclaration de nom de variable valide?', 'C'),
('Lequel des énoncés suivants n’est pas une déclaration valide?', 'C'),
('Les variables d’un appel de fonction sont allouées dans :\r\n', 'C'),
('Lorsque la portée d\'une classe n\'est pas précisée dans un package, celle-ci est dite', 'JAVA'),
('Par quel symbole indique-t-on une fonction du préprocesseur ?', 'C'),
('Par qui a été créé le langage C ?', 'General'),
('Peut-on coder sur un ordinateur Linux ?', 'General'),
('Pour empêcher de redéfinir une méthode on la déclare', 'JAVA'),
('pour lire la variable x au clavier on peut utiliser : ', 'C++'),
('Qu\'est ce qu\'un IDE ?', 'General'),
('Quand l\'événement \"load\" se déclenche-t-il pour une page?\r\n', 'JS'),
('Que signifie l\'acronyme AJAX ?\r\n', 'JS'),
('que va afficher ce programme?\r\nint a=128;\r\nchar b=a;\r\na=b;\r\ncout<<a;', 'C++'),
('Que va afficher ce programme?\r\nint a[]={1,2,3,4,5,6};\r\ncout<<((1+3)[a] == a[1+3]);', 'C++'),
('Que va afficher ce programme?\r\nint a[]={1,2,3,4,5,6};\r\ncout<<(1+3)[a]-a[0]+(a+1)[2];\r\n', 'C++'),
('que va afficher ce programme?\r\nint x=3;\r\nint y=5;\r\nfunction<int (void)> foo =[x,y]{return x+y;};\r\n\r\nx=22;\r\ny=44;\r\n\r\ncout<<foo();', 'C++'),
('Que va être l’output?\r\nchar a[15]=”Hello”;\r\nchar b[]=”World!”;\r\ncout<<a+b;', 'C++'),
('Que va être l’output?\r\ncout<<sizeof(1);', 'C++'),
('Que va être l’output?\r\nif(0)\r\ncout<<”Hello”;	\r\ncout<<”!”;	', 'C++'),
('Quel attribut des noeuds de l\'arbre DOM correspond à l\'attribut (X)HTML class ?', 'JS'),
('Quel est l\'équivalent de pouet.coin ?\r\n', 'JS'),
('Quel est l\'équivalent pour un noeud de l\'arbre DOM de node.childNodes[1] (en supposant que le noeud demandé existe) ?', 'JS'),
('Quel est le rapport entre Java et JavaScript ?', 'JS'),
('Quel est le rôle principal du constructeur d’une classe', 'C++'),
('Quelle est la différence majeure entre le langage C et le langage C++ ?', 'General'),
('Quelle est la méthode spécifiée dans le DOM-2 pour l\'ajout des gestionnaires d\'événements ?\r\n', 'JS'),
('Quelle est l’extension des fichiers sources JAVA?', 'General'),
('Quelle est l’extension des fichiers sources JAVA?', 'JAVA'),
('Quelle syntaxe est correcte pour que la fonction init soit appelée au chargement de la page?\r\n', 'JS'),
('Quels sont les types de nombres définis en JavaScript ?\r\n', 'JS'),
('Qui a développé le langage C ?', 'General'),
('Qu’est-ce que UML ?\r\n', 'General'),
('Qu’est-ce qu’un CPU ?', 'General'),
('Si i est défini par int i; alors i *= 2.; est du type : ', 'C++'),
('Supposons qu’un programme C ait une constante flottante 1.414 quel est le meilleur moyen de convertir cela en tant que type de données ‘float’ ?', 'C'),
('trouvez l\'intrus parmi ces portes logiques\r\n', 'General'),
('Un cookie sur internet, peut ?', 'General'),
('Un design pattern permet de gérer des', 'JAVA'),
('Une classe \"serializable\" permet de:', 'JAVA'),
('Une fonction renvoie toujours une valeur?', 'C'),
('window.i = 0; var i = 2; alert(window.i); : que va afficher ce code ?\r\n', 'JS'),
('Par quel symbole indique-t-on une fonction du préprocesseur?', 'C'),
('Dans quel(s) des cas suivant(s) est-il possible d\'obtenir des résultats différents pour le passage de paramètre par référence et par valeur?', 'C'),
('Dans quel(s) des cas suivant(s) est-il possible d\'obtenir des résultats différents pour le passage de paramètre par référence et par valeur?', 'C'),
('Dans quel(s) des cas suivant(s) est-il possible d’obtenir des résultats différents pour le passage de paramètre par référence et par valeur?', 'C'),
('Par quel symbole indique-t-on une fonction du préprocesseur?', 'C'),
('Est ce qu’on peut créer une classe vide ?', 'C++'),
('Quelle classe fondamentale ne nécessite pas l\'instruction \"import\" car celui-ci est fait automatiquement ?', 'JAVA'),
('Qu\'est-ce qu\'une \"super classe\" ?', 'JAVA'),
('Dans une classe, on accède à ses variables grâce ', 'JAVA'),
('Le Java reprend la syntaxe du', 'JAVA');

-- --------------------------------------------------------

--
-- Structure de la table `langage`
--

CREATE TABLE `langage` (
  `nom` varchar(254) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `logo` varchar(254) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `langage`
--

INSERT INTO `langage` (`nom`, `description`, `logo`) VALUES
('C', 'C est un langage de programmation impératif généraliste, de bas niveau. Inventé au début des années 1970 pour réécrire UNIX, C est devenu un des langages les plus utilisés, encore de nos jours. De nombreux langages plus modernes comme C++, C#, Java et PHP ou Javascript ont repris une syntaxe similaire au C et reprennent en partie sa logique. C offre au développeur une marge de contrôle importante sur la machine (notamment sur la gestion de la mémoire) et est de ce fait utilisé pour réaliser les « fondations » (compilateurs, interpréteurs…) de ces langages plus modernes.', 'space/Ressources/c.png'),
('C++', 'C++ est un langage de programmation compilé permettant la programmation sous de multiples paradigmes (comme la programmation procédurale, orientée objet ou générique). Ses bonnes performances, et sa compatibilité avec le C en font un des langages de programmation les plus utilisés dans les applications où la performance est critique.\r\n\r\nCréé initialement par Bjarne Stroustrup dans les années 1980, le langage C++ est aujourd\'hui normalisé par l\'ISO.', 'space/Ressources/CPPLOGO.png'),
('JAVA', 'Java est un langage de programmation orienté objet créé par James Gosling et Patrick Naughton, employés de Sun Microsystems, avec le soutien de Bill Joy (cofondateur de Sun Microsystems en 1982), présenté officiellement le 23 mai 1995 au SunWorld.\r\n\r\nLa société Sun a été ensuite rachetée en 2009 par la société Oracle qui détient et maintient désormais Java.\r\n\r\nUne particularité de Java est que les logiciels écrits dans ce langage sont compilés vers une représentation binaire intermédiaire qui peut être exécutée dans une machine virtuelle Java (JVM) en faisant abstraction du système d\'exploitation.', 'space/Ressources/JAVALOGO.png'),
('JS', 'JavaScript est un langage de programmation de scripts principalement employé dans les pages web interactives mais aussi pour les serveurs avec l\'utilisation (par exemple) de Node.js. C\'est un langage orienté objet à prototype, c\'est-à-dire que les bases du langage et ses principales interfaces sont fournies par des objets qui ne sont pas des instances de classes, mais qui sont chacun équipés de constructeurs permettant de créer leurs propriétés, et notamment une propriété de prototypage qui permet d\'en créer des objets héritiers personnalisés. En outre, les fonctions sont des objets de première classe. Le langage supporte le paradigme objet, impératif et fonctionnel. JavaScript est le langage possédant le plus large écosystème grâce à son gestionnaire de dépendances npm, avec environ 500 000 paquets en août 2017', 'space/Ressources/JSLOGO.png');

-- --------------------------------------------------------

--
-- Structure de la table `modes`
--

CREATE TABLE `modes` (
  `nom` varchar(254) NOT NULL,
  `score` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `modes`
--

INSERT INTO `modes` (`nom`, `score`) VALUES
('ALEATOIRE', 0),
('C', 0),
('C++', 0),
('General', 0),
('JAVA', 0),
('JS', 0);

-- --------------------------------------------------------

--
-- Structure de la table `question`
--

CREATE TABLE `question` (
  `texte` varchar(254) NOT NULL,
  `niveau` int(11) DEFAULT NULL,
  `choix1` varchar(254) DEFAULT NULL,
  `choix2` varchar(254) DEFAULT NULL,
  `choix3` varchar(254) DEFAULT NULL,
  `rep` int(11) DEFAULT NULL,
  `verifier` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `question`
--

INSERT INTO `question` (`texte`, `niveau`, `choix1`, `choix2`, `choix3`, `rep`, `verifier`) VALUES
(' HTTP est un est un protocole de communication client-serveur développé pour le World Wide Web mais ça signifie :', NULL, 'HyperText Transfer Protocol ', 'HyperTransfert Text Protocol', 'HyperTranslate Text Protocol\r\n', 1, NULL),
(' Il préférable d’utiliser des variable :', 2, 'Locales', 'Globales', NULL, 1, NULL),
(' Lequel de ces définitions de fonctions dont correctes si elles sont sensées calculer « X » élevé à la puissance « N »entière ?', 2, 'float puissance(float X, int N)', 'puissance (float X ; int N )', 'void puissance (float X , int N )', 1, NULL),
(' les variables booléennes (bool) valent :', 1, 'vrai ou faux', 'true ou false', '0 ou 1', 2, NULL),
(' Où est stockée une variable ?', 2, 'Dans le disque dur', 'Dans la mémoire vive', 'Dans la mémoire caché', 2, NULL),
(' Quelles sont les extensions relatives à un fichier texte ?\r\n', NULL, 'txt ', ' rtl', ' doc', 1, NULL),
(' Si i et d sont définis par int i; double d; alors l’expression (int)i%d est du type :  ', 2, ' int', 'double', 'C’est une expression erronée	', 3, NULL),
('-Lequel de ces types d’événements \"bouillonne\" (se propage) ?', 3, 'Blur\r\n', 'Focus', 'select', 3, NULL),
('1-Le nombre binaire 1011 vaut en décimal :', NULL, '7', '11', '9', 2, NULL),
('A quoi sert une adresse ip ?', NULL, 'Afficher l\'adresse postale d\'un serveur	', 'Définir le positionnement GPS d\'un internaut', 'Identifier chaque ordinateur connecté à Internet', 1, NULL),
('après l’exécution du code suivant la variable m vaut :\r\nint i = 4, j = 3, n = 0 ;\r\nfloat m ;\r\nj = n*j+i-3 ;\r\nn = i/4 ; \r\nm = i*j+n/2 ;\r\n', 1, '2', '4', '4,5', 2, NULL),
('c\'est quoi WWW?', NULL, 'World Wide Wireless', 'World Wide Web	', 'Wireless Wide Web', 2, NULL),
('Comment connaître la classe mère de Classe1 ?', 3, 'Classe1.class.getsuperclass();', 'Classe1.getsuperclass();', 'Classe1.getclass();', 1, NULL),
('Comment s\'écrit la commande qui permet d\'afficher un texte à l\'écran ?', 1, 'Print', 'Printf', 'Prints', 2, NULL),
('Comment s’appelle un logiciel malveillant installé dans un ordinateur dans le but de collecter et transférer des informations sans que l’utilisateur en ait connaissance ?', NULL, 'spyware ', 'Spam', 'Virus', NULL, NULL),
('Comment tester si un objet \"File\" est un répertoire ?', 3, '.Directory()', '.isDirectory() ', '.dir()', 2, NULL),
('Compiler du Java donne:', 2, 'rien', 'Un fichier .jve', 'byte code', 3, NULL),
('Correction de cette ligne : printf(\'Bonjour\'\\n)', 1, 'Printf(‘Bonjour\\n’) ;', 'Printf(‘Bonjour\\n) ;', 'Printf(‘Bonjour\\n’)', 1, NULL),
('Dans \"throws ClasseA\", ClasseA\r\n', 3, 'Gère une exception. ', 'Change de portée.', 'est détruite.', 1, NULL),
('Dans le langage C, tout part d’une seule fonction. Laquelle ?\r\n', NULL, 'la fonction main()', 'la fonction firt()', 'la fonction principale()', 1, NULL),
('Dans quel ordre s\'effectue une compilation ?', 3, 'Préprocesseur - Compilateur – Linker', 'Compilateur - Linker – Préprocesseur', 'Préprocesseur - Linker – Compilateur', 1, NULL),
('Dans un fichier JavaScript externe (.js), il faut :', 1, 'entourer le code avec les balises <script> et </script>.', 'échapper les caractères spéciaux (X)HTML. ', 'Aucune des réponses précédentes.', 3, NULL),
('En quelle année a été créé le langage C ?', NULL, '1972', '1975', '1980', 1, NULL),
('En quoi consiste <<l\'overcloaking>>?\r\n', NULL, 'Mesure les performances d\'un microprocesseur', 'Augmenter la fréquence d\'un microprocesseur', 'Combiner deux microprocesseurs', 2, NULL),
('Java est un langage développé par \r\n', NULL, 'Sun Microsystems', 'Oracle', 'IBM', NULL, NULL),
('Laquelle de ces expressions est évaluée à false ?\r\n', 3, '\"Infinity\" == Infinity ', 'NaN == NaN', '\"0xa\" == 10 ', 2, NULL),
('Le package \"javax.swing\" est utilisé pour', 1, 'Les applets', 'Les fenêtres', 'Le réseau', 2, NULL),
('Le terme \"polymorphisme\" s\'emploie pour', 2, 'Méthode', 'Classe', 'Attribut', 1, NULL),
('Le type \"float\" est codé sur combien d\'octets ?\r\n', 3, '8', '4', '2', 2, NULL),
('le type du résultat de la division de deux entiers (int) : ', 1, 'est un entier ', 'est un réel ', 'dépend du type de la destination', 1, NULL),
('Lequel de ces types d\'événements n\'existe pas :\r\n', 1, 'mouseclick', 'load', 'Blur', 1, NULL),
('Lequel de ces types d\'événements n\'existe pas :', 1, 'document.getElementsByClassName', 'document.getElementsByTagName', 'document.getElementsByAttribute', 3, NULL),
('Lequel des énoncés suivants n’est pas une déclaration de nom de variable valide?', 1, 'int__a7 ;', 'int__7a ;', 'Aucune de ces réponses', 3, NULL),
('Lequel des énoncés suivants n’est pas une déclaration valide?', 1, 'float PI = 3.14;', 'int PI = 3.14 ;', '#define PI 3.14', 3, NULL),
('Les variables d’un appel de fonction sont allouées dans :\r\n', 3, 'Registres et pile', 'Cache et tas', 'Pile et tas', 1, NULL),
('Lorsque la portée d\'une classe n\'est pas précisée dans un package, celle-ci est dite', 3, 'public', 'private', 'default', 3, NULL),
('Par quel symbole indique-t-on une fonction du préprocesseur ?', 2, '@', '::', '#', 3, NULL),
('Par qui a été créé le langage C ?', NULL, 'Bill Gates', 'Steve Jobs', 'Dennis Ritchie', 3, NULL),
('Peut-on coder sur un ordinateur Linux ?', NULL, 'Oui', 'Non', 'Seulement le langage C', 1, NULL),
('Pour empêcher de redéfinir une méthode on la déclare', 2, 'Static', 'Final', 'Private', 2, NULL),
('pour lire la variable x au clavier on peut utiliser : ', 1, 'cin >> &x', 'cin >> x >> endl', 'cin >> x', 3, NULL),
('Qu\'est ce qu\'un IDE ?', NULL, 'Un environnement de développement', 'Une fonction', 'Une condition', 1, NULL),
('Quand l\'événement \"load\" se déclenche-t-il pour une page?\r\n', 2, 'Dès que le navigateur commence à recevoir le code HTML.\r\n', 'Quand le code HTML a fini d\'être chargé. ', 'Quand l\'arbre DOM a été construit et toutes les ressources chargées (images, ...). ', 3, NULL),
('Que signifie l\'acronyme AJAX ?\r\n', 2, 'Advanced JavaScript with XMLHttpRequest. ', 'JavaScript extensible.', 'Asynchronous JavaScript and XML.', 3, NULL),
('que va afficher ce programme?\r\nint a=128;\r\nchar b=a;\r\na=b;\r\ncout<<a;', 3, '128', '-128', '-127', 2, NULL),
('Que va afficher ce programme?\r\nint a[]={1,2,3,4,5,6};\r\ncout<<((1+3)[a] == a[1+3]);', 3, '1', 'true', NULL, 1, NULL),
('Que va afficher ce programme?\r\nint a[]={1,2,3,4,5,6};\r\ncout<<(1+3)[a]-a[0]+(a+1)[2];\r\n', 3, '9', '6', '8', 3, NULL),
('que va afficher ce programme?\r\nint x=3;\r\nint y=5;\r\nfunction<int (void)> foo =[x,y]{return x+y;};\r\n\r\nx=22;\r\ny=44;\r\n\r\ncout<<foo();', 3, '8', '47', '66', 1, NULL),
('Que va être l’output?\r\nchar a[15]=”Hello”;\r\nchar b[]=”World!”;\r\ncout<<a+b;', 2, 'Erreur: opérateur invalide	', 'Hello World!', 'Hello', 1, NULL),
('Que va être l’output?\r\ncout<<sizeof(1);', 2, '0', '1', '4', 3, NULL),
('Que va être l’output?\r\nif(0)\r\ncout<<”Hello”;	\r\ncout<<”!”;	', 2, 'Hello!', '!', 'Hello', 2, NULL),
('Quel attribut des noeuds de l\'arbre DOM correspond à l\'attribut (X)HTML class ?', 1, 'class', 'className', 'kiwi', 2, NULL),
('Quel est l\'équivalent de pouet.coin ?\r\n', 3, 'pouet[\"coin\"]', 'pouet[coin]', 'pouet.getCoin()', 1, NULL),
('Quel est l\'équivalent pour un noeud de l\'arbre DOM de node.childNodes[1] (en supposant que le noeud demandé existe) ?', 2, 'node.firstChild', 'node.previousSibling.parentNode ', 'node.firstChild.nextSibling', 3, NULL),
('Quel est le rapport entre Java et JavaScript ?', 1, 'C\'est le même langage, mais le nom  JavaScript  est utilisé pour le code s\'exécutant dans une page Web. ', 'Ce sont deux langages différents, malgré quelques points communs dans la syntaxe.', 'Java est une île, ça n\'a rien à voir !', 2, NULL),
('Quel est le rôle principal du constructeur d’une classe', 2, 'allouer la mémoire nécessaire d’une instance de cette classe', 'initialiser une instance de cette classe', 'définir une instance de cette classe', 2, NULL),
('Quelle est la différence majeure entre le langage C et le langage C++ ?', NULL, ' Le C ne supporte pas les classes et les objets', 'Le C++ ne supporte pas les boucles logiques', 'Le C++ ne supporte  pas les variables booléennes', 1, NULL),
('Quelle est la méthode spécifiée dans le DOM-2 pour l\'ajout des gestionnaires d\'événements ?\r\n', 3, 'addEventListener', 'attachEvent', 'attachEventListener\r\n', 1, NULL),
('Quelle est l’extension des fichiers sources JAVA?', 1, '.jv', '.java', '.j', 2, NULL),
('Quelle syntaxe est correcte pour que la fonction init soit appelée au chargement de la page?\r\n', 2, 'window.onload = init;', 'window.onload = init();', 'window.onload() = init; ', 1, NULL),
('Quels sont les types de nombres définis en JavaScript ?\r\n', 2, 'Integer et Float.', 'Number.', 'Number et Double.', 2, NULL),
('Qui a développé le langage C ?', NULL, 'Dennis Ritchie, seul', 'Dennis Ritchie & Bell Labs', 'Bell Labs, seul', 2, NULL),
('Qu’est-ce que UML ?\r\n', NULL, 'Un langage de développement objet', 'Un langage de modélisation objet', 'Une démarche de définition de logiciel', 2, NULL),
('Qu’est-ce qu’un CPU ?', NULL, 'Un processeur', 'Une carte video', 'Un disque dur', 1, NULL),
('Si i est défini par int i; alors i *= 2.; est du type : ', 1, 'long', 'float ', 'int	', 3, NULL),
('Supposons qu’un programme C ait une constante flottante 1.414 quel est le meilleur moyen de convertir cela en tant que type de données ‘float’ ?', 2, '1.414 lui-même de type \"float\" c\'est-à-dire rien d\'autre n\'est requis.', '1.414f ou 1.414F', '(float)1.414', 2, NULL),
('trouvez l\'intrus parmi ces portes logiques\r\n', NULL, 'ET', 'DANS', 'OUI', 2, NULL),
('Un cookie sur internet, peut ?', NULL, 'être un programme', ' contenir un virus', 'paramétrer de façon personnalisé la page d’accueil d’un site web ', 3, NULL),
('Un design pattern permet de gérer des', 2, 'Caractères étendues\r\n', 'problèmes récurrents d’architecture logicielle', 'entités graphiques', 2, NULL),
('Une classe \"serializable\" permet de:', 3, 'd’empiler et dépiler ses objets.', 'de sauvegarder ses objets dans un fichier.', 'de gérer ses objets sous forme de listes.\r\n', 2, NULL),
('Une fonction renvoie toujours une valeur?', 1, 'Faux', 'Vrai', NULL, 2, NULL),
('window.i = 0; var i = 2; alert(window.i); : que va afficher ce code ?\r\n', 3, '0', '2', 'Game over', 2, NULL),
('Dans quel(s) des cas suivant(s) est-il possible d’obtenir des résultats différents pour le passage de paramètre par référence et par valeur?', 3, 'Passer une expression en tant que paramètre.', 'Passer un tableau en tant que paramètre.', 'Passer un tableau d’éléments en tant que paramètre.', 3, NULL),
('Par quel symbole indique-t-on une fonction du préprocesseur?', 3, '@', '#', '::', 2, NULL),
('Est ce qu’on peut créer une classe vide ?', 3, 'Oui', 'Non', 'Oui,Mais avec limitation', 1, NULL),
('Comment connaître la classe mère de Classe1 ?', 2, 'Classe1.class.getsuperclass();', 'Classe1.getsuperclass();', 'Classe1.getclass();', 1, NULL),
('Quelle classe fondamentale ne nécessite pas l\'instruction \"import\" car celui-ci est fait automatiquement ?', 2, 'java.io', 'java.lang', 'java.main', 2, NULL),
('Qu\'est-ce qu\'une \"super classe\" ?', 1, 'une classe public', 'une classe du langage Java', 'une classe mère', 3, NULL),
('Dans une classe, on accède à ses variables grâce ', 1, 'par l’opérateur.', 'par mot clé this', 'par mot clé new', 2, NULL),
('Le Java reprend la syntaxe du', 1, 'C++', 'PHP', 'Java Script', 1, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `username` varchar(254) NOT NULL,
  `password` varbinary(254) DEFAULT NULL,
  `email` varchar(254) DEFAULT NULL,
  `authentification` int(11) DEFAULT NULL,
  `avatar` varchar(254) DEFAULT NULL,
  `score` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `langage`
--
ALTER TABLE `langage`
  ADD PRIMARY KEY (`nom`);

--
-- Index pour la table `modes`
--
ALTER TABLE `modes`
  ADD PRIMARY KEY (`nom`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
