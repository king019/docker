#FROM king019/alpine:p316
FROM king019/alpine:p
MAINTAINER king019




RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  nodejs
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  npm
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  git


COPY dkrun.sh /dkrun.sh
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER};git clone https://gitee.com/y_project/RuoYi-Cloud.git
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/RuoYi-Cloud;git checkout ${ruoyi_cloud_version}
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/RuoYi-Cloud/ruoyi-ui;sed -i s/localhost:8080/ruoyi-gateway/g vue.config.js
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/RuoYi-Cloud/ruoyi-ui;npm install 
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh


EXPOSE 8080


CMD /dkrun.sh



