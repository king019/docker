FROM king019/rhel
# FROM  quay.io/centos/centos:stream9
# FROM openeuler/openeuler

MAINTAINER king019

RUN mkdir -p /opt/soft/tunasync

COPY tun_sync.sh /tun_sync.sh
COPY docker.sh /docker.sh
COPY manager.conf /opt/soft/tunasync/manager.conf
COPY worker.conf /opt/soft/tunasync/worker.conf


ADD https://gitee.com/king019/save_github/raw/main/tunasync-linux-amd64-bin.tar.gz /opt/soft/tunasync/tunasync-linux-amd64-bin.tar.gz
ADD https://gitee.com/king019/save_github/raw/main/tunasync-linux-arm64-bin.tar.gz /opt/soft/tunasync/tunasync-linux-arm64-bin.tar.gz

RUN cd /opt/soft/tunasync;chmod 777 /tun_sync.sh;/tun_sync.sh



RUN chmod 755 /*.sh
CMD /docker.sh


