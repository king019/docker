#FROM  registry.cn-qingdao.aliyuncs.com/king019/python:2.7.18-alpine
FROM king019/alpine:p311

MAINTAINER king019
DKCONFIG multi_run_cmd baseEnv
WORKDIR ${WS}
DKCONFIG multi_run_cmd alpine



DKCONFIG multi_config dk_config_all

RUN apk add maven
RUN apk add git
RUN apk add python2
RUN apk add nginx



DKCONFIG multi_run_cmd alphne_jdk8


DKCONFIG multi_run_cmd server8



COPY conf/application.properties  /conf/application.properties
COPY conf/jdbc-mysql.properties  /conf/jdbc-mysql.properties
COPY conf/redis-config.properties  /conf/redis-config.properties
COPY conf/zoo.properties  /conf/zoo.properties

COPY nginx.conf /etc/nginx/
RUN rm -rf /etc/nginx/conf.d/default.conf





COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh

CMD /docker.sh
