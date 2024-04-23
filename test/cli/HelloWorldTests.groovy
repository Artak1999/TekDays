import grails.test.AbstractCliTestCase

class HelloWorldTests extends AbstractCliTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testHelloWorld() {

        execute(["hello-world"])

        assertEquals 0, waitForProcess()
        verifyHeader()
    }
}
