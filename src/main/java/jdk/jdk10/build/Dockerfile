FROM  centos:7

MAINTAINER king019

RUN mkdir -p /soft/

ADD https://download.java.net/java/GA/jdk10/10/binaries/openjdk-10_linux-x64_bin.tar.gz /soft/openjdk-10_linux-x64_bin.tar.gz

COPY docker.sh /docker.sh
CMD /docker.sh

