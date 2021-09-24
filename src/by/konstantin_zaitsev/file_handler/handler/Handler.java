package by.konstantin_zaitsev.file_handler.handler;

import by.konstantin_zaitsev.file_handler.builder.DataLinkerBuilderSingleton;
import by.konstantin_zaitsev.file_handler.builder.FileAccessBuilderSingleton;

public class Handler {

  public void createInstances(FileAccessBuilderSingleton fileAccessBuilder,
      DataLinkerBuilderSingleton dataLinkerBuilder, Command command) {
    if (command.getCompressFileAccess()) {
      fileAccessBuilder.setCompress();
    }
    if (command.getEncryptFileAccess()) {
      fileAccessBuilder.setEncrypt();
    }
    if (command.getCompressDataLinker()) {
      dataLinkerBuilder.setCompress();
    }
    if (command.getEncryptDataLinker()) {
      dataLinkerBuilder.setEncrypt();
    }
  }
}
