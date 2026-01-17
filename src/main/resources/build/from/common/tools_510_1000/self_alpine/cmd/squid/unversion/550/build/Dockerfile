FROM king019/alpine:p

DKCONFIG multi_run_cmd alpine_squid

EXPOSE 3128
COPY dkrun.sh /dkrun.sh
RUN chmod 755 /*.sh
CMD /docker.sh