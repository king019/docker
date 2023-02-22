FROM king019/linux:jdk17



EXPOSE 8981
COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh

COPY config/cmd.sh /cmd.sh
COPY config/cms.sh /cms.sh
COPY config/g1.sh /g1.sh




RUN chmod 755 /*.sh
RUN /gitjar.sh
CMD /docker.sh