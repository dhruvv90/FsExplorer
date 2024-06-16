package org.dhruv.core.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
public class FsItemMetadata {
    private final Instant created;

    @Setter
    private Instant modified;

    FsItemMetadata() {
        Instant now = Instant.now();
        this.created = now;
        this.modified = now;
    }
}
