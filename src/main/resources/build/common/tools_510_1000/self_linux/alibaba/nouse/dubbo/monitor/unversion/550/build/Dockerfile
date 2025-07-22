FROM  king019/linux:jdk8 as pre

MAINTAINER king019
COPY gitjar.sh /gitjar.sh
COPY dkrun.sh /dkrun.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh



EXPOSE 8080


CMD /docker.sh



FROM  king019/linux:jdk8
COPY --from=pre /opt/soft/dubbo-monitor-simple-2.5.10-assembly.tar.gz /opt/soft/dubbo-monitor-simple-2.5.10-assembly.tar.gz
COPY dkrun.sh /dkrun.sh
COPY gitNext.sh /gitNext.sh
RUN chmod 755 /*.sh
RUN /gitNext.sh
CMD /docker.sh


