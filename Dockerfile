FROM arm32v7/gradle:jdk11
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
EXPOSE 1883/tcp
CMD ["gradle", "--stacktrace", "--no-daemon", "run"]