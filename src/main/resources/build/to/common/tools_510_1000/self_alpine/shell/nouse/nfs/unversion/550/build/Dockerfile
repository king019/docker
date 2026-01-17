FROM king019/alpine:p

RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  nfs-utils
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  bash
RUN source /etc/profile;chmod 755 /*.sh;echo "rpc_pipefs /var/lib/nfs/rpc_pipefs rpc_pipefs defaults 0 0" >> /etc/fstab
RUN source /etc/profile;chmod 755 /*.sh;echo "nfsd       /proc/fs/nfsd           nfsd       defaults 0 0" >> /etc/fstab

COPY exports /etc/
COPY nfsd.sh /nfsd.sh

EXPOSE 2049

EXPOSE 2049
COPY dkrun.sh /dkrun.sh
COPY exports /etc/exports
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
CMD /docker.sh
