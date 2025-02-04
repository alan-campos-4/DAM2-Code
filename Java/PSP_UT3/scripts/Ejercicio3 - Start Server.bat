javac ./../Ej3_AdivinaNumero_Servidor.java
javac ./../Ej3_AdivinaNumero_Cliente.java

jar cfe Ej3_AdivinaNumero_Servidor.jar Ej3_AdivinaNumero_Servidor ./../Ej3_AdivinaNumero_Servidor.class
jar cfe Ej3_AdivinaNumero_Cliente.jar Ej3_AdivinaNumero_Cliente ./../Ej3_AdivinaNumero_Cliente.class

cls
java -jar "Ej3_AdivinaNumero_Servidor.jar"

pause