FROM king019/alpine:b

RUN apk add python3


EXPOSE 53


DKCONFIG multi_run_cmd dockerMonitorMonitor

COPY dkrun.sh /dkrun.sh
RUN chmod 755 /*.sh
CMD /docker.sh