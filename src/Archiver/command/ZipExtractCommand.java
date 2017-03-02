package Archiver.command;

import Archiver.ConsoleHelper;
import Archiver.ZipFileManager;
import Archiver.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipExtractCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Розпакування архіву.");

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Введіть шлях для розпакування:");
            Path destinationPath = Paths.get(ConsoleHelper.readString());
            zipFileManager.extractAll(destinationPath);

            ConsoleHelper.writeMessage("Архів був розпакований.");

        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Невірний шлях для розпакування.");
        }
    }
}
