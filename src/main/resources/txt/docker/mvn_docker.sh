docker login --username=906451283@qq.com registry.cn-hangzhou.aliyuncs.com

mvn clean install -Dmaven.test.skip=true
rpc
dubbo_rpc

mvn clean package jib:build -am -Dmaven.test.skip=true -DsendCredentialsOverHttp -pl com.k.sshm:sshm_cloud_alibaba_nacos_rpc_dubbo_server,com.k.sshm:sshm_cloud_alibaba_nacos_rpc_dubbo_consumer






