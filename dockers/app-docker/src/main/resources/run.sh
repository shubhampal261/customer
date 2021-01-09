#!/bin/sh

echo "I'm in docker image"

cd $HOME

java -agentlib:jdwp=transport=dt_socket,address=8090,server=y,suspend=n -jar ./app-0.0.1-SNAPSHOT.jar

echo "Customer Service module successfully deployed!!"