package com.challenge.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SubmissionIdentity implements Serializable {

    @ManyToOne
    @NotNull
    private user user;

    @ManyToOne
    @NotNull
    private challenge challenge;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubmissionIdentity that = (SubmissionIdentity) o;
        return Objects.equals(user, that.user) && Objects.equals(challenge, that.challenge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, challenge);
    }
}
