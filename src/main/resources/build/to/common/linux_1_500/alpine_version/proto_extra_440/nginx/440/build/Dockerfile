FROM  king019/alpine:p

MAINTAINER king019

RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  nginx

COPY dkrun.sh /dkrun.sh

RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
CMD /docker.sh
