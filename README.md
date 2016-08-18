# thymeleaf + spring + recaptcha (google)
contact : rijaramampiandra@gmail.com

Build project :
- Maven 3.0.4 or UP

JDK :
- Version 6 or 7

Deploiement server :
- Tomcat 6 or tomcat 7
- Tom cat 6 : http://www-eu.apache.org/dist/tomcat/tomcat-6/v6.0.45/bin/apache-tomcat-6.0.45.zip

Config database connexion :
- /gestion_inscription/src/main/resources/spring.xml (jdbc:mysql://localhost:3306/client_connexion, password, user)
- Database : MySQL
- Table script : user.sql

Config STMP connexion :
- /gestion_inscription/src/main/resources/config.properties 

Site :
- RWD (Responsive Web design) : bootstrap + jquery

Techno :
- Thymeleaf
- Spring
- Recaptcha de google
- Password crypted with : SHA-256
- hibernate
- javax.mail
- json

http://localhost:8080/gestion_inscription

Documentation :
- http://getbootstrap.com/css/
- www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html
- https://developers.google.com/recaptcha/old/docs/customization?hl=fr
- http://www.journaldev.com/2532/javamail-example-send-mail-in-java-smtp
- https://www.mkyong.com/regular-expressions/how-to-validate-email-address-with-regular-expression/
- https://www.mkyong.com/regular-expressions/how-to-validate-password-with-regular-expression/
- http://o7planning.org/en/10397/using-google-recaptcha-with-java-web-application