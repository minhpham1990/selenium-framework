This is demo automation WebUI 

##Run test
mvn clean test -Dsurefire.suiteXmlFiles=testsuite/SmokeTest.xml

##Run report
- Using command `allure generate --clean` then `allure open `
- OR using command `allure serve ./allure-results/`
