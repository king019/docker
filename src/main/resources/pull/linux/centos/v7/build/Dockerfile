FROM centos:7

MAINTAINER king019

RUN yum list|sed -n '7,1111111p' |awk '{print "yum -y install  " $1}'|sh