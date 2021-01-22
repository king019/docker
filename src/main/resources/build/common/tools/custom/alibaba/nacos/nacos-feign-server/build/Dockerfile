FROM  king019/linux:jdk11_maven

MAINTAINER king019
RUN mkdir -p /root/tools/
RUN mkdir -p /opt/soft/version



#ADD https://raw.githubusercontent.com/king019/save_sshm/master/sshm_cloud_feign_nacos_server-1.0-SNAPSHOT.jar /opt/soft/sshm_cloud_feign_nacos_server-1.0-SNAPSHOT.jar
#RUN cp /opt/soft/sshm_cloud_feign_nacos_server-1.0-SNAPSHOT.jar /root/tools/sshm_cloud_feign_nacos_server-1.0-SNAPSHOT.jar

COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh
CMD /docker.sh
