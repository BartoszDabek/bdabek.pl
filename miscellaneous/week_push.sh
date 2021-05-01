#!/bin/sh

RED='\033[0;31m'
NC='\033[0m' # No Color

cd $Repos/bdabek.pl/posts/personal-goals/
git add .

echo -e "${RED}Do you want to push the following changes?${NC}"
git status
select yn in "Yes" "No"; do
	case $yn in
		Yes ) git commit -m "week in review"; git push; break;;
		No ) exit;;
	esac
done
