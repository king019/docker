FROM king019/linux
RUN mkdir -p /opt/soft
ADD http://nginxdown:9500/sshm_boot_cloud_admin_server-1.0-SNAPSHOT.jar /opt/soft/sshm_boot_cloud_admin_server-1.0-SNAPSHOT.jar
RUN mkdir -p /root/tools
RUN cp /opt/soft/sshm_boot_cloud_admin_server-1.0-SNAPSHOT.jar /root/tools/sshm_boot_cloud_admin_server-1.0-SNAPSHOT.jar

EXPOSE 8981
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh