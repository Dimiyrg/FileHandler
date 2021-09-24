import by.konstantin_zaitsev.file_handler.builder.DataLinkerBuilderSingleton;
import by.konstantin_zaitsev.file_handler.builder.FileAccessBuilderSingleton;
import by.konstantin_zaitsev.file_handler.data_linker.DataLinker;
import by.konstantin_zaitsev.file_handler.file_access.FileAccess;
import by.konstantin_zaitsev.file_handler.file_access.IFileAccess;
import by.konstantin_zaitsev.file_handler.file_access.decorator.CompressionFileAccessDecorator;
import by.konstantin_zaitsev.file_handler.handler.Command;
import by.konstantin_zaitsev.file_handler.handler.Handler;
import org.junit.Assert;
import org.junit.Test;

public class HandlerTest {

  @Test
  public void testHandler() {
    FileAccessBuilderSingleton fileAccessBuilder = FileAccessBuilderSingleton.getInstance(
        new FileAccess("temp/test/handler/test_HandlerFileAccess.zip"));
    DataLinkerBuilderSingleton dataLinkerBuilder = DataLinkerBuilderSingleton.getInstance(
        new DataLinker("temp/test/handler/test_HandlerDataLinker.zip(txt)"));
    Command command = new Command("CEce");
    new Handler().createInstances(fileAccessBuilder, dataLinkerBuilder, command);
    dataLinkerBuilder.getDataLinker().writeData(fileAccessBuilder.getFileAccess().readData());
    IFileAccess fileAccess = new CompressionFileAccessDecorator(
        new FileAccess("temp/test/handler/test_HandlerDataLinker.zip"));
    String expected = "RGF0YSBmb3IgY29tcGFyaXNvbg==";
    String actual = fileAccess.readData();
    Assert.assertEquals(expected, actual);
  }
}
