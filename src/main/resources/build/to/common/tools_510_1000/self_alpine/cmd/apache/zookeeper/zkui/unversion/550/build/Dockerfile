FROM  king019/alpine:jdk8 as pre

MAINTAINER king019
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER};git clone https://gitee.com/king019/zkui.git
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/zkui;mvn versions:set -DnewVersion=release
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/zkui;sed -i 's/<artifactId>maven-assembly-plugin<\/artifactId>/<artifactId>maven-assembly-plugin<\/artifactId><version>3.3.0<\/version>/g' pom.xml
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/zkui;mvn install -DskipTests -Dmaven.javadoc.skip=true
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/zkui;find . -name zkui-release-jar-with-dependencies.jar | awk -v WS=${WS} '{print "cp " $1 " " WS"/zkui-release-jar-with-dependencies.jar"}' | sh
FROM  king019/alpine:jdk8
COPY dkrun.sh /dkrun.sh
COPY config.cfg ${WS}/config.cfg

COPY --from=pre ${WS}/zkui-release-jar-with-dependencies.jar ${WS}/zkui-release-jar-with-dependencies.jar


RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh



CMD /docker.sh
