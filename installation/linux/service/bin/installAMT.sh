#!/bin/sh

ln -s $AMTU_HOME/service/bin/amt /etc/init.d/amt

ln -s /etc/init.d/amt /etc/rc0.d/K02amt 
ln -s /etc/init.d/amt /etc/rc1.d/K02amt 
ln -s /etc/init.d/amt /etc/rc6.d/K02amt 

ln -s /etc/init.d/amt /etc/rc2.d/S99amt 
ln -s /etc/init.d/amt /etc/rc3.d/S99amt 
ln -s /etc/init.d/amt /etc/rc4.d/S99amt 
ln -s /etc/init.d/amt /etc/rc5.d/S99amt 
