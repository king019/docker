FROM king019/centos

MAINTAINER king019


#RUN sed -i "s/dl-cdn.alpinelinux.org/mirrors.aliyun.com/g" /etc/apk/repositories

COPY docker.sh /docker.sh




RUN cd /opt/soft/version;git clone https://github.com/openjdk/jdk.git



RUN chmod 755 /*.sh


CMD /docker.sh

