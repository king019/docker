FROM  king019/alpine:jdk

MAINTAINER king019



ENV jenkins_version=2.516.2
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER};wget https://mirrors.huaweicloud.com/jenkins/war-stable/${jenkins_version}/jenkins.war
RUN source /etc/profile;chmod 755 /*.sh;cp ${WS_VER}/jenkins.war ${WS}/tomcat/webapps/ROOT.war


COPY dkrun.sh /dkrun.sh
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh

CMD /docker.sh
