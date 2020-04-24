FROM king019/alpine:p

MAINTAINER king019

RUN apk add git

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh

CMD /docker.sh
