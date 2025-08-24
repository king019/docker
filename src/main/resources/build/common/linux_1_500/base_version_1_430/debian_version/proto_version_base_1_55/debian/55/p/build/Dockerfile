FROM king019/debian:13




RUN echo 'source /etc/profile' >> /root/.bashrc


ENV DEBIAN_FRONTEND noninteractive

ENV TZ=Asia/Shanghai

DKCONFIG multi_config dk_config_all


WORKDIR /app



RUN chmod 755 /*.sh
#RUN /expect_bash.sh
#RUN source /etc/profile

CMD /docker.sh
