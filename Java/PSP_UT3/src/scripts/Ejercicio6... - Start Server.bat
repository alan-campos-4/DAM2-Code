
javac "./../Ej6_Server.java"
javac "./../Ej6_Client.java"

jar cfe Ej6_Server.jar Ej6_Server "./../Ej6_Server.class"
jar cfe Ej6_Client.jar Ej6_Client "./../Ej6_Client.class"

cls

java -jar "Ej6_Server.jar"

pause

del Ej6_Server.jar
del "./../Ej6_Server.class"
del Ej6_Client.jar
del "./../Ej6_Client.class"
