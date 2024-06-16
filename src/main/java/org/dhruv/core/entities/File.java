package org.dhruv.core.entities;

public class File extends  FsItem {

    File(Directory parent, String name) {
        super(parent, name, false);
    }
}
