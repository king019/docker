FROM  king019/linux

MAINTAINER king019

COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
COPY hub_frame.sh /hub_frame.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh
RUN /hub_frame.sh
CMD /docker.sh
