FROM registry.cn-qingdao.aliyuncs.com/king019/node:16
MAINTAINER king019
COPY gitjar.sh /gitjar.sh
COPY dkrun.sh /dkrun.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh


EXPOSE 8080


CMD /dkrun.sh



