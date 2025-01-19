source /etc/profile
cd /opt/soft/version/gitea/




cd energy-analysis-server
mvn8 clean compile jib:build -DsendCredentialsOverHttp
cd ..

cd gateway
mvn11 install
cd crossgate-gateway
mvn11 clean compile jib:build -DsendCredentialsOverHttp
cd ..
cd ..

cd inftt
mvn8 install
cd sun-admin
mvn8 clean compile jib:build -DsendCredentialsOverHttp
cd ..
cd ..


cd opc-da
mvn8 install
cd sun-admin
mvn8 clean compile jib:build -DsendCredentialsOverHttp
cd ..
cd ..

cd sso
mvn11 install
cd sun-admin
mvn11 clean compile jib:build -DsendCredentialsOverHttp

cd ..
cd ..
cd datacenter
mvn8 install
cd sun-admin
mvn8 clean compile jib:build -DsendCredentialsOverHttp
cd ..
cd ..