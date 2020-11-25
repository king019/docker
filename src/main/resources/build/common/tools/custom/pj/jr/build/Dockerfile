FROM  king019/linux

MAINTAINER king019
RUN mkdir -p /opt/soft/tool
RUN cd /opt/soft/tool;git clone https://gitee.com/gsls200808/JrebelLicenseServerforJava.git
RUN cd /opt/soft/tool/JrebelLicenseServerforJava;mvn package

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
