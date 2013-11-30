#!/bin/bash
USUARIO=XYZ
PASSWORDMD5=PASS_XYZ
DOMAIN=xyz.keeper.sareweb.net
SCRIPTS_PATH=/opt/keeper/scripts
cd $SCRIPTS_PATH
mv current_ip old_ip
wget icanhazip.com -q -O current_ip
CURRENT_IP=$(cat current_ip)
OLD_IP=$(cat old_ip)
if [ "$CURRENT_IP" != "$OLD_IP" ]
then
echo $CURRENT_IP >> ip_history.txt
wget --no-check-certificate "https://dinamico.cdmon.org/onlineService.php?enctype=MD5&n=$USUARIO&p=$PASSWORDMD5&ip=$IPACTUAL" -O /dev/null
fi

