echo "Installing AMT as daemon."
./installAMT.sh

echo "Installing Monitor as daemon."
./installMonitor.sh

echo "Starting Monitor"
/etc/init.d/amt_monitor start

echo "Starting AMT"
/etc/init.d/amt start
