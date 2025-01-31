#!/bin/bash


programme=RecherchePLSSC


if [[ $# -lt 1 ]]
then
	TEST_FILES_DIRECTORY="./tests"
else
	TEST_FILES_DIRECTORY="$1"
fi

#./recompile.sh || { echo "Erreur de compilation"; exit 1; }

if [[ -f "${programme}.class" ]]
then
	for file in ${TEST_FILES_DIRECTORY}/*
	do 
		test_file_name=$(basename $file)
		if [[ -f $file ]]
		then
			echo "### Test <$test_file_name> ###"
			java "$programme"  "$file"
			echo ""
		fi
	done
fi
