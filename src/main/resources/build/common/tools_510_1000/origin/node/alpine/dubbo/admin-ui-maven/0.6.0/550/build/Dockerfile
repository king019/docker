FROM king019/centos:jdk8  as pre




COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh




FROM registry.cn-qingdao.aliyuncs.com/king019/nginx:stable-alpine
COPY nginx.conf /etc/nginx/
RUN rm -rf /etc/nginx/conf.d/default.conf
COPY --from=pre /opt/soft/version/dubbo-admin/dubbo-admin-ui/public /opt/soft/app