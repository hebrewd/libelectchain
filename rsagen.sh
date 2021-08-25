#!/bin/sh
#Private-key
openssl genrsa -out privkey.pem 2048

#Public-key
openssl rsa -pubout -in privkey.pem -out pubkey.pem
