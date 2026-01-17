#FROM king019/alpine:p311
FROM king019/alpine:jdk8 as pre

FROM  king019/alpine:b
DKCONFIG multi_run_cmd alpine_311
RUN apk add git
RUN apk add python2
RUN apk add nginx
DKCONFIG multi_run_cmd alphne_jdk8
DKCONFIG multi_run_cmd server8_next




COPY conf/application.properties  ${WS}/conf/application.properties
COPY conf/jdbc-mysql.properties  ${WS}/conf/jdbc-mysql.properties
COPY conf/redis-config.properties  ${WS}/conf/redis-config.properties
COPY conf/zoo.properties  ${WS}/conf/zoo.properties

COPY nginx.conf /etc/nginx/
RUN rm -rf /etc/nginx/conf.d/default.conf



DKCONFIG multi_run_cmd soft_disconf_pre

COPY dkrun.sh /dkrun.sh
RUN chmod 755 /*.sh

CMD /docker.sh
