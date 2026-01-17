FROM  king019/alpine:jdk8 as pre

MAINTAINER king019

DKCONFIG multi_run_cmd soft_lucky_frame_client_pre


FROM  king019/alpine:jdk8


COPY dkrun.sh /dkrun.sh
DKCONFIG multi_run_cmd soft_lucky_frame_client_next
RUN chmod 755 /*.sh

CMD /docker.sh