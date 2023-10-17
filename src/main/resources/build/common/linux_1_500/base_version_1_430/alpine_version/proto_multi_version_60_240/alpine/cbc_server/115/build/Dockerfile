FROM king019/alpine:jdk

MAINTAINER king019

COPY config/server.sh /server.sh

RUN chmod 755 /*.sh

RUN /server.sh

CMD /docker.sh
