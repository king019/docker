FROM king019/alpine:p

MAINTAINER king019




COPY docker.sh /docker.sh
COPY multi.sh /multi.sh
COPY sshd.sh /sshd.sh
COPY dkrun.sh /dkrun.sh



RUN apk add openssh-server

RUN apk add openssh tzdata  openssh-client && \
    cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
    sed -i "s/#PermitRootLogin.*/PermitRootLogin yes/g" /etc/ssh/sshd_config && \
       ssh-keygen -t dsa -P "" -f /etc/ssh/ssh_host_dsa_key && \
    ssh-keygen -t rsa -P "" -f /etc/ssh/ssh_host_rsa_key && \
    ssh-keygen -t ecdsa -P "" -f /etc/ssh/ssh_host_ecdsa_key && \
    ssh-keygen -t ed25519 -P "" -f /etc/ssh/ssh_host_ed25519_key
RUN echo 'root:111111' | chpasswd
RUN sed -i 's/#PermitRootLogin prohibit-password/PermitRootLogin yes/' /etc/ssh/sshd_config
RUN /usr/sbin/sshd
CMD /docker.sh
