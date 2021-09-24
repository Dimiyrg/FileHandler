package by.konstantin_zaitsev.file_handler.file_access.decorator;

import by.konstantin_zaitsev.file_handler.file_access.IFileAccess;
import java.util.Base64;

public class EncryptionFileAccessDecorator extends FileAccessDecorator {

  public EncryptionFileAccessDecorator(IFileAccess fileAccess) {
    super(fileAccess);
  }

  @Override
  public String readData() {
    return decode(super.readData());
  }

  private String decode(String data) {
    byte[] result = Base64.getDecoder().decode(data.getBytes());
    return new String(result);
  }
}
