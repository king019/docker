FROM  king019/ruoyi:cloud_base_3.6.5 as base



FROM  king019/linux:jdk8
MAINTAINER king019
COPY gitjar.sh /gitjar.sh
COPY dkrun.sh /dkrun.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh



COPY --from=base /opt/soft/ruoyi-gateway.jar /opt/soft

EXPOSE 8080


CMD /docker.sh



