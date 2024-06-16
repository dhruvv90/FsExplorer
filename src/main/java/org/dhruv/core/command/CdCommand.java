package org.dhruv.core.command;

import org.dhruv.core.entities.FileSystem;
import org.dhruv.exception.InvalidInputsException;

public class CdCommand implements Command {
    private final FileSystem fs;
    private String dirName;
    private boolean forRoot;

    public CdCommand(FileSystem fs){
        this.fs  = fs;
        this.forRoot = true;
    }

    public CdCommand(FileSystem fs, String dirName){
        this(fs);
        this.forRoot = false;
        this.dirName = dirName;
    }


    @Override
    public void execute() throws InvalidInputsException {
        if(this.forRoot){
            this.fs.navigateToRoot();
        }
        else if(this.dirName.equals("..")){
            this.fs.navigateUp();
        }
        else{
            this.fs.navigateToNamedDirectory(this.dirName);
        }
    }

}
