FROM docker:5001/king019/debian:gitea_runner


RUN mkdir -p /root/.kube


COPY minikube /usr/bin/minikube
COPY config /root/.kube/config
COPY .minikube /root/.minikube


RUN chmod 755 /usr/bin/minikube

RUN ln -s $(which minikube) /usr/bin/kubectl