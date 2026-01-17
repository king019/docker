FROM king019/alpine:git

MAINTAINER king019






#RUN apk add openssh-server
#
#RUN apk add openssh tzdata  openssh-client && \
#    cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
#    sed -i "s/#PermitRootLogin.*/PermitRootLogin yes/g" /etc/ssh/sshd_config && \
#    ssh-keygen -t rsa -P "" -f /etc/ssh/ssh_host_rsa_key && \
#    ssh-keygen -t ecdsa -P "" -f /etc/ssh/ssh_host_ecdsa_key && \
#    ssh-keygen -t ed25519 -P "" -f /etc/ssh/ssh_host_ed25519_key



#    ssh-keygen -t dsa -P "" -f /etc/ssh/ssh_host_dsa_key && \




#RUN ssh-keygen -t dsa -P "" -f /root/.ssh/id_dsa
#RUN ssh-keygen -t rsa -P "" -f /root/.ssh/id_rsa
#RUN ssh-keygen -t ecdsa -P "" -f /root/.ssh/id_ecdsa
#RUN ssh-keygen -t ed25519 -P "" -f /root/.ssh/id_ed25519


RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  openssh-server
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  openssh
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  tzdata
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  openssh-client
RUN source /etc/profile;chmod 755 /*.sh;cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN source /etc/profile;chmod 755 /*.sh;sed -i "s/#PermitRootLogin.*/PermitRootLogin yes/g" /etc/ssh/sshd_config
RUN source /etc/profile;chmod 755 /*.sh;ssh-keygen -t rsa -P "" -f /etc/ssh/ssh_host_rsa_key
RUN source /etc/profile;chmod 755 /*.sh;ssh-keygen -t ecdsa -P "" -f /etc/ssh/ssh_host_ecdsa_key
RUN source /etc/profile;chmod 755 /*.sh;ssh-keygen -t ed25519 -P "" -f /etc/ssh/ssh_host_ed25519_key
RUN source /etc/profile;chmod 755 /*.sh;cat  /id_dsa > /root/.ssh/id_dsa
RUN source /etc/profile;chmod 755 /*.sh;cat  /id_rsa > /root/.ssh/id_rsa
RUN source /etc/profile;chmod 755 /*.sh;cat  /id_ecdsa > /root/.ssh/id_ecdsa
RUN source /etc/profile;chmod 755 /*.sh;cat  /id_ed25519 > /root/.ssh/id_ed25519
RUN source /etc/profile;chmod 755 /*.sh;cat  /id_dsa.pub > /root/.ssh/id_dsa.pub
RUN source /etc/profile;chmod 755 /*.sh;cat  /id_rsa.pub > /root/.ssh/id_rsa.pub
RUN source /etc/profile;chmod 755 /*.sh;cat  /id_ecdsa.pub > /root/.ssh/id_ecdsa.pub
RUN source /etc/profile;chmod 755 /*.sh;cat  /id_ed25519.pub > /root/.ssh/id_ed25519.pub
RUN source /etc/profile;chmod 755 /*.sh;sed -i 's/#PermitRootLogin prohibit-password/PermitRootLogin yes/' /etc/ssh/sshd_config

#RUN echo 'root:111111' | chpasswd
#RUN sed -i 's/#PermitRootLogin prohibit-password/PermitRootLogin yes/' /etc/ssh/sshd_config
#RUN sed -i 's/#PermitRootLogin prohibit-password/PermitRootLogin prohibit-password/' /etc/ssh/sshd_config
#RUN /usr/sbin/sshd
CMD /docker.sh
