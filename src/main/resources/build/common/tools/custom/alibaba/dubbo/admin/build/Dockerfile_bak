FROM king019/linux
RUN mkdir -p /opt/soft
ADD https://raw.githubusercontent.com/king019/save_github/master/dubbo-admin-0.2.0.jar /opt/soft/dubbo-admin-0.2.0.jar
RUN mkdir -p /root/tools
RUN cp /opt/soft/dubbo-admin-0.2.0.jar /root/tools/dubbo-admin-0.2.0.jar

EXPOSE 8080
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh