ctrl_interface=DIR=/var/run/wpa_supplicant GROUP=netdev
update_config=1

network={
        ssid="@SSID"
        psk="@PSK"

        proto=WPA
        key_mgmt=WPA-PSK
        pairwise=TKIP
        auth_alg=OPEN
}
