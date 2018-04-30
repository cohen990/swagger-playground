npm install -g oatts
npm install -g mocha
npm install --save mocha
npm install --save chakram
oatts generate -s swagger.yaml -w ./generated
ls -hal generated
mocha --recursive generated/
