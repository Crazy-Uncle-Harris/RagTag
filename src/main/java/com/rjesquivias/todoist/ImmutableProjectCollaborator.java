package com.rjesquivias.todoist;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = ImmutableProjectCollaborator.Builder.class)
final class ImmutableProjectCollaborator implements ProjectCollaborator{
 
    private final long id;
   private final String name;
   private final String email; 
 
  
  
   private ImmutableProjectCollaborator(Builder builder) {
    id = builder.id;
    name = builder.name;
    email = builder.email;
   }

    @Override
    public long id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String email() {
        return email;
    }


    @JsonPOJOBuilder(withPrefix = "")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Builder {

        private long id;
        private String name;
        private String email;

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder email(String email) {
            this.email = email;
            return this;
        }
        public ImmutableProjectCollaborator build() {
            return new ImmutableProjectCollaborator(this);
        }
    }
    @Override 
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final ImmutableProjectCollaborator other = (ImmutableProjectCollaborator) obj;

        if (this.id != other.id) {
            return false;
        }
        boolean nameEquals = ((this.name == null && other.name == null) || (this.name != null && this.name.equals(other.name)));
        if (!nameEquals) {
            return false;
        }
        boolean emailEquals = ((this.email == null && other.email == null) || (this.email != null && this.email.equals(other.email)));
        if (!emailEquals) {
            return false;
        }

        return true;
    }
    
    @Override
    public int hashCode() {
        int result = 1;
        result = result * 31 + Long.hashCode(id);
        result = result * 31 + (name == null ? 0 : name.hashCode());
        result = result * 31 + (email == null ? 0 : email.hashCode());
        return result;
    }

    @Override 
    public String toString() {
        return "ImmutableProjectCollaborator{"
            + "id=" + id
            + ", name=" + name
            + ", email=" + email
            + "}";
    }
}