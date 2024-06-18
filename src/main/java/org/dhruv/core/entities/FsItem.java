package org.dhruv.core.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
abstract public class FsItem {

    private final FsItemMetadata metadata;
    private final boolean isDirectory;
    private final String name;
    @Setter
    private Directory parent;


    FsItem(Directory parent, String name, boolean isDirectory) {
        this.parent = parent;
        this.name = name;
        this.isDirectory = isDirectory;
        this.metadata = new FsItemMetadata();
    }
}
