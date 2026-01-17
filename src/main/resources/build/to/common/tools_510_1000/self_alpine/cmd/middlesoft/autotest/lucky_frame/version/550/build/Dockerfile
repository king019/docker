FROM  king019/alpine:jdk8 as pre

MAINTAINER king019

ENV lucky_frame_client_version=V3.5.2
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER};git clone https://gitee.com/seagull1985/LuckyFrameClient.git
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/LuckyFrameClient;git checkout ${lucky_frame_client_version}
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/LuckyFrameClient;mvn package -Dmaven.test.skip=true
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/LuckyFrameClient;mv target/LuckyFrameClient.jar ${WS}/LuckyFrameClient.jar


FROM  king019/alpine:jdk8


COPY dkrun.sh /dkrun.sh
ENV lucky_frame_client_version=V3.5.2
COPY --from=pre ${WS}/LuckyFrameClient.jar ${WS}/LuckyFrameClient.jar
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh

CMD /docker.sh
