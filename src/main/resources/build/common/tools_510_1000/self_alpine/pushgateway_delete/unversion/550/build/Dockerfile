FROM king019/alpine:p



COPY config/delete.sh /delete.sh
#COPY config/trans.sh /trans.sh
#COPY config/trans_repo_bak.sh /trans_repo_bak.sh
#COPY config/trans_repo_nexus.sh /trans_repo_nexus.sh
#COPY config/trans_maven.sh /trans_maven.sh
#COPY config/trans_repo.sh /trans_repo.sh


RUN mkdir -p /root/.m2
RUN mkdir -p /opt/soft/tools/


RUN apk add jq

RUN apk add  curl


COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh