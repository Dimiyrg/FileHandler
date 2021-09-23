package by.konstantin_zaitsev.file_handler.file_access;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileAccess implements IFileAccess {

  private final String path;

  public FileAccess(String path) {
    this.path = path;
  }

  @Override
  public String readData() {
    char[] buffer = null;
    File file = new File(path);
    try (FileReader reader = new FileReader(file)) {
      buffer = new char[(int) file.length()];
      int temp = reader.read(buffer);
    } catch (IOException exception) {
      exception.printStackTrace();
    }
    return new String(buffer != null ? buffer : new char[0]);
  }

  @Override
  public String getPath() {
    return path;
  }
}
