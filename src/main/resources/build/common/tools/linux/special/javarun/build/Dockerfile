FROM  king019/linux

MAINTAINER king019
RUN mkdir -p /opt/soft
RUN mkdir -p /root/tools/
ADD https://raw.githubusercontent.com/king019/save_github/master/javarun.jar /opt/soft/javarun.jar

RUN cp /opt/soft/javarun.jar /root/tools/javarun.jar

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
