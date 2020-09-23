#!/bin/sh
chmod -R 777 .
sh ./src/main/resources/travis/login.sh
sh ./src/main/resources/travis/cmd.sh
