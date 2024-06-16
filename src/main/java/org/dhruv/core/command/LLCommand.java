package org.dhruv.core.command;

import org.dhruv.core.entities.FileSystem;
import org.dhruv.core.entities.FsItem;

import java.util.List;

public class LLCommand implements Command {

    private FileSystem fs;

    public LLCommand(FileSystem fs) {
        this.fs = fs;
    }

    @Override
    public void execute() {
        List<FsItem> items = fs.getContents();
        System.out.println("Total Items: " + items.size());

        for (FsItem i : items) {
            System.out.println(i.getName() + " " + i.getMetadata().getCreated() + " " + i.getMetadata().getModified());
        }
    }

}
