FROM  registry.cn-qingdao.aliyuncs.com/king019/docker

MAINTAINER king019
DKCONFIG multi_run_cmd baseEnv
WORKDIR ${WS}

DKCONFIG multi_run_cmd alpine

RUN apk add maven
RUN apk add git
RUN apk add curl

#RUN curl -fsSL https://get.docker.com | bash -s docker --mirror Aliyun
#RUN apk add docker

RUN which docker


DKCONFIG multi_run_cmd alphne_jdk8





DKCONFIG multi_config dk_config_all

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
