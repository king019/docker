FROM king019/alpine:p

RUN apk add nfs-utils
RUN apk add bash
RUN echo "rpc_pipefs /var/lib/nfs/rpc_pipefs rpc_pipefs defaults 0 0" >> /etc/fstab
RUN echo "nfsd       /proc/fs/nfsd           nfsd       defaults 0 0" >> /etc/fstab

COPY exports /etc/
COPY nfsd.sh /nfsd.sh

EXPOSE 2049

EXPOSE 2049
COPY dkrun.sh /dkrun.sh
COPY exports /etc/exports
RUN chmod 755 /*.sh
CMD /docker.sh