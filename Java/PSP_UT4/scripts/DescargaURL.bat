@echo off

javac "./../src/DescargaURL.java"
jar cfe DescargaURL.jar DescargaURL -C ./../src/ .


echo Iniciando pruebas de descarga...

echo Probando con http://elpais.es
java -jar "DescargaURL.jar" http://elpais.es elpais_es.html
echo Código HTTP: %errorlevel%
echo.

echo Probando con https://elpais.com
java -jar "DescargaURL.jar" https://elpais.com elpais_com.html
echo Código HTTP: %errorlevel%
echo.

echo Probando con https://elpais.com/paginainexistente
java -jar "DescargaURL.jar" https://elpais.com/paginainexistente noexiste.html
echo Código HTTP: %errorlevel%
echo.

echo Probando con https://github.com/
java -jar "DescargaURL.jar" https://github.com github.html
echo Código HTTP: %errorlevel%
echo.

pause


del "./../src/DescargaURL.class"
del "./DescargaURL.jar"