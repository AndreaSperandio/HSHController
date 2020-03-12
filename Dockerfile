FROM gradle:jdk8
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
CMD ["gradle", "--stacktrace", "run"]