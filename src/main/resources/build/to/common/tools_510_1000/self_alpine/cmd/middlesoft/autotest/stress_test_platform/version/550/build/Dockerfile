FROM  king019/alpine:jdk8 as pre

MAINTAINER king019
ENV stress_test_platform_version=V3.5.2
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER};git clone https://gitee.com/king019/stressTestPlatform.git
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/stressTestPlatform;mvn package -Dmaven.test.skip=true
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/stressTestPlatform;mv target/renren-fast.jar ${WS}/renren-fast.jar

FROM  king019/alpine:jdk8
COPY dkrun.sh /dkrun.sh
ENV stress_test_platform_version=V3.5.2
COPY --from=pre ${WS}/renren-fast.jar ${WS}/renren-fast.jar


RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh

CMD /docker.sh
