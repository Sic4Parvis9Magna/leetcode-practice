#!/bin/bash

# Given a text file file.txt, print just the 10th line of the file.

# Example:

# Assume that file.txt has the following content:
# Line 1
# Line 2
# Line 3
# Line 4
# Line 5
# Line 6
# Line 7
# Line 8
# Line 9
# Line 10
# Your script should output the tenth line, which is:

# Line 10
# Note:
# 1. If the file contains less than 10 lines, what should you output?
# 2. There's at least three different solutions. Try to explore all possibilities.

file_name="file.txt"
i=0
while IFS= read -r line
do
    if [[ "$i" == '9' ]]
        then
        echo "Number $i!"
        break
    fi
    ((i++))
done < "$file_name"
echo "$line"
