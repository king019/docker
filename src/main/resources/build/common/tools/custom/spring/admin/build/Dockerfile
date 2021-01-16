FROM king019/linux
COPY git.sh /git.sh
RUN mkdir -p /root/tools/
RUN mkdir -p /opt/soft/version
RUN /git.sh

#ADD https://raw.githubusercontent.com/king019/save_sshm/master/sshm_boot_cloud_admin_server-1.0-SNAPSHOT.jar /opt/soft/sshm_boot_cloud_admin_server-1.0-SNAPSHOT.jar
#RUN cp /opt/soft/sshm_boot_cloud_admin_server-1.0-SNAPSHOT.jar /root/tools/sshm_boot_cloud_admin_server-1.0-SNAPSHOT.jar

EXPOSE 8981
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh