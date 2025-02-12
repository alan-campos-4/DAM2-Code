
javac "./../Ej4_Server.java"
javac "./../Ej4_Client.java"

jar cfe Ej4_Server.jar Ej4_Server "./../Ej4_Server.class"
jar cfe Ej4_Client.jar Ej4_Client "./../Ej4_Client.class"

cls

java -jar "Ej4_Server.jar"

pause

del Ej4_Server.jar
del "./../Ej4_Server.class"
del Ej4_Client.jar
del "./../Ej4_Client.class"

