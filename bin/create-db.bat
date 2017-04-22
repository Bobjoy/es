@echo off
echo [INFO] create db.
echo [INFO] please confirm db encoding utf-8.
echo [INFO] please confirm has modified es/web/pom.xml--^>profile--^>development---^>connection.admin.url/connection.username/password 
cd %~dp0

cd ../plugins/maven-db-plugin
call mvn clean install -pl . -Dmaven.test.skip=true

cd ../../web
call mvn db:create

cd ../bin
pause