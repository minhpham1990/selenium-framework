This is demo automation WebUI 

**Run test**
mvn clean test -Dsurefire.suiteXmlFiles=testsuite/SmokeTest.xml

**Run report**
allure report 
allure open 
OR
allure serve ./allure-results/
