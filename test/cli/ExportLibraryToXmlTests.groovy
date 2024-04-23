import grails.test.AbstractCliTestCase

class ExportLibraryToXmlTests extends AbstractCliTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testExportLibraryToXml() {

        execute(["export-library-to-xml"])

        assertEquals 0, waitForProcess()
        verifyHeader()
    }
}
