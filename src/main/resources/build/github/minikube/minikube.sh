
https://zhuanlan.zhihu.com/p/429690423

mac
curl -Lo minikube https://kubernetes.oss-cn-hangzhou.aliyuncs.com/minikube/releases/v1.23.1/minikube-darwin-amd64
linux
curl -Lo minikube https://kubernetes.oss-cn-hangzhou.aliyuncs.com/minikube/releases/v1.23.1/minikube-linux-amd64


chmod +x minikube &&  mv minikube /usr/local/bin/


minikube start --force --registry-mirror=https://msb3wa7d.mirror.aliyuncs.com