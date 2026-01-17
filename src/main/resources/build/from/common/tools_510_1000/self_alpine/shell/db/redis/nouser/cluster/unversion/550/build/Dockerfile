FROM  king019/alpine

MAINTAINER king019


RUN apk add redis



ADD conf/7001/redis7001.conf ${WS}/conf/7001/redis7001.conf
ADD conf/7002/redis7002.conf ${WS}/conf/7002/redis7002.conf
ADD conf/7003/redis7003.conf ${WS}/conf/7003/redis7003.conf
ADD conf/7004/redis7004.conf ${WS}/conf/7004/redis7004.conf
ADD conf/7005/redis7005.conf ${WS}/conf/7005/redis7005.conf
ADD conf/7006/redis7006.conf ${WS}/conf/7006/redis7006.conf
ADD conf/7007/redis7007.conf ${WS}/conf/7007/redis7007.conf
ADD conf/7008/redis7008.conf ${WS}/conf/7008/redis7008.conf
ADD conf/7009/redis7009.conf ${WS}/conf/7009/redis7009.conf





COPY dkrun.sh /dkrun.sh
COPY cluster.sh /cluster.sh
RUN chmod 755 /*.sh
CMD /docker.sh
