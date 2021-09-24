package by.konstantin_zaitsev.file_handler.builder;

import by.konstantin_zaitsev.file_handler.file_access.IFileAccess;
import by.konstantin_zaitsev.file_handler.file_access.decorator.CompressionFileAccessDecorator;
import by.konstantin_zaitsev.file_handler.file_access.decorator.EncryptionFileAccessDecorator;

public class FileAccessBuilderSingleton implements IBuilder {

  private static FileAccessBuilderSingleton instance;
  private IFileAccess fileAccess;

  private FileAccessBuilderSingleton(IFileAccess fileAccess) {
    this.fileAccess = fileAccess;
  }

  public static FileAccessBuilderSingleton getInstance(IFileAccess fileAccess) {
    if (instance == null) {
      instance = new FileAccessBuilderSingleton(fileAccess);
    }
    return instance;
  }

  @Override
  public void setEncrypt() {
    fileAccess = new EncryptionFileAccessDecorator(fileAccess);
  }

  @Override
  public void setCompress() {
    fileAccess = new CompressionFileAccessDecorator(fileAccess);
  }

  public IFileAccess getFileAccess() {
    return fileAccess;
  }
}
