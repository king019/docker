FROM  registry.cn-qingdao.aliyuncs.com/king019/docker

MAINTAINER king019



DKCONFIG sed_mirror alpine

RUN apk add maven
RUN apk add openjdk8
RUN apk add git
RUN apk add curl

#RUN curl -fsSL https://get.docker.com | bash -s docker --mirror Aliyun
#RUN apk add docker

RUN which docker
RUN mvn -v


RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-1.8-openjdk' >> /etc/profile
RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile

DKCONFIG multi_config dk_config_all

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
