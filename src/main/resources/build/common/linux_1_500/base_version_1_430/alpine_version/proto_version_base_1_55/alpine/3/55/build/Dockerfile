FROM king019/alpine:p320

ENV TZ=Asia/Shanghai

#RUN echo 'source /etc/profile' >> /root/.bashrc


RUN mkdir -p /root/.m2/repository
RUN mkdir -p /opt/soft/version
RUN mkdir -p /opt/soft/tool
RUN mkdir -p /root/.docker
RUN mkdir -p /etc/docker




COPY file trans.sh
COPY file trans_repo_bak.sh
COPY file trans_repo_nexus.sh
COPY file trans_maven.sh
COPY file trans_repo.sh

COPY file settings.xml
COPY file settings.xml
COPY file daemon.json
COPY file config.json
COPY file bashrc





RUN mkdir -p /root/.docker;cp /config.json /root/.docker/config.json
RUN mkdir -p /etc/docker;cp /daemon.json /etc/docker/daemon.json







RUN echo 'trans_maven'
RUN apk add bash

CMD /docker.sh
