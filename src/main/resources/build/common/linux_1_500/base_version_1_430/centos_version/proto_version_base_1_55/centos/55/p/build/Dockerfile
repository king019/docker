FROM king019/centos:p10



RUN echo 'source /etc/profile' >> /root/.bashrc

ENV TZ=Asia/Shanghai

DKCONFIG multi_config dk_config_all

WORKDIR /app




CMD /docker.sh
