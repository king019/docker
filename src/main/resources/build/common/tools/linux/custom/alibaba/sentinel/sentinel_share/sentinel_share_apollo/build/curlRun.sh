#!/bin/sh
while true
 do
   sleep $(($RANDOM%5))
   curl http://127.0.0.1:$1/index
   curl http://127.0.0.1:$1/index
   curl http://127.0.0.1:$1/index
   curl http://127.0.0.1:$1/index
   curl http://127.0.0.1:$1/index
   curl http://127.0.0.1:$1/index
 done