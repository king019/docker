#FROM nginx:1.15.0-alpine
FROM nginx:stable-alpine
COPY nginx.conf /etc/nginx/
#COPY passwd /etc/nginx/


COPY maven.aliyun.com.csr /data/maven.aliyun.com.csr
COPY maven.aliyun.com.key /data/maven.aliyun.com.key
RUN rm -rf /etc/nginx/conf.d/default.conf