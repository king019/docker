FROM king019/centos:p10



RUN echo 'source /etc/profile' >> /root/.bashrc

ENV TZ=Asia/Shanghai

DKCONFIG mkdir_file dir_all
DKCONFIG sed_mirror go_proxy
DKCONFIG multi_file config_all

WORKDIR /app





RUN mkdir -p /root/.docker;cp /config.json /root/.docker/config.json
RUN mkdir -p /etc/docker;cp /daemon.json /etc/docker/daemon.json




CMD /docker.sh
