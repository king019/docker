FROM king019/alpine:p



COPY config/delete.sh /delete.sh

COPY config/crontab.txt /crontab.txt
COPY config/delete_all.sh /delete_all.sh


RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  jq

RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted   curl


RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
CMD /docker.sh
