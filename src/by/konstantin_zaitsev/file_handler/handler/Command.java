package by.konstantin_zaitsev.file_handler.handler;

public class Command {

  private boolean encryptFileAccess;
  private boolean compressFileAccess;
  private boolean encryptDataLinker;
  private boolean compressDataLinker;

  public Command(String keys) {
    if (keys.indexOf('E') != -1) {
      encryptFileAccess = true;
    }
    if (keys.indexOf('C') != -1) {
      compressFileAccess = true;
    }
    if (keys.indexOf('e') != -1) {
      encryptDataLinker = true;
    }
    if (keys.indexOf('c') != -1) {
      compressDataLinker = true;
    }
  }

  public boolean getEncryptFileAccess() {
    return encryptFileAccess;
  }

  public boolean getCompressFileAccess() {
    return compressFileAccess;
  }

  public boolean getEncryptDataLinker() {
    return encryptDataLinker;
  }

  public boolean getCompressDataLinker() {
    return compressDataLinker;
  }
}
