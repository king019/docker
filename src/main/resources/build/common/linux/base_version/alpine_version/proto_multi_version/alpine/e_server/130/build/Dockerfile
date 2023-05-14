FROM king019/alpine:m

MAINTAINER king019

COPY config/server.sh /server.sh

RUN chmod 755 /*.sh

RUN /server.sh

CMD /docker.sh
