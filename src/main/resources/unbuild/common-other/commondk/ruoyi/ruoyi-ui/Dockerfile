#FROM registry.cn-qingdao.aliyuncs.com/king019/node:14
FROM king019/node:14

MAINTAINER king019

COPY docker.sh /docker.sh
COPY git.sh /git.sh
RUN chmod -R 777 /*.sh
RUN /git.sh
CMD /docker.sh
