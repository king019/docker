FROM  king019/alpine:jdk11

MAINTAINER king019


RUN apk add redis

COPY dkrun.sh /dkrun.sh
COPY exporter.sh /exporter.sh
RUN cd /opt/soft;wget https://raw.gitcode.com/king019/save_github/blobs/327915380b67c2a6bfebabb8bc19781d27e8fc92/redis_exporter-v1.62.0.linux-amd64.tar.gz
RUN chmod 755 /*.sh
CMD /docker.sh
