FROM  king019/alpine:jdk

MAINTAINER king019



DKCONFIG multi_run_cmd jenkins


COPY dkrun.sh /dkrun.sh
RUN chmod 755 /*.sh

CMD /docker.sh
