#!/bin/bash
#git pull


mkdir -p ./gc/bak
mv ./gc/gc* ./gc/bak

mvn clean compile
mvn spring-boot:stop
mvn spring-boot:start