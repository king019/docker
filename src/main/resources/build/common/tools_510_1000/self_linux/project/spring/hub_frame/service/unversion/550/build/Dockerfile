FROM king019/linux:jdk17
COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh
CMD /docker.sh