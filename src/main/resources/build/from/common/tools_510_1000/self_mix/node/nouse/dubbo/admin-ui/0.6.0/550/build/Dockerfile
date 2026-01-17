FROM king019/alpine  as base
RUN apk add git


COPY gitjar_clone.sh /gitjar.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh




FROM king019/alpine:p


DKCONFIG multi_config dk_config_all

COPY --from=base ${WS}/dubbo-admin ${WS}/dubbo-admin

RUN npm config set registry http://registry.npmmirror.com



COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh
CMD /docker.sh