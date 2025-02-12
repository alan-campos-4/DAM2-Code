
javac "./../Ej8_Server.java"
javac "./../Ej8_Client.java"

jar cfe Ej8_Server.jar Ej8_Server "./../Ej8_Server.class"
jar cfe Ej8_Client.jar Ej8_Client "./../Ej8_Client.class"

cls

java -jar "Ej8_Server.jar"

pause

del Ej8_Server.jar
del "./../Ej8_Server.class"
del Ej8_Client.jar
del "./../Ej8_Client.class"

