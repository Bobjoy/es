#!/usr/bin/env bash
echo [INFO] create db.
echo [INFO] please confirm db encoding utf-8.
echo [INFO] please confirm has modified es/web/pom.xml

cd ./plugins/maven-db-plugin
mvn clean install -pl . -Dmaven.test.skip=true
cd ../../

cd ./web
mvn db:create
