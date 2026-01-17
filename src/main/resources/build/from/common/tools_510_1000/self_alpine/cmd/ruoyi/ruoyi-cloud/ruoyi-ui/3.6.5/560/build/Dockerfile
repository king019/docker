#FROM king019/alpine:p316
FROM king019/alpine:p
DKCONFIG multi_run_cmd alpine_316
MAINTAINER king019




RUN apk add nodejs
RUN apk add npm
RUN apk add git


COPY dkrun.sh /dkrun.sh
DKCONFIG multi_run_cmd soft_ruoyi_cloud_ui_pre
RUN chmod 755 /*.sh


EXPOSE 8080


CMD /dkrun.sh



