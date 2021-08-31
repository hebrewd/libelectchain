#!/bin/sh


#Private-key
openssl genrsa -out $1/privkey.pem 2048

#Public-key
openssl rsa -pubout -in $1/privkey.pem -out $1/pubkey.pem
