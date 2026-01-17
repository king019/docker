FROM  king019/alpine:p

MAINTAINER king019

RUN apk add nginx

COPY dkrun.sh /dkrun.sh

RUN chmod 755 /*.sh
CMD /docker.sh
