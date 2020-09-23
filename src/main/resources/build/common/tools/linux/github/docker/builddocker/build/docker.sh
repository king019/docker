#!/bin/sh
set -x
echo "$DOCKER_PASSWORD" | docker login --username "$DOCKER_USERNAME" --password-stdin



/docker_run.sh