#!/bin/bash -x

LANG=C java -jar build/libs/taf001-all.jar \
support/test-suites/example.json \
support/features
