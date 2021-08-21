FROM alpine:v3.11
RUN sed -i "s/dl-cdn.alpinelinux.org/mirrors.cloud.tencent.com/g" /etc/apk/repositories
RUN apk add git

RUN apk add  nodejs
RUN apk add  npm

RUN npm config set registry https://registry.npm.taobao.org


COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh