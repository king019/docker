FROM king019/alpine:p

RUN apk add squid
RUN echo 'http_upgrade_request_protocols WebSocket allow all' >> /etc/squid/squid.conf


EXPOSE 3128
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh