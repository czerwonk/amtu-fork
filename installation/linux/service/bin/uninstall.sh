echo "Stopping Monitor."
/etc/init.d/amt_monitor stop

echo "Stopping AMT."
/etc/init.d/amt stop

echo "Uninstalling Monitor."
./uninstallMonitor.sh

echo "Uninstalling AMT."
./uninstallAMT.sh
