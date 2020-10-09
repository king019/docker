FROM node:12-alpine as builder

RUN sed -i "s/dl-cdn.alpinelinux.org/mirrors.aliyun.com/g" /etc/apk/repositories

RUN apk add --no-cache git python make openssl tar gcc

ADD https://github.com/YMFE/yapi/archive/v1.9.2.tar.gz /home/v1.9.2.tar.gz

#COPY yapi.tar.gz /home

RUN cd /home && tar zxvf yapi.tar.gz && mkdir /api && mv /home/yapi-1.9.2 /api/vendors

RUN cd /api/vendors && \
    npm install --production --registry https://registry.npm.taobao.org

FROM node:12-alpine

MAINTAINER king019

ENV TZ="Asia/Shanghai" HOME="/"

WORKDIR ${HOME}

COPY --from=builder /api/vendors /api/vendors

COPY config.json /api/

EXPOSE 3000

ENTRYPOINT ["node"]