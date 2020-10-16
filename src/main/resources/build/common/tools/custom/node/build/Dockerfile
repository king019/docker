FROM  king019/linux

MAINTAINER king019
RUN apk add nodejs
RUN apk add npm
RUN npm config set registry https://registry.npm.taobao.org

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
