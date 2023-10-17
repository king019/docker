FROM king019/centos:runuse

MAINTAINER king019

RUN mkdir -p /root/.m2




COPY run/mvnclean.sh /mvnclean.sh
# COPY run/perf.sh /perf.sh
COPY run/profile.sh /profile.sh
# COPY run/protoc.sh /protoc.sh
COPY run/run.sh /run.sh
COPY run/run_env.sh /run_env.sh


# 开放22端口
EXPOSE 22

RUN chmod 755 /*.sh


CMD /docker.sh
