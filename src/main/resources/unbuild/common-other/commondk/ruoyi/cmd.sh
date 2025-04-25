
cd ruoyi-auth
docker build -t docker:5001/king019/ruoyi-auth .
docker push docker:5001/king019/ruoyi-auth
cd ..
cd ruoyi-modules-file
docker build -t docker:5001/king019/ruoyi-modules-file .
docker push docker:5001/king019/ruoyi-modules-file
cd ..
cd ruoyi-gateway
docker build -t docker:5001/king019/ruoyi-gateway .
docker push docker:5001/king019/ruoyi-gateway
cd ..
cd ruoyi-modules-gen
docker build -t docker:5001/king019/ruoyi-modules-gen .
docker push docker:5001/king019/ruoyi-modules-gen
cd ..
cd rruoyi-modules-job
docker build -t docker:5001/king019/rruoyi-modules-job .
docker push docker:5001/king019/rruoyi-modules-job
cd ..
cd ruoyi-visual-monitor
docker build -t docker:5001/king019/ruoyi-visual-monitor .
docker push docker:5001/king019/ruoyi-visual-monitor
cd ..
cd ruoyi-modules-system
docker build -t docker:5001/king019/ruoyi-modules-system .
docker push docker:5001/king019/ruoyi-modules-system

cd ..
cd ruoyi-ui
docker build -t docker:5001/king019/ruoyi-ui .
docker push docker:5001/king019/ruoyi-ui












