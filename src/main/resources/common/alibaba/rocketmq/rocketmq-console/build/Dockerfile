FROM king019/alpine

MAINTAINER king019

RUN mkdir -p /opt/soft/version

RUN cd /opt/soft/version;git clone http://gitea:3000/king019/rocketmq-externals.git
EXPOSE 8080
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh