package by.konstantin_zaitsev.file_handler.file_access.decorator;

import by.konstantin_zaitsev.file_handler.file_access.FileAccess;
import by.konstantin_zaitsev.file_handler.file_access.IFileAccess;
import java.io.File;
import java.util.List;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;

public class CompressionFileAccessDecorator extends FileAccessDecorator {

  public CompressionFileAccessDecorator(IFileAccess fileAccess) {
    super(fileAccess);
  }

  @Override
  public String readData() {
    String fileName = null;
    try {
      List<FileHeader> fileHeaders = new ZipFile(wrapper.getPath()).getFileHeaders();
      fileName = fileHeaders.get(0).getFileName();
      new ZipFile(wrapper.getPath()).extractFile(fileName, "temp/runtime");
    } catch (ZipException exception) {
      exception.printStackTrace();
    }
    String data = new FileAccess("temp/runtime/" + fileName).readData();
    boolean temp = new File("temp/runtime/" + fileName).delete();
    return data;
  }
}
