package org.dhruv.core.entities;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

@Getter
public class Directory extends FsItem {

    private final List<FsItem> items;
    private final String absolutePath;

    Directory() {
        this(null, "");
    }

    Directory(Directory parent, String name) {
        super(parent, name, true);
        this.items = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        if (parent != null) {
            sb.append(this.getParent().getAbsolutePath());
            sb.append(this.getName());
        }
        sb.append("/");
        absolutePath = sb.toString();
    }

    public boolean deleteItem(FsItem item) {
        boolean isRemoved = items.remove(item);
        if (isRemoved) {
            item.setParent(null);
        }
        return isRemoved;
    }

    public boolean addItem(FsItem item) {
        return items.add(item);
    }

}
