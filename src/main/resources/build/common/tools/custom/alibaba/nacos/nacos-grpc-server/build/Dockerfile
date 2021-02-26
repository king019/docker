FROM  king019/linux

MAINTAINER king019


#ADD https://raw.githubusercontent.com/king019/save_sshm/master/sshm_boot_cloud_grpc_provider-1.0-SNAPSHOT.jar /opt/soft/sshm_boot_cloud_grpc_provider-1.0-SNAPSHOT.jar
#RUN cp /opt/soft/sshm_boot_cloud_grpc_provider-1.0-SNAPSHOT.jar /root/tools/sshm_boot_cloud_grpc_provider-1.0-SNAPSHOT.jar

COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh
CMD /docker.sh
