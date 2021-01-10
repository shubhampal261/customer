#!/bin/sh

echo "I'm in docker image"

cd $HOME

java -agentlib:jdwp=transport=dt_socket,address=8090,server=y,suspend=n -jar ./customer-1.0.0-SNAPSHOT.jar

echo "Customer Service module successfully deployed!!"