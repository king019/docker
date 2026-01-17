FROM  king019/alpine:b as pre

MAINTAINER king019



RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  maven
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  openjdk8
RUN source /etc/profile;chmod 755 /*.sh;echo 'export JAVA_HOME=/usr/lib/jvm/java-1.8-openjdk' >> /etc/profile
RUN source /etc/profile;chmod 755 /*.sh;echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
RUN source /etc/profile;chmod 755 /*.sh;rm -fr /usr/lib/jvm/default-jvm
RUN source /etc/profile;chmod 755 /*.sh;ln -s /usr/lib/jvm/java-1.8-openjdk /usr/lib/jvm/default-jvm
ENV tomcat_version=9.0.113
ENV jetty_version=9.4.58.v20250814
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

FROM  king019/alpine:b

RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  maven
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  openjdk8
RUN source /etc/profile;chmod 755 /*.sh;echo 'export JAVA_HOME=/usr/lib/jvm/java-1.8-openjdk' >> /etc/profile
RUN source /etc/profile;chmod 755 /*.sh;echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
RUN source /etc/profile;chmod 755 /*.sh;rm -fr /usr/lib/jvm/default-jvm
RUN source /etc/profile;chmod 755 /*.sh;ln -s /usr/lib/jvm/java-1.8-openjdk /usr/lib/jvm/default-jvm
COPY --from=pre ${WS}/tomcat ${WS}/tomcat
COPY --from=pre ${WS}/jetty ${WS}/jetty



RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
CMD /docker.sh
