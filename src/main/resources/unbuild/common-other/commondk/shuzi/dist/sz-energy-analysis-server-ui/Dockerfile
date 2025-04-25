FROM docker:5000/king019/sz-ui-base as ui


MAINTAINER king019

COPY docker.sh /docker.sh
COPY git.sh /git.sh
RUN chmod -R 777 /*.sh
RUN /git.sh

FROM registry.cn-qingdao.aliyuncs.com/king019/nginx:stable-alpine
COPY ./nginx.conf /etc/nginx/nginx.conf
COPY --from=ui /dist /usr/share/nginx/html
