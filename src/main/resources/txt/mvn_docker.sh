docker login --username=906451283@qq.com registry.cn-hangzhou.aliyuncs.com

mvn clean install -Dmaven.test.skip=true
rpc
dubbo_rpc

mvn clean package jib:build -am -Dmaven.test.skip=true -DsendCredentialsOverHttp -pl com.k.sshm:sshm_cloud_alibaba_nacos_rpc_dubbo_server,com.k.sshm:sshm_cloud_alibaba_nacos_rpc_dubbo_consumer


cd /root
git clone https://gitee.com/seagull1985/LuckyFrameClient.git
cd LuckyFrameClient
git checkout V3.5.2


apk add openjdk8
echo 'export JAVA_HOME=/usr/lib/jvm/java-1.8-openjdk' >> /etc/profile

mvn clean package jib:build -am -Dmaven.test.skip=true -DsendCredentialsOverHttp

registry.cn-hangzhou.aliyuncs.com/king019/lucky_frame
<plugin>
    <groupId>com.google.cloud.tools</groupId>
    <artifactId>jib-maven-plugin</artifactId>
    <version>3.3.2</version>
    <configuration>
        <allowInsecureRegistries>true</allowInsecureRegistries>
        <from>
            <image>registry.cn-beijing.aliyuncs.com/king019/linux:jdk8</image>
        </from>
        <container>
        <mainClass>springboot.RunService</mainClass>
            <jvmFlags>
                <jvmFlag>-Xms128m</jvmFlag>
                <jvmFlag>-Xmx128m</jvmFlag>
                <jvmFlag>-Duser.timezone=GMT+08</jvmFlag>
                <jvmFlag>-Dfile.encoding=UTF8</jvmFlag>
            </jvmFlags>
        </container>
        <to>
            <image>registry.cn-hangzhou.aliyuncs.com/king019/lucky_frame</image>
            <tags>
                <tag>latest</tag>
            </tags>
        </to>
    </configuration>
    </plugin>






cd /root
git clone https://gitee.com/king019/stressTestPlatform.git
cd stressTestPlatform
registry.cn-hangzhou.aliyuncs.com/king019/renren-fast
mvn clean package jib:build -am -Dmaven.test.skip=true -DsendCredentialsOverHttp

<plugin>
                <groupId>com.google.cloud.tools</groupId>
                <artifactId>jib-maven-plugin</artifactId>
                <version>3.3.2</version>
                <configuration>
                    <allowInsecureRegistries>true</allowInsecureRegistries>
                    <from>
                        <!--                        <image>registry.cn-beijing.aliyuncs.com/king019/linux:jdk17</image>-->
                        <image>registry.cn-beijing.aliyuncs.com/king019/linux:jdk17</image>
                        <!--                        <image>docker:5000/king019/graalvm:jdk17</image>-->
                    </from>
                    <container>
                        <jvmFlags>
                            <!--                            <jvmFlag>-agentlib:jdwp=transport=dt_socket,address=9090,server=y,suspend=n</jvmFlag>-->
                            <!--                            <jvmFlag>-Djava.security.egd=file:/dev/./urandom</jvmFlag>-->
                            <jvmFlag>-Xms128m</jvmFlag>
                            <jvmFlag>-Xmx128m</jvmFlag>
                            <jvmFlag>-Duser.timezone=GMT+08</jvmFlag>
                            <jvmFlag>-Dfile.encoding=UTF8</jvmFlag>
                        </jvmFlags>
                    </container>
                    <to>
                        <image>registry.cn-hangzhou.aliyuncs.com/king019/stress_test_platform</image>
                        <tags>
                            <tag>latest</tag>
                        </tags>
                    </to>
                </configuration>
            </plugin>