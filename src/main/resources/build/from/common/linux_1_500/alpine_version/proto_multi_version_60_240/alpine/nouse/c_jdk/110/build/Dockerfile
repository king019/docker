FROM king019/alpine:res

MAINTAINER king019


RUN apk add maven

#RUN apk add go

RUN chmod -R 777 /*.sh


DKCONFIG multi_run_cmd alphne_jdk

RUN chmod 755 /*.sh


CMD /docker.sh
