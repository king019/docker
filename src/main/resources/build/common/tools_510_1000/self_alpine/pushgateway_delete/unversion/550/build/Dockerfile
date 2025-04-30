FROM king019/alpine:p



COPY config/delete.sh /delete.sh

COPY config/crontab.txt /crontab.txt
COPY config/delete_all.sh /delete_all.sh


RUN mkdir -p /opt/soft/tool/


RUN apk add jq

RUN apk add  curl


RUN chmod 755 /*.sh
CMD /docker.sh