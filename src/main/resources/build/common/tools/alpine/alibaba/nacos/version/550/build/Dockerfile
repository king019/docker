FROM  king019/alpine:p3.14

MAINTAINER king019



RUN apk add maven
RUN apk add openjdk8
RUN apk add git
RUN apk add protobuf
RUN apk add protoc


COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
COPY application.properties /application.properties
RUN chmod 755 /*.sh
RUN /gitjar.sh
CMD /docker.sh
