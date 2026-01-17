FROM  king019/alpine:jdk8 as pre

MAINTAINER king019
ENV nacos_version=3.1.0

COPY gitjar.sh /gitjar.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh


FROM  king019/alpine:jdk8
ENV nacos_version=3.1.0


COPY --from=pre ${WS}/nacos-server-${nacos_version}.zip${WS}/nacos-server-${nacos_version}.zip

COPY gitNext.sh /gitNext.sh



COPY dkrun.sh /dkrun.sh
COPY application.properties /application.properties
RUN chmod 755 /*.sh
RUN /gitNext.sh
CMD /docker.sh
