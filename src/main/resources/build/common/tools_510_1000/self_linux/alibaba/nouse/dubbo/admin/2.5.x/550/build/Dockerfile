FROM king019/linux:jdk8 as pre



COPY gitjar.sh /gitjar.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh
CMD /docker.sh




FROM  king019/linux:jdk8
COPY --from=pre /opt/soft/tool/tomcat/webapps/ROOT.war /opt/soft/tool/tomcat/webapps/ROOT.war
COPY dkrun.sh /dkrun.sh
RUN chmod 755 /*.sh
CMD /docker.sh