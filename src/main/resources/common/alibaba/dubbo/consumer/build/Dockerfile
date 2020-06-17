FROM  king019/alpine

MAINTAINER king019
RUN mkdir -p /opt/soft

ADD http://aaaaaa/fw_rpc_dubbo_anno_api-1.0-SNAPSHOT.jar /opt/soft/fw_rpc_dubbo_anno_api-1.0-SNAPSHOT.jar
RUN mkdir -p /root/tools
RUN cp /opt/soft/fw_rpc_dubbo_anno_api-1.0-SNAPSHOT.jar /root/tools/fw_rpc_dubbo_anno_api-1.0-SNAPSHOT.jar

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
