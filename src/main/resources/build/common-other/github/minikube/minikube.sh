
https://zhuanlan.zhihu.com/p/429690423

mac
curl -Lo minikube https://kubernetes.oss-cn-hangzhou.aliyuncs.com/minikube/releases/v1.23.1/minikube-darwin-amd64
linux
curl -Lo minikube https://kubernetes.oss-cn-hangzhou.aliyuncs.com/minikube/releases/v1.23.1/minikube-linux-amd64


chmod +x minikube &&  mv minikube /usr/local/bin/


minikube start --force --registry-mirror=https://msb3wa7d.mirror.aliyuncs.com






kubectl delete pod PODNAME --force --grace-period=0

kubectl delete namespace ingress-nginx --force --grace-period=0



kubectl delete pod ingress-nginx-controller-55dcf56b68-b2kzj --force --grace-period=0


搭建展示
https://developer.aliyun.com/article/221687

#安装
https://gitee.com/mirrors/ingress-nginx/blob/controller-v1.3.0/deploy/static/provider/cloud/deploy.yaml

kubectl delete namespace ingress-nginx --force --grace-period=0

kubectl delete namespace kube-system --force --grace-period=0


kubectl apply -f deploy.yaml

kubectl get pods --all-namespaces

kubectl describe pod ingress-nginx-admission-patch--1-2v7ls -n ingress-nginx

kubectl logs -n ingress-nginx ingress-nginx-admission-patch--1-xqgp6