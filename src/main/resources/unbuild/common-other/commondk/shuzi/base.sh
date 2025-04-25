
cd sz-svr-base-8
docker build -t docker:5001/king019/sz-svr-base-8 .
docker push docker:5001/king019/sz-svr-base-8
cd ..
cd sz-svr-base-11
docker build -t docker:5001/king019/sz-svr-base-11 .
docker push docker:5001/king019/sz-svr-base-11


cd ..
cd sz-ui-base
docker build -t docker:5001/king019/sz-ui-base .
docker push docker:5001/king019/sz-ui-base
cd ..
