FROM king019/alpine:jdk8 as pre

MAINTAINER king019
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER};git clone https://gitee.com/king019/rocketmq-dashboard.git
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/rocketmq-dashboard;git checkout rocketmq-dashboard-1.0.0
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/rocketmq-dashboard;mvn clean package -Dmaven.test.skip=true
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/rocketmq-dashboard;cp target/rocketmq-dashboard-1.0.0.jar ${WS}/rocketmq-dashboard.jar



FROM king019/alpine:jdk8
COPY --from=pre ${WS}/rocketmq-dashboard.jar ${WS}/rocketmq-dashboard.jar

COPY dkrun.sh /dkrun.sh
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
CMD /docker.sh





