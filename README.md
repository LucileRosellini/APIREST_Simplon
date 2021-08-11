# Projet_API_REST_Simplon
Projet admission CDA Simplon.

==================================================================================

1) Lecture de l'ennoncé. 
-Révision des termes: Repository/DAO, API REST

Difficultés:
-Découvrir le terme DAO.
-Imaginer travailler sans framework.

Solutions:
-Lire et Relire.

==> J'ai déjà travaillé avec des API Rest dans le cadre de projets Vues.js. Modèles MVC. 

Temps cumulé: 0h30

----------------------------------------------------------------------------------

2) Comprendre l'UML
-Etudier la représentation des classes intervenant dans le système attendu.
-Révision des relations 1-0*.
-Etudier les éventuelles interactions entre les classes.
-Noter les attributs specifiés par le diagramme de classe. 


Difficultés: 
-Regretter de ne pas avoir d'indications sur les méthodes attendues dans les classes.

Solutions: 
-Lecture de documentation 

Ressources:
https://fr.wikipedia.org/wiki/UML_(informatique)
https://www.lucidchart.com/pages/fr/langage-uml
https://www.youtube.com/watch?v=odKgwPftibM&t=189s&ab_channel=Emds

==> J'apprécies de m'appuyer sur des UML pour travailler. 

Temps cumulé: 1h30

----------------------------------------------------------------------------------

3) Choix du langage
-Hésitation entre JAVA et JAVASCRIPT. 
==>JAVA avec IntelliJi permet de facilement manipuler les classes. JAVA est un langage typé, carré, qui me permet de coder proprement avec une bonne relecture que j'apprécies beaucoup. 
==>JAVASCRIPT permet une evolution de l'API REST: Il permet l'utilisation de JQuery, de node.js. Travailler avec PHP, HTML/CSS pour une evolution de l'application vers du front web. 
-Choix retenu: JavaScript pour ses capacités d'évolutions. 

Difficultés: 
-Pas d'affinité particulière avec JavaScript. 

Solutions: 
-Devoir réviser JavaScript depuis le début. (Pas utilisé depuis longtemps)

Ressources: 
-https://openclassrooms.com/fr/courses/6175841-apprenez-a-programmer-avec-javascript


==> JavaScript est un langage avec des objets "magiques" que je ne comprends pas toujours. Il existe des subtilités en JavaScript qui m'echappent tel que this dans un objet, différent du this dans une expression de fonction fléchée. Je ne suis pas à l'aise avec les raccourcis d'expression de JavaScript. 

Temps cumulé: 20h

----------------------------------------------------------------------------------
4) Bien comprendre la notion d'API REST.

API REST (également appelée API RESTful) est une interface de programmation d'application (API ou API web) qui respecte les contraintes du style d'architecture REST et permet d'interagir avec les services web RESTful. Une API est un ensemble de définitions et de protocoles qui facilite la création et l'intégration de logiciels d'applications. 
Utiliser une API REST sur internet, c’est interroger un serveur tiers en utilisant les mêmes méthodes que ce que propose l’affichage de page web ou des formulaires inclus dans ces mêmes pages web. Ainsi on va interroger ce serveur à partir d’une URL communiquée par l’éditeur de l’API.
Cette interrogation va se faire suivant différentes méthodes : GET, POST, PUT et DELETE. 

Difficultés:
-J'ai déjà mis en place des API REST en utilisant des framework jamais en procédant manuellement. (vues.js)

Solutions: 
-Se repporter à la documentation.

-Ressources: 
https://www.redhat.com/fr/topics/api/what-is-a-rest-api
https://www.youtube.com/watch?v=BbZnsN3LSbY
https://devstory.net/11199/tutoriel-java-restful-web-service-pour-debutant

Temps cumulé : 2h

----------------------------------------------------------------------------------

5) Comprendre la notion de DAO ==> /!/ DECISION : CHANGER DE TECHNO!!! 

DAO (en anglais data access object ou DAO) est un objet d'accès aux données. C'est un patron de conception (c'est-à-dire un modèle pour concevoir une solution) utilisé dans les architectures logicielles objet. Les objets en mémoire vive sont souvent liés à des données persistantes (stockées en base de données, dans des fichiers, dans des annuaires…). Le modèle DAO propose de regrouper les accès aux données persistantes dans des classes à part, plutôt que de les disperser. Il s'agit surtout de ne pas écrire ces accès dans les classes "métier", qui ne seront modifiées que si les règles de gestion métier changent.

Difficultés: 
-Mettre en place un DAO sans framework. 
-Je ne trouve pas comment simuler une interface avec JavaScript.. !!! (PANIQUE. Nous sommes le 9/08/21. Il me reste 2jours pour finaliser le projet)

Solutions: 
-Beaucoup de documentations.===> Tenter de faire un fichier pour simuler le DAO???? Résultat non efficient! . 
-Devant l'urgence (deadline du 11/08).Je décide de changer de language et de passer en JAVA. ===>  Projet en JavaScript avorté! 

Ressources (principales): 
https://fr.wikipedia.org/wiki/Objet_d%27acc%C3%A8s_aux_donn%C3%A9es
https://www.youtube.com/watch?v=EVP35NXbQBU&t=305s

Temps cumulé :
-Essayer de simuler un DAO avec JavaScript sans framework via fichier route et Json : < 8h
-Réfléchir au DAO lui-même : 4h
-Batailler avec git : 1h 


----------------------------------------------------------------------------------

6) Redémarrer le projet en Java

/// ---- CHAOS!!!---- /// 
En essayant de "clean" mon repertoire git pour relancer un projet en java j'ai "PERDU" tout le travail de ma branche javascript et le debut de mes classes en java!!! Par chance, mon editeur de test était encore ouvert! ... Desordre complet dans mon repo git. Je dois me résoudre à en créer un nouveau! ///

Methodologie:

a) Créer des classes comportant attribut de classe, accesseur de classe
==> Classes prévues à l'origine: User, Topic, Category, Post. 
==> Fichiers implémentés: User.java, Topic.java 

b) Créer une interface qui permet de passer les contrats des methodes entre Topic/User et topicDao/UserDao 
==> Fichier implémenté : Dao.java

c) Création des modèle necessaire pour acceder aux objets afin de recuperer les informations « brutes » (modèle inspiré mvc) afin de servir le controller qui pourra se charger de la manipulation des données pour faire le crud (Create Read update Delete). C'est une couche d'abstraction qui permet de ne pas écrire les méthodes directement dans les classes métiers.
==> Fichiers Implémentés: userDao.java et topicDao.java 

d.1) Creation d'un controller (modèle inspiré mvc) qui sert à manipuler les données qui ont été récupéré par le modèle.
En l'occurence le controller permet de:
-Créer deux utilisateurs par defaut. 
-Gerer les erreurs en cas d'une requête curl http inexistante.
-Afficher l'utilisateur par id ou en liste.
-Ajouter, Afficher, Modifier, supprimer user.
-Gerer l'affichage individuel ou en liste de user. (voir d.2)
-Générer un nouvelle id (/!/ La gestion d'erreur si id déjà existant non implémenté.)
==> Fichier Controllers.java. 


d.2) Modification du fichier User: ajout methode de classe pour le constructeur pour désérialiser les données en récupérant les données de User afin de pouvoir les traiter individuellement.Pour cela j'ai ajouté une librairie à mon IDE pour pouvoir importer et utiliser des outils qui peuvent traiter le format Json.
==> settings.json + librairie json-simple.


e) Créer un script principale (main) pour affichage sur port http 8000 (http://localhost:8000/user/ - Afficher la liste des utilisateurs. ou http://localhost:8000/user/0 - Permet d'afficher l'utilisateur par ID ==> Accessible par requête curl.)
==>Fichiers Implémentés: main.java


Ce que j'ai sût faire: 
-Implementer classes, interface, methodes CRUD, utiliser git et curl en ligne de commande, comprendre le shema UMl, Utiliser visual studio code, importer des librairies, comprendre le shema DAO/MVC, m'inspirer du modèle MVC.

Ce qui a été plus flou: 
-Désérialiser avec la librairie Json. 

Ce que je n'ai pas sût faire sans aide: 
-Mettre en place les routes http. Je ne visualisais pas comment traiter les routes.

Solutions: 
-Beaucoup de documentations. 
-Appeller tous mes copains developpeurs pour avoir des panneaux d'indications pour me mettre sur la bonne voie.


Ressources (principales): 
https://www.jmdoudoux.fr/java/dej/chap-json.htm
https://koor.fr/Java/Tutorial/java_reflexion_persistance.wp
https://blog.oxiane.com/2018/09/24/http2-api-http-client-de-java-11/
https://www.playframework.com/documentation/2.8.x/JavaRouting
https://github.com/cliftonlabs/json-simple

Temps cumulé :
-Coder: < 18h
-Appeller au secours: 4h 


==================================================================================



