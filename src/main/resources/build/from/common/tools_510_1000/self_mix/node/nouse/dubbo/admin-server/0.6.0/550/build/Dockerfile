FROM king019/rhel:jdk8  as pre

DKCONFIG multi_run_cmd baseEnv
WORKDIR ${WS}
COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh
CMD /docker.sh

FROM king019/rhel:jdk8

COPY --from=pre ${WS}/dubbo-admin-server.jar ${WS}/dubbo-admin-server.jar


COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh