FROM king019/linux:jdk17



EXPOSE 8981
COPY gitjar.sh /gitjar.sh
COPY dkrun.sh /dkrun.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh
CMD /docker.sh