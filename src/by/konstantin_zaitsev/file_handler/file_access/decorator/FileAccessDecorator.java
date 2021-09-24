package by.konstantin_zaitsev.file_handler.file_access.decorator;

import by.konstantin_zaitsev.file_handler.file_access.IFileAccess;

public class FileAccessDecorator implements IFileAccess {

  protected final IFileAccess wrapper;

  public FileAccessDecorator(IFileAccess fileAccess) {
    wrapper = fileAccess;
  }

  @Override
  public String readData() {
    return wrapper.readData();
  }

  @Override
  public String getPath() {
    return wrapper.getPath();
  }
}
