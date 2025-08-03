FROM king019/debian:12




RUN echo 'source /etc/profile' >> /root/.bashrc


ENV DEBIAN_FRONTEND noninteractive

ENV TZ=Asia/Shanghai

DKCONFIG mkdir_file dir_all
DKCONFIG sed_mirror go_proxy
DKCONFIG multi_file config_all


WORKDIR /app
RUN mkdir -p /root/.docker;cp /config.json /root/.docker/config.json
RUN mkdir -p /etc/docker;cp /daemon.json /etc/docker/daemon.json



RUN chmod 755 /*.sh
#RUN /expect_bash.sh
#RUN source /etc/profile

CMD /docker.sh
