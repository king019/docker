FROM king019/linux:jdk8as pre

MAINTAINER king019

COPY gitjar.sh /gitjar.sh
COPY dkrun.sh /dkrun.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh


CMD /docker.sh

FROM king019/linux:jdk8
COPY --from=pre /opt/soft/rocketmq-console-ng-release.jar /opt/soft/rocketmq-console-ng-release.jar
COPY dkrun.sh /dkrun.sh
RUN chmod 755 /*.sh
CMD /docker.sh