FROM docker:5000/king019/centos:jdk
MAINTAINER king019

#RUN dnf -y install  gcc
#RUN dnf -y install  zlib-devel zlib


RUN echo 'source /etc/profile' >> /root/.bashrc

ADD http://smp:9500/graalvm-jdk-17_linux-x64_bin.tar.gz    /usr/lib/jvm/graalvm-jdk-17_linux-x64_bin.tar.gz
RUN cd /usr/lib/jvm;tar -xzf graalvm-jdk-17_linux-x64_bin.tar.gz;mv graalvm-jdk-17.0.7+8.1 graalvm-jdk-17

RUN echo 'export JAVA_HOME=/usr/lib/jvm/graalvm-jdk-17' >> /etc/profile
RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
RUN sed -i 's/^export JAVA_HOME/export JAVA_HOME=\/usr\/lib\/jvm\/graalvm-jdk-17/g'  /usr/share/maven/bin/mvn
COPY configshell/run.sh /run.sh

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh