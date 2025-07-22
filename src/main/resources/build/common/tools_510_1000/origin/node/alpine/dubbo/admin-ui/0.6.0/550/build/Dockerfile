FROM king019/alpine  as base


RUN apk add git


COPY gitjar_clone.sh /gitjar.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh




FROM registry.cn-qingdao.aliyuncs.com/king019/node:9.1-alpine  as pre


DKCONFIG mkdir_file dir_all
DKCONFIG sed_mirror go_proxy
DKCONFIG multi_file config_all

COPY --from=base /opt/soft/version/dubbo-admin /opt/soft/version/dubbo-admin

RUN npm config set registry http://registry.npmmirror.com



COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh
CMD /docker.sh




#FROM registry.cn-qingdao.aliyuncs.com/king019/nginx:stable-alpine
#COPY nginx.conf /etc/nginx/
#RUN rm -rf /etc/nginx/conf.d/default.conf
#COPY --from=pre /opt/soft/version/dubbo-admin/dubbo-admin-ui/public /opt/soft/app