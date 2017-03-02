package Archiver.command;

import Archiver.ConsoleHelper;
import Archiver.ZipFileManager;
import Archiver.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipCreateCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Створення архіву.");

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Введіть повне ім'я файлу або директорії для архівації:");
            Path sourcePath = Paths.get(ConsoleHelper.readString());
            zipFileManager.createZip(sourcePath);

            ConsoleHelper.writeMessage("Архів створено.");

        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Ви невірно вказали ім'я файлу або директорії.");
        }
    }
}
