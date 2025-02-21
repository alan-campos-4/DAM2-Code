@echo off

echo Iniciando pruebas de descarga...
echo Probando con http://elpais.es
java DescargaURL http://elpais.es elpais_es.html
echo Código HTTP: %errorlevel%
echo.

pause

echo Probando con https://elpais.com
java DescargaURL https://elpais.com elpais_com.html
echo Código HTTP: %errorlevel%
echo.

pause

echo Probando con https://elpais.com/paginainexistente
java DescargaURL https://elpais.com/paginainexistente noexiste.html
echo Código HTTP: %errorlevel%
echo.

pause