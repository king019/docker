FROM  king019/linux:jdk8 as pre

MAINTAINER king019


COPY gitjar.sh /gitjar.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh
FROM  king019/linux:jdk8
COPY --from=pre /app/renren-fast.jar /app/renren-fast.jar

COPY dkrun.sh /dkrun.sh
RUN chmod 755 /*.sh

CMD /docker.sh