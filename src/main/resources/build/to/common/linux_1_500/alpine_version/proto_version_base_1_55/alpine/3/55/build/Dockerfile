FROM king019/alpine:p3



#COPY shell/docker.sh /docker.sh
#COPY shell/multi.sh /multi.sh
#COPY shell/extra.sh /extra.sh
#COPY shell/sshd.sh /sshd.sh
#COPY shell/dkrun.sh /dkrun.sh







RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  bash

CMD /docker.sh
