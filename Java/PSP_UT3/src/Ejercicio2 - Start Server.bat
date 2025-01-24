javac Ej2_Calculadora_Servidor.java
javac Ej2_Calculadora_Cliente.java

jar cfe Ej2_Calculadora_Servidor.jar Ej2_Calculadora_Servidor Ej2_Calculadora_Servidor.class
jar cfe Ej2_Calculadora_Cliente.jar Ej2_Calculadora_Cliente Ej2_Calculadora_Cliente.class

cls
java -jar "Ej2_Calculadora_Servidor.jar"

pause