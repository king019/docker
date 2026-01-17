FROM king019/ubuntu:p26


DKCONFIG multi_run_cmd baseEnv
WORKDIR ${WS}

COPY shell/docker.sh /docker.sh
COPY shell/multi.sh /multi.sh
COPY shell/extra.sh /extra.sh
COPY shell/sshd.sh /sshd.sh
COPY shell/dkrun.sh /dkrun.sh




RUN echo 'source /etc/profile' >> /root/.bashrc


ENV DEBIAN_FRONTEND noninteractive


DKCONFIG multi_config dk_config_all





RUN chmod 755 /*.sh
#RUN /expect_bash.sh
#RUN source /etc/profile

CMD /docker.sh
