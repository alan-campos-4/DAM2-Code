
javac "./../Ej1_Server.java"
javac "./../Ej1_Client.java"

jar cfe Ej1_Server.jar Ej1_Server "./../Ej1_Server.class"
jar cfe Ej1_Client.jar Ej1_Client "./../Ej1_Client.class"

cls

java -jar "Ej1_Server.jar"

pause

del Ej1_Server.jar
del "./../Ej1_Server.class"
del Ej1_Client.jar
del "./../Ej1_Client.class"
