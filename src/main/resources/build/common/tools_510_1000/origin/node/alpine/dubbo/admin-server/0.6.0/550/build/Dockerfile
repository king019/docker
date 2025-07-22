FROM king019/centos:jdk8  as pre



COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh
CMD /docker.sh

FROM king019/centos:jdk8

COPY --from=pre /opt/soft/dubbo-admin-server.jar /opt/soft/dubbo-admin-server.jar


COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh