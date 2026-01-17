FROM king019/alpine:jdk



EXPOSE 8981
COPY gitjar.sh /gitjar.sh
COPY dkrun.sh /dkrun.sh
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
RUN source /etc/profile;chmod 755 /*.sh;/gitjar.sh
CMD /docker.sh
