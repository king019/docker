FROM  king019/alpine:jdk8 as pre

MAINTAINER king019

COPY gitjar.sh /gitjar.sh
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
RUN source /etc/profile;chmod 755 /*.sh;/gitjar.sh
CMD /docker.sh



FROM  king019/alpine:jdk8

COPY --from=pre${WS}/JrebelBrainsLicenseServerforJava-release.jar ${WS}/JrebelBrainsLicenseServerforJava-release.jar

COPY dkrun.sh /dkrun.sh
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh


CMD /docker.sh
