FROM  king019/alpine:jdk

MAINTAINER king019
ENV arthas_version=4.1.4
RUN source /etc/profile;chmod 755 /*.sh;mvn dependency:get -Dtransitive=false -DgroupId=com.taobao.arthas -DartifactId=arthas-packaging -Dversion=${arthas_version} -Dclassifier=bin -Dpackaging=zip
RUN source /etc/profile;chmod 755 /*.sh;cp /root/.m2/repository/com/taobao/arthas/arthas-packaging/${arthas_version}/arthas-packaging-${arthas_version}-bin.zip ${WS}
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS};unzip arthas-packaging-${arthas_version}-bin.zip

COPY dkrun.sh /dkrun.sh
COPY arthas.sh /arthas.sh
#COPY sshm.sh /sshm.sh
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
#RUN /sshm.sh
CMD /docker.sh
