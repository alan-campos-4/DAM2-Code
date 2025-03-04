@echo off

echo Iniciando pruebas de descarga...

echo Probando con http://elpais.es
java DescargaURL.java http://elpais.es elpais_es.html
echo Código HTTP: %errorlevel%
echo.

echo Probando con https://elpais.com
java DescargaURL.java https://elpais.com elpais_com.html
echo Código HTTP: %errorlevel%
echo.

echo Probando con https://elpais.com/paginainexistente
java DescargaURL.java https://elpais.com/paginainexistente noexiste.html
echo Código HTTP: %errorlevel%
echo.


echo Probando con https://github.com/
java DescargaURL.java https://github.com github.html
echo Código HTTP: %errorlevel%
echo.

pause