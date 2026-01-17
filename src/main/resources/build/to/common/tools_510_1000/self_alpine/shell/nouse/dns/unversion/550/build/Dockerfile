FROM king019/alpine:p

RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  dnsmasq


EXPOSE 53
COPY dkrun.sh /dkrun.sh
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
CMD /docker.sh
