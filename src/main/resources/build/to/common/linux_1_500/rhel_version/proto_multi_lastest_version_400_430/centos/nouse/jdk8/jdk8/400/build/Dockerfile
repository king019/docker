FROM  king019/rhel:b

MAINTAINER king019

RUN source /etc/profile;chmod 755 /*.sh;echo -e "#!/bin/sh\nset -x\n\ntomcat_version=$1\n\n\n\n#https://repo1.maven.org/maven2/org/eclipse/jetty/jetty-home/12.1.0/jetty-home-12.1.0.tar.gz\n\nmvn dependency:get -DgroupId=org.apache.tomcat -DartifactId=tomcat -Dversion=${tomcat_version} -Dpackaging=tar.gz -Dtransitive=false;cp /root/.m2/repository/org/apache/tomcat/tomcat/${tomcat_version}/tomcat-${tomcat_version}.tar.gz ${WS}\n\n\n\ncd ${WS};tar -xzf tomcat-${tomcat_version}.tar.gz\ncd ${WS};mv apache-tomcat-${tomcat_version} tomcat\n\n\ncd ${WS}/tomcat/webapps;rm -fr *\nmkdir -p ${WS}/tomcat/webapps\n\nrm -fr /root/.m2/repository" > /tomcat.sh
RUN source /etc/profile;chmod 755 /*.sh;chmod -R 777 /tomcat.sh
RUN source /etc/profile;chmod 755 /*.sh;/tomcat.sh 9.0.99
RUN source /etc/profile;chmod 755 /*.sh;echo -e "#!/bin/sh\nset -x\n\njetty_version=$1\n\n\n\n#https://repo1.maven.org/maven2/org/eclipse/jetty/jetty-home/12.1.0/jetty-home-12.1.0.tar.gz\n\nmvn dependency:get -DgroupId=org.eclipse.jetty -DartifactId=jetty-home -Dversion=${jetty_version} -Dpackaging=tar.gz -Dtransitive=false;cp /root/.m2/repository/org/eclipse/jetty/jetty-home/${jetty_version}/jetty-home-${jetty_version}.tar.gz ${WS}\n\n\ncd ${WS};tar -xzf jetty-home-${jetty_version}.tar.gz\ncd ${WS};mv jetty-home-${jetty_version} jetty\n\nrm -fr /root/.m2/repository" > /jetty.sh
RUN source /etc/profile;chmod 755 /*.sh;chmod -R 777 /jetty.sh
RUN source /etc/profile;chmod 755 /*.sh;/jetty.sh 9.4.58.v20250814

RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  maven
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  java-1.8.0-openjdk-devel
RUN source /etc/profile;chmod 755 /*.sh;echo 'export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk' >> /etc/profile
RUN source /etc/profile;chmod 755 /*.sh;echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
RUN source /etc/profile;chmod 755 /*.sh;rm -fr /etc/alternatives/java
RUN source /etc/profile;chmod 755 /*.sh;ln -s /usr/lib/jvm/java-1.8.0-openjdk/bin/java /etc/alternatives/java

RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
CMD /docker.sh
