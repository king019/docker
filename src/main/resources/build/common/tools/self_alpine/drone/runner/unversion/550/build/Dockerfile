FROM king019/alpine:p as alpine
# RUN apk add -U --no-cache ca-certificates
RUN apk add ca-certificates

FROM king019/alpine:p
EXPOSE 3000

ENV GODEBUG netdns=go
ENV DRONE_PLATFORM_OS linux
ENV DRONE_PLATFORM_ARCH amd64

COPY --from=alpine /etc/ssl/certs/ca-certificates.crt /etc/ssl/certs/

LABEL com.centurylinklabs.watchtower.stop-signal="SIGINT"
ADD https://gitlab.com/king019/save_github/-/raw/main/drone-runner-docker /bin/drone-runner-docker
RUN chmod -R 777 /bin
ENTRYPOINT ["/bin/drone-runner-docker"]