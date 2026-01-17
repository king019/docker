FROM  king019/almalinux:p9 as pre

MAINTAINER king019

RUN source /etc/profile;chmod 755 /*.sh;mkdir -p ${WS}
RUN source /etc/profile;chmod 755 /*.sh;mkdir -p ${WS_VER}
RUN source /etc/profile;chmod 755 /*.sh;mkdir -p /root/.ssh
RUN source /etc/profile;chmod 755 /*.sh;mkdir -p /root/.m2/repository
RUN source /etc/profile;chmod 755 /*.sh;mkdir -p /etc/docker
RUN source /etc/profile;chmod 755 /*.sh;mkdir -p /root/.docker

RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  git

RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  maven
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  java-1.8.0-openjdk-devel
RUN source /etc/profile;chmod 755 /*.sh;echo 'export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk' >> /etc/profile
RUN source /etc/profile;chmod 755 /*.sh;echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
RUN source /etc/profile;chmod 755 /*.sh;rm -fr /etc/alternatives/java
RUN source /etc/profile;chmod 755 /*.sh;ln -s /usr/lib/jvm/java-1.8.0-openjdk/bin/java /etc/alternatives/java
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  unzip
ENV nexus_version=3.41.1-01
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER};git clone https://gitee.com/mirrors/nexus-public.git
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/nexus-public;git checkout release-${nexus_version}
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/nexus-public;sed -i 's/<\/yarnVersion>/<\/yarnVersion><nodeDownloadRoot>https:\/\/mirrors.huaweicloud.com\/nodejs\/<\/nodeDownloadRoot><npmDownloadRoot>https:\/\/mirrors.huaweicloud.com\/npm\/<\/npmDownloadRoot><yarnDownloadRoot>https:\/\/mirrors.huaweicloud.com\/yarn\/<\/yarnDownloadRoot><npmRegistryURL>https:\/\/registry.npmmirror.com<\/npmRegistryURL><yarnConfig><registry>https:\/\/registry.npmmirror.com<\/registry><\/yarnConfig>/g' ./pom.xml
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/nexus-public;sed -i 's/install --immutable/install/g' ./pom.xml
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/nexus-public;mvn clean install -DskipTests -Dmaven.javadoc.skip=true
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/nexus-public;find . -name nexus-base-template-${nexus_version}.zip | awk -v nexus_version=${nexus_version}  '{print "cp " $1  " /app/nexus-base-template-"nexus_version".zip"}' | sh

DKCONFIG multi_run_cmd mirror_nexus


FROM  king019/alpine:jdk8

ENV nexus_version=3.41.1-01
COPY --from=pre ${WS}/nexus-base-template-${nexus_version}.zip ${WS}/nexus-base-template-${nexus_version}.zip
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS};unzip nexus-base-template-${nexus_version}.zip
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS};mv nexus-base-template-${nexus_version} nexus

COPY dkrun.sh /dkrun.sh

RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
CMD /docker.sh
