spring-boot-ribbon> mvn package -DskipTests=true
eureka-server>java -jar target\ribbon-eureka-server-0.0.1-SNAPSHOT.jar
open http://localhost:8761/

ribbon-server>java -jar target\ribbon-server-0.0.1-SNAPSHOT.jar
open http://localhost:9090/backend


ribbon-client>java -jar target\ribbon-client-0.0.1-SNAPSHOT.jar

open http://localhost:8888/client/frontend/1323

