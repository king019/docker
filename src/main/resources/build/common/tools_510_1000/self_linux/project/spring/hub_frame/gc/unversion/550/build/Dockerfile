FROM king019/linux:usejdk17



EXPOSE 8981
COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh

COPY config/admin.sh /admin.sh
COPY config/gc.sh /gc.sh




RUN chmod 755 /*.sh
RUN /gitjar.sh
CMD /docker.sh