#!/usr/bin/env bash
echo [INFO]  init schema/data.
echo [INFO] confirm has created db.
cd ./web
echo [INFO] init schema.
mvn db:schema

echo [INFO] init data.
mvn db:data