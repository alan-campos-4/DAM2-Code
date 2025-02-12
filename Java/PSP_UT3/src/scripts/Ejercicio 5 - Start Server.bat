
javac "./../Ej5_Server.java"
javac "./../Ej5_Client.java"

jar cfe Ej5_Server.jar Ej5_Server "./../Ej5_Server.class"
jar cfe Ej5_Client.jar Ej5_Client "./../Ej5_Client.class"

cls

java -jar "Ej5_Server.jar"

pause

del Ej5_Server.jar
del "./../Ej5_Server.class"
del Ej5_Client.jar
del "./../Ej5_Client.class"

