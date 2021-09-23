package by.konstantin_zaitsev.file_handler.data_linker;

import java.io.FileWriter;
import java.io.IOException;

public class DataLinker implements IDataLinker {

  private final String path;

  public DataLinker(String path) {
    this.path = path;
  }

  @Override
  public void writeData(String data) {
    try (FileWriter writer = new FileWriter(path)) {
      writer.write(data);
      writer.flush();
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }

  @Override
  public String getPath() {
    return path;
  }
}
