
#cd crossgate-gateway
#docker build -t docker:5001/king019/crossgate-gateway .
#docker push docker:5001/king019/crossgate-gateway
#cd ..
#cd sun-admin
#docker build -t docker:5001/king019/sun-admin .
#docker push docker:5001/king019/sun-admin

#cd ..
#cd sso
#docker build -t docker:5001/king019/sso .
#docker push docker:5001/king019/sso

#cd ..
cd sz-inftt-ui
docker build -t docker:5001/king019/sz-inftt-ui .
docker push docker:5001/king019/sz-inftt-ui

cd ..
cd sz-portal
docker build -t docker:5001/king019/sz-portal .
docker push docker:5001/king019/sz-portal

cd ..
cd sz-sso-ui
docker build -t docker:5001/king019/sz-sso-ui .
docker push docker:5001/king019/sz-sso-ui




cd ..
cd sz-datacenter-ui
docker build -t docker:5001/king019/sz-datacenter-ui .
docker push docker:5001/king019/sz-datacenter-ui
cd ..
cd sz-energy-analysis-server-ui
docker build -t docker:5001/king019/sz-energy-analysis-server-ui .
docker push docker:5001/king019/sz-energy-analysis-server-ui
cd ..
cd sz-opc-da-ui
docker build -t docker:5001/king019/sz-opc-da-ui .
docker push docker:5001/king019/sz-opc-da-ui






