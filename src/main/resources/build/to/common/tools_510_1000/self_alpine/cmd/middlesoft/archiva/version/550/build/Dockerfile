FROM  king019/alpine:jdk8 as pre

MAINTAINER king019


ENV archiva_version=2.2.10
RUN source /etc/profile;chmod 755 /*.sh;mvn dependency:get -Dtransitive=false -DgroupId=org.apache.archiva -DartifactId=archiva-jetty -Dversion=${archiva_version} -Dclassifier=bin -Dpackaging=tar.gz
RUN source /etc/profile;chmod 755 /*.sh;cp /root/.m2/repository/org/apache/archiva/archiva-jetty/${archiva_version}/archiva-jetty-${archiva_version}-bin.tar.gz ${WS}

FROM  king019/alpine:jdk8
ENV archiva_version=2.2.10
COPY --from=pre ${WS}/archiva-jetty-${archiva_version}-bin.tar.gz ${WS}/archiva-jetty-${archiva_version}-bin.tar.gz
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS};tar -xzf archiva-jetty-${archiva_version}-bin.tar.gz
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS};mv apache-archiva-${archiva_version} archiva
COPY dkrun.sh /dkrun.sh
COPY archiva.xml /archiva.xml
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh


CMD /docker.sh
