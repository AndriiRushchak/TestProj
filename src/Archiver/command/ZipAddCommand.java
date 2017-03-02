package Archiver.command;

import Archiver.ConsoleHelper;
import Archiver.ZipFileManager;
import Archiver.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipAddCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Додавання нового файлу в архів.");

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Введіть повне ім'я файлу для додавання:");
            Path sourcePath = Paths.get(ConsoleHelper.readString());

            zipFileManager.addFile(sourcePath);

            ConsoleHelper.writeMessage("Додавання в архів завершено.");

        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Файл не був знайдений.");
        }
    }
}
