FROM  king019/linux

MAINTAINER king019
COPY git.sh /git.sh
RUN mkdir -p /opt/soft/version
RUN /git.sh
#ADD https://raw.githubusercontent.com/king019/save_fw/master/fw_rpc_dubbo_anno_api-1.0-SNAPSHOT.jar /opt/soft/fw_rpc_dubbo_anno_api-1.0-SNAPSHOT.jar
RUN mkdir -p /root/tools
RUN cp /opt/soft/fw_rpc_dubbo_anno_api-1.0-SNAPSHOT.jar /root/tools/fw_rpc_dubbo_anno_api-1.0-SNAPSHOT.jar

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
