rm -rf generated
mkdir generated
oatts generate -s swagger.yaml -w ./generated
ls -hal generated
mocha --recursive generated/
