FROM king019/alpine:ssh

MAINTAINER king019

RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  git
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  go
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  curl
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  wget
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  vim
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  maven

CMD /docker.sh
