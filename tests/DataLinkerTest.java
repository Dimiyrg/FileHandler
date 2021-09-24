import by.konstantin_zaitsev.file_handler.data_linker.DataLinker;
import by.konstantin_zaitsev.file_handler.data_linker.IDataLinker;
import by.konstantin_zaitsev.file_handler.data_linker.decorator.CompressionDataLinkerDecorator;
import by.konstantin_zaitsev.file_handler.data_linker.decorator.EncryptionDataLinkerDecorator;
import by.konstantin_zaitsev.file_handler.file_access.FileAccess;
import by.konstantin_zaitsev.file_handler.file_access.IFileAccess;
import by.konstantin_zaitsev.file_handler.file_access.decorator.CompressionFileAccessDecorator;
import org.junit.Assert;
import org.junit.Test;

public class DataLinkerTest {

  @Test
  public void testWriteDataTxt() {
    IDataLinker dataLinker = new DataLinker("temp/test/data_linker/test_writeDataTxt.txt");
    IFileAccess fileAccess = new FileAccess("temp/test/data_linker/test_writeDataTxt.txt");
    String expected = "Data for comparison";
    dataLinker.writeData(expected);
    String actual = fileAccess.readData();
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testWriteDataXml() {
    IDataLinker dataLinker = new DataLinker("temp/test/data_linker/test_writeDataXml.xml");
    IFileAccess fileAccess = new FileAccess("temp/test/data_linker/test_writeDataXml.xml");
    String expected = """
        <test>
          Data for comparison
        </test>""";
    dataLinker.writeData(expected);
    String actual = fileAccess.readData();
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testWriteDataJson() {
    IDataLinker dataLinker = new DataLinker("temp/test/data_linker/test_writeDataJson.json");
    IFileAccess fileAccess = new FileAccess("temp/test/data_linker/test_writeDataJson.json");
    String expected = """
        {
          "test": "Data for comparison"
        }""";
    dataLinker.writeData(expected);
    String actual = fileAccess.readData();
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testWriteDataEncryption() {
    IDataLinker dataLinker = new EncryptionDataLinkerDecorator(
        new DataLinker("temp/test/data_linker/test_writeDataEncryption.txt"));
    IFileAccess fileAccess = new FileAccess(
        "temp/test/data_linker/test_writeDataEncryption.txt");
    dataLinker.writeData("Data for comparison");
    String expected = "RGF0YSBmb3IgY29tcGFyaXNvbg==";
    String actual = fileAccess.readData();
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testWriteDataCompression() {
    IDataLinker dataLinker = new CompressionDataLinkerDecorator(
        new DataLinker("temp/test/data_linker/test_writeDataCompression.zip(txt)"));
    IFileAccess fileAccess = new CompressionFileAccessDecorator(
        new FileAccess("temp/test/data_linker/test_writeDataCompression.zip"));
    String expected = "Data for comparison";
    dataLinker.writeData(expected);
    String actual = fileAccess.readData();
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testWriteDataEncryptionCompression() {
    IDataLinker dataLinker = new EncryptionDataLinkerDecorator(new CompressionDataLinkerDecorator(
        new DataLinker("temp/test/data_linker/test_writeDataEncryptionCompression.zip")));
    IFileAccess fileAccess = new CompressionFileAccessDecorator(
        new FileAccess("temp/test/data_linker/test_writeDataEncryptionCompression.zip"));
    dataLinker.writeData("Data for comparison");
    String expected = "RGF0YSBmb3IgY29tcGFyaXNvbg==";
    String actual = fileAccess.readData();
    Assert.assertEquals(expected, actual);
  }
}
