FROM king019/alpine:p

RUN adk add squid



EXPOSE 3128
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh