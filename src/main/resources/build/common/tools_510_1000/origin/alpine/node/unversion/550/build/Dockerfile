FROM registry.cn-qingdao.aliyuncs.com/king019/alpine:3.11



COPY file trans.sh
COPY file trans_repo_bak.sh
COPY file trans_repo_nexus.sh
COPY file trans_maven.sh
COPY file trans_repo.sh


RUN sed -i 's/https/http/g' /etc/apk/repositories

RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.aliyun.com/g' /etc/apk/repositories

RUN mkdir -p /root/.m2
RUN mkdir -p /opt/soft/tool/


RUN apk add git

RUN apk add  nodejs
RUN apk add  npm

RUN npm config set registry http://registry.npmmirror.com


COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh