FROM  king019/linux:jdk as pre

MAINTAINER king019


COPY gitjar.sh /gitjar.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh
FROM  king019/linux:jdk
COPY --from=pre /app/LuckyFrameClient.jar /app/LuckyFrameClient.jar

COPY dkrun.sh /dkrun.sh
RUN chmod 755 /*.sh

CMD /docker.sh