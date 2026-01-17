FROM  king019/alpine:jdk8

MAINTAINER king019


DKCONFIG multi_run_cmd soft_iot_db_backend_pre



COPY dkrun.sh /dkrun.sh
RUN chmod 755 /*.sh



EXPOSE 8080


CMD /docker.sh



