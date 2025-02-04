javac ./../Ej1_SaludoExpress_Servidor.java
javac ./../Ej1_SaludoExpress_Cliente.java

jar cfe Ej1_SaludoExpress_Servidor.jar Ej1_SaludoExpress_Servidor ./../Ej1_SaludoExpress_Servidor.class
jar cfe Ej1_SaludoExpress_Cliente.jar Ej1_SaludoExpress_Cliente ./../Ej1_SaludoExpress_Cliente.class

java -jar "Ej1_SaludoExpress_Servidor.jar"

pause

del Ej1_SaludoExpress_Servidor.jar
del Ej1_SaludoExpress_Cliente.jar
del ./../Ej1_SaludoExpress_Servidor.class
del ./../Ej1_SaludoExpress_Cliente.class