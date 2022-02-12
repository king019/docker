FROM  king019/rhel

MAINTAINER king019

RUN mkdir -p /opt/soft/tunasync

COPY tun_sync.sh /tun_sync.sh
COPY docker.sh /docker.sh
COPY manager.conf /manager.conf
COPY worker.conf /worker.conf

RUN dnf -y install  rsync

ADD https://king019.coding.net/p/github/d/save_github/git/raw/master/tunasync-linux-amd64-bin.tar.gz /opt/soft/tunasync/tunasync-linux-amd64-bin.tar.gz
ADD https://king019.coding.net/p/github/d/save_github/git/raw/master/tunasync-linux-arm64-bin.tar.gz /opt/soft/tunasync/tunasync-linux-arm64-bin.tar.gz

RUN cd /opt/soft/tunasync; /tun_sync.sh



RUN chmod 755 /*.sh
CMD /docker.sh


