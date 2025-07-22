FROM  king019/linux:jdk11 as pre

MAINTAINER king019


COPY gitjar.sh /gitjar.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh
CMD /docker.sh


FROM  king019/linux:jdk11
COPY --from=pre /opt/soft/sshm_boot_cloud_feign_nacos_server-release.jar /opt/soft/sshm_boot_cloud_feign_nacos_server-release.jar
COPY dkrun.sh /dkrun.sh
RUN chmod 755 /*.sh
CMD /docker.sh