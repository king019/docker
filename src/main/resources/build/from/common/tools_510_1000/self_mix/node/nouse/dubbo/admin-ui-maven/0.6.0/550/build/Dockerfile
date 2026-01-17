FROM king019/rhel:jdk8  as pre


COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh




FROM king019/alpine:p
COPY nginx.conf /etc/nginx/
RUN rm -rf /etc/nginx/conf.d/default.conf
COPY --from=pre ${WS}/dubbo-admin/dubbo-admin-ui/public ${WS}