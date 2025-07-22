FROM king019/alpine:3.11


RUN apk add git

RUN apk add  nodejs
RUN apk add  npm

RUN npm config set registry http://registry.npmmirror.com


COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh