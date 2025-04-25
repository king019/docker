FROM gitea/runner-images:ubuntu-20.04



RUN apt-get -y install  openjdk-21-jdk
RUN apt-get -y install  maven
COPY file trans.sh
COPY file trans_repo_bak.sh
COPY file trans_repo_nexus.sh
COPY file trans_maven.sh
COPY file trans_repo.sh

COPY file settings.xml
COPY file daemon.json
COPY file config.json
COPY file bashrc