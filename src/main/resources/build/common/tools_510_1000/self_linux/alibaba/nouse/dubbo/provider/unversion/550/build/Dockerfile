FROM  king019/linux:jdk17 as pre

MAINTAINER king019

COPY gitjar.sh /gitjar.sh
COPY dkrun.sh /dkrun.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh
CMD /docker.sh




FROM  king019/linux:jdk17
COPY --from=pre /opt/soft/fw_rpc_dubbo_anno_server_nacos-release.jar /opt/soft/fw_rpc_dubbo_anno_server_nacos-release.jar
COPY dkrun.sh /dkrun.sh
RUN chmod 755 /*.sh
CMD /docker.sh