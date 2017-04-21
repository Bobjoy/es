#!/usr/bin/env bash
echo [INFO]  jetty starting
cd ./web

mvn clean jetty:run  -Dmaven.test.skip=true