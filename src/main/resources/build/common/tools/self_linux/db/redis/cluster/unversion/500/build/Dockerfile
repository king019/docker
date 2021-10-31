FROM  king019/linux
#FROM  ruby:alpine3.12

MAINTAINER king019



#RUN gem sources  --remove https://rubygems.org/
#RUN gem sources -a https://gems.ruby-china.com
#RUN gem sources -l
#RUN gem install redis

RUN mkdir -p /opt/soft/conf



ADD conf/7001/redis7001.conf /opt/soft/conf/7001/redis7001.conf
ADD conf/7002/redis7002.conf /opt/soft/conf/7002/redis7002.conf
ADD conf/7003/redis7003.conf /opt/soft/conf/7003/redis7003.conf
ADD conf/7004/redis7004.conf /opt/soft/conf/7004/redis7004.conf
ADD conf/7005/redis7005.conf /opt/soft/conf/7005/redis7005.conf
ADD conf/7006/redis7006.conf /opt/soft/conf/7006/redis7006.conf
ADD conf/7007/redis7007.conf /opt/soft/conf/7007/redis7007.conf
ADD conf/7008/redis7008.conf /opt/soft/conf/7008/redis7008.conf
ADD conf/7009/redis7009.conf /opt/soft/conf/7009/redis7009.conf





COPY docker.sh /docker.sh
COPY cluster.sh /cluster.sh
RUN chmod 755 /*.sh
CMD /docker.sh
