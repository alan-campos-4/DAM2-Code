jar cfe Ej1_SaludoExpress_Servidor.jar Ej1_SaludoExpress_Servidor "..\bin\Ej1_SaludoExpress_Servidor.class"
jar cfe Ej1_SaludoExpress_Cliente.jar Ej1_SaludoExpress_Cliente "..\bin\Ej1_SaludoExpress_Cliente.class"

java -jar "Ej1_SaludoExpress_Servidor.jar"

pause

del Ej1_SaludoExpress_Servidor.jar
del Ej1_SaludoExpress_Cliente.jar