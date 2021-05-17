FROM  king019/alpine
#FROM  ruby:alpine3.12

MAINTAINER king019



#RUN gem sources  --remove https://rubygems.org/
#RUN gem sources -a https://gems.ruby-china.com
#RUN gem sources -l
#RUN gem install redis

RUN mkdir -p /root/tools/conf

# ADD https://mirrors.huaweicloud.com/redis/redis-5.0.8.tar.gz /opt/soft/redis-5.0.8.tar.gz
# RUN cp /opt/soft/redis-5.0.8.tar.gz /root/tools/redis-5.0.8.tar.gz
# RUN cd /root/tools;tar -xzf redis-5.0.8.tar.gz
# RUN cd /root/tools;mv redis-5.0.8 redis


ADD conf/7001/redis7001.conf /root/tools/conf/7001/redis7001.conf
ADD conf/7002/redis7002.conf /root/tools/conf/7002/redis7002.conf
ADD conf/7003/redis7003.conf /root/tools/conf/7003/redis7003.conf
ADD conf/7004/redis7004.conf /root/tools/conf/7004/redis7004.conf
ADD conf/7005/redis7005.conf /root/tools/conf/7005/redis7005.conf
ADD conf/7006/redis7006.conf /root/tools/conf/7006/redis7006.conf
ADD conf/7007/redis7007.conf /root/tools/conf/7007/redis7007.conf
ADD conf/7008/redis7008.conf /root/tools/conf/7008/redis7008.conf
ADD conf/7009/redis7009.conf /root/tools/conf/7009/redis7009.conf





COPY docker.sh /docker.sh
COPY cluster.sh /cluster.sh
RUN chmod 755 /*.sh
CMD /docker.sh
