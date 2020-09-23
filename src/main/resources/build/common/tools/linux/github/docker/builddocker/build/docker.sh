#!/bin/sh
set -x
echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin



/docker_run.sh