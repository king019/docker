#!/bin/sh
while true
 do
   sleep 1
   curl http://127.0.0.1:$1/index
 done