#! /bin/bash

export JAVA_HOME=/opt/third-party/depot/Linux-2.4c2.2-i686/java-1.4.2_06_SUN
export PATH=$JAVA_HOME/bin:$PATH
export AMTU_HOME=`pwd`

./configure.sh
cd service/bin
./install.sh
cd ../..
