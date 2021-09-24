package by.konstantin_zaitsev.file_handler.data_linker.decorator;

import by.konstantin_zaitsev.file_handler.data_linker.IDataLinker;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import net.lingala.zip4j.ZipFile;

public class CompressionDataLinkerDecorator extends DataLinkerDecorator {

  public CompressionDataLinkerDecorator(IDataLinker dataLinker) {
    super(dataLinker);
  }

  @Override
  public void writeData(String data) {
    String[] fileNameAndTruePath = getFileNameAndTruePath();
    File file = new File("temp/runtime/" + fileNameAndTruePath[0]);
    try {
      boolean temp = file.createNewFile();
      FileWriter writer = new FileWriter(file);
      writer.write(data);
      writer.flush();
      writer.close();
      new ZipFile(fileNameAndTruePath[1]).addFile(file);
    } catch (IOException exception) {
      exception.printStackTrace();
    }
    boolean temp = file.delete();
  }

  private String[] getFileNameAndTruePath() {
    String format = ".txt";
    String truePath = wrapper.getPath();
    if (wrapper.getPath().substring(wrapper.getPath().lastIndexOf('.')).contains("(txt)")) {
      truePath = wrapper.getPath().replace("(txt)", "");
    }
    if (wrapper.getPath().substring(wrapper.getPath().lastIndexOf('.')).contains("(xml)")) {
      format = ".xml";
      truePath = wrapper.getPath().replace("(xml)", "");
    }
    if (wrapper.getPath().substring(wrapper.getPath().lastIndexOf('.')).contains("(json)")) {
      format = ".json";
      truePath = wrapper.getPath().replace("(json)", "");
    }
    String fileName =
        truePath.substring(truePath.lastIndexOf('/'), truePath.lastIndexOf('.')) + format;
    return new String[] {fileName, truePath};
  }
}
