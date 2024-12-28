FROM docker:5000/king019/centos:jdk17


MAINTAINER king019

COPY docker.sh /docker.sh
COPY git.sh /git.sh
RUN chmod -R 777 /*.sh
RUN /git.sh
CMD /docker.sh
