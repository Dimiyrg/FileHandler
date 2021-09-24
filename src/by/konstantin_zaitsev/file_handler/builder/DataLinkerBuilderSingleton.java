package by.konstantin_zaitsev.file_handler.builder;

import by.konstantin_zaitsev.file_handler.data_linker.IDataLinker;
import by.konstantin_zaitsev.file_handler.data_linker.decorator.CompressionDataLinkerDecorator;
import by.konstantin_zaitsev.file_handler.data_linker.decorator.EncryptionDataLinkerDecorator;

public final class DataLinkerBuilderSingleton implements IBuilder {

  private static DataLinkerBuilderSingleton instance;
  private IDataLinker dataLinker;

  private DataLinkerBuilderSingleton(IDataLinker dataLinker) {
    this.dataLinker = dataLinker;
  }

  public static DataLinkerBuilderSingleton getInstance(IDataLinker dataLinker) {
    if (instance == null) {
      instance = new DataLinkerBuilderSingleton(dataLinker);
    }
    return instance;
  }

  @Override
  public void setEncrypt() {
    dataLinker = new EncryptionDataLinkerDecorator(dataLinker);
  }

  @Override
  public void setCompress() {
    dataLinker = new CompressionDataLinkerDecorator(dataLinker);
  }

  public IDataLinker getDataLinker() {
    return dataLinker;
  }
}
