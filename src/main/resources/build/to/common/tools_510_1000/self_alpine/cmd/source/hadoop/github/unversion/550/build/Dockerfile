FROM king019/alpine:git

RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER};git clone https://github.com/apache/hadoop.git

EXPOSE 8981
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
CMD /docker.sh
