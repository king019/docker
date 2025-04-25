#!/bin/sh
set -x
source /etc/profile
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone http://gogs:3000/king019/ali_fw_go.git
cd ali_fw_go
cd go-sshm
go mod download
go build sshm.go
