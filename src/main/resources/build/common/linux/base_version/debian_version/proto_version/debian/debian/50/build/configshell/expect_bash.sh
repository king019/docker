#!/usr/bin/expect
spawn dpkg-reconfigure dash
expect "Use dash as the default system shell"
send "no\r"
expect eof
exit