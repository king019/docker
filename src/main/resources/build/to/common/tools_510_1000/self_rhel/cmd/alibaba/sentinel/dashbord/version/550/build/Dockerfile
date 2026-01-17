FROM  king019/alpine:jdk as pre

MAINTAINER king019

ENV sentinel_version=1.8.9
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER};git clone https://gitee.com/mirrors/Sentinel.git sentinel
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/sentinel/sentinel-dashboard;git checkout 1.8.9
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/sentinel/sentinel-dashboard;mvn clean install -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/sentinel/sentinel-dashboard;find . -name sentinel-dashboard.jar | awk '{print "cp " $1  " /app/sentinel-dashboard.jar"}' | sh
FROM  king019/alpine:jdk

ENV sentinel_version=1.8.9
COPY --from=pre ${WS}/sentinel-dashboard.jar ${WS}/sentinel-dashboard.jar

COPY dkrun.sh /dkrun.sh
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
CMD /docker.sh
