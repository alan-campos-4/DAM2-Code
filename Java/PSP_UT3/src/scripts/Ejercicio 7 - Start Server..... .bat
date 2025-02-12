
javac "./../Ej7_Server.java"
javac "./../Ej7_Client.java"

jar cfe Ej7_Server.jar Ej7_Server "./../Ej7_Server.class"
jar cfe Ej7_Client.jar Ej7_Client "./../Ej7_Client.class"

cls

java -jar "Ej7_Server.jar"

pause

del Ej7_Server.jar
del "./../Ej7_Server.class"
del Ej7_Client.jar
del "./../Ej7_Client.class"

