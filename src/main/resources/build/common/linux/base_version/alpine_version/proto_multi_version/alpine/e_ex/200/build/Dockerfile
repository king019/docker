FROM king019/alpine:m

MAINTAINER king019

# COPY get-pip.py /opt/soft/get-pip.py

RUN apk add nginx
RUN apk add gdb
RUN apk add protobuf
RUN apk add protoc

RUN apk add perf
RUN apk add go
RUN apk add thrift
RUN apk add make
RUN apk add autoconf
RUN apk add ttf-dejavu

RUN apk add python3
RUN apk add py3-pip
RUN echo "alias python='python3'" >> /etc/profile;source /etc/profile



RUN apk add redis
RUN apk add rsync

RUN apk add procps
#gnu
#RUN apk add gnupg

#jenkins 需要这个
#RUN apk add ttf-dejavu
#nodejs

#RUN apk add  --repository https://mirrors.aliyun.com/alpine/v3.11/main/ nodejs=12.22.4-r0
#RUN apk add  --repository https://mirrors.aliyun.com/alpine/v3.11/main/ npm=12.22.4-r0

RUN apk add nodejs
RUN apk add npm

RUN npm config set registry https://registry.npm.taobao.org

RUN apk add ca-certificates


RUN chmod -R 777 /*.sh

RUN apk add bash bash-doc bash-completion \
    && sed -i 's/ash/bash/g' /etc/passwd \
    && source /root/.bashrc


# 开放22端口
EXPOSE 22

RUN chmod 755 /*.sh


# 执行ssh启动命令
CMD ["/usr/sbin/sshd", "-D"]


CMD /docker.sh
