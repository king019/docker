FROM king019/alpine:git

DKCONFIG multi_run_cmd source_mysql_server

EXPOSE 8981
RUN chmod 755 /*.sh
CMD /docker.sh