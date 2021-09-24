package by.konstantin_zaitsev.file_handler.data_linker.decorator;

import by.konstantin_zaitsev.file_handler.data_linker.IDataLinker;
import java.util.Base64;

public class EncryptionDataLinkerDecorator extends DataLinkerDecorator {

  public EncryptionDataLinkerDecorator(IDataLinker dataLinker) {
    super(dataLinker);
  }

  @Override
  public void writeData(String data) {
    super.writeData(encode(data));
  }

  private String encode(String data) {
    byte[] result = Base64.getEncoder().encode(data.getBytes());
    return new String(result);
  }
}
