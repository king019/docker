FROM king019/alpine:p

MAINTAINER king019

COPY settings.xml /root/.m2/settings.xml
COPY run/run.sh /run.sh
COPY run/run_env.sh /run_env.sh
COPY run/profile.sh /profile.sh
COPY run/git.sh /opt/soft/git.sh

COPY docker.sh /docker.sh

RUN apk add git
RUN apk add openjdk11
RUN apk add maven



RUN chmod 755 /*.sh

CMD /docker.sh
