FROM  quay.io/centos/centos:stream9

MAINTAINER king019

RUN mkdir -p /opt/soft/tunasync

COPY tun_sync.sh /tun_sync.sh
COPY docker.sh /docker.sh
COPY manager.conf /opt/soft/tunasync/manager.conf
COPY worker.conf /opt/soft/tunasync/worker.conf


ADD https://king019.coding.net/p/github/d/save_github/git/raw/master/tunasync-linux-amd64-bin.tar.gz /opt/soft/tunasync/tunasync-linux-amd64-bin.tar.gz
ADD https://king019.coding.net/p/github/d/save_github/git/raw/master/tunasync-linux-arm64-bin.tar.gz /opt/soft/tunasync/tunasync-linux-arm64-bin.tar.gz

RUN cd /opt/soft/tunasync;chmod 777 /tun_sync.sh;/tun_sync.sh



RUN chmod 755 /*.sh
CMD /docker.sh


