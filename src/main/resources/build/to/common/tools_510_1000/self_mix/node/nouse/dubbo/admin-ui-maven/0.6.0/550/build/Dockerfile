FROM king019/rhel:jdk8  as pre


COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
RUN source /etc/profile;chmod 755 /*.sh;/gitjar.sh




FROM king019/alpine:p
COPY nginx.conf /etc/nginx/
RUN source /etc/profile;chmod 755 /*.sh;rm -rf /etc/nginx/conf.d/default.conf
COPY --from=pre ${WS}/dubbo-admin/dubbo-admin-ui/public ${WS}
