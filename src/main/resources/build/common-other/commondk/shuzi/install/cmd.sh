

cd sz-opc-da-ui
docker build -t docker:5001/king019/sz-opc-da-ui .
docker push docker:5001/king019/sz-opc-da-ui
cd ..
cd sz-portal
docker build -t docker:5001/king019/sz-portal .
docker push docker:5001/king019/sz-portal


cd ..
cd sz-inftt-ui
docker build -t docker:5001/king019/sz-inftt-ui .
docker push docker:5001/king019/sz-inftt-ui

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
cd sz-file-ui
docker build -t docker:5001/king019/sz-file-ui .
docker push docker:5001/king019/sz-file-ui

cd ..
cd sz-message-center-ui
docker build -t docker:5001/king019/sz-message-center-ui .
docker push docker:5001/king019/sz-message-center-ui

cd ..
cd sz-work-order-ui
docker build -t docker:5001/king019/sz-work-order-ui .
docker push docker:5001/king019/sz-work-order-ui


cd ..
cd sz-workflow-ui
docker build -t docker:5001/king019/sz-workflow-ui .
docker push docker:5001/king019/sz-workflow-ui


cd ..
cd sz-low-server-ui
docker build -t docker:5001/king019/sz-low-server-ui .
docker push docker:5001/king019/sz-low-server-ui

cd ..
cd sz-media-ui
docker build -t docker:5001/king019/sz-media-ui .
docker push docker:5001/king019/sz-media-ui

cd ..
cd sz-gs-twin-ui
docker build -t docker:5001/king019/sz-gs-twin-ui .
docker push docker:5001/king019/sz-gs-twin-ui

cd ..
cd sz-gs-twin-unity
docker build -t docker:5001/king019/sz-gs-twin-unity .
docker push docker:5001/king019/sz-gs-twin-unity

