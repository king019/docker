FROM king019/linux

ADD https://github.com/mysql/mysql-server/archive/refs/heads/5.7.zip /opt/soft/version/5.7.zip

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh