FROM king019/linux

COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh
CMD /docker.sh