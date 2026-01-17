FROM king019/rhel

MAINTAINER king019

RUN source /etc/profile;chmod 755 /*.sh;mkdir -p ${WS}/tunasync

COPY tun_sync.sh /tun_sync.sh
COPY dkrun.sh /dkrun.sh
COPY manager.conf ${WS}/tunasync/manager.conf
COPY worker.conf ${WS}/tunasync/worker.conf


ADD https://gitee.com/king019/save_github/raw/main/tunasync-linux-amd64-bin.tar.gz ${WS}/tunasync/tunasync-linux-amd64-bin.tar.gz
ADD https://gitee.com/king019/save_github/raw/main/tunasync-linux-arm64-bin.tar.gz ${WS}/tunasync/tunasync-linux-arm64-bin.tar.gz

RUN source /etc/profile;chmod 755 /*.sh;cd ${WS}/tunasync;chmod 777 /tun_sync.sh;/tun_sync.sh



RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
CMD /docker.sh


