import by.konstantin_zaitsev.file_handler.file_access.FileAccess;
import by.konstantin_zaitsev.file_handler.file_access.IFileAccess;
import org.junit.Assert;
import org.junit.Test;

public class FileAccessTest {

  @Test
  public void testReadDataTxt() {
    IFileAccess fileAccess = new FileAccess("temp/test/file_access/test_readDataTxt.txt");
    String expected = "Data for comparison";
    String actual = fileAccess.readData();
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testReadDataXml() {
    IFileAccess fileAccess = new FileAccess("temp/test/file_access/test_readDataXml.xml");
    String expected = """
        <test>
          Data for comparison
        </test>""";
    String actual = fileAccess.readData();
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testReadDataJson() {
    IFileAccess fileAccess = new FileAccess("temp/test/file_access/test_readDataJson.json");
    String expected = """
        {
          "test": "Data for comparison"
        }""";
    String actual = fileAccess.readData();
    Assert.assertEquals(expected, actual);
  }
}
