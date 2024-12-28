FROM  registry.cn-beijing.aliyuncs.com/king019/linux:jdk8

MAINTAINER king019
ADD https://mirrors.aliyun.com/apache/jmeter/binaries/apache-jmeter-5.6.3.tgz   /apache-jmeter-5.6.3.tgz
RUN tar -xzf /apache-jmeter-5.6.3.tgz

RUN chmod 755 /*.sh

CMD /docker.sh