FROM king019/alpine

MAINTAINER king019
COPY settings.xml /root/.m2/settings.xml
COPY docker.sh /docker.sh

RUN mkdir -p /root/soft


RUN chmod 755 /*.sh

CMD /docker.sh
