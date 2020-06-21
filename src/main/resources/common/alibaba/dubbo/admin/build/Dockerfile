FROM king019/alpine
RUN mkdir -p /opt/soft
ADD http://nginxdown/dubbo-admin-0.2.0.jar /opt/soft/dubbo-admin-0.2.0.jar
RUN mkdir -p /root/tools
RUN cp /opt/soft/dubbo-admin-0.2.0.jar /root/tools/dubbo-admin-0.2.0.jar

EXPOSE 8080
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh