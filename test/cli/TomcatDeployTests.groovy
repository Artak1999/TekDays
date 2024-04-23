import grails.test.AbstractCliTestCase

class TomcatDeployTests extends AbstractCliTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testTomcatDeploy() {

        execute(["tomcat-deploy"])

        assertEquals 0, waitForProcess()
        verifyHeader()
    }
}
