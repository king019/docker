FROM docker:5000/king019/centos:jdk17
MAINTAINER king019


ADD http://smp:9500/graalvm-jdk-17_linux-x64_bin.tar.gz    /usr/lib/jvm/graalvm-jdk-17_linux-x64_bin.tar.gz
RUN cd /usr/lib/jvm;tar -xzf graalvm-jdk-17_linux-x64_bin.tar.gz;mv graalvm-jdk-17.0.7+8.1 graalvm-jdk-17

RUN echo 'export JAVA_HOME=/usr/lib/jvm/graalvm-jdk-17' >> /etc/profile
RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile


COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh