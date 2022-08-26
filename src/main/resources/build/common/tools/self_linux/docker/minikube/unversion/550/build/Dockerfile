FROM  king019/linux
#FROM  ruby:alpine3.12

MAINTAINER king019



#RUN gem sources  --remove https://rubygems.org/
#RUN gem sources -a https://gems.ruby-china.com
#RUN gem sources -l
#RUN gem install redis



COPY docker.sh /docker.sh
COPY cluster.sh /cluster.sh
RUN chmod 755 /*.sh
CMD /docker.sh
