FROM docker:5001/king019/self:gitea_runner_pre


RUN source /etc/profile;chmod 755 /*.sh;mkdir -p /root/.kube


COPY minikube /usr/bin/minikube
COPY config /root/.kube/config
COPY .minikube /root/.minikube


RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /usr/bin/minikube

RUN source /etc/profile;chmod 755 /*.sh;echo "alias kubectl='minikube kubectl --'" >> /etc/profile




#RUN ln -s $(which minikube) /usr/bin/kubectl
