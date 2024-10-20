FROM  king019/linux:jdk11 as pre

MAINTAINER king019


COPY gitjar.sh /gitjar.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh
FROM  king019/linux:jdk11
RUN mkdir -p /app
COPY --from=pre /app/LuckyFrameClient.jar /app/LuckyFrameClient.jar

COPY dkrun.sh /dkrun.sh
RUN chmod 755 /*.sh

CMD /docker.sh