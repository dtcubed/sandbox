ECHO OFF
ECHO "================================================"
ECHO "Execute Example Test Suite"
ECHO "================================================"
ECHO ON

java -jar build/libs/taf001-all.jar support/test-suites/example.json support/features

GOTO AROUND
ECHO "not gonna see this"
:AROUND

