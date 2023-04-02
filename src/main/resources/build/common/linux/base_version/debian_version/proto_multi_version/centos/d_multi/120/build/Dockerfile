FROM king019/debian:jdk

MAINTAINER king019


RUN apt-get -y install  git
RUN apt-get -y install  wget
RUN apt-get -y install  vim
RUN apt-get -y install  unzip
RUN apt-get -y install  lsof

RUN apt-get -y install  telnet
RUN apt-get -y install  tcpdump

#base
#放入extra
RUN chmod -R 777 /*.sh



RUN chmod 755 /*.sh
CMD /docker.sh
