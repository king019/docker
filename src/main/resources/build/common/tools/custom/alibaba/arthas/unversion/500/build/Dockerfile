FROM  king019/linux

MAINTAINER king019

ADD https://arthas.aliyun.com/arthas-boot.jar  /opt/soft/arthas-boot.jar

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
