#FROM nginx:1.15.0-alpine
FROM nginx:stable-alpine
COPY nginx.conf /etc/nginx/
#COPY passwd /etc/nginx/


COPY server.pem /data/server.pem
COPY privkey.pem /data/privkey.pem
RUN rm -rf /etc/nginx/conf.d/default.conf