FROM king019/alpine:p

RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  squid
RUN source /etc/profile;chmod 755 /*.sh;echo 'http_upgrade_request_protocols WebSocket allow all' >> /etc/squid/squid.conf

EXPOSE 3128
COPY dkrun.sh /dkrun.sh
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
CMD /docker.sh
