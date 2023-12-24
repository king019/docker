FROM registry.cn-qingdao.aliyuncs.com/king019/nginx:stable-alpine
COPY nginx.conf /etc/nginx/
COPY config/front.conf /root/front.conf
COPY config/back.conf /root/back.conf
RUN rm -rf /etc/nginx/conf.d/default.conf