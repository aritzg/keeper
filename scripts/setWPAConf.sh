#!/bin/bash
# file: setWPAConf.sh
if [ "$#" -lt 2 ] 
then
	echo "Error! Usage: " $0 " SSID_NAME PASSWORD" 
	exit -1
fi
#DEST_FILE='/etc/wpa_supplicant/wpa_supplicant.conf'
DEST_FILE='./wpa_supplicant.conf'
TEMPLATE_FILE='./WPAConf.tpl'
REG_EX="s/@SSID/$1/g;s/@PSK/$2/g"
cat $TEMPLATE_FILE | sed -e $REG_EX > "${DEST_FILE}"

