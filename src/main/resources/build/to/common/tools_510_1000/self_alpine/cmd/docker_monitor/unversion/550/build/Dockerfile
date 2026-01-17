FROM king019/alpine:b

RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  python3


EXPOSE 53


RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER};git clone https://gitee.com/Mcwlgzs/docker-mirror-monitor.git
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER};mkdir -p docker-mirror-monitor/backend/cache
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER};mkdir -p docker-mirror-monitor/backend/logs

COPY dkrun.sh /dkrun.sh
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
CMD /docker.sh
