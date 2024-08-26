FROM king019/centos:p9








RUN echo 'source /etc/profile' >> /root/.bashrc

ENV TZ=Asia/Shanghai

RUN mkdir -p /root/.m2/repository
RUN mkdir -p /root/.ssh
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
COPY file daemon.json
COPY file config.json
COPY file bashrc






RUN echo 'trans_maven'
RUN mkdir -p /root/.docker;cp /config.json /root/.docker/config.json
RUN mkdir -p /etc/docker;cp /daemon.json /etc/docker/daemon.json




CMD /docker.sh
