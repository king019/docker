#FROM king019/alpine:p311
FROM king019/alpine:jdk8 as pre

FROM  king019/alpine:b
DKCONFIG multi_run_cmd alpine_311
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  git
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  python2
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  nginx
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  maven
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  openjdk8
RUN source /etc/profile;chmod 755 /*.sh;echo 'export JAVA_HOME=/usr/lib/jvm/java-1.8-openjdk' >> /etc/profile
RUN source /etc/profile;chmod 755 /*.sh;echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
RUN source /etc/profile;chmod 755 /*.sh;rm -fr /usr/lib/jvm/default-jvm
RUN source /etc/profile;chmod 755 /*.sh;ln -s /usr/lib/jvm/java-1.8-openjdk /usr/lib/jvm/default-jvm
COPY --from=pre ${WS}/tomcat ${WS}/tomcat
COPY --from=pre ${WS}/jetty ${WS}/jetty




COPY conf/application.properties  ${WS}/conf/application.properties
COPY conf/jdbc-mysql.properties  ${WS}/conf/jdbc-mysql.properties
COPY conf/redis-config.properties  ${WS}/conf/redis-config.properties
COPY conf/zoo.properties  ${WS}/conf/zoo.properties

COPY nginx.conf /etc/nginx/
RUN source /etc/profile;chmod 755 /*.sh;rm -rf /etc/nginx/conf.d/default.conf



RUN source /etc/profile;chmod 755 /*.sh;mkdir -p ${WS}/conf
RUN source /etc/profile;chmod 755 /*.sh;mkdir -p ${WS}/war
ENV disconf_version=2.6.36
ENV ONLINE_CONFIG_PATH=${WS}/conf
ENV WAR_ROOT_PATH=${WS}/war
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER};git clone https://gitee.com/mirrors/disconf.git
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/disconf;git checkout ${disconf_version}
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/disconf/disconf-web;sh deploy/deploy.sh
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS}/tomcat/conf;sed -i 's/<\/Host>/<Context path="" docBase="\/app\/war"\/><\/Host>/' server.xml

COPY dkrun.sh /dkrun.sh
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh

CMD /docker.sh
