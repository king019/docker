FROM  king019/linux

MAINTAINER king019
RUN mkdir -p /opt/soft
RUN mkdir -p /root/tools/
ADD https://raw.githubusercontent.com/king019/save_sshm/master/sshm_cloud_feign_nacos_server-1.0-SNAPSHOT.jar /opt/soft/sshm_cloud_feign_nacos_server-1.0-SNAPSHOT.jar

RUN cp /opt/soft/sshm_cloud_feign_nacos_server-1.0-SNAPSHOT.jar /root/tools/sshm_cloud_feign_nacos_server-1.0-SNAPSHOT.jar

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
