FROM king019/centos:m

MAINTAINER king019

COPY docker.sh /docker.sh

RUN mkdir -p /root/soft

COPY git.sh /root/git.sh

RUN chmod 755 /*.sh

CMD /docker.sh
