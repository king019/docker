FROM  king019/rhel:ex as pre

MAINTAINER king019

RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  maven
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  java-21-openjdk-devel
RUN source /etc/profile;chmod 755 /*.sh;echo 'export JAVA_HOME=/usr/lib/jvm/java-21-openjdk' >> /etc/profile
RUN source /etc/profile;chmod 755 /*.sh;echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
RUN source /etc/profile;chmod 755 /*.sh;rm -fr /etc/alternatives/java
RUN source /etc/profile;chmod 755 /*.sh;ln -s /usr/lib/jvm/java-21-openjdk/bin/java /etc/alternatives/java
ENV tomcat_version=11.0.15
ENV jetty_version=12.1.5
RUN source /etc/profile;chmod 755 /*.sh;mvn dependency:get -DgroupId=org.apache.tomcat -DartifactId=tomcat -Dversion=${tomcat_version} -Dpackaging=tar.gz -Dtransitive=false
RUN source /etc/profile;chmod 755 /*.sh;cp /root/.m2/repository/org/apache/tomcat/tomcat/${tomcat_version}/tomcat-${tomcat_version}.tar.gz ${WS}
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS};tar -xzf tomcat-${tomcat_version}.tar.gz
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS};mv apache-tomcat-${tomcat_version} tomcat
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS}/tomcat/webapps;rm -fr *
RUN source /etc/profile;chmod 755 /*.sh;mkdir -p ${WS}/tomcat/webapps
RUN source /etc/profile;chmod 755 /*.sh;mvn dependency:get -DgroupId=org.eclipse.jetty -DartifactId=jetty-home -Dversion=${jetty_version} -Dpackaging=tar.gz -Dtransitive=false
RUN source /etc/profile;chmod 755 /*.sh;cp /root/.m2/repository/org/eclipse/jetty/jetty-home/${jetty_version}/jetty-home-${jetty_version}.tar.gz ${WS}
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS};tar -xzf jetty-home-${jetty_version}.tar.gz
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS};mv jetty-home-${jetty_version} jetty
FROM  king019/rhel:ex
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  maven
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  java-21-openjdk-devel
RUN source /etc/profile;chmod 755 /*.sh;echo 'export JAVA_HOME=/usr/lib/jvm/java-21-openjdk' >> /etc/profile
RUN source /etc/profile;chmod 755 /*.sh;echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
RUN source /etc/profile;chmod 755 /*.sh;rm -fr /etc/alternatives/java
RUN source /etc/profile;chmod 755 /*.sh;ln -s /usr/lib/jvm/java-21-openjdk/bin/java /etc/alternatives/java
COPY --from=pre ${WS}/tomcat ${WS}/tomcat
COPY --from=pre ${WS}/jetty ${WS}/jetty

RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
CMD /docker.sh
