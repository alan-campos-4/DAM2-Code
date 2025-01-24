javac Ej1_SaludoExpress_Servidor.java
javac Ej1_SaludoExpress_Cliente.java

jar cfe Ej1_SaludoExpress_Servidor.jar Ej1_SaludoExpress_Servidor Ej1_SaludoExpress_Servidor.class
jar cfe Ej1_SaludoExpress_Cliente.jar Ej1_SaludoExpress_Cliente Ej1_SaludoExpress_Cliente.class

cls
java -jar "Ej1_SaludoExpress_Servidor.jar"
call "Ejercicio1 - Start.bat"

pause