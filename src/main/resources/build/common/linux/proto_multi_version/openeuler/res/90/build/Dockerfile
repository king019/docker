FROM king019/openeuler:p

MAINTAINER king019

RUN mkdir -p /root/.m2



COPY run/git.sh /opt/soft/git.sh
COPY run/mvnclean.sh /mvnclean.sh
# COPY run/perf.sh /perf.sh
COPY run/profile.sh /profile.sh
# COPY run/protoc.sh /protoc.sh
COPY run/run.sh /run.sh
COPY run/run_env.sh /run_env.sh







COPY config/settings.xml /root/.m2/settings.xml


ADD config/bashrc /root/.bashrc

COPY config/config.json /config.json
RUN mkdir -p /root/.docker;cp /config.json /root/.docker/config.json

COPY config/daemon.json /daemon.json
RUN mkdir -p /etc/docker;cp /daemon.json /etc/docker/daemon.json


# 开放22端口
EXPOSE 22

RUN chmod 755 /*.sh


CMD /docker.sh
