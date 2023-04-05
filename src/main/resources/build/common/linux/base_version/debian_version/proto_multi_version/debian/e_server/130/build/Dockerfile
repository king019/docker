FROM king019/debian:m

MAINTAINER king019

RUN mvn dependency:get -DgroupId=org.eclipse.jetty -DartifactId=jetty-distribution -Dversion=9.4.49.v20220914 -Dpackaging=tar.gz;cp /root/.m2/repository/org/eclipse/jetty/jetty-distribution/9.4.49.v20220914/jetty-distribution-9.4.49.v20220914.tar.gz /opt/soft/tools
RUN mvn dependency:get -DgroupId=org.apache.tomcat -DartifactId=tomcat -Dversion=9.0.68 -Dpackaging=tar.gz;cp /root/.m2/repository/org/apache/tomcat/tomcat/9.0.68/tomcat-9.0.68.tar.gz /opt/soft/tools


RUN cd /opt/soft/tools/;tar -xzf jetty-distribution-9.4.49.v20220914.tar.gz
RUN cd /opt/soft/tools/;mv jetty-distribution-9.4.49.v20220914 jetty


RUN cd /opt/soft/tools;tar -xzf tomcat-9.0.68.tar.gz
RUN cd /opt/soft/tools;mv apache-tomcat-9.0.68 tomcat
RUN cd /opt/soft/tools/tomcat/webapps;rm -fr *
RUN mkdir -p /opt/soft/tools/tomcat/webapps

RUN rm -fr /root/.m2/repository


RUN chmod 755 /*.sh
CMD /docker.sh