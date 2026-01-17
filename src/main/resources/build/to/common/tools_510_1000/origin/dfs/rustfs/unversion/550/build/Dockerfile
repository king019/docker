FROM  registry.cn-qingdao.aliyuncs.com/king019/rustfs_rustfs

MAINTAINER king019
USER root
DKCONFIG multi_run_cmd alpine
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  bash
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  tzdata
USER rustfs
