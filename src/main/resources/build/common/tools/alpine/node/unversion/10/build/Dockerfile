FROM alpine:3.11
RUN sed -i 's/https/http/g' /etc/apk/repositories
RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.aliyun.com/g' /etc/apk/repositories
RUN apk add git

RUN apk add  nodejs
RUN apk add  npm

RUN npm config set registry https://registry.npm.taobao.org


COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh