FROM king019/linux:jdk8




COPY file settings.xml
COPY file mvnclean.sh


COPY gitjar.sh /gitjar.sh
COPY dkrun.sh /dkrun.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh
CMD /docker.sh