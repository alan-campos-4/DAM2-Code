javac -d ./../src/Ej1_SaludoExpress_Servidor.java
javac -d ./../src/Ej1_SaludoExpress_Cliente.java

jar cfe Ej1_SaludoExpress_Servidor.jar Ej1_SaludoExpress_Servidor ./../src/Ej1_SaludoExpress_Servidor.class
jar cfe Ej1_SaludoExpress_Cliente.jar Ej1_SaludoExpress_Cliente ./../src/Ej1_SaludoExpress_Cliente.class

java -jar "Ej1_SaludoExpress_Servidor.jar"

pause

del Ej1_SaludoExpress_Servidor.jar
del Ej1_SaludoExpress_Cliente.jar
del ./../src/Ej1_SaludoExpress_Servidor.class
del ./../src/Ej1_SaludoExpress_Cliente.class