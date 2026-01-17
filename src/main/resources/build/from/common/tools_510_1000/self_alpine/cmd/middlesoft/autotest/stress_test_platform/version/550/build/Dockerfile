FROM  king019/alpine:jdk8 as pre

MAINTAINER king019
DKCONFIG multi_run_cmd soft_stress_test_platform_pre

FROM  king019/alpine:jdk8
COPY dkrun.sh /dkrun.sh
DKCONFIG multi_run_cmd soft_stress_test_platform_next


RUN chmod 755 /*.sh

CMD /docker.sh