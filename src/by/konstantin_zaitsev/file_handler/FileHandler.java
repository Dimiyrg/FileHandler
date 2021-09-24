package by.konstantin_zaitsev.file_handler;

import by.konstantin_zaitsev.file_handler.builder.DataLinkerBuilderSingleton;
import by.konstantin_zaitsev.file_handler.builder.FileAccessBuilderSingleton;
import by.konstantin_zaitsev.file_handler.data_linker.DataLinker;
import by.konstantin_zaitsev.file_handler.file_access.FileAccess;
import by.konstantin_zaitsev.file_handler.handler.Command;
import by.konstantin_zaitsev.file_handler.handler.Handler;
import java.util.Scanner;

public class FileHandler {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the first path: ");
    String firstPath = scanner.nextLine();
    System.out.println("Enter the second path: ");
    String secondPath = scanner.nextLine();
    System.out.println("Enter the keys: ");
    String keys = scanner.nextLine();
    scanner.close();
    FileAccessBuilderSingleton fileAccessBuilder = FileAccessBuilderSingleton.getInstance(
        new FileAccess(firstPath));
    DataLinkerBuilderSingleton dataLinkerBuilder = DataLinkerBuilderSingleton.getInstance(
        new DataLinker(secondPath));
    Command command = new Command(keys);
    new Handler().createInstances(fileAccessBuilder, dataLinkerBuilder, command);
    dataLinkerBuilder.getDataLinker().writeData(fileAccessBuilder.getFileAccess().readData());
  }
}
