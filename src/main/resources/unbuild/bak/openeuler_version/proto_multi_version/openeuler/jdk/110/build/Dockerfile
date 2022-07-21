FROM king019/openeuler:res

MAINTAINER king019


RUN dnf -y install  maven

RUN dnf -y install  java-1.8.0-openjdk-devel
RUN dnf -y install  java-11-openjdk-devel



RUN chmod -R 777 /*.sh



# RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-11-openjdk' >> /etc/profile
# RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
# RUN echo '#jdk' >> /etc/profile

RUN chmod 755 /*.sh
CMD /docker.sh


