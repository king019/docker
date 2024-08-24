FROM king019/alpine:p

RUN apk add dnsmasq


EXPOSE 53
COPY dkrun.sh /dkrun.sh
RUN chmod 755 /*.sh
CMD /docker.sh