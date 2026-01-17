FROM king019/rhel:git

MAINTAINER king019







#RUN dnf -y install  procps
#RUN dnf -y install  openssh-server

#RUN dnf -y install  openssh tzdata openssh-clients && \
#    cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
#    sed -i "s/#PermitRootLogin.*/PermitRootLogin yes/g" /etc/ssh/ssh_config && \
#    ssh-keygen -t rsa -P "" -f /etc/ssh/ssh_host_rsa_key && \
#    ssh-keygen -t ecdsa -P "" -f /etc/ssh/ssh_host_ecdsa_key && \
#    ssh-keygen -t ed25519 -P "" -f /etc/ssh/ssh_host_ed25519_key
##可用  ssh-keygen -t dsa -P "" -f /etc/ssh/ssh_host_dsa_key && \


#RUN ssh-keygen -t dsa -P "" -f /root/.ssh/id_dsa
#RUN ssh-keygen -t rsa -P "" -f /root/.ssh/id_rsa
#RUN ssh-keygen -t ecdsa -P "" -f /root/.ssh/id_ecdsa
#RUN ssh-keygen -t ed25519 -P "" -f /root/.ssh/id_ed25519

DKCONFIG multi_run_cmd rhel_ssh

#RUN echo 'root:111111' | chpasswd
#RUN sed -i 's/#PermitRootLogin prohibit-password/PermitRootLogin yes/' /etc/ssh/sshd_config
#RUN sed -i 's/#PermitRootLogin prohibit-password/PermitRootLogin prohibit-password/' /etc/ssh/sshd_config

#RUN /usr/sbin/sshd

CMD /docker.sh