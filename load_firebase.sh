#!/bin/bash
status1=404
day_count=0
while [ $status1 -eq 404 ]; do
	month=$(date --date "$day_count day" +%b | awk '{print toupper($0)}')
	nse_path=https://www.nseindia.com/content/historical/DERIVATIVES/$(date --date "$day_count day" +%Y)/$month/fo$(date --date "$day_count day" +%d)$month$(date --date "$day_count day" +%Y)bhav.csv.zip
	file=fo$(date --date "$day_count day" +%d)$month$(date --date "$day_count day" +%Y)bhav.csv
	echo 'File to be read is ' $nse_path
	status1=$(wget -U 'Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.8.1.6) Gecko/20070802 SeaMonkey/1.1.4' $nse_path -O fo_bhav.zip --server-response 2>&1 | awk '/^  HTTP/{print $2}')
	echo 'Returned status is ' $status1
	if [ $status1 -eq 200 ]; then
   		echo 'Successfully read the bhavcopy file'
   		unzip -o fo_bhav.zip
   		mv -f $file fo_bhav.csv
		rm *zip
	else
    		echo 'Error in reading the bhavcopy'
	fi
	let "day_count=day_count - 1"
done

if [ $status1 -eq 200 ]; then
	echo 'Successfully read bhavcopy'
	echo 'Uploading data to firebase'
	java -jar ./target/bhavcopyToJSon-0.0.1-SNAPSHOT.jar
#	curl -X DELETE https://testhub-1f083.firebaseio.com/instruments.json
#	curl -X PUT -d @fo_bhav.json https://testhub-1f083.firebaseio.com/instruments.json
	curl -X DELETE https://nitrohub-9226a.firebaseio.com/instruments.json
	curl -X PUT -d @fo_bhav.json https://nitrohub-9226a.firebaseio.com/instruments.json
else
	echo 'Either of the file reading failed'
fi
