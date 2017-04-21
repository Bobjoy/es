#!/usr/bin/env bash
echo [INFO] create db.
echo [INFO] please confirm db encoding utf-8.
echo [INFO] please confirm has modified es/web/pom.xml
cd ./web
mvn db:create
