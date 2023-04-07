Cloner le repository sur votre machine locale.
Ouvrir le projet dans un environnement de développement tel qu'Eclipse ou IntelliJ.
Assurez-vous d'avoir les dépendances suivantes dans votre fichier pom.xml :
spring-boot-starter-web
spring-boot-starter-test
json

Exécuter l'application en utilisant la commande "Run As -> Spring Boot App" ou en exécutant la classe principale "TennisStatsApplication.java".
Une fois l'application démarrée, ouvrir votre navigateur et accéder à l'URL http://localhost:8080/players/sorted.
La liste des joueurs devrait s'afficher au format JSON.
Pour tester l'API REST, vous pouvez utiliser un outil tel que Postman en envoyant une requête GET à l'URL http://localhost:8080/players/sorted. Assurez-vous de spécifier l'en-tête "Content-Type: application/json".
Vous devriez recevoir une réponse contenant la liste des joueurs au format JSON.

Thank you :)