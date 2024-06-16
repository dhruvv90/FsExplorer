package org.dhruv.core.entities;

import org.dhruv.exception.InvalidInputsException;

import java.util.List;
import java.util.Optional;

public class FileSystem {

    private Directory current;
    private final Directory root;

    private FileSystem() {
        this.current = new Directory();
        this.root = current;
    }

    public static FileSystem buildOrGet() {
        return FileSystemSingleton.instance;
    }

    private Optional<FsItem> findItemByName(String name){
        for(FsItem item: current.getItems()){
            if(item.getName().equals(name)){
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    public void createDirectory(String name) throws InvalidInputsException {
        Optional<FsItem> item = this.findItemByName(name);
        if(item.isPresent()){
            throw new InvalidInputsException("File or dir name conflict!");
        }

        Directory dir = new Directory(current, name);
        current.addItem(dir);
    }

    public void createFile(String name) {
        File file = new File(current, name);
        current.addItem(file);
    }

    public List<FsItem> getContents() {
        return current.getItems();
    }

    public String getCurrentPath(){
        return current.getAbsolutePath();
    }

    public void deleteItem(String name) throws InvalidInputsException {
        Optional<FsItem> item = findItemByName(name);
        if(item.isEmpty()){
            throw new InvalidInputsException("Cannot delete : Invalid file or dir name");
        }
        current.deleteItem(item.get());
    }

    private static class FileSystemSingleton {
        private static final FileSystem instance = new FileSystem();
    }

    public void navigateToRoot(){
        this.current = root;
    }

    public void navigateUp(){
        if(this.current == this.root){
            return;
        }
        this.current = this.current.getParent();
    }

    public void navigateToNamedDirectory(String dirName) throws InvalidInputsException {
        Optional<FsItem> item = findItemByName(dirName);
        if(item.isEmpty() || !item.get().isDirectory()){
            throw new InvalidInputsException("No such file or directory");
        }
        this.current = (Directory) item.get();
    }
}
