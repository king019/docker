
cd crossgate-gateway
docker build -t docker:5001/king019/crossgate-gateway .
docker push docker:5001/king019/crossgate-gateway
cd ..
cd sun-admin
docker build -t docker:5001/king019/sun-admin .
docker push docker:5001/king019/sun-admin

cd ..
cd datacenter
docker build -t docker:5001/king019/datacenter .
docker push docker:5001/king019/datacenter

cd ..
cd energy-analysis-server
docker build -t docker:5001/king019/energy-analysis-server .
docker push docker:5001/king019/energy-analysis-server

cd ..
cd opc-da
docker build -t docker:5001/king019/opc-da .
docker push docker:5001/king019/opc-da

cd ..
cd sso
docker build -t docker:5001/king019/sso .
docker push docker:5001/king019/sso

cd ..
cd sun-admin
docker build -t docker:5001/king019/sun-admin .
docker push docker:5001/king019/sun-admin

cd ..
cd low-admin
docker build -t docker:5001/king019/low-admin .
docker push docker:5001/king019/low-admin

