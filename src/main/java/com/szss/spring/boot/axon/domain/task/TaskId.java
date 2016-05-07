package com.szss.spring.boot.axon.domain.task;

import org.axonframework.common.Assert;
import org.axonframework.domain.IdentifierFactory;

/**
 * Created by zcg on 16/5/7.
 */
public class TaskId {
    private String identifier;

    public TaskId() {
        identifier = IdentifierFactory.getInstance().generateIdentifier();
    }

    public TaskId(String identifier) {
        Assert.notNull(identifier, "identifier is not null");
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskId)) return false;
        TaskId userId = (TaskId) o;
        if (!identifier.equals(userId.identifier)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return identifier.hashCode();
    }

    @Override
    public String toString() {
        return this.identifier;
    }
}
