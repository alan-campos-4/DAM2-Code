
javac "./../Ej3_Server.java"
javac "./../Ej3_Client.java"

jar cfe Ej3_Server.jar Ej3_Server "./../Ej3_Server.class"
jar cfe Ej3_Client.jar Ej3_Client "./../Ej3_Client.class"

cls

java -jar "Ej3_Server.jar"

pause

del Ej3_Server.jar
del "./../Ej3_Server.class"
del Ej3_Client.jar
del "./../Ej3_Client.class"
