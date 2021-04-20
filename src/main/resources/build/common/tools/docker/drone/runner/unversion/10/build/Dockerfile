FROM alpine as alpine
RUN sed -i "s/dl-cdn.alpinelinux.org/repo.huaweicloud.com/g" /etc/apk/repositories
RUN apk add -U --no-cache ca-certificates

FROM alpine
RUN sed -i "s/dl-cdn.alpinelinux.org/repo.huaweicloud.com/g" /etc/apk/repositories
EXPOSE 3000

ENV GODEBUG netdns=go
ENV DRONE_PLATFORM_OS linux
ENV DRONE_PLATFORM_ARCH amd64

COPY --from=alpine /etc/ssl/certs/ca-certificates.crt /etc/ssl/certs/

LABEL com.centurylinklabs.watchtower.stop-signal="SIGINT"
ADD https://king019.coding.net/p/github/d/save_github/git/raw/master/drone-runner-docker /bin/
RUN chmod -R 777 /bin
ENTRYPOINT ["/bin/drone-runner-docker"]