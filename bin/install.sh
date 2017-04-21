#!/usr/bin/env bash
echo [INFO] Install es.
cd ..
mvn clean install -pl . -Dmaven.test.skip=true

echo [INFO] Install es/parent.
cd ./parent
mvn clean install -pl . -Dmaven.test.skip=true


echo [INFO] Install es/common.
cd ./common
mvn clean install -pl . -Dmaven.test.skip=true
