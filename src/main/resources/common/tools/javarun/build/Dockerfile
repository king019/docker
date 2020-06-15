FROM  king019/alpine

MAINTAINER king019
RUN mkdir -p /opt/soft
RUN mkdir -p /root/tools/
ADD http://aaaaaaaa/javarun.jar /opt/soft/javarun.jar

RUN cp /opt/soft/javarun.jar /root/tools/javarun.jar

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
