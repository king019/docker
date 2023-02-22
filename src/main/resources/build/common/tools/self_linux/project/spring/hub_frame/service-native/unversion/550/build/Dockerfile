FROM registry.cn-qingdao.aliyuncs.com/king019/graal-build:centos
COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh
CMD /docker.sh