FROM arm32v7/gradle
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
CMD ["gradle", "--stacktrace", "run"]