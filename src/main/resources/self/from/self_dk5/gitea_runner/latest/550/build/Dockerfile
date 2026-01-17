FROM docker:5001/king019/self:gitea_runner_pre


RUN mkdir -p /root/.kube


COPY minikube /usr/bin/minikube
COPY config /root/.kube/config
COPY .minikube /root/.minikube


RUN chmod 755 /usr/bin/minikube

RUN echo "alias kubectl='minikube kubectl --'" >> /etc/profile




#RUN ln -s $(which minikube) /usr/bin/kubectl