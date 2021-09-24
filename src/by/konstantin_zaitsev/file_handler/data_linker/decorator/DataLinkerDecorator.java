package by.konstantin_zaitsev.file_handler.data_linker.decorator;

import by.konstantin_zaitsev.file_handler.data_linker.IDataLinker;

public class DataLinkerDecorator implements IDataLinker {

  protected final IDataLinker wrapper;

  public DataLinkerDecorator(IDataLinker dataLinker) {
    wrapper = dataLinker;
  }

  @Override
  public void writeData(String data) {
    wrapper.writeData(data);
  }

  @Override
  public String getPath() {
    return wrapper.getPath();
  }
}
