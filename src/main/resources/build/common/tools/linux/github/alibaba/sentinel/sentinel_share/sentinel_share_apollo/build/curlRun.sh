#!/bin/sh
while true
 do
   sleep $[RANDOM%5+1]
   curl http://127.0.0.1:$server.port/index
 done