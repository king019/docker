FROM king019/rhel:jdk8  as pre

ENV WS=/app
ENV TZ=Asia/Shanghai
ENV WS_VER=/app/ver
WORKDIR ${WS}
COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
RUN source /etc/profile;chmod 755 /*.sh;/gitjar.sh
CMD /docker.sh

FROM king019/rhel:jdk8

COPY --from=pre ${WS}/dubbo-admin-server.jar ${WS}/dubbo-admin-server.jar


COPY docker.sh /docker.sh
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
CMD /docker.sh
