FROM openeuler/openeuler

MAINTAINER king019

RUN mkdir -p /root/.m2/repository
RUN mkdir -p /root/soft
RUN mkdir -p /root/tools
RUN mkdir -p /opt/soft/version
RUN mkdir -p /opt/soft/tools
RUN mkdir -p /root/.docker
RUN mkdir -p /etc/docker

# RUN echo 'fastestmirror=True' >> /etc/dnf/dnf.conf
# RUN dnf makecache

COPY docker.sh /docker.sh


RUN chmod 755 /*.sh

RUN source /etc/profile

CMD /docker.sh
