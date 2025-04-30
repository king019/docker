FROM king019/centos:p

MAINTAINER king019


COPY shell/docker.sh /docker.sh
COPY shell/multi.sh /multi.sh
COPY shell/extra.sh /extra.sh
COPY shell/sshd.sh /sshd.sh
COPY shell/dkrun.sh /dkrun.sh




RUN dnf -y install  procps
RUN dnf -y install  openssh-server

RUN dnf -y install  openssh tzdata openssh-clients && \
    cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
    sed -i "s/#PermitRootLogin.*/PermitRootLogin yes/g" /etc/ssh/ssh_config && \
    ssh-keygen -t rsa -P "" -f /etc/ssh/ssh_host_rsa_key && \
    ssh-keygen -t ecdsa -P "" -f /etc/ssh/ssh_host_ecdsa_key && \
    ssh-keygen -t ed25519 -P "" -f /etc/ssh/ssh_host_ed25519_key
#可用  ssh-keygen -t dsa -P "" -f /etc/ssh/ssh_host_dsa_key && \
COPY file id_dsa
COPY file id_rsa
COPY file id_ecdsa
COPY file id_ed25519

COPY file id_dsa.pub
COPY file id_rsa.pub
COPY file id_ecdsa.pub
COPY file id_ed25519.pub

#RUN ssh-keygen -t dsa -P "" -f /root/.ssh/id_dsa
#RUN ssh-keygen -t rsa -P "" -f /root/.ssh/id_rsa
#RUN ssh-keygen -t ecdsa -P "" -f /root/.ssh/id_ecdsa
#RUN ssh-keygen -t ed25519 -P "" -f /root/.ssh/id_ed25519

RUN cat  /id_dsa > /root/.ssh/id_dsa
RUN cat  /id_rsa > /root/.ssh/id_rsa
RUN cat  /id_ecdsa > /root/.ssh/id_ecdsa
RUN cat  /id_ed25519 > /root/.ssh/id_ed25519

RUN cat  /id_dsa.pub > /root/.ssh/id_dsa.pub
RUN cat  /id_rsa.pub > /root/.ssh/id_rsa.pub
RUN cat  /id_ecdsa.pub > /root/.ssh/id_ecdsa.pub
RUN cat  /id_ed25519.pub > /root/.ssh/id_ed25519.pub

RUN echo 'root:111111' | chpasswd
RUN sed -i 's/#PermitRootLogin prohibit-password/PermitRootLogin yes/' /etc/ssh/sshd_config
#RUN sed -i 's/#PermitRootLogin prohibit-password/PermitRootLogin prohibit-password/' /etc/ssh/sshd_config

RUN /usr/sbin/sshd

CMD /docker.sh