FROM gradle:latest
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
EXPOSE 1883/tcp
CMD ["gradle", "--stacktrace", "run"]