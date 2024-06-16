package org.dhruv.core.command;

import org.dhruv.core.entities.FileSystem;
import org.dhruv.core.entities.FsItem;

import java.util.List;

public class LsCommand implements Command {

    private FileSystem fs;

    public LsCommand(FileSystem fs){
        this.fs = fs;
    }

    @Override
    public void execute() {
        List<FsItem> items = fs.getContents();
        for(FsItem i: items){
            System.out.println(i.getName());
        }
    }

}
