#!/bin/sh
# From gist at https://gist.github.com/chadmaughan/5889802

# stash any unstaged changes
git stash -q --keep-index

# run the tests with the gradle wrapper
./gradlew test

# store the last exit code in a variable
RESULT=$?

# unstash the unstashed changes
git stash pop -q

# return the './gradlew test' exit code
exit $RESULT