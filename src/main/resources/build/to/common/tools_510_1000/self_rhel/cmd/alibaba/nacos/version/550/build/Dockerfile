FROM  king019/rhel:jdk as pre

MAINTAINER king019
ENV nacos_version=3.1.1
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER};git clone https://gitee.com/mirrors/Nacos.git nacos
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER};cd nacos;git checkout ${nacos_version}
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER};cd nacos;cd console;sed -i 's/<artifactId>spring-boot-maven-plugin<\/artifactId>/<artifactId>spring-boot-maven-plugin<\/artifactId><version>2.6.3<\/version>/' pom.xml
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER};cd nacos;mvn -Prelease-nacos -Dmaven.test.skip=true clean install
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER};cd nacos;find . -name nacos-server-${nacos_version}.zip | awk -v nacos_version=${nacos_version}  '{print "cp " $1  " /app/nacos-server-"nacos_version".zip"}' | sh

FROM  king019/rhel:jdk

COPY application.properties /application.properties
COPY dkrun.sh /dkrun.sh

ENV nacos_version=3.1.1
COPY --from=pre ${WS}/nacos-server-${nacos_version}.zip ${WS}/nacos-server-${nacos_version}.zip
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS};unzip nacos-server-${nacos_version}.zip
RUN source /etc/profile;chmod 755 /*.sh;cat /application.properties > ${WS}/nacos/conf/application.properties




RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
CMD /docker.sh
