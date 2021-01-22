FROM  king019/linux:jdk11

MAINTAINER king019

RUN mkdir -p /opt/soft/version
RUN mkdir -p /root/tools
#ADD https://raw.githubusercontent.com/king019/save_fw/master/fw_rpc_dubbo_anno_api-1.0-SNAPSHOT.jar /opt/soft/fw_rpc_dubbo_anno_api-1.0-SNAPSHOT.jar

#RUN cp /opt/soft/fw_rpc_dubbo_anno_api-1.0-SNAPSHOT.jar /root/tools/fw_rpc_dubbo_anno_api-1.0-SNAPSHOT.jar
COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh
CMD /docker.sh
