#!/bin/sh

ln -s $AMTU_HOME/service/bin/amt_monitor /etc/init.d/amt_monitor

ln -s /etc/init.d/amt_monitor /etc/rc0.d/K01amt_monitor
ln -s /etc/init.d/amt_monitor /etc/rc1.d/K01amt_monitor
ln -s /etc/init.d/amt_monitor /etc/rc6.d/K01amt_monitor

ln -s /etc/init.d/amt_monitor /etc/rc2.d/S98amt_monitor
ln -s /etc/init.d/amt_monitor /etc/rc3.d/S98amt_monitor
ln -s /etc/init.d/amt_monitor /etc/rc4.d/S98amt_monitor
ln -s /etc/init.d/amt_monitor /etc/rc5.d/S98amt_monitor
