
javac "./../Ej2_Server.java"
javac "./../Ej2_Client.java"

jar cfe Ej2_Server.jar Ej2_Server "./../Ej2_Server.class"
jar cfe Ej2_Client.jar Ej2_Client "./../Ej2_Client.class"

cls

java -jar "Ej2_Server.jar"

pause

del Ej2_Server.jar
del "./../Ej2_Server.class"
del Ej2_Client.jar
del "./../Ej2_Client.class"
