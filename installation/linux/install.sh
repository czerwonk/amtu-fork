#! /bin/bash

if [ -z "$JAVA_HOME" ]; then
  echo "The JAVA_HOME environment variable is not defined"
  echo "This environment variable is needed to run this program"
  exit 1
fi
echo "JAVA_HOME: " $JAVA_HOME
export PATH=$JAVA_HOME/bin:$PATH
export AMTU_HOME=`pwd`
echo "AMTU_HOME: " $AMTU_HOME

./configure.sh
cd service/bin
./install.sh
cd ../..
